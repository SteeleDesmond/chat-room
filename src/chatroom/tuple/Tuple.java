package chatroom.tuple;

import java.util.*;

public class Tuple implements Comparable<Object> {

    private TreeSet<Object> tuple = new TreeSet<>();

    public Tuple(Object... items) {
        tuple.addAll(Arrays.asList(items));
        //tuple.add(items);
        //tuple.addAll(items);
    }

    public TreeSet<Object> getTuple() {
        return tuple;
    }

    public int size() {
        return tuple.size();
    }

//    public Collection<Object> getObject(Object o) {
//
//        Iterator<Object> it = tuple.iterator();
//        int i = 0;
//        Object current = null;
//
//        while(it.hasNext()) {
//            if current =
//        }
//
//        return Iterables.get(tuple, o);
//    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "tuple=" + tuple +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleTuple that = (SimpleTuple) o;


        return Objects.equals(tuple, that.tupleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tuple);
    }

}
