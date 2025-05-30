package src.utils;
import java.util.Scanner;

public class Npc {

    public void Tavian() {
        Scanner input = new Scanner(System.in);

        System.out.println("Old Man Tavian - Abandoned Houses:");
        System.out.println("Tavian: You lookin' for a ghost or justice, boy? Either way, yer gonna bleed gettin' it.");
        System.out.println("I saw men like you before - muscle, pain, and a storm in their eyes.");
        System.out.println("The tag I lost… Belonged to someone brave.");
        System.out.println("That boy of yours is fightin’ to live.");
        System.out.println("Trade me that tag… I’ll show you where the shadows hide.");

        System.out.println("");
        System.out.println("What do you want to do?");
        System.out.println("1. Fine. Here. Start talking.");
        System.out.println("2. ....");

        System.out.print("Enter 1 or 2: ");
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.println("You gave him the tag. (You got Map Fragment 2)");
            System.out.println("Tavian: The 'Front'? Nothing “Antique” about that scummy place.");
            System.out.println("That’s where the devils arm their devils.");
            System.out.println("Look past the glass. The stairs go down to hell.");
        }

        if (choice == 2) {
            System.out.println("You walk away in silence.");
        }

        if (choice != 1 && choice != 2) {
            System.out.println("Tavian: Huh? That ain't a real choice.");
        }

        input.close();
    }

    public void Henchmen() {
        System.out.println("Well, well, well… Hercule Cage. Didn’t think I would see you here. Looks like I get to be the guy who ends it.");
    }

    public void Diavolo() {
        System.out.println("You made it farther than most, Cage. But rage doesn’t win wars. It is blind.");
        System.out.println("Your son? He’s a witness. A risk. But now... now he’s a lesson.");
        System.out.println("Come see if your fists are louder than your regrets.");
        System.out.println("You thought this cane was just for walking? Let’s see how well you dance when venom's in your veins.");
    }

    public void Hercule() {
        System.out.println("Justice isn’t blind... it’s iron-willed. And it just broke you.");
    }

    public void ExampleShop(Player player) {
        Scanner input = new Scanner(System.in);
        boolean notValidInput = true;
        while (notValidInput) {
            System.out.print(
                    """
                     Hello, this is the example shop!
                     Here are the options to buy things:
                       - (1) Mask
                       - (2) Lockpick set
                       - (3) Bandages
                       - (0) Leave the shop
                     """);
            int choice = input.nextInt();

            switch (choice) {
                case 0 -> {
                    System.out.println("See you next time!");
                    notValidInput = false;
                }
                case 1 -> {
                    GameItems coinAddress = player.getItem("coins");
                    if (coinAddress.getItemName().equals("coins") && coinAddress.getValue() > 10) {
                        System.out.println("You bought a Mask!");
                        coinAddress.setValue(coinAddress.getValue() - 10);
                        notValidInput = false;
                    }
                    else {
                        System.out.println("You do not have enough coins to pay for this!");
                    }
                }
                case 2 -> {
                    GameItems coinAddress = player.getItem("coins");
                    if (coinAddress.getItemName().equals("coins") && coinAddress.getValue() > 10) {
                        System.out.println("You bought a Lockpick set!");
                        coinAddress.setValue(coinAddress.getValue() - 15);
                        notValidInput = false;
                    }
                    else {
                        System.out.println("You do not have enough coins to pay for this!");
                    }
                }
                case 3 -> {
                    GameItems coinAddress = player.getItem("coins");
                    if (coinAddress.getItemName().equals("coins") && coinAddress.getValue() > 10) {
                        System.out.println("You bought Bandages!");
                        coinAddress.setValue(coinAddress.getValue() - 5);
                        notValidInput = false;
                    }
                    else {
                        System.out.println("You do not have enough coins to pay for this!");
                    }
                }
                default ->  System.out.print("Not a valid input. Please write either a 1, 2, 3 or 0.\n");
            }
        }
        input.close();
    }
}



