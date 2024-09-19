package org.example.testRunner;

import org.example.TestClass;
import org.example.testRunner.testAnnotations.AfterSuite;
import org.example.testRunner.testAnnotations.BeforeSuite;
import org.example.testRunner.testAnnotations.Exceptions.InvalidTestAnnotationUsageException;
import org.example.testRunner.testAnnotations.Test;

import java.lang.reflect.Method;
import java.util.*;

public class TestRunner {

    private static final int MAX_PRIORITY = 10;
    private static final int MIN_PRIORITY = 1;
    public static void runTests(Class testClass) throws InvalidTestAnnotationUsageException {

        validateAnnotations(testClass);

        Method[] methods = testClass.getDeclaredMethods();
        Map<Method, Integer>  methodPriorityHashMap = generatePriorityHashMap(methods);

        System.out.println("We have " + methodPriorityHashMap.size() + " methods for tests in " + testClass.getName());

        int successTests = 0;
        int failedTests = 0;

        List<Integer> priorityList = new ArrayList<>(methodPriorityHashMap.values());
        priorityList.sort(Collections.reverseOrder());

        Method processedMethod = null;

        for (Integer integer : priorityList) {
            for (Map.Entry<Method, Integer> entry : methodPriorityHashMap.entrySet()) {
                processedMethod = entry.getKey();
                int priority = entry.getValue();
                if (priority == integer) {
                    try {
                    processedMethod.invoke(new TestClass());
                    successTests++;
                    } catch (Exception e) {
                    failedTests++;
                    }
                    break;
                }
            }
            methodPriorityHashMap.remove(processedMethod);
        }
        printTestsSummary(testClass, successTests, failedTests);
    }

    private static void printTestsSummary(Class testClass, int successTests, int failedTests) {
        System.out.println("Tests for " + testClass.getName() + " finished\n"
                + "Success: " + successTests
                + "\nFailed: " + failedTests
        );
    }


    private static Map<Method, Integer> generatePriorityHashMap(Method[] methods) {
        Map<Method, Integer> methodPriorityHashMap = new HashMap<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class))
                methodPriorityHashMap.put(method, method.getAnnotation(Test.class).priority());
            if (method.isAnnotationPresent(BeforeSuite.class))
                methodPriorityHashMap.put(method, MAX_PRIORITY + 1);
            if (method.isAnnotationPresent(AfterSuite.class))
                methodPriorityHashMap.put(method, MIN_PRIORITY - 1);
        }
        return methodPriorityHashMap;
    }

    private static void validateAnnotations(Class testClass) throws InvalidTestAnnotationUsageException {
        Method[] methods = testClass.getDeclaredMethods();
        int afterSuiteUsages = 0;
        int beforeSuiteUsages = 0;

        for (Method m: methods) {
            if ((m.isAnnotationPresent(Test.class) && m.isAnnotationPresent(AfterSuite.class))
                    || (m.isAnnotationPresent(Test.class) && m.isAnnotationPresent(BeforeSuite.class))
                    || (m.isAnnotationPresent(AfterSuite.class) && m.isAnnotationPresent(BeforeSuite.class))) {
                throw new InvalidTestAnnotationUsageException("Bad usage of @Test/@AfterSuite/@BeforeSuite annotations for method " + m.getName() + " in class " + testClass.getName());
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                afterSuiteUsages++;
                if (afterSuiteUsages > 1)
                    throw new InvalidTestAnnotationUsageException("You can use @AfterSuite only once per class. " + testClass.getName());
            }
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuiteUsages++;
                if (beforeSuiteUsages > 1)
                    throw new InvalidTestAnnotationUsageException("You can use @BeforeSuite only once per class. " + testClass.getName());
            }
            if (m.isAnnotationPresent(Test.class)) {
                if (m.getAnnotation(Test.class).priority() > MAX_PRIORITY || m.getAnnotation(Test.class).priority() < MIN_PRIORITY) {
                    throw new InvalidTestAnnotationUsageException("You can set priority only from 1 to 10. " + testClass.getName());
                }
            }
        }
    }
}
