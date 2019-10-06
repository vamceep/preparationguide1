package preparation
        ;

/**
 * Hello world!
 *
 */
public class App
{
    static class Node {
        int data;
        public Node(int data) {
            this.data = data;
        }
    };
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Node node = new Node(5);
        System.out.println("data: " + node.data);
    }

}
