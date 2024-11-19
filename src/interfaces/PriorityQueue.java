package interfaces;

/** Interface used to define a priority queue in this project.
 */
public interface PriorityQueue<K extends Comparable<K>,V> {
    /** Method to get queue size.
     * @return Queue size.
     */
    int size();
    /** Method used to check if a queue is empty or not.
     * @return A boolean: true if the queue is empty else false.
     */
    boolean isEmpty();

    /** Insert an entry in the queue.
     * @param key The key to insert.
     * @param value The value to insert.
     * @return The number of visited nodes
     */
    int insert(K key, V value);
    /** Return the entry with the lowest key, without removing it.
     * @return The entry with the lowest key.
     */
    Entry<K,V> min();
    /** Remove and return the entry with the lowest key.
     * @return The entry with the lowest key.
     */
    Entry<K,V> removeMin();

    /** Prints all entries in S in the order in which they appear in the bottom list S0. */
     void print();
}