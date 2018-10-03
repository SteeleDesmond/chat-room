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
 * Tuples are stored as object or string arrays.
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
        if(currentUser != null) {
            return currentUser[1].toString();
        }
        else return null;
    }

    /**
     * Switch the current user to a different user.
     * @param username The username of the user to switch to.
     * @return True = the user was switched, false means the current user did not switch.
     */
    public boolean switchCurrentUser(String username) {
        if(getCurrentUser() == null) {
            return false;
        }
        for(String s : getAllUsers()) {
            // If we find the username they would like to switch to then it exists and we can switch
            if(s.equals(username)) {
                Object[] newCurrentUser = tm.makeCurrentUserTuple(username);
                ts.remove("Current User", "*");
                ts.add(newCurrentUser);
                return true;
            }
        }
        return false;
    }

    /**
     * Get the 10 most recent messages posted to the tuple space.
     * @return A string containing the 10 most recent messages.
     */
    public ArrayList<String> getRecentMessages() {
        ArrayList<Object[]> listOfMessageTuples = new ArrayList<>();
        ArrayList<String> messageList = new ArrayList<>();

        if(ts.read("Msg", "*", "*", "*") == null) {
            return null;
        }

        int latestMessage = getCounter();
        // Pull out the 10 most recent messages from the tuple space and extract the message from them
        for(int i = latestMessage; i > 0 && i > latestMessage - 10; i--) {
            Object[] currentMessage = ts.remove("Msg", i, "*", "*");
            messageList.add("(Msg ID:" + currentMessage[1] + ") (User: " + currentMessage[2].toString() +  ") : " + currentMessage[3].toString());
            listOfMessageTuples.add(currentMessage);
        }

        // Put the tuples back into the tuple space
        for (Object[] msg : listOfMessageTuples) {
            ts.add(msg);
        }
        return messageList;
    }

    /**
     * Get a list of active users in the tuple space.
     * @return A string containing the active users in the tuple space.
     */
    public ArrayList<String> getActiveUsers() {

        Object[] currentUser;
        ArrayList<Object[]> listOfUserTuples = new ArrayList<>();
        ArrayList<String> activeUsers = new ArrayList<>();

        if(ts.read("Active", "*") == null) {
            return null;
        }
        // Get a list of all active users' user names from the tuple space
        while(ts.read("Active", "*") != null) {
            currentUser = ts.remove("Active", "*");
            activeUsers.add(currentUser[1].toString());
            listOfUserTuples.add(currentUser);
        }
        // Put the tuples back into the tuple space
        for (Object[] user : listOfUserTuples) {
            ts.add(user);
        }
        return activeUsers;
    }

    /**
     * Get a list of all users in the tuple space.
     * @return A string containing the active users in the tuple space.
     */
    public ArrayList<String> getAllUsers() {
        Object[] currentUser;
        ArrayList<Object[]> listOfUserTuples = new ArrayList<>();
        ArrayList<String> allUsers = new ArrayList<>();

        if(ts.read("User", "*") == null) {
            return null;
        }
        // Get a list of all active users' user names from the tuple space
        while(ts.read("User", "*") != null) {
            currentUser = ts.remove("User", "*");
            allUsers.add(currentUser[1].toString());
            listOfUserTuples.add(currentUser);
        }
        // Put the tuples back into the tuple space
        for (Object[] user : listOfUserTuples) {
            ts.add(user);
        }
        return allUsers;
    }

    /**
     * Adds a message to the tuple space using a message tuple format.
     * @param msg The message to add
     */
    public boolean postMessage(String msg) {
        if(getCurrentUser() == null) {
            return false;
        }
        String currentUser = getCurrentUser();
        int messageNumber = updateCounterTuple();
        Object[] msgTuple = tm.makeMsgTuple(messageNumber, currentUser, msg);
        ts.add(msgTuple);
        return true;
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
                //System.out.println("Username is taken from UserController");

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
        Object[] newUser = tm.makeUserTuple(username);
        ts.add(newUser);
        System.out.println(newUser[0] + " " + newUser[1]);

        ts.remove("Current User", "*");
        ts.add(tm.makeCurrentUserTuple(username));
        ts.add(tm.makeStatusTuple("Active", username));
        return true;
    }

    private int updateCounterTuple() {
        Object[] counterTuple = ts.remove("Counter", "*");
        ts.add(tm.makeCounterTuple((int) counterTuple[1] + 1));
        return (int) counterTuple[1] + 1;
    }

    private int getCounter() {
        Object[] counterTuple = ts.read("Counter", "*");
        return (int) counterTuple[1];
    }


}
