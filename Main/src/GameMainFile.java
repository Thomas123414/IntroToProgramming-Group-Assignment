package src;
import src.utils.*;
import static src.utils.ConsoleFormating.*;
import java.util.Random;
import java.util.Scanner;

public class GameMainFile {
    public static void main(String[] args) {
            Navigation.Navigate();

            final Player Player1 = new Player(100, true);
            final GameItems MapFrag1 = new GameItems("Map_Fragment1", "This fragment suggests we go west of your home, It might be worth gathering there!", 0, "Map");
            Player1.addInventoryItem(MapFrag1);
            Player.search(Player1);
            Player1.CheckInventory();

    }
}