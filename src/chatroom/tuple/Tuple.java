package chatroom.tuple;

import javafx.scene.Parent;

import java.util.*;

public class Tuple implements Comparator<Tuple> {

    private TreeSet<Object> tuple = new TreeSet<>(Comparator.comparing(Object::hashCode));

    public Tuple(Object... items) {
        tuple.addAll(Arrays.asList(items));
    }

    public TreeSet<Object> getTuple() {
        return tuple;
    }

    public int size() {
        return tuple.size();
    }

//    @Override
//    public int compareTo(Tuple tuple) {
//        return this.tuple.size() - tuple.size();
//    }

    /**
     * Creates a string representation of the Tuple's contents
     * @return a string representation of the Tuple's contents
     */
    @Override
    public String toString() {
        return "Tuple{" +
                "tuple=" + tuple +
                '}';
    }

    @Override
    public int compare(Tuple o1, Tuple o2) {
        System.out.println("test");
        if(o1.equals(o2)) {
            return 0;
        }
        else {
            return 1;
        }
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
