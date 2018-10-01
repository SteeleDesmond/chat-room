package chatroom;

import chatroom.test.SimpleTupleSpaceTest;
import chatroom.tuple.SimpleTuple;
import chatroom.tuple.Tuple;
import chatroom.tuplespace.TupleSpace;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class mainApp {

    public static void main(String[] args) {

        //SimpleTupleSpaceTest simpleTest = new SimpleTupleSpaceTest();
        //HashMap<Integer,Object> testmap = new HashMap<>();
        //testmap.put(tuple2.size(),tuple2.tupleList);

        //Tuple tuple = new Tuple("hello",19);
        Tuple tuple = new Tuple(10, 20);
        TupleSpace tupleSpace = new TupleSpace(10);

        tupleSpace.add(tuple.getTuple());

        System.out.print(tupleSpace);

        //tuple2.test.add(tuple2);
        //System.out.print(tuple2.test);

       // simpleTest.runEasyTest();
        //simpleTest.runHardTest();
    }
}

