package chatroom.tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class SimpleTuple {

    private ArrayList<Object> tuple = new ArrayList();

    public SimpleTuple(Object... tupleParameters) {
        tuple.addAll(Arrays.asList(tupleParameters));
    }

    public Collection<Object> read() {
        return tuple;
    }

    public int size() {
        return tuple.size();
    }

    public Object get(int index) {
        return tuple.get(index);
    }
}
