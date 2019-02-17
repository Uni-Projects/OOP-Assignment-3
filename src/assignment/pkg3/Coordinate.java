package assignment.pkg3;

/**
 *
 * @author Paolo Scattolin s1023775
 * @author Johan Urban s1024726
 *
 * This class is used to better handle coordinates for the objects.
 */
public class Coordinate {

    private double x;
    private double y;

    public Coordinate(double x1, double y1) {
        this.x = x1;
        this.y = y1;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void moveCoord(double dx, double dy) {
        x += dx;
        y += dy;
    }

}
