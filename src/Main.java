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

    //public static InputParser parser = new InputParser();

    public static void main(String[] args) {
        integrateExits();
        integrateItems();

        // Create player
        Player player = new Player(dungeon);

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

            // Translate shorthand directions to full commands
            switch (command) {
                case "n":
                case "north":
                    command = "go north";
                    break;
                case "s":
                case "south":
                    command = "go south";
                    break;
                case "e":
                case "east":
                    command = "go east";
                    break;
                case "w":
                case "west":
                    command = "go west";
                    break;
            }

            //parser.SplitCommand(command, Player.inventory);

            // Special case commands **TEMPORARY UNTIL PARSER COMPLETE**
            if (command.equals("quit")) {
                System.out.println("Thanks for playing!");
                break;
            } else if (command.equals("look")) {
                player.lookAround();
            } else if (command.startsWith("go ")) {
                String direction = command.substring(3);
                player.move(direction);
            } else if (command.startsWith("take ")) {
                String itemName = command.substring(5);
                player.takeItem(itemName);
            } else if (command.equals("inventory")) {
                player.showInventory();
            } else {
                System.out.println("I don't understand that command.");
            }
            // Special case commands **TEMPORARY UNTIL PARSER COMPLETE**
        }

        scanner.close();
    }
}
