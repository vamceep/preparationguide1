package preparation.misc;

public class RectangleInterSection {
    /**
     * find given coordinates bottom left and top right of two rectangle,
     * check if they intersect and return intersection coordinates.
     *
     * https://www.geeksforgeeks.org/intersecting-rectangle-when-bottom-left-and-top-right-corners-of-two-rectangles-are-given/
     *
     * https://leetcode.com/problems/rectangle-overlap/
     */

    private static  class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private static class Rectangle {
        Point c1;
        Point c2;
        public Rectangle(Point c1, Point c2) {
            this.c1 = c1;
            this.c2 = c2;
        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "c1=" + c1 +
                    ", c2=" + c2 +
                    '}';
        }
    }

    private static boolean isIntersecting(Rectangle r1, Rectangle r2) {
        return  (r1.c1.x < r2.c1.x || r1.c2.x > r2.c2.x || r1.c1.y > r2.c1.y || r1.c2.y < r2.c2.y);
    }
    private static Rectangle getIntersection(Rectangle r1, Rectangle r2) {
        boolean intersect = isIntersecting(r1,r2);
        if(intersect == false) {
            return null;
        }
        int x1 = Math.max(r1.c1.x, r2.c1.x);
        int y1 = Math.max(r1.c1.y, r2.c1.y);
        int x2 = Math.min(r1.c2.x, r2.c2.x);
        int y2 = Math.min(r1.c2.y, r2.c2.y);

        Rectangle r = new Rectangle(new Point(x1, y2) , new Point(x2, y1));
        return r;
    }
    public static void main(String[] args) {
        Rectangle r1  = new Rectangle(new Point(0,10), new Point(10,0));
        Rectangle r2 = new Rectangle(new Point(5,5), new Point(15,0));

        Rectangle r = getIntersection(r1, r2);
        if(r != null) {
            System.out.println(r);
        }else {
            System.out.println("doesn't intersect");
        }
    }


}
