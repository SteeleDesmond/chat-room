package chatroom.tuplespace;

/**
 * Used for better code practice and for the TupleSpaceTest class.
 */
public interface TupleSpaceInterface {

    void add(Object... pattern);

    Object[] remove(Object... pattern);

    Object[] read(Object... pattern);
}
