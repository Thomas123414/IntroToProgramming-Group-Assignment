package src.utils;
import java.util.Random;
import java.util.Scanner;
import static src.utils.ConsoleFormating.*;
import static src.utils.Npc.*;

public class Fighting {
    public static final Scanner Input = new Scanner(System.in);
    private static final Random ValueRND = new Random();

    public static void Fighting(Player player, Enemy enemy, Npc npc){
        Enemy[] enemies = {
                new Enemy("Henchmen", 100, 3, 10),
                new Enemy("Claw Enforcer", 180, 5, 25),
                new Enemy("Twin Blade Enforcer", 250, 6, 50),
                new Enemy("Diavolo Meezasalma", 300, 9, 50)
        };

        int playerCritChance, enemyCritChance, playermissChance, enemymissChance, playerdamage, enemydamage;
        boolean Stillfighting = true;

        switch (Navigation.getCombatIndex()) {
            case 1:
                npc.Henchmen();
                while (Stillfighting)
                    print("What would you like to do? (1) Fight, (2) Heal, (3) LeaveFight which number option would you like?");
                int PlayerChoice = Input.nextInt();
                if (PlayerChoice == 1) {
                    playerCritChance = ValueRND.nextInt(12);
                    enemyCritChance = ValueRND.nextInt(12);
                    playermissChance = ValueRND.nextInt(12);
                    enemymissChance = ValueRND.nextInt(12);
                    if (playermissChance >= 9) {
                        if (enemyCritChance >= 11) {
                            enemydamage = enemies[Navigation.getCombatIndex()].getAttack2();
                            player.setHealth(player.getHealth() - enemydamage);
                            print("You missed your attack, Enemy successfully attacked you causing " + enemydamage + "which sets your health to " + player.getHealth());
                        } else {
                            enemydamage = enemies[Navigation.getCombatIndex()].getAttack1();
                            player.setHealth(player.getHealth() - enemydamage);
                            print("You missed your attack, Enemy successfully attacked you causing " + enemydamage + "which sets your health to " + player.getHealth());
                        }
                    }
                    else if (enemymissChance >= 9) {
                            if (playerCritChance > 9) {
                                playerdamage = player.Weapon.getDamage() * 3;
                                player.setHealth(player.getHealth() - damage);
                                print("You missed your attack, Enemy successfully attacked you causing " + damage + "which sets your health to " + player.getHealth());
                            } else if (playerCritChance > 6) {
                                playerdamage = player.Weapon.getDamage() * 2;
                                player.setHealth(player.getHealth() - damage);
                                print("Your enemy missed your attack, You successfully attacked the enemy causing " + damage + "which sets enemy health to " + player.getHealth());
                            }
                            else if (){
                                playerdamage = player.Weapon.getDamage() * 2;
                                player.setHealth(player.getHealth() - damage);
                                print("You missed your attack, Enemy successfully attacked you causing " + damage + "which sets your health to " + player.getHealth());
                            }

                    }

                }
                else if () {

                }


                    break;
            case 2:
                print("d");
                break;
            case 3:
                print("d");
                break;
            case 4:
                print("d");
                break;
        }
        }

    }
}
