package chatroom;

import chatroom.test.SimpleTupleSpaceTest;
import chatroom.tuple.SimpleTuple;
import chatroom.tuple.Tuple;
import chatroom.tuplespace.SimpleTupleSpace;
import chatroom.tuplespace.TupleSpace;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class mainApp {

    public static void main(String[] args) {

        SimpleTupleSpaceTest simpleTest = new SimpleTupleSpaceTest();


//        TupleSpace tupleSpace = new TupleSpace(10);
//        Tuple tuple = new Tuple(10, 20, 5);
//        Tuple tuple0 = new Tuple(5, 10);
//        Tuple tuple1 = new Tuple("hello",19);
//
//        tupleSpace.add(tuple);
//        tupleSpace.add(tuple0);
//        tupleSpace.add(tuple1);
//        System.out.println(tupleSpace);


        //simpleTest.runEasyTest();
        //simpleTest.runHardTest();

        SimpleTupleSpace simpleTupleSpace = new SimpleTupleSpace(10);
        SimpleTuple sTuple1 = new SimpleTuple("Test", 1, 2);
        SimpleTuple sTuple2 = new SimpleTuple("Test", 1, 3);
        simpleTupleSpace.add(sTuple1);
        simpleTupleSpace.add(sTuple2);


        System.out.println(simpleTupleSpace.toString());

        //simpleTupleSpace.remove("Test", "*", "*");
        simpleTupleSpace.remove(sTuple1.getAsObjectList());
        System.out.println(simpleTupleSpace.toString());
    }
}

