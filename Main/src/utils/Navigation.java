package src.utils;
import java.util.Scanner;
import static src.utils.ConsoleFormating.*;

public class Navigation {
    private static final Scanner Input = new Scanner(System.in);
    private static int CurrentLocation = 8;
    private static int PX = 0, PY = 0;
    private static int IndexLocation;
    private static int TempIndexLocation;
    private static int TempPX = 0, TempPY = 0;

    private static final String[] Locations = {
        "HerculesHome",                   "Forest",                   "Pathway",                   "villainMountainBase",                   "Unknown",
        "Unknown",                        "Unknown",                  "AbandonedHouses",           "Venice",                                "Shop",
        "Unknown",                        "Unknown",                  "Warehouse",                 "BackAlley",                             "Front",
        "Unknown",                        "Unknown",                  "Unknown",                   "BridgeRoute",                           "Unknown",
        "Unknown",                        "Unknown",                  "Unknown",                   "Lair",                                  "Unknown"
    };

    private static final boolean[] LocationsVisited = {
            true, false, false, false, false,
            false, false, false, false, false,
            false, false, false, false, false,
            false, false, false, false, false,
            false, false, false, false, false
    };

    private static final boolean[] CombatLocations = {
            false, false, false, false, false,
            false, false, false, false,  false,
            false, false, false, false, false,
            false, false, false, false,  false,
            false, false, false, false, false
    };

    public static void Navigate() {
        map();
    }

    public static void map() {
        // Calculate player's current location
        PX = CurrentLocation % 5;
        PY = CurrentLocation / 5;

        println("Map Key: P = Players, 0 = Travelable Locations, - = Non-Travelable Locations");

        // Print the map
        for (int y = 0; y < 5; y++) {
            System.out.println("+---+---+---+---+---+");
            for (int x = 0; x < 5; x++) {
                System.out.print("| ");
                if (PY == y && PX == x) {
                    print("P "); // Player's current location
                } else if ((PX == x && (PY == y - 1 || PY == y + 1) || (PY == y && (PX == x - 1 || PX == x + 1))))
                {
                    print("O "); // Travelable locations
                }
                else {
                    print("- "); // Non-travelable locations
                }
            }
            System.out.println("|");
        }
        System.out.println("+---+---+---+---+---+");
    }

    public static void ViewMap() {
        // Calculate the coordinates and relative index of the player's location
        PX = CurrentLocation % 5;
        PY = CurrentLocation / 5;
        IndexLocation = PY * 5 + PX;

        // Print the player's current location
        println("You currently reside in the location " + Locations[IndexLocation]);

        // Print the map
        map();

        if (PY > 0) {
            print("Above you is the " + Locations[IndexLocation - 5]);
            lineBreak();
        }
        if (PY < 4) {
            print("Below you is the " + Locations[IndexLocation + 5]);
            lineBreak();
        }
        if (PX > 0) {
            print("To the Left of you is the " + Locations[IndexLocation- 1]);
            lineBreak();
        }
        if (PX < 4) {
            print("To the Right of you is the " + Locations[IndexLocation + 1]);
            lineBreak();
        }
    }

}
