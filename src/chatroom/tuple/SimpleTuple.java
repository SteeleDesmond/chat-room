package chatroom.tuple;

import java.util.*;

public class SimpleTuple implements Comparable<Object> {

    public ArrayList<Object> tupleList = new ArrayList();

    public SimpleTuple(Object... tupleParameters) {
        tupleList.addAll(Arrays.asList(tupleParameters));
    }

    public Collection<Object> read() {
        return tupleList;
    }

    public int size() {
        return tupleList.size();
    }

    public Object get(int index) {
        return tupleList.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleTuple that = (SimpleTuple) o;


        return Objects.equals(tupleList, that.tupleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tupleList);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }



}
