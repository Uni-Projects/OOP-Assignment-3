package assignment.pkg3;

/**
 *
 * @author Paolo Scattolin s1023775
 * @author Johan Urban s1024726
 *
 * This class handles rectangles attributes and methods
 */
public class Rectangle implements Geometric {

    private Coordinate leftBottom;
    private int height;
    private int width;

    public Rectangle(double x, double y, int h, int w) {
        this.leftBottom = new Coordinate(x, y);
        this.height = Math.abs(h);
        this.width = Math.abs(w);
    }

    /**
     *
     * @return left border distance from x-axis.
     */
    @Override
    public double getLeft() {
        return leftBottom.getX();
    }

    /**
     *
     * @return right border distance from x-axis.
     */
    @Override
    public double getRight() {
        return leftBottom.getX() + width;
    }

    /**
     *
     * @return bottom border distance from y-axis.
     */
    @Override
    public double getBottom() {
        return leftBottom.getY();
    }

    /**
     *
     * @return top border distance from y-axis.
     */
    @Override
    public double getTop() {
        return leftBottom.getY() + height;
    }

    /**
     *
     * @return area of the rectangle
     */
    @Override
    public double area() {
        return width * height;
    }

    /**
     *
     * @param x distance in the x axis
     * @param y distance in the y axis
     */
    @Override
    public void move(double x, double y) {
        leftBottom.moveCoord(x, y);
    }

    @Override
    public String toString() {
        return "Rectangle with left bottom corner at (" + leftBottom.getX()
                + ";"
                + leftBottom.getY()
                + ") Width: " + width
                + " Height: " + height;
    }

    /**
     *
     * @return result of comparing by area.
     */
    @Override
    public int compareTo(Geometric o) {
        double res;
        res = this.area() - o.area();
        if (res < 0) {
            return -1;
        } else if (res > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
