package preparation;

import preparation.binarytrees.BinaryTree;
import preparation.linkedlists.LinkedList;
import preparation.sorting.HeapSort;

/**
 * Hello world!
 *
 */
public class App
{

    public static void printDuplicates() {
        int numRay[] = {0, 4, 3, 2, 7, 8, 2, 3, 1};

        for (int i = 0; i < numRay.length; i++) {
            numRay[numRay[i] % 10] = numRay[numRay[i] % 10] + 10;
        }
        System.out.println("The repeating elements are : ");
        for (int i = 0; i < numRay.length; i++) {
            if (numRay[i] > 19) {
                System.out.println(i + " ");
            }
        }

    }

    public static int binSearch(int[] a, int key) {
        //TODO: Write - Your - Code
        int start = 0;
        int end = a.length -1;

        while(start <= end) {
            int m = start + (end - start) /2 ;
            if(a[m] == key) {
                return m;
            }
            if(a[m]> key) {
                end = m-1;
            }else {
                start = m+1;
            }
        }
        return -1;
    }
    public static void simpleBinarySearch() {
        //int[] nums= {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        int[] nums = {1, 2, 4, 7, 8, 12, 15, 19, 24, 50, 69, 80, 100};
        int key = 100;
        int res = binSearch(nums, key);
        System.out.println("Result: " + res);
    }
    public static void main( String[] args )
    {
       //linkedListProblems();
       // binaryTreeProblems();
       // heapSortProblems();
       // printDuplicates();
        simpleBinarySearch();
    }

    public static void heapSortProblems() {
        HeapSort heapSort = new HeapSort();
        int[] a= {1,2,12,15};
        int[] b = {2,4,9,13,14};
        int[] result = heapSort.merge(a,b);
        int i = 0;
        while(i < result.length) {
            System.out.println(result[i]);
            i++;
        }
    }
    public static void binaryTreeProblems() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createSampleTree();
        //binaryTree.printInorder(binaryTree.getRoot());

        int n1 = 60;
        int n2 = 10;

        try {
            int lca = binaryTree.lca(n1, n2);
            System.out.println("lca for " + n1 + " : " + n2 + " is " + lca);
        } catch (NullPointerException e) {
            System.out.println("No lca found  ");
        }
    }

    public static void linkedListProblems() {
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        System.out.println("list:");
        ll.print();
        System.out.println("After reverse");
        //ll.reverse();
        ll.reverseItr();
        ll.print();
    }
}
