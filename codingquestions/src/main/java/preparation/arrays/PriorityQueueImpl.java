package preparation.arrays;

public class PriorityQueueImpl {
    int[] heap;
    int size;
    int maxSize;

    PriorityQueueImpl(int maxSize) {
        this.heap = new int[maxSize];
        this.size = 0;
        this.maxSize = maxSize;
    }
}
