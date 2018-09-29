package chatroom.test;

import chatroom.tuple.SimpleTuple;
import chatroom.tuple.SimpleTupleSpace;

import java.util.concurrent.ThreadLocalRandom;

public class SimpleTupleSpaceTest {

    public SimpleTupleSpaceTest() {
        SimpleTupleSpace tupleSpace = new SimpleTupleSpace();
    }

    public void runEasyTest() {
        System.out.println("Running SimpleTupleSpace Easy Test...");
        SimpleTuple tuple;
        final long startTime;
        final long endTime;

        String stringObj = "test";
        int intObj = 50;
        boolean boolObj = true;

        startTime = System.currentTimeMillis();
        for(int i = 0; i < 100; i++) {
            tuple = new SimpleTuple(stringObj, intObj, boolObj);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + " millisecond(s)" );
    }

    public void runHardTest() {
        System.out.println("Running SimpleTupleSpace Hard Test...");
        SimpleTuple tuple;
        final long startTime;
        final long endTime;

        String stringObj = "test";
        int intObj = 50;
        boolean boolObj = true;

        startTime = System.currentTimeMillis();
        for(int i = 0; i < 100000000; i++) {
            tuple = new SimpleTuple(stringObj, intObj, boolObj);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + " millisecond(s)" );
    }
}
