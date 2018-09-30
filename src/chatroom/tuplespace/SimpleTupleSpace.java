package chatroom.tuplespace;

import chatroom.tuple.SimpleTuple;

import java.util.ArrayList;
import java.util.Collection;

public class SimpleTupleSpace {

    private ArrayList<SimpleTuple> simpleTuples;

    public SimpleTupleSpace(int size) {
        simpleTuples = new ArrayList<>(size);

    }

    public SimpleTuple remove(Object... items) {

        boolean validFlag = true;
        int lengthCount = 0;
        SimpleTuple tupleToCheck;
        
        for (Object objectToFind : items) {
            for(int i = 0; i < simpleTuples.size(); i++) {

                tupleToCheck = simpleTuples.get(i);
                for(int j = 0; j < tupleToCheck.size(); j++) {
                    if(objectToFind != "*" || objectToFind != tupleToCheck.get(j)) {
                        validFlag = false;
                    }
                    else {
                        j++;
                    }
                    if(!validFlag) {
                        j = tupleToCheck.size();
                    }
                }
                if(validFlag) {
                    simpleTuples.remove(tupleToCheck);
                    return tupleToCheck;
                }
                validFlag = true;
            }
        }
        tupleToCheck = new SimpleTuple(-1);
        return tupleToCheck;
    }

    public void add(Object... tuple) {
        SimpleTuple addSimpleTuple = new SimpleTuple(tuple);
        if(read(tuple) != null) {
            simpleTuples.add(addSimpleTuple);
        }
        else {
            System.out.println("Duplicate Tuple found -- Tuple has not been added.");
        }
    }

    public SimpleTuple read(Object... items) {
        SimpleTuple tupleToFind = null;
        for(int i = 0; i < simpleTuples.size(); i++) {
            tupleToFind = simpleTuples.get(i);

            for(int j = 0; j < tupleToFind.size(); j++) {
                if(tupleToFind.get(j) == items) {
                    return tupleToFind;
                }
            }
        }
        return tupleToFind;
    }
}
