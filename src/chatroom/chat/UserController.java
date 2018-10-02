package chatroom.chat;

import chatroom.tuplespace.SimpleTupleSpace;

/**
 * Manages the users of the chat room. Handles all interactions with the tuple space.
 */
public class UserController {

    private SimpleTupleSpace ts;

    public UserController(SimpleTupleSpace ts) {
        this.ts = ts;
    }

    /**
     * Get the current user.
     * @return A string of the current user.
     */
    public String getCurrentUser() {

        return null;
    }

    /**
     * Switch the current user to a different user.
     * @param username The username of the user to switch to.
     */
    public void switchCurrentUser(String username) {

    }

    /**
     * Get the 10 most recent messages posted to the tuple space.
     * @return A string containing the 10 most recent messages.
     */
    public String getRecentMessages() {
        // Might want to make this and active users return a String[]
        return null;
    }

    /**
     * Get a list of active users in the tuple space.
     * @return A string containing the active users in the tuple space.
     */
    public String getActiveUsers() {

        return null;
    }

    /**
     * Adds a message to the tuple space.
     * @param msg The message to add
     */
    public void postMessage(String msg) {

    }

    /**
     * Adds a user to the tuple space.
     * @param username The name of the user to add
     * @return True if it was successful, False if the user already exists.
     */
    public boolean addUser(String username) {
        User user = new User(username);
        ts.add(user);

        return true;
    }


        // Add and track counter tuples. Manage User tuples
}
