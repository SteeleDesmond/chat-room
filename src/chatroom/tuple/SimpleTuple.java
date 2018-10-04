package chatroom.tuple;

import java.util.*;

public class SimpleTuple {

    private ArrayList<Object> tupleList = new ArrayList<>();

    public SimpleTuple(Object... tupleContents) {
        tupleList.addAll(Arrays.asList(tupleContents));
    }

    public Collection<Object> getAsArrayList() {
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
