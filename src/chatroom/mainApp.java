package chatroom;

import chatroom.chat.ChatRoom;

/**
 * Used to launch the program for code cleanliness. Creates a chat room.
 */
public class mainApp {

    public static void main(String[] args) {
        ChatRoom coordinator = new ChatRoom();
        coordinator.start();
    }
}

