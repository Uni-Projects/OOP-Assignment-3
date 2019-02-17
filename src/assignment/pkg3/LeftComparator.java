package assignment.pkg3;

/**
 *
 * @author Paolo Scattolin s1023775
 * @author Johan Urban s1024726
 *
 */
import java.util.Comparator;

public class LeftComparator implements Comparator<Geometric> {

    @Override
    public int compare(Geometric o1, Geometric o2) {
        double res;
        res = o1.getLeft() - o2.getLeft();
        if (res < 0) {
            return -1;
        } else if (res > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
