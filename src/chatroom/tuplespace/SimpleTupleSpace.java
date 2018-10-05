package chatroom.tuplespace;

import chatroom.tuple.SimpleTuple;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Simple tuple space implementation. The Tuple Space structure allows the user to add, remove, or read tuples from
 * the tuple space. Tuples are represented as an arbitrary size array of objects as input and are returned as a finite
 * array of objects.
 */
public class SimpleTupleSpace {

    private ArrayList<SimpleTuple> tupleSpace = new ArrayList<>();
    private int maxTupleSize;

    public SimpleTupleSpace(int size) {
        maxTupleSize = size;
    }


    /**
     * Find and remove a tuple in the Tuple Space that matches the given pattern of objects. A '*' represents any
     * object.
     * @param items The pattern of tuple contents to search for
     * @return A tuple that matches the pattern of objects given
     */
    public Object[] remove(Object... items) {

        SimpleTuple patternToFind = new SimpleTuple(items);
        ArrayList<Object> currentTuple;

        // Look at each Tuple in the TupleSpace and iterate through its contents.
        // Compare the contents to the pattern to search for.
        for (SimpleTuple t : tupleSpace) {
            if(t.size() != patternToFind.size()) {
                continue;
            }
            currentTuple = t.getAsArrayList();
            for (int i = 0; i < patternToFind.size() && i < currentTuple.size(); i++) {
                Object o = currentTuple.get(i);
                // If the object in the tuple is not the same as the pattern, or it is not a wildcard then skip
                if (!(o.equals(patternToFind.get(i)) || patternToFind.get(i) == "*")) {
                    break;
                }
                // We found a tuple that matches the pattern
                if (i == patternToFind.size() - 1) {
                    tupleSpace.remove(t);
                    return t.getAsObjectList();
                }
            }
        }
        //System.out.println("The pattern to remove wasn't found in the TupleSpace.");
        return null;
    }

    /**
     * Add a tuple to the tuple space. No duplicates are allowed.
     * @param tupleContents The tuple to add
     */
    public void add(Object... tupleContents) {
        SimpleTuple tuple = new SimpleTuple(tupleContents);
        int counter = 0;

        if (tuple.size() > maxTupleSize) {
            System.out.println("Tuple size is longer than given max size -- Tuple has not been added.");
            return;
        }
        // Look at each Tuple in the TupleSpace and iterate through its contents.
        // Compare the contents to the pattern to search for.
        for (SimpleTuple t : tupleSpace) {
            counter = 0;
            for (Object o : t.getAsArrayList()) {
                // If the object in the tuple is the same as the pattern
                if(o.equals(tuple.get(counter))) {
                    counter++;
                }
                // Else it is not a matching tuple so go to the next tuple.
                else {
                    counter = 0;
                    break;
                }
                // We found a tuple that matches the pattern
                if(counter == tuple.size()) {
                    System.out.println("Duplicate Tuple found -- Tuple has not been added.");
                    return;
                }
                //counter = 0;
            }
        }
        // The tuple is not already in the tuple space.
        //System.out.println("Tuple added");
        tupleSpace.add(tuple);
    }

    /**
     * Search for a given pattern in the tuple space and return a tuple that matches the given pattern.
     * @param items The pattern of tuple contents to search for
     */
    public Object[] read(Object... items) {
        SimpleTuple patternToFind = new SimpleTuple(items);
        ArrayList<Object> currentTuple;

        // Look at each Tuple in the TupleSpace and iterate through its contents.
        // Compare the contents to the pattern to search for.
        for (SimpleTuple t : tupleSpace) {
            if(t.size() != patternToFind.size()) {
                continue;
            }
            currentTuple = t.getAsArrayList();
            for (int i = 0; i < patternToFind.size() && i < currentTuple.size(); i++) {
                Object o = currentTuple.get(i);
                // If the object in the tuple is not the same as the pattern, or it is not a wildcard then skip
                if (!(o.equals(patternToFind.get(i)) || patternToFind.get(i) == "*")) {
                    break;
                }
                // We found a tuple that matches the pattern
                if (i == patternToFind.size() - 1) {
                    return t.getAsObjectList();
                }
            }
        }
        //System.out.println("The pattern to remove wasn't found in the TupleSpace.");
        return null;
    }

    @Override
    public String toString() {
        return "TupleSpace contents: " + tupleSpace.toString();
    }
}
