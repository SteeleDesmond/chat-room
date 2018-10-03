package chatroom.chat;

/**
 * Manages the different kinds of tuples that can be placed in the TupleSpace. This is to help keep the TupleSpace
 * tuples uniform.
 *
 * Internal Tuple patterns created:
 * currentUserTuple -- ("Current User", "username")
 * counterTuple -- ("Count", int)
 * statusTuple -- ("Active/Inactive", "username")
 * msgTuple -- ("Msg", timeInt, "username", "message")
 * userTuple -- ("User", "username")
 *
 * First object parameter is always a string tag.
 */
public class TupleManager {

    public Object[] makeCurrentUserTuple(String username) {
        String currentUserTuple[] = new String[2];
        String tag = "Current User";
        currentUserTuple[0] = tag;
        currentUserTuple[1] = username;
        return currentUserTuple;
    }

    public Object[] makeCounterTuple(int counter) {
        Object counterTuple[] = new Object[2];
        String tag = "Counter";
        counterTuple[0] = tag;
        counterTuple[1] = counter;
        return counterTuple;
    }

    public Object[] makeStatusTuple(String status, String username) {
        String statusTuple[] = new String[2];
        statusTuple[0] = status;
        statusTuple[1] = username;
        return statusTuple;
    }

    public Object[] makeMsgTuple(int time, String username, String message) {
        Object msgTuple[] = new Object[4];
        String tag = "Msg";
        msgTuple[0] = tag;
        msgTuple[1] = time;
        msgTuple[2] = username;
        msgTuple[3] = message;
        return msgTuple;
    }

    public Object[] makeUserTuple(String username) {
        String userTuple[] = new String[2];
        String tag = "User";
        userTuple[0] = tag;
        userTuple[1] = username;
        return userTuple;
    }
}
