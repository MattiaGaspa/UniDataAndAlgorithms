import interfaces.Node;
import interfaces.PriorityQueue;
import interfaces.SkipList;

/** Implementation of the interface PriorityQueue by using SkipList for this project. */
public class SkipListPQ implements PriorityQueue<Integer, String> {
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
        this.size++;
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
        this.size--;
        return null;
    }

    /** Prints all entries in S in the order in which they appear in the bottom list S0. */
    @Override
    public void print() {

    }

    /** Variable used to store the size of the priority queue */
    private int size = 0;
}
