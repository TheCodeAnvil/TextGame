public class Item {
    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
    public boolean equals(String s) {
        return name.equals(s);
    }

    public String getDescription() {
        return description;
    }
}
