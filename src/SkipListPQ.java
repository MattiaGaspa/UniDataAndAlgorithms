import interfaces.Node;
import interfaces.PriorityQueue;
import interfaces.SkipList;

/** Implementation of the interface PriorityQueue by using SkipList for this project. */
public class SkipListPQ implements PriorityQueue<Integer, String>, SkipList<MyNode> {
    /** Method to get queue size.
     * @return Queue size.
     */
    @Override
    public int size() { return this.size; }
    /** Method used to check if a queue is empty or not.
     * @return A boolean: true if the queue is empty else false.
     */
    @Override
    public boolean isEmpty() { return this.size == 0; }

    /** Insert an entry in the queue.
     * @param key The key to insert.
     * @param value The value to insert.
     */
    @Override
    public int insert(Integer key, String value) {
        return 0;
    }
    /** Return the entry with the lowest key, without removing it.
     * @return The entry with the lowest key.
     */
    @Override
    public MyEntry min() {
        return null;
    }
    /** Remove and return the entry with the lowest key.
     * @return The entry with the lowest key.
     */
    @Override
    public MyEntry removeMin() {
        return null;
    }

    /** Prints all entries in S in the order in which they appear in the bottom list S0. */
    @Override
    public void print() {

    }

    /** Return the successor of the given position.
     * @param p The position in the list.
     * @return The successor of p or null if it's the right sentinel.
     */
    @Override
    public MyNode next(MyNode p) {
        return null;
    }
    /** Return the predecessor of the given position.
     * @param p The position in the list.
     * @return The predecessor of p or null if it's the right sentinel.
     */
    @Override
    public MyNode prev(MyNode p) {
        return null;
    }
    /** Return the position above of the given position.
     * @param p The position in the list.
     * @return The position above of p if it exists else null.
     */
    @Override
    public MyNode above(MyNode p) {
        return null;
    }
    /** Return the position below of the given position.
     * @param p The position in the list.
     * @return The position below of p if it exists else null.
     */
    @Override
    public MyNode below(MyNode p) {
        return null;
    }

    /** Variable used to store the size of the priority queue */
    private int size = 0;
}
