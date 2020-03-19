package preparation.threads;

public class PrintEvenOdd {
    /**
     * Print even and odd numbers using two threads with prinve static Object lock
     * using synchronize on (object / lock)
     * then call lock.wait() to get the state and
     * lock.notify() or lock.notifyAll()
     */
    public static int NUMBERS_UPTO = 10;

    static public class OddEvenNumberPrint implements Runnable {
        static int number = 1;
        public int upto = 0;
        public int remainder = 0;
        static Object lock = new Object();

        public OddEvenNumberPrint(int upto, int remainder) {
            this.upto = upto;
            this.remainder = remainder;
        }

        @Override
        public void run() {
            while (number < upto) {
                synchronized (lock) {
                    while (number % 2 != remainder) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " " + number);
                    number++;
                    lock.notifyAll();
                }
            }
        }
    }
    public static void main(String[] args) {
        OddEvenNumberPrint evenNumberPrint = new OddEvenNumberPrint(10, 0);
        OddEvenNumberPrint oddNumberPrint = new OddEvenNumberPrint(10, 1);
        Thread t1 = new Thread(evenNumberPrint, "even");
        Thread t2 = new Thread(oddNumberPrint, "odd");
        //t1.setDaemon(true);
        t2.start();
        t1.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting main...");

    }
}
