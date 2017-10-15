import world.World;

import java.util.Scanner;

public class ViagogoGrid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        World world = new World();

        runLoop(sc, world);
    }

    private static void runLoop(Scanner sc, World world) {
        String response;

        do {
            print("Please Input Coordinates. Enter 'q' to quit.\n");
            response = clearWhitespace(sc.nextLine());

            if (response.equals("q"))
                break;

            try {
                String[] coordinates = response.split(",");

                if (coordinates.length != 2)
                    throw new IllegalArgumentException();

                print("\nClosest events to (" + coordinates[0] + "," + coordinates[1] + ")\n");

                world.printNearestNumberEvents(Integer.parseInt(coordinates[0]),
                                             Integer.parseInt(coordinates[1]));

            } catch (IllegalArgumentException e) {
                print("Error: " + e.toString());
            }

        } while (!response.equals("q"));
    }

    private static void print(String str) {
        System.out.println(str);
    }

    private static String clearWhitespace(String s) {
        return s.replaceAll("\\s+","");
    }
}


