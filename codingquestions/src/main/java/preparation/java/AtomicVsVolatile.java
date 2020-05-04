package preparation.java;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicVsVolatile {
    /**
     * https://www.quora.com/Why-do-we-use-atomic-variables-instead-of-a-volatile-in-Java
     *
     * volatile is used to get a change to thread attention.
     * say to stop a thread, have global volatile boolean variable.
     * setting to stop/false would make run() to stop a thread.
     */
    static volatile  int count =0;
    static AtomicInteger atomicCounnter = new AtomicInteger();
    public static void countNumbersAtomic() {
        IntStream.range(0,100).parallel().forEach(v -> count++);
        // results different values instead of 100
        System.out.println("volatile count: " + count);
    }

    public static void countNumbersVolatime() {
        IntStream.range(0,100).parallel().forEach(v -> atomicCounnter.incrementAndGet());
        // alwasy returns 100 which is accurate.
        System.out.println("Atomic count: " + atomicCounnter.get());
    }
    public static void main(String[] args) {
        countNumbersAtomic();
        countNumbersVolatime();
    }
}
