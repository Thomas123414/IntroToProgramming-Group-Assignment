package src.utils;
import java.util.Random;
import java.util.Scanner;
import static src.utils.ConsoleFormating.*;
import static src.utils.Npc.*;

public class Fighting {
    public static final Scanner Input = new Scanner(System.in);
    private static final Random ValueRND = new Random();

    public static void Fighting(Player player, Npc npc) {
        Enemy[] enemies = {
                new Enemy("Invisible", 100, 3, 10),
                new Enemy("Henchmen", 100, 3, 10),
                new Enemy("Claw Enforcer", 180, 5, 25),
                new Enemy("Twin Blade Enforcer", 250, 6, 50),
                new Enemy("Diavolo Meezasalma", 300, 9, 50)
        };

        int playerCritChance, enemyCritChance, playermissChance, enemymissChance, playerdamage, enemydamage;
        boolean Stillfighting = true;
        int Iter = 1;

        switch (Navigation.getCombatIndex()) {
            case 1:
                npc.Henchmen();
                print("What would you like to do? (1) Fight, (2) Heal, (3) Leave Fight, which number option would you like?");
                while (Stillfighting) {
                    if (Iter > 1) {
                    print("What would you like to do now? (1) Fight, (2) Heal, (3) Leave Fight, which number option would you like?");
                    }
                    if (Iter == 1) {
                        Iter ++;
                    }
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
                                println("You missed your attack, Enemy successfully attacked you causing " + enemydamage + " damage which sets your health to " + player.getHealth());
                            } else {
                                enemydamage = enemies[Navigation.getCombatIndex()].getAttack1();
                                player.setHealth(player.getHealth() - enemydamage);
                                println("You missed your attack, Enemy successfully attacked you causing " + enemydamage + " damage which sets your health to " + player.getHealth());
                            }
                        } else if (enemymissChance >= 9) {
                            if (playerCritChance > 9) {
                                playerdamage = player.Weapon.getDamage() * 3;
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                                println("Your enemy missed your attack, You successfully attacked the enemy causing " + playerdamage + " damage which sets enemy health to " + enemies[Navigation.getCombatIndex()].getHealth());
                            } else if (playerCritChance > 6) {
                                playerdamage = player.Weapon.getDamage() * 2;
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                                println("Your enemy missed your attack, You successfully attacked the enemy causing " + playerdamage + " damage which sets enemy health to " + enemies[Navigation.getCombatIndex()].getHealth());
                            } else if (playerCritChance <= 6) {
                                playerdamage = player.Weapon.getDamage();
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                                println("Your enemy missed your attack, You successfully attacked the enemy causing " + playerdamage + " damage which sets enemy health to " + enemies[Navigation.getCombatIndex()].getHealth());
                            }
                        } else {
                            playerdamage = 0;
                            enemydamage = 0;
                            if (enemyCritChance >= 11) {
                                enemydamage = enemies[Navigation.getCombatIndex()].getAttack2();
                                player.setHealth(player.getHealth() - enemydamage);
                            } else {
                                enemydamage = enemies[Navigation.getCombatIndex()].getAttack1();
                                player.setHealth(player.getHealth() - enemydamage);
                            }

                            if (playerCritChance > 9) {
                                playerdamage = player.Weapon.getDamage() * 3;
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                            } else if (playerCritChance > 6) {
                                playerdamage = player.Weapon.getDamage() * 2;
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                            } else if (playerCritChance <= 6) {
                                playerdamage = player.Weapon.getDamage();
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                            }
                            println("You sucessfully hit the enemy weilding " + playerdamage + " damage, inflicted into them which leaves them with " + enemies[Navigation.getCombatIndex()].getHealth() + " health");
                            println("The enemy sucessfully hit the you weilding " + enemydamage + " damage, inflicted into you which leaves you with " + player.getHealth() + " health");
                        }
                        if (enemies[Navigation.getCombatIndex()].getHealth() == 0) {
                            Stillfighting = false;
                        }
                    } else if (PlayerChoice == 2) {
                        GameItems healAddress = player.getItem("bandage");
                        if (healAddress.getItemName().equals("bandage") && healAddress.getValue() >= 1) {
                            System.out.println("You healed!");
                            healAddress.setValue(healAddress.getValue() - 1);
                            player.setHealth(player.getHealth() + 20);
                        }
                    } else if (PlayerChoice == 3) {
                        if (player.getHealth() >= 60) {
                            print("You left the fight, you are still alive!");
                            Navigation.setCurrentLocation(03);
                            Stillfighting = false;
                        } else {
                            print("You left the fight, you are dead!");
                        }
                        print("What would you like to do now? (1) Fight, (2) Heal, (3) Leave Fight, which number option would you like?");
                    }
                }
                break;
            case 2:
                npc.Claw();
                print("What would you like to do? (1) Fight, (2) Heal, (3) Leave Fight, which number option would you like?");
                while (Stillfighting) {
                    if (Iter > 1) {
                        print("What would you like to do now? (1) Fight, (2) Heal, (3) Leave Fight, which number option would you like?");
                    }
                    if (Iter == 1) {
                        Iter ++;
                    }
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
                                println("You missed your attack, Enemy successfully attacked you causing " + enemydamage + " damage which sets your health to " + player.getHealth());
                            } else {
                                enemydamage = enemies[Navigation.getCombatIndex()].getAttack1();
                                player.setHealth(player.getHealth() - enemydamage);
                                println("You missed your attack, Enemy successfully attacked you causing " + enemydamage + " damage which sets your health to " + player.getHealth());
                            }
                        } else if (enemymissChance >= 9) {
                            if (playerCritChance > 9) {
                                playerdamage = player.Weapon.getDamage() * 3;
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                                println("Your enemy missed your attack, You successfully attacked the enemy causing " + playerdamage + " damage which sets enemy health to " + enemies[Navigation.getCombatIndex()].getHealth());
                            } else if (playerCritChance > 6) {
                                playerdamage = player.Weapon.getDamage() * 2;
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                                println("Your enemy missed your attack, You successfully attacked the enemy causing " + playerdamage + " damage which sets enemy health to " + enemies[Navigation.getCombatIndex()].getHealth());
                            } else if (playerCritChance <= 6) {
                                playerdamage = player.Weapon.getDamage();
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                                println("Your enemy missed your attack, You successfully attacked the enemy causing " + playerdamage + " damage which sets enemy health to " + enemies[Navigation.getCombatIndex()].getHealth());
                            }
                        } else {
                            playerdamage = 0;
                            enemydamage = 0;
                            if (enemyCritChance >= 11) {
                                enemydamage = enemies[Navigation.getCombatIndex()].getAttack2();
                                player.setHealth(player.getHealth() - enemydamage);
                            } else {
                                enemydamage = enemies[Navigation.getCombatIndex()].getAttack1();
                                player.setHealth(player.getHealth() - enemydamage);
                            }

                            if (playerCritChance > 9) {
                                playerdamage = player.Weapon.getDamage() * 3;
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                            } else if (playerCritChance > 6) {
                                playerdamage = player.Weapon.getDamage() * 2;
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                            } else if (playerCritChance <= 6) {
                                playerdamage = player.Weapon.getDamage();
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                            }
                            println("You sucessfully hit the enemy weilding " + playerdamage + " damage, inflicted into them which leaves them with " + enemies[Navigation.getCombatIndex()].getHealth() + " health");
                            println("The enemy sucessfully hit the you weilding " + enemydamage + " damage, inflicted into you which leaves you with " + player.getHealth() + " health");
                        }
                        if (enemies[Navigation.getCombatIndex()].getHealth() == 0) {
                            Stillfighting = false;
                        }
                    } else if (PlayerChoice == 2) {
                        GameItems healAddress = player.getItem("bandage");
                        if (healAddress.getItemName().equals("bandage") && healAddress.getValue() >= 1) {
                            System.out.println("You healed!");
                            healAddress.setValue(healAddress.getValue() - 1);
                            player.setHealth(player.getHealth() + 20);
                        }
                    } else if (PlayerChoice == 3) {
                        if (player.getHealth() >= 60) {
                            print("You left the fight, you are still alive!");
                            Navigation.setCurrentLocation(03);
                            Stillfighting = false;
                        } else {
                            print("You left the fight, you are dead!");
                        }
                        print("What would you like to do now? (1) Fight, (2) Heal, (3) Leave Fight, which number option would you like?");
                    }
                }
                break;
            case 3:
                npc.Dual();
                print("What would you like to do? (1) Fight, (2) Heal, (3) Leave Fight, which number option would you like?");
                while (Stillfighting) {
                    if (Iter > 1) {
                        print("What would you like to do now? (1) Fight, (2) Heal, (3) Leave Fight, which number option would you like?");
                    }
                    if (Iter == 1) {
                        Iter ++;
                    }
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
                                println("You missed your attack, Enemy successfully attacked you causing " + enemydamage + " damage which sets your health to " + player.getHealth());
                            } else {
                                enemydamage = enemies[Navigation.getCombatIndex()].getAttack1();
                                player.setHealth(player.getHealth() - enemydamage);
                                println("You missed your attack, Enemy successfully attacked you causing " + enemydamage + " damage which sets your health to " + player.getHealth());
                            }
                        } else if (enemymissChance >= 9) {
                            if (playerCritChance > 9) {
                                playerdamage = player.Weapon.getDamage() * 3;
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                                println("Your enemy missed your attack, You successfully attacked the enemy causing " + playerdamage + " damage which sets enemy health to " + enemies[Navigation.getCombatIndex()].getHealth());
                            } else if (playerCritChance > 6) {
                                playerdamage = player.Weapon.getDamage() * 2;
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                                println("Your enemy missed your attack, You successfully attacked the enemy causing " + playerdamage + " damage which sets enemy health to " + enemies[Navigation.getCombatIndex()].getHealth());
                            } else if (playerCritChance <= 6) {
                                playerdamage = player.Weapon.getDamage();
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                                println("Your enemy missed your attack, You successfully attacked the enemy causing " + playerdamage + " damage which sets enemy health to " + enemies[Navigation.getCombatIndex()].getHealth());
                            }
                        } else {
                            playerdamage = 0;
                            enemydamage = 0;
                            if (enemyCritChance >= 11) {
                                enemydamage = enemies[Navigation.getCombatIndex()].getAttack2();
                                player.setHealth(player.getHealth() - enemydamage);
                            } else {
                                enemydamage = enemies[Navigation.getCombatIndex()].getAttack1();
                                player.setHealth(player.getHealth() - enemydamage);
                            }

                            if (playerCritChance > 9) {
                                playerdamage = player.Weapon.getDamage() * 3;
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                            } else if (playerCritChance > 6) {
                                playerdamage = player.Weapon.getDamage() * 2;
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                            } else if (playerCritChance <= 6) {
                                playerdamage = player.Weapon.getDamage();
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                            }
                            println("You sucessfully hit the enemy weilding " + playerdamage + " damage, inflicted into them which leaves them with " + enemies[Navigation.getCombatIndex()].getHealth() + " health");
                            println("The enemy sucessfully hit the you weilding " + enemydamage + " damage, inflicted into you which leaves you with " + player.getHealth() + " health");
                        }
                        if (enemies[Navigation.getCombatIndex()].getHealth() == 0) {
                            Stillfighting = false;
                        }
                    } else if (PlayerChoice == 2) {
                        GameItems healAddress = player.getItem("bandage");
                        if (healAddress.getItemName().equals("bandage") && healAddress.getValue() >= 1) {
                            System.out.println("You healed!");
                            healAddress.setValue(healAddress.getValue() - 1);
                            player.setHealth(player.getHealth() + 20);
                        }
                    } else if (PlayerChoice == 3) {
                        if (player.getHealth() >= 60) {
                            print("You left the fight, you are still alive!");
                            Navigation.setCurrentLocation(03);
                            Stillfighting = false;
                        } else {
                            print("You left the fight, you are dead!");
                        }
                        print("What would you like to do now? (1) Fight, (2) Heal, (3) Leave Fight, which number option would you like?");
                    }
                }
                break;
            case 4:
                npc.Diavolo();
                print("What would you like to do? (1) Fight, (2) Heal, (3) Leave Fight, which number option would you like?");
                while (Stillfighting) {
                    if (Iter > 1) {
                        print("What would you like to do now? (1) Fight, (2) Heal, (3) Leave Fight, which number option would you like?");
                    }
                    if (Iter == 1) {
                        Iter ++;
                    }
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
                                println("You missed your attack, Enemy successfully attacked you causing " + enemydamage + " damage which sets your health to " + player.getHealth());
                            } else {
                                enemydamage = enemies[Navigation.getCombatIndex()].getAttack1();
                                player.setHealth(player.getHealth() - enemydamage);
                                println("You missed your attack, Enemy successfully attacked you causing " + enemydamage + " damage which sets your health to " + player.getHealth());
                            }
                        } else if (enemymissChance >= 9) {
                            if (playerCritChance > 9) {
                                playerdamage = player.Weapon.getDamage() * 3;
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                                println("Your enemy missed your attack, You successfully attacked the enemy causing " + playerdamage + " damage which sets enemy health to " + enemies[Navigation.getCombatIndex()].getHealth());
                            } else if (playerCritChance > 6) {
                                playerdamage = player.Weapon.getDamage() * 2;
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                                println("Your enemy missed your attack, You successfully attacked the enemy causing " + playerdamage + " damage which sets enemy health to " + enemies[Navigation.getCombatIndex()].getHealth());
                            } else if (playerCritChance <= 6) {
                                playerdamage = player.Weapon.getDamage();
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                                println("Your enemy missed your attack, You successfully attacked the enemy causing " + playerdamage + " damage which sets enemy health to " + enemies[Navigation.getCombatIndex()].getHealth());
                            }
                        } else {
                            playerdamage = 0;
                            enemydamage = 0;
                            if (enemyCritChance >= 11) {
                                enemydamage = enemies[Navigation.getCombatIndex()].getAttack2();
                                player.setHealth(player.getHealth() - enemydamage);
                            } else {
                                enemydamage = enemies[Navigation.getCombatIndex()].getAttack1();
                                player.setHealth(player.getHealth() - enemydamage);
                            }

                            if (playerCritChance > 9) {
                                playerdamage = player.Weapon.getDamage() * 3;
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                            } else if (playerCritChance > 6) {
                                playerdamage = player.Weapon.getDamage() * 2;
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                            } else if (playerCritChance <= 6) {
                                playerdamage = player.Weapon.getDamage();
                                enemies[1].setHealth(enemies[1].getHealth() - playerdamage);
                            }
                            println("You sucessfully hit the enemy weilding " + playerdamage + " damage, inflicted into them which leaves them with " + enemies[Navigation.getCombatIndex()].getHealth() + " health");
                            println("The enemy sucessfully hit the you weilding " + enemydamage + " damage, inflicted into you which leaves you with " + player.getHealth() + " health");
                        }
                        if (enemies[Navigation.getCombatIndex()].getHealth() == 0) {
                            Stillfighting = false;
                        }
                    } else if (PlayerChoice == 2) {
                        GameItems healAddress = player.getItem("bandage");
                        if (healAddress.getItemName().equals("bandage") && healAddress.getValue() >= 1) {
                            System.out.println("You healed!");
                            healAddress.setValue(healAddress.getValue() - 1);
                            player.setHealth(player.getHealth() + 20);
                        }
                    } else if (PlayerChoice == 3) {
                        if (player.getHealth() >= 60) {
                            print("You left the fight, you are still alive!");
                            Navigation.setCurrentLocation(03);
                            Stillfighting = false;
                        } else {
                            print("You left the fight, you are dead!");
                        }
                        print("What would you like to do now? (1) Fight, (2) Heal, (3) Leave Fight, which number option would you like?");
                    }
                }
                break;

        }
    }
}

