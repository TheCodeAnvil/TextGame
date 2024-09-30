import java.util.ArrayList;

public class Room {
    private Boolean visited = false;
    private String name;
    private String description;
    private ArrayList<Exit> exits;
    public static ArrayList<Item> items;

    public Room(String name, String description) {
        this.visited = visited;
        this.name = name;
        this.description = description;
        this.exits = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public void addExit(Exit exit) {
        exits.add(exit);
    }

    public Room getExitRoom(String direction) {
        for (Exit exit : exits) {
            if (exit.getDirection().equalsIgnoreCase(direction)) {
                return exit.getLeadsTo();
            }
        }
        return null;
    }
    public Exit getExit(String direction) {
        for (Exit exit : exits) {
            if (exit.getDirection().equalsIgnoreCase(direction)) {
                return exit;
            }
        }
        return null;
    }

    public String getDescription() {
        StringBuilder fullDescription = new StringBuilder(">> " + description);
        fullDescription.append("\n");
        fullDescription.append("\nExits:");
        for (Exit exit : exits) {
            fullDescription.append("\n- ").append(exit.getDescription()).append(" to the ").append(exit.getDirection());
        }
        if(items.size() > 0){
            fullDescription.append("\nItems:");
            for (Item item : items) {
                fullDescription.append("\n- ").append(item.getDescription());
            }
        }
        fullDescription.append("\n");
        return fullDescription.toString();
    }
    public Boolean getVisited() {
        return visited;
    }
    public void setVisited(Boolean newVisited) {
        visited = newVisited;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public String getName() {
        return name;
    }
}
