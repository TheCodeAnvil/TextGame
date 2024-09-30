public class Exit {
    private Boolean visited = false;
    private String direction;
    private String description;
    private String travelDescription;
    private Room leadsTo;
    private Boolean locked;

    public Exit(String direction, String description, Room leadsTo, String travelDescription, Boolean locked) {
        this.direction = direction;
        this.description = description;
        this.travelDescription = travelDescription;
        this.leadsTo = leadsTo;
        this.visited = visited;
        this.locked = locked;
    }

    public String getDirection() {
        return direction;
    }

    public String getDescription() {
        return description;
    }

    public Room getLeadsTo() {
        return leadsTo;
    }

    public Boolean getVisited(){
        return visited;
    }
    public String getTravelDescription(){
        return travelDescription;
    }
    public void setVisited(boolean newValue){
        visited = newValue;
    }
}
