package assignment.pkg3;

/**
 *
 * @author Paolo Scattolin s1023775
 * @author Johan Urban s1024726
 *
 * Main interface with functions for all geometric objects.
 */
public interface Geometric extends Comparable<Geometric> {

    double area();

    void move(double x, double y);

    double getLeft();

    double getRight();

    double getTop();

    double getBottom();
}
