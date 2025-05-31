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
        GameItems MapFrag1 = new GameItems("mapFrag1", "Map to village", 1, "Map");
        GameItems gun = new GameItems("gun", "Medium damage weapon that comes with every detective", 1, "Weapon");
        Npc Npc1 = new Npc();
        Fighting fighting1 = new Fighting();
        Random ValueRND = new Random();
        Scanner Input = new Scanner(System.in);


            Player player1 = new Player(100, true);
            player1.addInventoryItem(MapFrag1);
            player1.addInventoryItem(gun);
            do {
                println("What would you like to do? (1)Travel, (2)View map, (3) Check Inventory, (4) Search Location, (5) Use Item or Set Weapon from Inventory");
                int choice = Input.nextInt();
                    switch (choice) {
                        // Use item
                        case 1 -> {
                            println(" Travel ");
                            Navigation.Navigate(player1, fighting1, Npc1);
                        }
                        // Move
                        case 2 -> {
                            println(" View Map ");
                            Navigation.map();
                            Navigation.ViewMap();
                        }
                        // View Map
                        case 3 -> {
                            println(" Check Inventory ");
                            player1.CheckInventory();
                        }
                        // Search
                        case 4 -> {
                            println(" Searching Location ");
                            Player.search(player1);
                        }
                        // Rest
                        case 5 -> {
                            println(" Use Item or Set Weapon from Inventory ");
                            Player.useItem(player1, Weapon1, Npc1);
                        }
                        default -> {
                            println("Not a valid input! Make sure to enter a number 1 and 5!");
                        }
                    }
                if (player1.getIsAlive() == false) {
                    println("You failed!");
                    repeatOptions = false;
                }
            } while (repeatOptions);
    }
}