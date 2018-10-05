package chatroom.test;

import chatroom.tuple.SimpleTuple;
import chatroom.tuplespace.SimpleTupleSpace;

public class SimpleTupleSpaceTest {

    public SimpleTupleSpaceTest() {
    }

    public void runCorrectnessTest() {
        System.out.println("Running SimpleTupleSpace Correctness Test...");
        int testSize = 10;
        SimpleTupleSpace ts = new SimpleTupleSpace(10);
        final long startTime;
        final long endTime;
        Object[] tuple;

        // 4 different simple objects
        String stringObj = "String-Object";
        int intObj = 50;
        Double doubleObj = -50.0;
        boolean boolObj = true;

        startTime = System.currentTimeMillis();
        System.out.println("Adding up to 50 tuples of different sizes (including duplicates) to Tuple Space...");
        for(int i = 0; i < testSize; i++) {
            ts.add(boolObj); // Size 1 Tuple
            ts.add(intObj + i, boolObj); // Size 2 tuple
            ts.add(doubleObj, intObj + i, stringObj); // Size 3 Tuple
            ts.add(stringObj, intObj, doubleObj + i, boolObj); // Size 4 Tuple
            ts.add(stringObj, intObj, doubleObj, boolObj, stringObj, doubleObj, intObj + i, boolObj); // Size 8 Tuple
        }
        System.out.println("Contents of Tuple Space...");
        System.out.println(ts.toString());

        System.out.println("Reading tuples of different sizes from Tuple Space...");

        System.out.println("Searching for tuple matching pattern ('*', '*', '*', '*')");
        System.out.print("Tuple found = ");
        tuple = ts.read("*", "*", "*", "*");
        for(Object o : tuple) {
            System.out.print(o + " ");
        }
        System.out.println();

        System.out.println("Searching for tuple matching pattern ('*', '*', 'String-Object')");
        System.out.print("Tuple found = ");
        tuple = ts.read("*", "*", "String-Object");
        for(Object o : tuple) {
            System.out.print(o + " ");
        }
        System.out.println();

        System.out.println("Searching for tuple matching pattern ('true')");
        System.out.print("Tuple found = ");
        tuple = ts.read(true);
        for(Object o : tuple) {
            System.out.print(o + " ");
        }
        System.out.println();

        System.out.println("Removing tuples of different sizes from Tuple Space...");
        System.out.println("Removing tuples matching pattern ('*', '*')");
        while(ts.read("*", "*") != null) {
            tuple = ts.remove("*", "*");
            System.out.print("Tuple removed = ");
            for(Object o : tuple) {
                System.out.print(o + " ");
            }
            System.out.println();
        }

        System.out.println("Removing tuples matching pattern ('String-Object', '*', '*', '*')");
        while(ts.read("String-Object", "*", "*", "*") != null) {
            tuple = ts.remove("String-Object", "*", "*", "*");
            System.out.print("Tuple removed = ");
            for(Object o : tuple) {
                System.out.print(o + " ");
            }
            System.out.println();
        }

        System.out.println(ts.toString());
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + " millisecond(s)" );
    }

    public void runStressTest(int testSize) {
        System.out.println("Running SimpleTupleSpace Stress Test...");
        SimpleTupleSpace ts = new SimpleTupleSpace(testSize);
        final long startTime;
        final long endTime;
        Object[] tuple;

        // 4 different simple objects
        String stringObj = "String-Object";
        int intObj = 50;
        Double doubleObj = -50.0;
        boolean boolObj = true;

        System.out.println("Adding " + testSize*4 + " Tuples to Tuple Space");
        startTime = System.currentTimeMillis();
        for(int i = 0; i < testSize; i++) {
            ts.add(stringObj, intObj + i, doubleObj - i, boolObj);
            ts.add(doubleObj + i);
            ts.add(intObj - i);
            ts.add(stringObj + i, boolObj);
        }
        for(int i = 0; i < testSize; i++) {
            ts.read(stringObj, intObj + i, doubleObj - i, boolObj);
            ts.read(doubleObj + i);
            ts.read(intObj - i);
            ts.read(stringObj + i, boolObj);
        }
        for(int i = 0; i < testSize; i++) {
            ts.remove(stringObj, intObj + i, doubleObj - i, boolObj);
            ts.remove(doubleObj + i);
            ts.remove(intObj - i);
            ts.remove(stringObj + i, boolObj);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + " millisecond(s)" );
    }
}
