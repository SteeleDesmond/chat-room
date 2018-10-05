package chatroom;

import chatroom.chat.ChatRoom;
import chatroom.tuplespace.TupleSpace;

/**
 * Used to launch the program for code cleanliness. Creates a chat room.
 */
public class MainApp {

    public static void main(String[] args) {
        ChatRoom coordinator = new ChatRoom();
        coordinator.start();
    }
}

