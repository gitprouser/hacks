/**
 * Created dgayash on 3/11/17.
 */
public class Rectangle {

    int x, y, width, height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public String toString() {
        return "[" + "(" + this.x + "," + this.y + "),"
                + "(" + (this.x + this.width) + "," + this.y + "),"
                + "(" + this.x + "," + (this.y + this.height) + "),"
                + "(" + (this.x + this.width) + "," + (this.y + this.height) + ")"
                + "]";
    }

    public static Rectangle intersectRectangle(Rectangle r1, Rectangle r2) {
        if (!isIntersect(r1, r1)) {
            return new Rectangle(0, 0, -1, -1); // No intersecting Rectangle found
        }

        return new Rectangle(
                Math.max(r1.x, r2.x), // x
                Math.max(r1.y, r2.y), // y
                Math.min(r1.x + r1.width, r2.x + r2.width) - Math.max(r1.x, r2.x), // width
                Math.min(r1.y + r1.height, r2.y + r2.height) - Math.max(r1.y, r2.y) // height
        );
    }

    public static boolean isIntersect(Rectangle r1, Rectangle r2) {
        return r1.x <= r2.x + r2.width
                && r1.x + r1.width >= r2.x
                && r1.y <= r2.y + r2.height;
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(0, 0, 5, 10);
        Rectangle r2 = new Rectangle(2, 5, 5, 10);

        System.out.println("R1:" + r1);
        System.out.println("R2:" + r2);

        System.out.println("Result:" + intersectRectangle(r1, r2));
    }
}
