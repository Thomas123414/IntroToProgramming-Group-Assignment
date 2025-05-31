package src.utils;
import java.util.Scanner;
import static src.utils.ConsoleFormating.*;

public class Navigation {
    private static final Scanner Input = new Scanner(System.in);
    private static int CurrentLocation = 02;
    private static int PX = 0, PY = 0;
    private static int IndexLocation;
    private static int TempIndexLocation;
    private static int TempPX = 0, TempPY = 0;

    private static final String[] Locations = {
        "AbandonedHouses",                "Forest",                   "Hercules Home",             "Pathway",                           "VillainMountainBase",
        "Unknown",                        "Shop",                     "Village",                   "Venice",                            "Unknown",
        "Unknown",                        "Unknown",                  "Warehouse",                 "Front",                             "BackAlley",
        "Unknown",                        "Unknown",                  "BridgeRoute",               "Unknown",                           "Bridge",
        "Unknown",                        "Unknown",                  "Unknown",                   "Unknown",                           "EndGame"
    };

    public static int getLocationIndex() {
        PX = CurrentLocation % 5;
        PY = CurrentLocation / 5;
        IndexLocation = PY * 5 + PX;
        return LocationIndex[IndexLocation];
    }

    private static int[] LocationIndex = {
            1, 1, 1, 1, 3,
            0, 2, 1, 1, 0,
            0, 0, 5, 4, 1,
            0, 0, 0, 0, 6,
            0, 0, 0, 0, 1
    };

    private static final boolean[] LocationsVisited = {
            true, false, false, false, false,
            false, false, false, false, false,
            false, false, false, false, false,
            false, false, false, false, false,
            false, false, false, false, false
    };



    private static final boolean[] CombatLocations = {
            false, true, false, false, true,
            false, false, false, false,  false,
            false, false, false, false, false,
            false, false, false, false,  true,
            false, false, false, false, true
    };

    public static int getCombatIndex() {
        PX = CurrentLocation % 5;
        PY = CurrentLocation / 5;
        IndexLocation = PY * 5 + PX;
        return CombatIndex[IndexLocation];
    }

    public static int[] CombatIndex = {
            0, 1, 0, 0, 0,
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 4
    };

    public static int getSearchIndex() {
        PX = CurrentLocation % 5;
        PY = CurrentLocation / 5;
        IndexLocation = PY * 5 + PX;
        return SearchIndex[IndexLocation];
    }

    public static int[] SearchIndex = {
            2, 1, 1, 3, 4,
            0, 0, 1, 1, 0,
            0, 0, 0, 5, 7,
            0, 0, 0, 0, 8,
            0, 0, 0, 0, 9
    };

    public static int getUseIndex() {
        PX = CurrentLocation % 5;
        PY = CurrentLocation / 5;
        IndexLocation = PY * 5 + PX;
        return UseIndex[IndexLocation];
    }

    private static int[] UseIndex = {
            0, 0, 0, 0, 1,
            0, 0, 0, 0, 0,
            0, 0, 2, 0, 3,
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0
    };

    public static void Navigate(Player player, Fighting Fighting, Npc npc) {
        int tempLocation = CurrentLocation;
        PX = CurrentLocation % 5;
        PY = CurrentLocation / 5;
        IndexLocation = PY * 5 + PX;

        print("You reside within the region of " + Locations[IndexLocation] + ", where do you want to go from here?");
        lineBreak();
            System.out.println("Current Location: " + PY + PX);
            boolean LoopActive = true;

            map();
            print("'N' = North, 'S' = South, 'W' = West, 'E' = East, '/' = Cancel Travel");

            while (LoopActive) {
                print("Enter Your Choice: ");
                String Movement = Input.nextLine().toUpperCase();
                if (Movement.isEmpty()) {
                    print("You need to enter your movement input");
                } else {
                    switch (Movement) {
                        case "N":
                            if (PY != 0) {
                                CurrentLocation -= 5;
                                LoopActive = false;
                            } else {
                                continue;
                            }
                            break;
                        case "S":
                            if (PY != 4) {
                                CurrentLocation += 5;
                                LoopActive = false;
                            } else {
                                continue;
                            }
                            break;
                        case "W":
                            if (PX != 0) {
                                CurrentLocation -= 1;
                                LoopActive = false;
                            } else {
                                continue;
                            }
                            break;
                        case "E":
                            if (PX != 4) {
                                CurrentLocation += 1;
                                LoopActive = false;
                            } else {
                                continue;
                            }
                            break;
                    }
                }


                PX = CurrentLocation % 5;
                PY = CurrentLocation / 5;
                IndexLocation = PY * 5 + PX;

                if (LocationIndex[IndexLocation] == 0) {
                    println("Cant travel here!");
                    CurrentLocation = tempLocation;

                    PX = CurrentLocation % 5;
                    PY = CurrentLocation / 5;
                    IndexLocation = PY * 5 + PX;
                    map();
                    print("Your traveled to " + Locations[IndexLocation]);
                    lineBreak();
                } else if (LocationIndex[IndexLocation] == 2) {
                    Npc.ExampleShop(player);
                    PX = CurrentLocation % 5;
                    PY = CurrentLocation / 5;
                    IndexLocation = PY * 5 + PX;
                }
                else if (LocationIndex[IndexLocation] == 5 && tempLocation == 12) {
                    CurrentLocation = tempLocation;
                    println("Rough terrain in that direction, Have to turn around!");
                    PX = CurrentLocation % 5;
                    PY = CurrentLocation / 5;
                    IndexLocation = PY * 5 + PX;
                    map();
                    print("Your traveled to " + Locations[IndexLocation]);
                    lineBreak();
                }
                else if (LocationIndex[IndexLocation] == 19 && CombatIndex[IndexLocation] == 0) {
                    println("Looks like you have to destory this wall in the way! To go in that direction!");
                    CurrentLocation = tempLocation;
                    PX = CurrentLocation % 5;
                    PY = CurrentLocation / 5;
                    IndexLocation = PY * 5 + PX;
                    map();
                    print("Your traveled to " + Locations[IndexLocation]);
                    lineBreak();
                }
                else {
                    map();
                    print("Your traveled to " + Locations[IndexLocation]);

                    lineBreak();
                    if (CombatLocations[IndexLocation] == true) {
                        player.setIsFighting(true);
                        Fighting.Fighting(player, npc);
                    }
                }
            }
        }



    public static void map() {
        PX = CurrentLocation % 5;
        PY = CurrentLocation / 5;

        println("Map Key: P = Players, 0 = Travelable Locations, - = Non-Travelable Locations");
        for (int y = 0; y < 5; y++) {
            System.out.println("+---+---+---+---+---+");
            for (int x = 0; x < 5; x++) {
                System.out.print("| ");
                if (PY == y && PX == x) {
                    print("P ");
                } else if ((PX == x && (PY == y - 1 || PY == y + 1) || (PY == y && (PX == x - 1 || PX == x + 1))))
                {
                    print("O ");
                }
                else {
                    print("- ");
                }
            }
            System.out.println("|");
        }
        System.out.println("+---+---+---+---+---+");
    }

    public static void ViewMap() {
        PX = CurrentLocation % 5;
        PY = CurrentLocation / 5;
        IndexLocation = PY * 5 + PX;

        println("You currently reside in the location " + Locations[IndexLocation]);
        map();

        if (PY > 0) {
            print("North of you is the " + Locations[IndexLocation - 5]);
            lineBreak();
        }
        if (PY < 4) {
            print("South of you is the " + Locations[IndexLocation + 5]);
            lineBreak();
        }
        if (PX > 0) {
            print("West of you is the " + Locations[IndexLocation- 1]);
            lineBreak();
        }
        if (PX < 4) {
            print("East of you is the " + Locations[IndexLocation + 1]);
            lineBreak();
        }
    }

    public static void setCurrentLocation(int Location) {
        CurrentLocation = Location;
    }

}
