import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // *** Room initialization
    public static Room dungeon = CreateRooms.dungeon;
    public static Room cavernHall = CreateRooms.cavernHall;
    public static Room storageRoom = CreateRooms.storageRoom;
    // *** Room initialization ***

    // *** Item initialization ***
    public static Item key = CreateItems.key;
    // *** Item initialization ***

    // *** Exit initialization ***
    public static Exit dungeonToCavernHall = CreateExits.dungeonToCavernHall;
    public static Exit cavernHallToDungeon = CreateExits.cavernHallToDungeon;
    public static Exit cavernHallToStorageRoom = CreateExits.cavernHallToStorageRoom;
    public static Exit storageRoomToCavernHall = CreateExits.storageRoomToCavernHall;
    // *** Exit initialization ***

    // *** Room/Exit Integration ***
    public static void integrateExits(){
        dungeon.addExit(dungeonToCavernHall);
        cavernHall.addExit(cavernHallToDungeon);
        cavernHall.addExit(cavernHallToStorageRoom);
        storageRoom.addExit(storageRoomToCavernHall);
    }
    // *** Room/Exit Integration ***

    // *** Room/Item Integration ***
    public static void integrateItems(){
        dungeon.addItem(key);
    }
    // *** Room/Item Integration ***

    // *** Input Parser Variables ***
    public static String[] actions = {"go", "take", "look", "hit", "open", "inventory", "quit"};

    public static String verb;
    public static int verbInd;
    public static String directObject;
    public static int directObjectInd;
    public static String indirectObject;
    public static int indirectObjectInd;
    // *** Input Parser Variables ***

    // Create player
    public static Player player = new Player(dungeon);

    public static void main(String[] args) {
        integrateExits();
        integrateItems();


        // Input rules
        Scanner scanner = new Scanner(System.in);
        String command;

        // Game introduction
        System.out.println("\nMoments before...\n");
        System.out.println(player.getCurrentRoom().getDescription());

        // Game loop
        while (true) {
            System.out.print("> ");
            command = scanner.nextLine().toLowerCase();

            parseCommand(command);

            if (verb.equals("quit")) {
                System.out.println("Thanks for playing!");
                break;
            } else if (verb.equals("look")) {
                player.lookAround();
            } else if (verb.equals("go")) {
                player.move(directObject);
            } else if (verb.equals("n") || verb.equals("north")) {
                player.move("north");
            } else if (verb.equals("s") || verb.equals("south")) {
                player.move("south");
            } else if (verb.equals("e") || verb.equals("east")) {
                player.move("east");
            } else if (verb.equals("w") || verb.equals("west")) {
                player.move("west");
            } else if (verb.equals("take")) {
                player.takeItem(directObject);
            } else if (verb.equals("inventory") || verb.equals("i")) {
                player.showInventory();
            } else {
                System.out.println("I don't understand that command.");
            }
        }

        scanner.close();
    }

    public static void parseCommand(String command) {
        String[] commandWords = command.split(" ");
        ArrayList<Item> inventory = player.inventory;
        ArrayList<Item> roomObjects = player.getCurrentRoom().getItems();
        verbInd = -1;
        directObjectInd = -1;
        indirectObjectInd = -1;
        verb = null;
        directObject = null;
        indirectObject = null;

        for (int index = 0; index < commandWords.length; index++) {
            if (index == 0) {
                verb = commandWords[index];
                while (verbInd == -1 && index < commandWords.length) {
                    for (int i = 0; i < actions.length; i++) {
                        if (commandWords[index].equals(actions[i])) {
                            verb = commandWords[index];
                            verbInd = index;
                            break;
                        }
                    }
                    index++;
                }
                index--; // Adjust index as it will be incremented in the outer loop
            }
            if (verbInd != -1 && index == (verbInd + 1)) {
                directObject = commandWords[index];
                while (directObjectInd == -1 && index < commandWords.length) {
                    for (int i = 0; i < roomObjects.size(); i++) {
                        if (roomObjects.get(i).equals(commandWords[index])) {
                            directObject = commandWords[index];
                            directObjectInd = index;
                            break;
                        }
                    }
                    index++;
                }
                index--; // Adjust index as it will be incremented in the outer loop
            }
            if (index < commandWords.length && commandWords[index].equals("with")) {
                indirectObject = commandWords[index];
                index++; // Move to the word after "with"
                while (indirectObjectInd == -1 && index < commandWords.length) {
                    for (int i = 0; i < inventory.size(); i++) {
                        if (inventory.get(i).equals(commandWords[index])) {
                            indirectObject = commandWords[index];
                            indirectObjectInd = index;
                            break;
                        }
                    }
                    index++;
                }
                break; // Exit the loop as we've found the indirect object
            }
        }

        // Handle direction words as direct objects for the "go" command
        if (verb != null && verb.equals("go") && directObject == null || verb.equals("look")) {
            String[] directions = {"north", "south", "east", "west"};
            for (String direction : directions) {
                if (command.contains(direction)) {
                    directObject = direction;
                    break;
                }
            }
        }
    }
}