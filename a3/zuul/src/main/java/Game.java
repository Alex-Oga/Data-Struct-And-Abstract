import java.util.Random;
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room lastRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office, officeSecondFloor, labBasement, randomizer;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        labBasement = new Room("in the basement of the computing lab");
        office = new Room("in the computing admin office");
        officeSecondFloor = new Room("on the second floor computing admin office");
        randomizer = new Room("somewhere");
        
        // initialise room exits
        outside.setExits("north", null);
        outside.setExits("east", theater);
        outside.setExits("south", lab);
        outside.setExits("west", pub);
        outside.setExits("up", null);
        outside.setExits("down", randomizer);
        theater.setExits("north", null);
        theater.setExits("east", null);
        theater.setExits("south", null);
        theater.setExits("west", outside);
        theater.setExits("up", null);
        theater.setExits("down", null);
        pub.setExits("north", null);
        pub.setExits("east", outside);
        pub.setExits("south", null);
        pub.setExits("west", null);
        pub.setExits("up", null);
        pub.setExits("down", null);
        lab.setExits("north", outside);
        lab.setExits("east", office);
        lab.setExits("south", null);
        lab.setExits("west", null);
        lab.setExits("up", null);
        lab.setExits("down", labBasement);
        labBasement.setExits("north", null);
        labBasement.setExits("east", null);
        labBasement.setExits("south", null);
        labBasement.setExits("west", null);
        labBasement.setExits("up", lab);
        labBasement.setExits("down", null);
        office.setExits("north", null);
        office.setExits("east", null);
        office.setExits("south", null);
        office.setExits("west", lab);
        office.setExits("up", officeSecondFloor);
        office.setExits("down", null);
        officeSecondFloor.setExits("north", null);
        officeSecondFloor.setExits("east", null);
        officeSecondFloor.setExits("south", null);
        officeSecondFloor.setExits("east", null);
        officeSecondFloor.setExits("up", null);
        officeSecondFloor.setExits("down", office);

        Room randomRoom = null;
        switch (randomNumber()) {
            case 0:
                randomRoom = outside;
                break;
            case 1:
                randomRoom = theater;
                break;
            case 2:
                randomRoom = pub;
                break;
            case 3:
                randomRoom = lab;
                break;
            case 4:
                randomRoom = office;
                break;
            case 5:
                randomRoom = officeSecondFloor;
                break;
            case 6:
                randomRoom = labBasement;
                break;
        }

        randomizer.setExits("north", randomRoom);
        randomizer.setExits("east", randomRoom);
        randomizer.setExits("south", randomRoom);
        randomizer.setExits("west", randomRoom);
        randomizer.setExits("up", randomRoom);
        randomizer.setExits("down", randomRoom);

        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(locationInfo());
    }
    private String locationInfo() {
        StringBuilder info = new StringBuilder();

        info.append("You are " + currentRoom.getDescription());
        info.append('\n');
        info.append("Exits: ");
        if(currentRoom.getExit("north")) {
            info.append("north ");
        }
        if(currentRoom.getExit("east")) {
            info.append("east ");
        }
        if(currentRoom.getExit("south")) {
            info.append("south ");
        }
        if(currentRoom.getExit("west")) {
            info.append("west ");
        }
        if(currentRoom.getExit("up")) {
            info.append("up ");
        }
        if(currentRoom.getExit("down")) {
            info.append("down ");
        }
        return info.toString();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        CommandWord commandWord = command.getCommandWord();
        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;

            case LOOK:
                goLook();
                break;

            case BACK:
                goBack();
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        switch (direction) {
            case "north":
                nextRoom = currentRoom.changeRoom("north");
                break;
            case "east":
                nextRoom = currentRoom.changeRoom("east");
                break;
            case "south":
                nextRoom = currentRoom.changeRoom("south");
                break;
            case "west":
                nextRoom = currentRoom.changeRoom("west");
                break;
            case "up":
                nextRoom = currentRoom.changeRoom("up");
                break;
            case "down":
                nextRoom = currentRoom.changeRoom("down");
                break;
        }
        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            lastRoom = currentRoom;
            currentRoom = nextRoom;
            System.out.println(locationInfo());
        }
    }
    /**
     * Try to go back to the last room,
     * if there is no last room print error.
     */
    private void goBack() {
        if (lastRoom == null)
            System.out.println("There are no rooms to go back to");
        else {
            currentRoom = lastRoom;
            System.out.println(locationInfo());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    /**
     * Print out the current location and exits.
     * @return location info
     */
    private void goLook() {
        System.out.println(locationInfo());
    }

    /**
     * Generates a number from 0 to 6, to be used in making the random room,
     * the numbers are attached to the rooms, which then decide the order of rooms in each direction
     * @return int
     */
    private int randomNumber() {
        Random random = new Random();
        int x = random.nextInt(6);
        return x;
    }
}
