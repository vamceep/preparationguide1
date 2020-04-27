package preparation.threads;

import java.util.LinkedList;
import java.util.Queue;

public class PrintEvenOddWithProducer {
    /**
     * Print even and odd numbers using two threads with prinve static Object lock
     * using synchronize on (object / lock)
     * then call lock.wait() to get the state and
     * lock.notify() or lock.notifyAll()
     */
    static Object lock = new Object();
    static int number = 1;
    final static int upto = 10;
    static int counter =0;
    final static Queue<Integer> queue = new LinkedList<>();

    static public class OddEvenNumberPrint implements Runnable {

        public int remainder = 0;

        public OddEvenNumberPrint(int upto, int remainder) {
            this.remainder = remainder;
        }

        @Override
        public void run() {
            int result = 0;
            while(true) {
                synchronized (lock) {
                    while (queue.peek() != null && queue.peek().intValue() % 2 != remainder) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Integer val = queue.poll();
                    if(val != null) {
                        result += val.intValue();
                        counter++;
                    }
                    lock.notifyAll();
                    if (counter >= upto) {
                        System.out.println("Total: " + result);
                        return;
                    }
                }
            }
        }
    }
    public static class Producer implements Runnable {
        @Override
        public void run() {
            int cnt = 1;
            while(cnt <= upto) {
                synchronized (lock) {
                    queue.add(number++);
                    cnt++;
                    lock.notifyAll();
                }
            }
            System.out.println("done");
        }
    }
    public static void main(String[] args) {

//        for(int i = 1; i<=upto;i++) {
//            queue.add(i);
//        }
        OddEvenNumberPrint evenNumberPrint = new OddEvenNumberPrint(upto, 0);
        OddEvenNumberPrint oddNumberPrint = new OddEvenNumberPrint(upto, 1);

        Producer  producer = new Producer();
        Thread t3 = new Thread(producer);
        Thread t1 = new Thread(evenNumberPrint, "even");
        Thread t2 = new Thread(oddNumberPrint, "odd");


        //t1.setDaemon(true);
        t2.start();
        t1.start();
        t3.start();
        try {
           t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting main...");

    }
}
