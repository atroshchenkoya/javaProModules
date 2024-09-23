package ru.otus;

import ru.otus.testRunner.testAnnotations.Exceptions.InvalidTestAnnotationUsageException;
import ru.otus.testRunner.TestRunner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InvalidTestAnnotationUsageException {
        TestRunner.runTests(TestClass.class);
    }
}