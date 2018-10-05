package chatroom.tuple;

import javafx.scene.Parent;

import java.util.*;

public class Tuple {


//    private TreeSet<Object> tuple = new TreeSet<>(Comparator.comparing(Object::hashCode));
//    private Comparator tupleComparator = new TupleComparator();
//    private TreeSet<Object> tuple = new TreeSet<Object>(tupleComparator);
    private ArrayList<Object> tuple = new ArrayList<>();


    public Tuple(Object... items) {
        tuple.addAll(Arrays.asList(items));
    }

    public ArrayList<Object> getTuple() {
        return tuple;
    }

    public int size() {
        return tuple.size();
    }

    /**
     * Creates a string representation of the Tuple's contents
     * @return a string representation of the Tuple's contents
     */
    @Override
    public String toString() {
        return "Tuple = " + tuple;
    }

//    implements Comparable<Tuple>
//    @Override
//    public int compareTo(Tuple tuple) {
//        System.out.println("test compareTo");
//        //return this.hashCode() - tuple.hashCode();
//        return this.tuple.size() - tuple.size();
//    }

//    @Override
//    public int compare(Tuple o1, Tuple o2) {
//        System.out.println("test");
//        if(o1.equals(o2)) {
//            return 0;
//        }
//        else {
//            return 1;
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple that = (Tuple) o;

        return Objects.equals(tuple, that.tuple);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tuple);
    }


//    class TupleComparator implements Comparator<Object> {
//
//        @Override
//        public int compare(Object o1, Object o2) {
//
//            if(o1.hashCode() == o2.hashCode()) {
//                return 0;
//            }
//            else return -1;
//        }
//    }
}

