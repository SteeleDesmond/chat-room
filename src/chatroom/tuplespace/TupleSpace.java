package chatroom.tuplespace;

import chatroom.tuple.Tuple;

import java.util.ArrayList;
import java.util.HashMap;

public class TupleSpace implements TupleSpaceInterface {

    // Key = Tuple size, Value = Tuple
    private HashMap<Integer, Tuple> tupleSpace;

    public TupleSpace(int size) {
        tupleSpace = new HashMap<>(size);
    }

    /**
     * Search for a given pattern in the tuple space and return a tuple that matches the given pattern.
     * @param tupleContents The pattern of tuple contents to search for
     */
    public Object[] read(Object... tupleContents) {

        for(Integer key : tupleSpace.keySet())
        {
            if(key > 0)
            {
                System.out.println(tupleSpace.get(key).getTuple().toString());
                System.out.println();
            }
        }
        return null;
    }

    /**
     * Add a tuple to the tuple space. No duplicates are allowed.
     * @param items The tuple to add
     */
    public void add(Object... items) {
        Tuple tuple = new Tuple(items);
        tupleSpace.put(tuple.size(), tuple);
        System.out.println("Added tuple to tupleSpace with contents: " + tuple.getTuple());
    }

    /**
     * Find and remove a tuple in the Tuple Space that matches the given pattern of objects. A '*' represents any
     * object.
     * @param tupleContents The pattern of tuple contents to search for
     * @return A tuple that matches the pattern of objects given
     */
    public Object[] remove(Object... tupleContents) {

        return null;
    }

    /**
     * Override toString for testing purposes
     * @return A string representation of the TupleSpace
     */
    @Override
    public String toString() {

        return "TupleSpace = " + tupleSpace;
    }
}
