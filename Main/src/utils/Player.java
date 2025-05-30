package src.utils;
import java.util.ArrayList;
import java.util.Random;
import static src.utils.ConsoleFormating.*;
import static src.utils.GameItems.*;

public class Player {
    private String name = "Hercule";
    private String fullName = "Hercule Cage";
    private int health;
    private GameWeapons weapon;
    private boolean isAlive;
    private boolean isFighting;
    private final ArrayList<GameItems> Inventory = new ArrayList<>();

    private static final Random ValueRND = new Random();
    public Player(int health, boolean isAlive) {
        this.health = health;
        this.isAlive = isAlive;
    }

    public String CheckInventory() {
        StringBuilder InventoryString = new StringBuilder();
        print("You are carrying the following items: ");
        if (Inventory.isEmpty()) {
            print("Your backpack is empty.");
        }
        else {
            for (GameItems GameItems : Inventory) {
                InventoryString.append(String.format("- (%d) %s\n", Inventory.indexOf(GameItems) + 1, GameItems.getItemName()));
            }
        }
        return InventoryString.toString();
    }

    GameWeapons Weapon = new GameWeapons("Gun", "Goes Pew Pew", 9);

    public boolean getInventoryItem(String name) {
        for (GameItems gameitems : Inventory) {
            if (gameitems.getItemName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void search(Player player) {
        switch (Navigation.getSearchIndex()) {
            case 0 -> print("You looked around but couldn't find anything useful.");
            case 1 -> {
                int RNDSearch = ValueRND.nextInt(2);
                GameItems[] gameItems = {
                        new GameItems("coins", "Curreny to help buy items from a shop", 10, "Curreny"),
                        new GameItems("bandage", "Healable Item, Heals you for a total 10 health", 1, "Healable Item"),
                };
                GameItems SearchedForItemRND = gameItems[RNDSearch];
                player.addInventoryItem(SearchedForItemRND);
            }
            case 2 -> {
                print("Yourmum 64");
            }
        }
    }

    public void addInventoryItem(GameItems gameitem) {
        Inventory.add(gameitem);
    }

    // Remove an item from the player's backpack
    public void removeInventoryItem(GameItems gameitem) {
        Inventory.remove(gameitem);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setWeapon(GameWeapons weapon) {
        this.weapon = weapon;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setIsFighting(boolean isFighting) {
        this.isFighting = isFighting;
    }

    public int getHealth() {
        return health;
    }

    public GameWeapons getWeapon() {
        return weapon;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public boolean getIsFighting() {
        return isFighting;
    }
}
