import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    public static ArrayList<Item> inventory;

    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
    }

    public void move(String direction) {
        Room nextRoom = currentRoom.getExitRoom(direction);
        if (nextRoom != null) {
            if(currentRoom.getExit(direction).getTravelDescription() != "" && currentRoom.getExit(direction).getVisited() == false){
                currentRoom.getExit(direction).setVisited(true);
                System.out.println(currentRoom.getExit(direction).getTravelDescription());
            }
            currentRoom = nextRoom;
            System.out.println("You moved to " + currentRoom.getName());
            if(currentRoom.getVisited() == false) {
                System.out.println(currentRoom.getDescription());
                currentRoom.setVisited(true);
            }
        } else {
            System.out.println("You can't go that way.");
        }
    }

    public void lookAround() {
        System.out.println(currentRoom.getDescription());
        System.out.println("Items here:");
        for (Item item : currentRoom.getItems()) {
            System.out.println("- " + item.getName() + ": " + item.getDescription());
        }
    }

    public void takeItem(String itemName) {
        ArrayList<Item> roomItems = currentRoom.getItems();
        for (Item item : roomItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                inventory.add(item);
                currentRoom.removeItem(item);
                System.out.println("You took the " + item.getName());
                return;
            }
        }
        System.out.println("There's no such item here.");
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your inventory:");
            for (Item item : inventory) {
                System.out.println("- " + item.getName() + ": " + item.getDescription());
            }
        }
    }

    public Room getCurrentRoom() {
        currentRoom.setVisited(true);
        return currentRoom;
    }
}
