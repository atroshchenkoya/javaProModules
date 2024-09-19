package org.example;

import org.example.testRunner.testAnnotations.AfterSuite;
import org.example.testRunner.testAnnotations.BeforeSuite;
import org.example.testRunner.testAnnotations.Test;

public class TestClass {
    public void test1() {
        System.out.println("This is test № " + 1);
    }
    @Test(priority = 1)
    public void test2() {
        System.out.println("This is test № " + 2);
    }

    @Test(priority = 2)
    public void test3() {
        System.out.println("This is test № " + 3);
    }
    @AfterSuite
    public void test4() {
        System.out.println("This is test № " + 4);
    }
    @BeforeSuite
    public void test5() {
        System.out.println("This is test № " + 5);
    }
    @Test(priority = 7)
    public void test6() {
        System.out.println("This is test № " + 6);
    }
    @Test(priority = 7)
    public void test7() {
        System.out.println("This is test № " + 7);
        throw new RuntimeException();
    }
}
