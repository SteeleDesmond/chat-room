package chatroom;

import chatroom.chat.ChatRoom;
import chatroom.tuplespace.TupleSpace;

/**
 * Used to launch the program for code cleanliness. Creates a chat room.
 */
public class mainApp {

    public static void main(String[] args) {

        TupleSpace ts = new TupleSpace(10);
        ts.add("Test", 1, 2);
        ts.read("test", 1, 2);

        ChatRoom coordinator = new ChatRoom();
        coordinator.start();
    }
}

