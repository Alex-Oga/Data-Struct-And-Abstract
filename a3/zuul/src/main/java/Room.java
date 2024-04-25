/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * A "Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  The exits are labelled north,
 * east, south, west, up, down.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room
{
    private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;
    private Room up;
    private Room down;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description)
    {
        this.description = description;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param direction The direction in which rooms will be assigned to.
     * @param neighbor The room that lies in that direction.
     */
    public void setExits(String direction, Room neighbor)
    {
        switch(direction) {
            case "north":
                if (neighbor != null) {
                    northExit = neighbor;
                    break;
                }
                northExit = null;
                break;
            case "east":
                if (neighbor != null) {
                    eastExit = neighbor;
                    break;
                }
                eastExit = null;
                break;
            case "south":
                if (neighbor != null) {
                    southExit = neighbor;
                    break;
                }
                southExit = null;
                break;
            case "west":
                if (neighbor != null) {
                    westExit = neighbor;
                    break;
                }
                westExit = null;
                break;
            case "up":
                if (neighbor != null) {
                    up = neighbor;
                    break;
                }
                up = null;
                break;
            case "down":
                if (neighbor != null) {
                    down = neighbor;
                    break;
                }
                down = null;
                break;
        }
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    public boolean getExit(String direction) {
        switch (direction) {
            case "north":
                if (northExit != null)
                    return true;
                return false;
            case "east":
                if (eastExit != null)
                    return true;
                return false;
            case "south":
                if (southExit != null)
                    return true;
                return false;
            case "west":
                if (westExit != null)
                    return true;
                return false;
            case "up":
                if (up != null)
                    return true;
                return false;
            case "down":
                if (down != null)
                    return true;
                return false;
        }
        return false;
    }

    public Room changeRoom(String direction) {
        switch (direction) {
            case "north":
                return northExit;
            case "east":
                return eastExit;
            case "south":
                return southExit;
            case "west":
                return westExit;
            case "up":
                return up;
            case "down":
                return down;
        }
        return null;
    }

}
