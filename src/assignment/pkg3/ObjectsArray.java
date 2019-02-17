package assignment.pkg3;

import java.util.Arrays;

/**
 *
 * @author Paolo Scattolin s1023775
 * @author Johan Urban s1024726
 *
 * This class is responsible for the management of the array containing our
 * geometric objects. It also keeps track of the number of elements.
 */
public class ObjectsArray {

    private Geometric[] objects;
    private int numOfObjects;
    final int MAXSIZE;

    public ObjectsArray() {

        this.MAXSIZE = 10;
        this.objects = new Geometric[MAXSIZE];
        this.numOfObjects = 0;

    }

    /**
     *
     * @return true if there is enough space in the array to place a new circle,
     * in that case it creates one and place it at the end of the array. Returns
     * false otherwise.
     */
    boolean addObject(double x, double y, int r) {

        if (numOfObjects < 10) {
            objects[numOfObjects] = new Circle(x, y, r);
            numOfObjects++;
            return true;
        } else {
            return false;
        }

    }

    /**
     *
     * @return true if there is enough space in the array to place a new
     * rectangle, in that case it creates one and place it at the end of the
     * array. Returns false otherwise.
     */
    boolean addObject(double x, double y, int h, int w) {

        if (numOfObjects < 10) {
            objects[numOfObjects] = new Rectangle(x, y, h, w);
            numOfObjects++;
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return number of current objects in the array.
     */
    int getNumOfObjects() {
        return numOfObjects;
    }

    /**
     *
     * @return the array of objects.
     */
    Geometric[] getObjects() {
        return objects;
    }

    /**
     *
     * @return true if the index provided is valid and in that case it deletes
     * the objects at that index by shifting back the position of the objects
     * after that index. Return false otherwise.
     */
    boolean deleteObject(int index) {

        if (index <= numOfObjects) {

            for (int i = index; i < (numOfObjects - 1); i++) {
                objects[i] = objects[i + 1];
            }
            objects[numOfObjects - 1] = null;  //this is to prevent out of bound stuff that may lead to unspecified behavior.
            numOfObjects--;
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return true if the index provided is valid and in that case it moves the
     * object at index by x and y. Returns false otherwise.
     */
    boolean moveObject(int index, double x, double y) {

        if (index < numOfObjects) {
            objects[index].move(x, y);
            return true;
        } else {
            return false;
        }
    }

    void sortByArea() {
        Arrays.sort(objects, 0, (numOfObjects));
    }

    void sortByLeft() {
        LeftComparator comparator = new LeftComparator();
        Arrays.sort(objects, 0, (numOfObjects), comparator);
    }

    void sortByBottom() {
        BottomComparator comparator = new BottomComparator();
        Arrays.sort(objects, 0, (numOfObjects), comparator);
    }
}
