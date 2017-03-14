/**
 * Created dgayash on 3/10/17.
 */
public class IntersectingRectangles {

    static class EndPoint implements  Comparable<EndPoint> {
        Rect rect;
        boolean isStart;
        double val;

        EndPoint (Rect r, boolean start, double v) {
            this.rect = r;
            this.isStart = start;
            this.val = v;
        }

        public int compareTo(EndPoint other) {
            int ret;
            double diff = this.val - other.val;

            if (diff == 0)
                ret = 0;
            else
                ret = (diff > 0) ? 1 : -1;

            return ret;
        }
    }

    static class Rect {
        Rect (double minX, double minY, double maxX, double maxY) {
//            xStart = new E
        }
    }

    public static void main(String[] args) {

    }
}
