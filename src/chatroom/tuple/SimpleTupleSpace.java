package chatroom.tuple;

import java.util.ArrayList;

public class SimpleTupleSpace {

    private ArrayList<SimpleTuple> simpleTuples = new ArrayList<>();

    public SimpleTupleSpace() {

    }

    public void remove(Object tuple) {
        simpleTuples.remove(tuple);
    }

    public void add(Object tuple) {
        SimpleTuple addSimpleTuple = new SimpleTuple(tuple);
        simpleTuples.add(addSimpleTuple);
    }

    public SimpleTuple read(Object... items) {
        SimpleTuple itemToGet = new SimpleTuple(-1);
        for(int i = 0; i < simpleTuples.size(); i++) {
            itemToGet = simpleTuples.get(i);

            for(int j = 0; j < itemToGet.size(); j++) {
                if(itemToGet.get(j) == items) {
                    return itemToGet;
                }
            }
        }
        return itemToGet;
    }
}
