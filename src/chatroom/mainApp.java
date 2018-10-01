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

        TupleSpace tupleSpace = new TupleSpace(10);
        Tuple tuple = new Tuple(10, 20, 5);
        Tuple tuple0 = new Tuple(5, 10);
        Tuple tuple1 = new Tuple("hello",19);

        tupleSpace.add(tuple);
        tupleSpace.add(tuple0);
        tupleSpace.add(tuple1);

        System.out.print(tupleSpace.toString());


        //tuple2.test.add(tuple2);
        //System.out.print(tuple2.test);

       // simpleTest.runEasyTest();
        //simpleTest.runHardTest();
    }
}

