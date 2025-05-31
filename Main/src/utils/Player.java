package src.utils;
import java.util.ArrayList;
import java.util.Scanner;
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
    private static ArrayList<GameItems> Inventory = new ArrayList<>();
    private static Scanner Input = new Scanner(System.in);

    private static final Random ValueRND = new Random();
    public Player(int health, boolean isAlive) {
        this.health = health;
        this.isAlive = isAlive;
    }

    public static void CheckInventory() {
        StringBuilder InventoryString = new StringBuilder();
        print("You are carrying the following items: ");
        if (Inventory.isEmpty()) {
            print("Your backpack is empty.");
        }
        else {
            for (GameItems GameItems : Inventory) {
                if (GameItems.getItemName() == "coins") {
                    InventoryString.append(String.format("- (%d) %s, Amount of coins: %d\n", Inventory.indexOf(GameItems) + 1, GameItems.getItemName(), GameItems.getValue()));
                }
                else if (GameItems.getItemName() == "bandage"){
                    InventoryString.append(String.format("- (%d) %s, Amount of bandages: %d\n", Inventory.indexOf(GameItems) + 1, GameItems.getItemName(), GameItems.getValue()));
                }
                else {
                    InventoryString.append(String.format("- (%d) %s\n", Inventory.indexOf(GameItems) + 1, GameItems.getItemName()));
                }
            }
        }
        System.out.println(InventoryString.toString());
    }

    public GameItems getItem(String string) {
        for (GameItems GameItems : Inventory) {
            if (GameItems.getItemName().equals(string)){
                return GameItems;
            }
        }
        return null;
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
                int RNDSearch = ValueRND.nextInt(2) + 1;
                boolean Itemexistsalready = false;
                GameItems[] gameItems = {
                        new GameItems("coins", "Curreny to help buy items from a shop", 10, "Curreny"),
                        new GameItems("bandage", "Healable Item, Heals you for a total 20 health", 1, "Tool"),
                };
                GameItems SearchedForItemRND = gameItems[RNDSearch - 1];

                for (GameItems GameItems : Inventory) {
                    if (GameItems.getItemName().equals("coins") || GameItems.getItemName().equals("bandage")){
                        Itemexistsalready = true;
                    }
                }
                if (Itemexistsalready == true) {
                    if (RNDSearch == 1) {
                        for (GameItems GameItems : Inventory) {
                            if (GameItems.getItemName().equals("coins")){
                                GameItems.setValue(GameItems.getValue() + 10);
                            }
                        }
                    }
                    else if (RNDSearch == 2) {
                        for (GameItems GameItems : Inventory) {
                            if (GameItems.getItemName().equals("bandage")) {
                                GameItems.setValue(GameItems.getValue() + 1);
                            }
                        }
                    }
                }
                else {
                    player.addInventoryItem(SearchedForItemRND);
                }
            }
            case 2 -> {
                Npc.Tavian(player);
            }
            case 3 -> {
                GameItems dogTag = new GameItems("dogTag", "Tag with the name of the pet that it belonged to", 1, "Quest");
                player.addInventoryItem(dogTag);
            }
            case 4 -> {
                GameItems machette = new GameItems("machette", "Can be used as better weapon with ", 1, "Weapon");
                player.addInventoryItem(machette);
            }
            case 5 -> {
                GameItems keyWarehouse = new GameItems("key", "a key to a location", 1, "Quest");
                player.addInventoryItem(keyWarehouse);
            }
            case 6 -> {
                GameItems explosiveGel = new GameItems("explosiveGel", "a gel that can be used to break through walls or barriers", 1, "Quest");
                GameItems mapFrag3 = new GameItems("mapFragment3", "This fragment suggests to go south of backalley, It might be worth gathering there!", 1, "Map");
                player.addInventoryItem(explosiveGel);
                player.addInventoryItem(mapFrag3);
            }
        }
    }

    public static void useItem(Player player, GameWeapons gameweapon, Npc npc){
        CheckInventory();
        print("What would you like to use? Type the corresponding number to the item you want to use.");
        int inventoryChoice = Input.nextInt();
        if (Inventory.get(inventoryChoice - 1).getItemName().equals("bandage")) {
            GameItems useAddress = player.getItem("bandage");
            if (useAddress.getItemName().equals("bandage") && useAddress.getValue() > 1) {
                useAddress.setValue(useAddress.getValue() - 1);
                player.setHealth(player.getHealth() +20);
                println("You used the bandage and healed you for 20 health.");
            }
            else if (useAddress.getItemName().equals("bandage")) {
                player.removeInventoryItem(useAddress);
                player.setHealth(player.getHealth() + 20);
            }
        }
        else if (Inventory.get(inventoryChoice - 1).getItemName().equals("gun")) {
            gameweapon.setWeaponName("gun");
            gameweapon.setDescription("Medium damage weapon that comes with every detective");
            gameweapon.setDamage(9);
        }
        else if (Inventory.get(inventoryChoice - 1).getItemName().equals("machette")) {
            gameweapon.setWeaponName("machette");
            gameweapon.setDescription("High damage weapon that is found at certain location");
            gameweapon.setDamage(20);
        }
        else if (Inventory.get(inventoryChoice - 1).getType().equals("Quest")) {
            switch (Navigation.getUseIndex()){
                case 1 -> {
                    if (Inventory.get(inventoryChoice - 1).getItemName().equals("lockPick")) {
                        player.removeInventoryItem(Inventory.get(inventoryChoice - 1));
                        println("You unlocked the lock on the thick door as you enter their base!");
                        Navigation.CombatIndex[4] = 2;
                        player.setIsFighting(true);
                        Fighting.Fighting(player, npc);

                    }
                    else {
                        println("It seems like the door is locked with a lockpad, you might need to find a way to unlock the lockpad!");
                    }

                }
                case 2 -> {
                    if (Inventory.get(inventoryChoice - 1).getItemName().equals("key")) {
                        player.removeInventoryItem(Inventory.get(inventoryChoice - 1));
                        println("You unlocked the an office room with the key that you find in the warehouse!");
                        Navigation.SearchIndex[12] = 6;
                    }
                    else {
                        println("It seems like the door is locked, you might need to find a key!");
                    }
                }
                case 3 -> {
                    if (Inventory.get(inventoryChoice - 1).getItemName().equals("explosiveGel")) {
                        player.removeInventoryItem(Inventory.get(inventoryChoice - 1));
                        println("You exploded the wall creating a pathway through to the other side!");
                        Navigation.CombatIndex[19] = 3;
                    }
                    else {
                        println("It seems like the door is locked, you might need to find a key!");
                    }
                }
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
