package chatroom.chat;

import chatroom.test.SimpleTupleSpaceTest;
import chatroom.tuplespace.SimpleTupleSpace;
import java.util.Scanner;

import static java.lang.System.exit;

public class ChatRoom {

    private SimpleTupleSpaceTest tsTest = new SimpleTupleSpaceTest();
    private ChatController uc = new ChatController(new SimpleTupleSpace(10));
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
                    System.out.println("'(cu)current user' -- Check which user you are currently logged in as");
                    System.out.println("'(s)switch user' -- Switch to a different user. Enter the username of the user");
                    System.out.println("'(m)get recent messages' -- Retrieve the last 10 messages posted in the chat room");
                    System.out.println("'(a)get active users' -- Get a list of active users in the chat room");
                    System.out.println("'(all)get all users' -- Get a list of all users in the chat room");
                    System.out.println("'(pm)post message' -- Post a new message as the current user");
                    System.out.println("'(nu)new user' -- Create a new user and log in as them");
                    System.out.println("'(t)testing mode' -- Call the tuple space test classes");
                    System.out.println();
                    break;
                case "cu":
                    if(uc.getCurrentUser() != null) {
                        System.out.println("You are currently logged in as: " + uc.getCurrentUser());
                    }
                    else {
                        System.out.println("Currently, there are no registered users in the chat room.");
                    }
                    break;
                case "s":
                    System.out.println("Which user would you like to switch to?");
                    input = sc.nextLine();
                    if(uc.switchCurrentUser(input)) {
                        System.out.println("Switched to user: " + input);
                    }
                    else {
                        System.out.println("The given username has not been registered in the chat room.");
                    }
                    break;
                case "m":
                    if(uc.getRecentMessages(1) == null) {
                        System.out.println("There are currently no messages posted. *crickets*");
                    }
                    else {
                        System.out.println("Most recent posts: ");
                        System.out.println();
                        for(String s : uc.getRecentMessages(10)) {
                            System.out.println(s);
                        }
                        System.out.println();
                    }
                    break;
                case "a":
                    if(uc.getActiveUsers() == null) {
                        System.out.println("There are currently no active users.");
                    }
                    else {
                        System.out.println("Currently active users: " + uc.getActiveUsers().toString());
                    }
                    break;
                case "all":
                    if(uc.getAllUsers() == null) {
                        System.out.println("There are no users currently registered. Type 'new user' to register!");
                    }
                    else {
                        System.out.print("All registered users: " + uc.getAllUsers().toString());
                    }
                    break;
                case "pm":
                    System.out.println("Enter message: ");
                    input = sc.nextLine();
                    if(uc.postMessage(input)) {
                        System.out.println("Posted message: " + input);
                    }
                    else {
                        System.out.println("Message cannot be posted. Please register a user first.");
                    }
                    break;
                case "nu":
                    System.out.print("Please enter a username: ");
                    input = sc.nextLine();

                    if(uc.addUser(input)) {
                        System.out.println("New user added.");
                    }
                    else {
                        System.out.println("Username is taken. User has not been added.");
                    }
                    break;
                case "t":
                    System.out.println("Testing Mode: Testing options...");
                    System.out.println("'(sc)simple correctness test'");
                    System.out.println("'(ss)simple stress test'");
                    System.out.println("'(ac)advanced correctness test'");
                    System.out.println("'(as)advanced stress test'");
                    System.out.println();
                    input = sc.nextLine();
                    switch(input) {
                        case "sc":
                            tsTest.runCorrectnessTest();
                            break;
                        case "ss":
                            System.out.println("The test will add, read, and remove tuples from the tuple space. " +
                                    "How many tuples should we add? (50,000 ~= 50 seconds)");
                            input = sc.nextLine();
                            tsTest.runStressTest(Integer.parseInt(input) / 4);
                            break;
                        case "ac":
                            System.out.println("ac");
                            break;
                        case "as":
                            System.out.println("as");
                            break;
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
