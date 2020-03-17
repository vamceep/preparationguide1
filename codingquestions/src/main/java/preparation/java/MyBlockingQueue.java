package preparation.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<T> {
    /**
     * Java provides BlockingQueue but try implementing it on your won
     * with locks
     */

    private int max;
    private Queue<T> queue;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public MyBlockingQueue(int size) {
        this.max = size;
        queue = new LinkedList<>();
    }

    public void put(T t) {
        lock.lock();

        try {
            while(queue.size() == max) {
                notFull.wait();
            }
            queue.add(t);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            System.out.println("Unable to wait. Interrupted in Put.");
            return;
        }finally {
            lock.unlock();
        }
    }

    public T get() {
        lock.lock();
        try {
            while (queue.size() == max) {
                notEmpty.wait();
            }
            T t = queue.remove();
            notFull.signalAll();
            return t;
        } catch (InterruptedException e) {
            System.out.println("Unable to wait. Interrupted in Get.");
        } finally {
            lock.unlock();
        }
        return null;
    }

    public static void main(String[] args) {
        MyBlockingQueue<Integer> myBlockingQueue = new MyBlockingQueue<>(5);

    }
}
