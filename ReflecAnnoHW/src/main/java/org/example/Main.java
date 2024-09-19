package org.example;

import org.example.testRunner.testAnnotations.Exceptions.InvalidTestAnnotationUsageException;
import org.example.testRunner.TestRunner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InvalidTestAnnotationUsageException {
        TestRunner.runTests(TestClass.class);
    }
}