package preparation.arrays;

import java.util.ArrayList;

public class PowerSets {
    /**
     * Write a method to return all subsets of all set
     * say {1,2} result = {}, {1},{2},{1,2}
     */

    public static void getSubSet(int x, int[] a, ArrayList<Integer> subSet) {
        int index = 0;
        for(int i = x; i > 0; i >>= 1 ) {
            if((i & 1) == 1) {
                subSet.add(a[index]);
            }
            index++;
        }
    }
    public static void printallSets(int[] a) {
        int max = 1 << a.length;
        ArrayList<ArrayList<Integer>> allSubSets = new ArrayList<>();
        for(int i = 0; i < max; i++) {
            ArrayList<Integer> subSet = new ArrayList<>();
            getSubSet(i, a, subSet);
            allSubSets.add(subSet);
        }
        for(ArrayList<Integer> subSet : allSubSets) {
            if(subSet.size() == 0) {
                System.out.print("{} ");
            }else {
                System.out.print("{");
                for (int val : subSet) {
                    System.out.print(val + " ");
                }
                System.out.print("} ");
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        printallSets(a);
    }
}
