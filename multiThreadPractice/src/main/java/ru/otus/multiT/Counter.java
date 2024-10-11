package ru.otus.multiT;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    AtomicInteger count = new AtomicInteger(0);

    public Double count(double a) {
        double b = a;
        for (int i = 0; i < 1000000; i++) {
            b = b + Math.tan(b);
        }
        System.out.println(count.incrementAndGet() + ": a=" + a + " b =" + b + " T:" + Thread.currentThread().getName());
        return b;
    }

}