package preparation.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEvenWithConditon {
    /**
     * print even and odd number by two separate threads
     * using Lock and Condition.
     */
    static int counter = 1;
    static int max = 10;
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    static class PrintEvenNumbers implements Runnable {
        @Override
        public void run() {
            boolean set_exit = false;
            while(true) {
                lock.lock();
                try {
                    while (counter % 2 != 0) {
                        condition.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + counter);
                    counter++;
                    if (counter >= max) {
                        set_exit = true;
                    }
                    condition.signal();
                } catch (InterruptedException e) {
                    System.out.println("Unable to wait in PrintEvenNumbers thread...");
                } finally {
                    lock.unlock();
                    if (set_exit) {
                        return;
                    }
                }
            }
        }
    }

    static class PrintOddNumbers implements Runnable {

        @Override
        public void run() {
            boolean set_exit = false;
            while(true) {
                lock.lock();
                if (counter == max) {
                    return;
                }
                try {
                    while (counter % 2 != 1) {
                        condition.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + counter);
                    counter++;
                    if (counter >= max) {
                        set_exit = true;
                    }
                    condition.signal();
                } catch (InterruptedException e) {
                    System.out.println("Unable to wait in PrintOddNumbers thread...");
                } finally {
                    lock.unlock();
                    if (set_exit) {
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintEvenNumbers printEvenNumbers = new PrintEvenNumbers();
        PrintOddNumbers printOddNumbers = new PrintOddNumbers();

        Thread t1 = new Thread(printEvenNumbers, "even: ");
        Thread t2 = new Thread(printOddNumbers, "odd: ");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Unable to join threads");
        }

        System.out.println("Exit main....");
    }
}
