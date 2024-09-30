public class CreateExits {
    public static Exit dungeonToCavernHall = new Exit("north", "a massive wooden door", CreateRooms.cavernHall, "", false);
    public static Exit cavernHallToDungeon = new Exit("south", "a massive wooden door", CreateRooms.dungeon, "", false);
    public static Exit cavernHallToStorageRoom = new Exit("north", "a narrow doorway", CreateRooms.storageRoom, "", false);
    public static Exit storageRoomToCavernHall = new Exit("south", "a narrow doorway", CreateRooms.cavernHall, "", false);
}
