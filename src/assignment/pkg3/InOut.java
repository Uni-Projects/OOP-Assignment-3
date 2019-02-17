package assignment.pkg3;

/**
 *
 * @author Paolo Scattolin s1023775
 * @author Johan Urban s1024726
 *
 * This class handles all the inputs and shows the results on screen giving
 * feedback on the success of the operations.
 */
import java.util.Scanner;

public class InOut {

    private ObjectsArray array;
    private Scanner scan;
    private String action;
    private String args;
    private boolean quit;
    private double x;
    private double y;
    private int pr1;
    private int pr2;

    public InOut() {
        array = new ObjectsArray();
        scan = new Scanner(System.in);
        this.quit = false;
    }

    /**
     *
     * starts the program loop that ask for new user input until the command
     * quit is inserted. The outer switch is for the command and for every case
     * the scanner will look for different inputs. In case sort there's an
     * additional switch for the different kind, or lack of arguments that the
     * user may use.
     */
    void startProgram() {
        printMenu();
        while (!quit) {
            action = scan.next();
            switch (action) {
                case "quit":
                    quit = true;
                    System.out.println("Program Terminated!");
                    break;

                case "circle":
                    x = scan.nextDouble();
                    scan.skip("\\s*");
                    y = scan.nextDouble();
                    scan.skip("\\s*");
                    pr1 = scan.nextInt();
                    if (array.addObject(x, y, pr1)) {
                        System.out.println("Circle added successfully!");
                    } else {
                        System.out.println("Too many objects on the list, delete some!");
                    }
                    break;

                case "rectangle":
                    x = scan.nextDouble();
                    scan.skip("\\s*");
                    y = scan.nextDouble();
                    scan.skip("\\s*");
                    pr1 = scan.nextInt();
                    scan.skip("\\s*");
                    pr2 = scan.nextInt();
                    if (array.addObject(x, y, pr1, pr2)) {
                        System.out.println("Rectangle added successfully!");
                    } else {
                        System.out.println("Too many objects on the list, delete some!");
                    }
                    break;

                case "move":
                    pr1 = scan.nextInt();
                    scan.skip("\\s*");
                    x = scan.nextDouble();
                    scan.skip("\\s*");
                    y = scan.nextDouble();
                    if (array.moveObject(pr1, x, y)) {
                        System.out.println("Object moved successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case "remove":
                    pr1 = scan.nextInt();
                    if (array.deleteObject(pr1)) {
                        System.out.println("Object removed successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case "sort":
                    args = scan.nextLine();
                    args = args.replaceAll("\\s", "");
                    switch (args) {
                        case "x":
                            array.sortByLeft();
                            System.out.println("Objects sorted from left to right position!");
                            break;

                        case "y":
                            array.sortByBottom();
                            System.out.println("Objects sorted from lowest to highest position!");
                            break;

                        case "":
                            array.sortByArea();
                            System.out.println("Objects sorted by area!");
                            break;

                        default:
                            System.out.println("Insert a correct sorting method!");
                    }
                    break;

                case "menu":
                    printMenu();
                    break;

                case "show":
                    for (int i = 0; i < array.getNumOfObjects(); i++) {
                        System.out.println("Object number " + (i + 1));
                        System.out.println(array.getObjects()[i]);
                    }
                    break;

                default:
                    scan.nextLine(); //this is to prevent wierd printing behavior given by invalid inputs.
                    System.out.println("Please insert a valid command!");
            }
        }
    }

    void printMenu() {
        System.out.println("Please, select an action:\n"
                + "  quit              -> stops the program.\n"
                + "  show              -> lists the geometric objects.\n"
                + "  circle x y r      -> adds a circle at (x;y) with radius r.\n"
                + "  rectangle x y h w -> adds a rectangle at (x;y) with height h and width w.\n"
                + "  move dx dy i      -> moves object i over the specified distance in x and y direction.\n"
                + "  remove i          -> deletes object i.\n"
                + "  sort c            -> sorts the objects in the array according to criterion c.\n"
                + "                            ”x”   ->  objects should be sorted by their left most point from small to large.\n"
                + "                            ”y”   ->  objects should be sorted by their bottom point from small to large.\n"
                + "                            empty -> the objects are sorted on their area from small to large.\n"
                + "  menu              -> show the list of possible actions");
    }
}
