/*import java.util.*;

public class InputParser {
    public static String[] roomObjects = new String[3]; // Also for testing. Will be stored slightly differently in-game, but we need to match the direct objects against this list.
    public static String[] actions = new String[3]; // For testing. These are actions the player could be taking.

    public static String verb;
    public static int verbInd;

    public static String directObject;
    public static int directObjectInd;

    public static String indirectObject;
    public static int indirectObjectInd;

    public static void SplitCommand(String command, List<Item> inventory) {

        roomObjects[0] = "Door";
        roomObjects[1] = "Troll";
        roomObjects[2] = "Hay Bale";

        actions[0] = "Hit";
        actions[1] = "Open";
        actions[2] = "Burn";

        while (true) {
            String[] commandWords = command.split(" ");
            verbInd = -1;
            directObjectInd = -1;
            indirectObjectInd = -1;

            for(int index = 0; index < commandWords.length; index++){
                if(index == 0){
                    while(verbInd == -1){ // As soon as a verb is found (verbInd is assigned a value) then we stop checking
                        for (int i = 0; i < actions.length; i++){
                            if(commandWords[index].equals(actions[i].toLowerCase())){ // Matching against all possible actions
                                verb = commandWords[index];
                                verbInd = index;
                            }
                        }
                        index++; // Add one to index and check again. In case of multiple adverbs e.g "very quickly hit troll with sword"
                        // This will also mean subsequent checks will begin from where the verb is found
                    }
                }
                if (index == (verbInd + 1)) {
                    while(directObjectInd == -1){ // As soon as a direct object is found (directObjectInd is assigned a value) then we stop checking
                        for (int i = 0; i < roomObjects.length; i++){
                            if(commandWords[index].equals(roomObjects[i].toLowerCase())){ // Matching against all possible actions
                                directObject = commandWords[index];
                                directObjectInd = index;
                            }
                        }
                        index++; // Add one to index and check again. In case of multiple (or any) adjectives e.g "hit very large troll with sword"
                        // This will also mean subsequent checks will begin from where the direct object is found
                    }
                }
                if (commandWords[index].toLowerCase().equals("with")) {
                    while(indirectObjectInd == -1){ // As soon as a direct object is found (directObjectInd is assigned a value) then we stop checking
                        for (int i = 0; i < inventory.size(); i++){
                            if(commandWords[index].equals(inventory[i].toLowerCase())){ // Matching against all possible actions
                                indirectObject = commandWords[index];
                                indirectObjectInd = index;
                            }
                        }
                        index++; // Add one to index and check again. In case of multiple (or any) adjectives e.g "hit very large troll with sword"
                        // This will also mean subsequent checks will begin from where the direct object is found
                    }
                }
            }

            System.out.println("Verb: " + verb);
            System.out.println("Direct Object: " + directObject);
            System.out.println("Indirect Object: " + indirectObject);
        }
    }
}
*/