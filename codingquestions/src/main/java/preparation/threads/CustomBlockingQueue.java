package preparation.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue {

    final Lock lock = new ReentrantLock();

    final Condition producerCondition = lock.newCondition();
    final Condition consumerCondition = lock.newCondition();

    // array store elements as queue
    final Object[] array = new Object[6];
    int putIndex = 0, takeIndex = 0;
    int count;

    public CustomBlockingQueue() {
    }

    public void put(Object object) throws InterruptedException {
        lock.lock();
        try {
            while (count == array.length) {
                producerCondition.await();
            }

            array[putIndex] = object;
            System.out.println("Producing..: " + object);
            putIndex++;
            if (putIndex == array.length) {
                putIndex = 0;
            }
            ++count;
            consumerCondition.signal();
        }finally {
            lock.unlock();
        }
    }

    public Object get() throws InterruptedException {
        lock.lock();
        try {
            while(count == 0) {
                consumerCondition.await();
            }
            Object object = array[takeIndex];
            System.out.println("Consumed..: " + object);
            takeIndex++;
            if(takeIndex == array.length) {
                takeIndex = 0;
            }
            --count;
            producerCondition.signal();
            return object;
        }finally {
            lock.unlock();
        }
    }
}
