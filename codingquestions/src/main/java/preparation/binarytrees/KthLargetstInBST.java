package preparation.binarytrees;

public class KthLargetstInBST {
    /**
     * print / find kth largest element of given binary search tree
     * idea: do reverse inOrder.
     */

    private static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static Node root;
    public void insert(int val)
    {
        this.root = this.insertRec(this.root, val);
    }

    /* A utility function to insert a new node  
    with given key in BST */
    Node insertRec(Node node, int val)
    {
        /* If the tree is empty, return a new node */
        if (node == null) {
            this.root = new Node(val);
            return this.root;
        }

        if (val == node.val) {
            return node;
        }

        /* Otherwise, recur down the tree */
        if (val < node.val) {
            node.left = this.insertRec(node.left, val);
        } else {
            node.right = this.insertRec(node.right, val);
        }
        return node;
    }
    static class Count {
        int c = 0;
    }

    public static void kthLargestUtil(Node root, int k, Count count) {
        if(root == null || count.c >= k) {
            return;
        }
        kthLargestUtil(root.right, k, count);
        count.c++;
        if(count.c == k) {
            System.out.println(k + "th largest: " + root.val);
            return;
        }
        kthLargestUtil(root.left, k, count);
    }

    public static void kthLargest(int k) {
        Count count = new Count();
        kthLargestUtil(root,k, count);
    }
    public static void main(String[] args) {
        KthLargetstInBST tree = new KthLargetstInBST();
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        for (int i = 1; i <= 7; i++) {
            tree.kthLargest(i);
        }
    }
}
