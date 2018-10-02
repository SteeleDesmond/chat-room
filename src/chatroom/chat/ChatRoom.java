package chatroom.chat;

import chatroom.tuplespace.TupleSpace;

import java.util.Scanner;

import static java.lang.System.exit;

public class ChatRoom {

    // Used to give to new User objects via constructor. Not used by the coordinator.
    private TupleSpace ts = new TupleSpace(10);
    private Scanner sc = new Scanner(System.in);
    private boolean isRunning;

    public ChatRoom() {
        System.out.println("Welcome to the Chat Room!");
        System.out.println("For a list of commands type 'help' in the command prompt.");
        System.out.println("---------------------------------------------------------");
        isRunning = true;
    }

    /**
     * Read in a line of input and perform commands requested. Loops continuously until exit command is prompted.
     */
    public void start() {
        String input;
        while(isRunning) {
            System.out.print("Please enter a command: ");
            input = sc.nextLine();
            switch(input) {
                case "help":
                    System.out.println();
                    System.out.println("Possible Commands:");
                    System.out.println("'current user' -- Check which user you are currently logged in as");
                    System.out.println("'switch user' -- Switch to a different user");
                    System.out.println("'get recent messages' -- Retrieve the last 10 messages posted in the chat room");
                    System.out.println("'get active users' -- Get a list of active users in the chat room");
                    System.out.println("'post message' -- Post a new message as the current user");
                    System.out.println("'new user' -- Create a new user and log in as them");
                    System.out.println();
                    break;
                case "current user":
                    break;
                case "switch user":
                    break;
                case "get recent messages":
                    break;
                case "get active users":
                    break;
                case "post message":
                    break;
                case "new user":
                    break;
                case "exit":
                    exit(0);
            }
        }
    }
}
