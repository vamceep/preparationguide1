package preparation.interview;

public class Questions {


    public static void printBits(int[] arr, int s, int e) {
        if(s==e) {
            for(int i=0;i<e;i++) {
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
            return;
        }
        arr[s] = 0;
        printBits(arr, s+1, e);
        arr[s]=1;
        printBits(arr, s+1, e);
    }

    public static void main(String[] args) {
        int n = 3;
        int[] arr= new int[n];
        for(int i=0; i< n;i++) {
            arr[i]=0;
        }
        printBits(arr, 0, n);

    }
}
