package preparation.threads;

public class OddEvenNumberPrint implements Runnable {
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
        while(number < upto) {
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
