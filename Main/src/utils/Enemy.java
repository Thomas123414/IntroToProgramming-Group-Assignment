package src.utils;
import java.util.Random;
import java.util.Scanner;
import static src.utils.ConsoleFormating.*;

public class Enemy {
    private String name;
    private int health;
    private int AttDam1;
    private int AttDam2;

    public Enemy(String name, int health, int AttDam1, int AttDam2) {
        this.name = name;
        this.health = health;
        this.AttDam1 = AttDam1;
        this.AttDam2 = AttDam2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack1(int attack) {
        this.AttDam1 = attack;
    }

    public void setAttack2(int attack) {
        this.AttDam2 = attack;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack1() {
        return AttDam1;
    }

    public int getAttack2() {
        return AttDam2;
    }
}
