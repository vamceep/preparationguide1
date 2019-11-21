package preparation.sorting;

public class HeapSort {

    public HeapSort() {

    }

    public int[] merge(int[] a, int[] b) {
        int i = 0, j = 0;
        int c[] = new int[a.length + b.length];
        int k = 0;
        while(i < a.length && j < b.length ) {
            if(a[i] < b[j]) {
                c[k++] = a[i++];
            }else if(a[i] > b[j]) {
                c[k++] = b[j++];
            }else {
                c[k++] = a[i++];
                c[k++] = b[j++];
            }
        }

        if(i < a.length) {
            while(i < a.length){
                c[k++] = a[i++];
            }
        }
        if(j < b.length) {
            while (j < b.length) {
                c[k++] = b[j++];
            }
        }
        return c;
    }
}
