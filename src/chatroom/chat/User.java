package chatroom.chat;

import chatroom.tuple.SimpleTuple;
import chatroom.tuplespace.SimpleTupleSpace;
import chatroom.tuplespace.TupleSpace;

public class User {

    private String username;
    private boolean activeStatus;
    private String[] messages;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
