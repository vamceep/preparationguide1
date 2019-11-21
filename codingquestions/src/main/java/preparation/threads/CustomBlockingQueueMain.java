package preparation.threads;

public class CustomBlockingQueueMain {
    public static void main(String[] args) throws InterruptedException {

        CustomBlockingQueue customBlockingQueue = new CustomBlockingQueue();
        Thread prod = new Thread(new producer(customBlockingQueue));
        Thread cons = new Thread(new consumer(customBlockingQueue));
        prod.start();
        cons.start();
        prod.join();
        cons.join();
        System.out.println("exiting CustomBlockingQueueMain");
    }
}

class producer implements Runnable {

    private CustomBlockingQueue customBlockingQueue;
    public producer(CustomBlockingQueue customBlockingQueue) {
        this.customBlockingQueue = customBlockingQueue;
    }
    @Override
    public void run() {
        for(int i = 0; i<=10 ;i++) {

            try {
                customBlockingQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class consumer implements Runnable {

    private CustomBlockingQueue customBlockingQueue;
    public consumer(CustomBlockingQueue customBlockingQueue) {
        this.customBlockingQueue = customBlockingQueue;
    }
    @Override
    public void run() {
        for(int i = 0; i<=10 ;i++) {

            try {
                customBlockingQueue.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}