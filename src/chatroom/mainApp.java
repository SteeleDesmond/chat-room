package chatroom;

import chatroom.test.SimpleTupleSpaceTest;
import chatroom.tuple.SimpleTuple;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class mainApp {

    public static void main(String[] args) {

        SimpleTupleSpaceTest simpleTest = new SimpleTupleSpaceTest();

        SimpleTuple tuple2 = new SimpleTuple("hello",19);

        HashMap<Integer,Object> testmap = new HashMap<>();


        testmap.put(tuple2.size(),tuple2.tupleList);

        System.out.print(testmap);

        tuple2.test.add(tuple2);

        System.out.print(tuple2.test);

        for(Integer key : testmap.keySet())
        {
            if(key == 0)
            {
                System.out.println("test");
                System.out.println();

            }
        }


       // simpleTest.runEasyTest();
        //simpleTest.runHardTest();
    }
}

