package chatroom.tuplespace;

import chatroom.tuple.Tuple;

import java.util.HashMap;

public class TupleSpace {

    // Integer = Tuple size, Object = Tuple (As a TreeSet)
    private HashMap<Integer,Object> tupleSpace;

    public TupleSpace(int size) {
        tupleSpace = new HashMap<>(size);
    }

    /**
     * Search for a given pattern in the tuple space and return a tuple that matches the given pattern.
     * @param tupleContents The pattern of tuple contents to search for
     */
    public void read(Object... tupleContents) {

        for(Integer key : tupleSpace.keySet())
        {
            if(key > 0)
            {
                System.out.println("test");
                System.out.println();

            }
        }

    }

    /**
     * Add a tuple to the tuple space. No duplicates are allowed.
     * @param tuple The tuple to add
     */
    public void add(Tuple tuple) {
        tupleSpace.put(tuple.size(), tuple.getTuple());
        System.out.println("Added tuple to tupleSpace with contents: " + tuple.getTuple());
    }

    /**
     * Find and remove a tuple in the Tuple Space that matches the given pattern of objects. A '*' represents any
     * object.
     * @param tupleContents The pattern of tuple contents to search for
     * @return A tuple that matches the pattern of objects given
     */
    public Tuple remove(Object... tupleContents) {
        Tuple tupleToFind = new Tuple(tupleContents);



        return tupleToFind;
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
