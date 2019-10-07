package preparation;

import preparation.binarytrees.BinaryTree;
import preparation.linkedlists.LinkedList;
import preparation.binarytrees.BinaryTree.Node;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
       //linkedListProblems();
       binaryTreeProblems();
    }

    public static void binaryTreeProblems() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createSampleTree();
        //binaryTree.printInorder(binaryTree.getRoot());

        int n1 = 200;
        int n2 = 100;

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
