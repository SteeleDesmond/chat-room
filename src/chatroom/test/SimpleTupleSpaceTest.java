package chatroom.test;

import chatroom.tuple.SimpleTuple;
import chatroom.tuplespace.SimpleTupleSpace;

public class SimpleTupleSpaceTest {

    public SimpleTupleSpaceTest() {
    }

    public void runEasyTest() {
        System.out.println("Running SimpleTupleSpace Easy Test...");
        int testSize = 100;
        SimpleTupleSpace tupleSpace = new SimpleTupleSpace(testSize);
        SimpleTuple tuple;
        final long startTime;
        final long endTime;
        String stringObj = "test";
        int intObj = 50;
        boolean boolObj = true;

        startTime = System.currentTimeMillis();
        for(int i = 0; i < testSize; i++) {
            tuple = new SimpleTuple(stringObj, intObj, boolObj);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + " millisecond(s)" );
    }

    public void runHardTest() {
        System.out.println("Running SimpleTupleSpace Hard Test...");
        int testSize = 100000000;
        SimpleTupleSpace tupleSpace = new SimpleTupleSpace(testSize);
        SimpleTuple tuple;
        final long startTime;
        final long endTime;

        String stringObj = "test";
        int intObj = 50;
        boolean boolObj = true;

        startTime = System.currentTimeMillis();
        for(int i = 0; i < testSize; i++) {
            tuple = new SimpleTuple(stringObj, intObj, boolObj);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + " millisecond(s)" );
    }
}
