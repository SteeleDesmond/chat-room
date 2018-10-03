package chatroom.chat;

import chatroom.tuplespace.SimpleTupleSpace;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Manages the users of the chat room. Handles all interactions with the tuple space.
 *
 * Internal Tuple patterns used:
 * currentUserTuple -- ("Current User", "username")
 * counterTuple -- ("Count", int)
 * statusTuple -- ("Active/Inactive", "username")
 * msgTuple -- ("msg", timeInt, "username", "message")
 * userTuple -- ("User", "username")
 *
 * First object parameter is always a string tag.
 */
public class UserController {

    private SimpleTupleSpace ts;
    private TupleManager tm = new TupleManager();

    public UserController(SimpleTupleSpace ts) {
        this.ts = ts;
        ts.add(tm.makeCounterTuple(0));
    }

    /**
     * Get the current user.
     * @return A string of the current user.
     */
    public String getCurrentUser() {
        Object[] currentUser = ts.read("Current User", "*");
        return currentUser[1].toString();
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
     * Get a list of all users in the tuple space.
     * @return A string containing the active users in the tuple space.
     */
    public String getAllUsers() {

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

        Object[] currentUser;
        ArrayList<Object[]> listOfUsers = new ArrayList<>();

        // Remove users one at a time from the Tuple Space and compare user names
        while (ts.read("User", "*") != null) {
            currentUser = ts.remove("User", "*");
            // If the username is taken
            if(username.equals(currentUser[1])) {
                System.out.println("Username is taken from UserController");

                // Put the list of users back into the Tuple Space
                ts.add(currentUser);
                for (Object[] user : listOfUsers) {
                    ts.add(user);
                }
                return false;
            }
            // Otherwise save the user tuple and check the next user
            else {
                listOfUsers.add(currentUser);
            }
        }
        // If we exit the while loop without returning then the username is free
        // Add the users back to the list
        for(Object[] user : listOfUsers) {
            ts.add(user);
        }
        // Then add the new user, add it as an active user, and make it the current user.
        String[] newUser = tm.makeUserTuple(username);
        ts.add(newUser);
        System.out.println(newUser[0] + " " + newUser[1]);

        ts.remove("Current User", "*");
        ts.add(tm.makeCurrentUserTuple(username));
        return true;
    }

    private void updateCounterTuple() {

    }


}
