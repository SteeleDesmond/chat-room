package chatroom.tuple;

import java.util.*;

/**
 * SimpleTuple is used internally for the Tuple Space to perform operations. It is constructed with an arbitrary size
 * array of objects and it stores the input as an ArrayList. Contains basic helper functions
 */
public class SimpleTuple {

    private ArrayList<Object> tupleList = new ArrayList<>();

    public SimpleTuple(Object... tupleContents) {
        tupleList.addAll(Arrays.asList(tupleContents));
    }

    public ArrayList<Object> getAsArrayList() {
        return tupleList;
    }

    public Object[] getAsObjectList() {
        return tupleList.toArray();
    }

    public int size() {
        return tupleList.size();
    }

    public Object get(int index) {
        return tupleList.get(index);
    }

    @Override
    public String toString() {
        return tupleList.toString();
    }
}