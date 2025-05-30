package src;
import src.utils.*;
import static src.utils.ConsoleFormating.*;
import java.util.Random;
import java.util.Scanner;

public class GameMainFile {
    public static void main(String[] args) {
            Navigation.Navigate();

            Player Player1 = new Player(100, true);
            GameItems MapFrag = new GameItems("Map_Fragment1", "This fragment suggests we go west of your home, It might be worth gathering there!", 0, "Map");
            Player1.addInventoryItem(MapFrag);

            GameItems coins = new GameItems("coins", "a", 100, "a");
            Player1.addInventoryItem(coins);
            GameItems bandage = new GameItems("bandage", "a", 0, "a");
            Player1.addInventoryItem(bandage);

            Player.search(Player1);
            Player.search(Player1);
            Player.search(Player1);
            Player.search(Player1);
            System.out.println(Player.CheckInventory());

            Npc npc = new Npc();
            npc.ExampleShop(Player1);
            System.out.println(Player.CheckInventory());

    }
}