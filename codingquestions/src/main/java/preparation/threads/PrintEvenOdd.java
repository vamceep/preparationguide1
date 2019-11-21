package preparation.threads;

public class PrintEvenOdd {
    public static int NUMBERS_UPTO = 10;

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
