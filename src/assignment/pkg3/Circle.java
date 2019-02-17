package assignment.pkg3;

/**
 *
 * @author Paolo Scattolin s1023775
 * @author Johan Urban s1024726
 *
 * This class handles circles attributes and methods
 */
public class Circle implements Geometric {

    private int radius;
    private Coordinate centre;

    public Circle(double x, double y, int r) {
        this.radius = Math.abs(r);
        this.centre = new Coordinate(x, y);
    }

    /**
     *
     * @return left border distance from x-axis.
     */
    @Override
    public double getLeft() {
        return centre.getX() - radius;
    }

    /**
     *
     * @return right border distance from x-axis.
     */
    @Override
    public double getRight() {
        return centre.getX() + radius;
    }

    /**
     *
     * @return bottom border distance from y-axis.
     */
    @Override
    public double getBottom() {
        return centre.getY() - radius;
    }

    /**
     *
     * @return top border distance from y-axis.
     */
    @Override
    public double getTop() {
        return centre.getY() + radius;
    }

    /**
     *
     * @return area of the circle
     */
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     *
     * @param x distance in the x axis
     * @param y distance in the y axis
     */
    @Override
    public void move(double x, double y) {
        centre.moveCoord(x, y);
    }

    @Override
    public String toString() {
        return "Circle with centre at (" + centre.getX() + ";" + centre.getY() + ") , Radius: " + radius;
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
