package src;
import src.utils.*;
import static src.utils.ConsoleFormating.*;
import static src.utils.Navigation.*;
import java.util.Random;
import java.util.Scanner;

public class GameMainFile {
    public static void main(String[] args) {
        boolean gameRunning = true;
        boolean repeatOptions = true;
        GameWeapons Weapon1 = new GameWeapons("gun", "Medium damage weapon that comes with every detective", 9);
        Npc Npc1 = new Npc();
        Fighting fighting1 = new Fighting();
        Random ValueRND = new Random();
        Scanner Input = new Scanner(System.in);

        do {
            Player player1 = new Player(100, true);
            do {
                println("What would you like to do? (1)Travel, (2)View map, (3) Check Inventory, (4) Search Location, (5) Use Item or Set Weapon from Inventory");
                int choice = Input.nextInt();
                    switch (choice) {
                        // Use item
                        case 1 -> {
                            println("<=-- Travel --=>");
                            Navigation.Navigate(player1, fighting1, Npc1);
                        }
                        // Move
                        case 2 -> {
                            println("<=-- View Map --=>");
                            Navigation.map();
                        }
                        // View Map
                        case 3 -> {
                            print(YELLOW, "<=-- Viewing Maps --=>");
                            lineBreak(2);
                            Navigation.viewCombinedMap();
                        }
                        // Search
                        case 4 -> {
                            print(YELLOW, "<=-- Searching Location --=>");
                            lineBreak(2);
                            playerCharacter.search();
                        }
                        // Rest
                        case 5 -> {
                            print(YELLOW, " <=-- Resting --=>");
                            lineBreak(2);
                            playerCharacter.rest();
                        }
                        // Check Character
                        case 6 -> {
                            print(YELLOW, "<=-- Checking Character --=>");
                            lineBreak(2);
                            playerCharacter.checkCharacter();
                        }
                        // Add all nuclear cores to the player's backpack for testing purposes
                        case 5428 -> {
                            print(YELLOW, "<=-- Adding Nuclear Cores --=>");
                            lineBreak(2);
                            for (int i = 0; i < 9; i++) {
                                playerCharacter.addBackpackItem(new Items("Nuclear Core " + (i + 1), 0, 0, 2));
                            }
                            lineBreak();
                        }
                        // Invalid choice
                        default -> {
                            printSeperator = false;
                            clearLine(2);
                        }
                    }
                }

                if (printSeperator) {
                    lineBreak();
                    printSpacer();
                }

                if (!playerCharacter.getIsAlive()) {
                    print(RED, "+--------------------------------------------------+");
                    lineBreak();
                    print(RED, "| You failed to complete the mission... Game Over  |");
                    lineBreak();
                    print(RED, "+--------------------------------------------------+");
                    lineBreak();
                    lineBreak();
                    print("Do you want to play again? " + colour(BLUE, "(Y)es / (N)o"));
                    lineBreak();
                    repeatOptions = false;
                } else if (playerCharacter.getIsGameEnding()){
                    lineBreak();
                    print(GREEN, "+--------------------------------------------------+");
                    lineBreak();
                    print(GREEN, "|       You completed the mission! Game Over       |");
                    lineBreak();
                    print(GREEN, "+--------------------------------------------------+");
                    lineBreak();
                    lineBreak();
                    print("Do you want to play again? " + colour(BLUE, "(Y)es / (N)o"));
                    lineBreak();
                    repeatOptions = false;
                }
            } while (repeatOptions);
    }
}