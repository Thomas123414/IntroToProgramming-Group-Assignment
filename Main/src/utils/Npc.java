package src.utils;
import java.util.Scanner;

public class Npc {

    public static void Tavian(Player player) {
        Scanner input = new Scanner(System.in);

        System.out.println("Old Man Tavian - Abandoned Houses:");
        System.out.println("Tavian: You lookin' for a ghost or justice, boy? Either way, yer gonna bleed gettin' it.");
        System.out.println("I saw men like you before - muscle, pain, and a storm in their eyes.");
        System.out.println("The tag I lost… Belonged to someone brave.");
        System.out.println("That boy of yours is fightin’ to live.");
        System.out.println("Help me find my tag and bring it back to me.");
        System.out.println("That someone brave was last seen near the long PATHWAY in the fields");
        System.out.println("If you bring it back to me, i will help you try and find your boy");

        System.out.println("");
        System.out.println("What do you want to do?");
        System.out.println("1. Accept the quest!");
        System.out.println("2. Decline the quest!");

        System.out.print("Enter 1 or 2: ");
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.println("You gave him the tag. (You got Map Fragment 2)");
            System.out.println("Tavian: The 'Front'? Nothing “Antique” about that scummy place.");
            System.out.println("That’s where the devils arm their devils.");
            System.out.println("Look past the glass. The stairs go down to hell.");

            Navigation.SearchIndex[3] = 3;
        }
        else if (choice == 2) {
            System.out.println("You walk away in silence.");
        }
        else  {
            System.out.println("Tavian: Huh? That ain't a real choice.");
        }

        GameItems TagAddress = player.getItem("dogTag");
        if (TagAddress.getItemName().equals("dogtag")) {
            System.out.println("Trade me that tag… I’ll show you where the shadows hide.");
            System.out.print("Enter yes or no: ");
            String choicequest = input.nextLine();
            if (choicequest.equals("yes")) {
                player.removeInventoryItem(TagAddress);
                System.out.println("You received the mapFrag2");
            }
            else {
                System.out.println("You refused the trade.");
            }
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

    public void Claw() {
        System.out.println("Y'know, I don’t get paid to talk but I’ll make an exception. You had chances. Plenty of 'em.");
        System.out.println("Heh… guess I ain’t bulletproof after all. Go on, then. Just… do it quick. He's already taken everything else.");
    }

    public void Dual() {
        System.out.println("Well, ain't that a pickle, guess I'll be working overtime! Make your move pal, I got a donut calling my name.");
        System.out.println("Aw, beans… well go ahead pal, just aim for somethin’ that won’t hurt too much.");
    }

    public static void ExampleShop(Player player) {
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
                        GameItems mask = new GameItems("mask", "A mask to hide your identity and hide in places", 10, "Quest");
                        player.addInventoryItem(mask);
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
                        GameItems lockPick = new GameItems("lockPick", "A set of lockpicks to be used to open up a lock", 15, "Quest");
                        player.addInventoryItem(lockPick);
                        coinAddress.setValue(coinAddress.getValue() - 15);
                        notValidInput = false;
                    }
                    else {
                        System.out.println("You do not have enough coins to pay for this!");
                    }
                }
                case 3 -> {
                    GameItems coinAddress = player.getItem("coins");
                    GameItems healAddress = player.getItem("bandage");
                    if (coinAddress.getItemName().equals("coins") && coinAddress.getValue() > 10) {
                        System.out.println("You bought Bandages!");
                        if (healAddress.getItemName().equals("bandage")) {
                            healAddress.setValue(healAddress.getValue() + 1);
                        }
                        else {
                            player.addInventoryItem(new GameItems("bandage", "Healable Item, Heals you for a total 20 health", 1, "Tool"));
                        }
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



