package chatroom.chat;

import chatroom.tuplespace.SimpleTupleSpace;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class ChatRoom {

    private UserController uc = new UserController(new SimpleTupleSpace(10));
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
                    System.out.println("'switch user' -- Switch to a different user. Enter the username of the user");
                    System.out.println("'get recent messages' -- Retrieve the last 10 messages posted in the chat room");
                    System.out.println("'get active users' -- Get a list of active users in the chat room");
                    System.out.println("'get all users' -- Get a list of all users in the chat room");
                    System.out.println("'post message' -- Post a new message as the current user");
                    System.out.println("'new user' -- Create a new user and log in as them");
                    System.out.println();
                    break;
                case "current user":
                    if(uc.getCurrentUser() != null) {
                        System.out.println("You are currently logged in as: " + uc.getCurrentUser());
                    }
                    else {
                        System.out.println("Currently, there are no registered users in the chat room.");
                    }
                    break;
                case "switch user":
                    System.out.println("Which user would you like to switch to?");
                    input = sc.nextLine();
                    if(uc.switchCurrentUser(input)) {
                        System.out.println("Switched to user: " + input);
                    }
                    else {
                        System.out.println("The given username has not been registered in the chat room.");
                    }
                    break;
                case "get recent messages":
                    System.out.println(uc.getRecentMessages());
                    break;
                case "get active users":
                    if(uc.getActiveUsers() == null) {
                        System.out.println("There are currently no active users.");
                    }
                    else {
                        System.out.print("Currently active users: " + uc.getActiveUsers().toString());
                    }
                    break;
                case "get all users":
                    if(uc.getAllUsers() == null) {
                        System.out.println("There are no users currently registered. Type 'new user' to register!");
                    }
                    else {
                        System.out.print("All registered users: " + uc.getAllUsers().toString());
                    }
                    break;
                case "post message":
                    System.out.println("Enter message: ");
                    input = sc.nextLine();
                    uc.postMessage(input);
                    System.out.println("Posted message: " + input);
                    break;
                case "new user":
                    System.out.print("Please enter a username: ");
                    input = sc.nextLine();

                    if(uc.addUser(input)) {
                        System.out.println("New user added.");
                    }
                    else {
                        System.out.println("Username is taken. User has not been added.");
                    }
                    break;
                case "exit":
                    exit(0);
                default:
                    System.out.println("Unrecognized command. Please try again, or type 'help' for more options.");
            }
        }
    }
}
