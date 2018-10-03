package chatroom.tuplespace;

import chatroom.tuple.SimpleTuple;

import java.util.ArrayList;
import java.util.Arrays;

public class SimpleTupleSpace {

    private ArrayList<SimpleTuple> tupleSpace = new ArrayList<>();
    private int maxTupleSize;

    public SimpleTupleSpace(int size) {
        maxTupleSize = size;
    }

    public Object[] remove(Object... items) {

        SimpleTuple patternToFind = new SimpleTuple(items);
        int counter = 0;

        // Look at each Tuple in the TupleSpace and iterate through its contents.
        // Compare the contents to the pattern to search for.
        for (SimpleTuple t : tupleSpace) {
            counter = 0;
            for (Object o : t.getAsArrayList()) {
                // If the object in the tuple is the same as the pattern, or it is a wildcard then keep going
                if(o.equals(patternToFind.get(counter)) || patternToFind.get(counter) == "*") {
                    counter++;
                }
                // Else it is not a matching tuple so go to the next tuple.
                else {
                    counter = 0; // Assignment is only redundant when the first parameter does not match.
                    break;
                }
                // We found a tuple that matches the pattern
                if(counter == patternToFind.size()) {
                    tupleSpace.remove(t);
                    return t.getAsObjectList();
                }
            }
        }
        System.out.println("The pattern to remove wasn't found in the TupleSpace.");
        return null;
    }

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

    public Object[] read(Object... items) {
        SimpleTuple patternToFind = new SimpleTuple(items);
        int counter = 0;

        // Look at each Tuple in the TupleSpace and iterate through its contents.
        // Compare the contents to the pattern to search for.
        for (SimpleTuple t : tupleSpace) {
            counter = 0;
            for (Object o : t.getAsArrayList()) {
                // If the object in the tuple is the same as the pattern, or it is a wildcard then keep going
                if(o.equals(patternToFind.get(counter)) || patternToFind.get(counter) == "*") {
                    counter++;
                }
                // Else it is not a matching tuple so go to the next tuple.
                else {
                    counter = 0;
                    break;
                }
                // We found a tuple that matches the pattern
                if(counter == patternToFind.size()) {
                    return t.getAsObjectList();
                }
            }
        }
        //System.out.println("The pattern to read wasn't found in the TupleSpace.");
        return null;
    }

    @Override
    public String toString() {
        return "TupleSpace contents: " + tupleSpace.toString();
    }
}
