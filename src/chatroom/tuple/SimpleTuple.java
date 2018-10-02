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

//    implements Comparable<Object>
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        SimpleTuple that = (SimpleTuple) o;
//
//
//        return Objects.equals(tupleList, that.tupleList);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(tupleList);
//    }
//
//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }

    @Override
    public String toString() {
        return tupleList.toString();
    }
}
