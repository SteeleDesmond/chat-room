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
     * Add a given pattern or list of items to the tuple space as a tuple. No duplicates are allowed.
     * @param tupleContents The list of objects to add
     */
    public void add(Object... tupleContents) {
        Tuple tuple = new Tuple(tupleContents);
        tupleSpace.put(tuple.size(), tuple.getTuple());
        System.out.println("Added tuple to tupleSpace");
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
}
