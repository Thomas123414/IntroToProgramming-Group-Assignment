package src.utils;
import java.util.ArrayList;
import java.util.Random;
import static src.utils.ConsoleFormating.*;

public class Player {
    private String name = "Hercule";
    private String fullName = "Hercule Cage";
    private int health;
    private GameWeapons weapon;
    private boolean isAlive;
    private boolean isFighting;
    private final ArrayList<GameItems> Inventory = new ArrayList<>();

    public String displayBackpackContents() {
        String backpackString = "";
        for (GameItems item : Inventory) {
            backpackString += String.format(" - (%d) %s\n", Inventory.indexOf(item) + 1, item.getItemName());
        }
        return backpackString;
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
