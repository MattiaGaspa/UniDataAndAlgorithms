package interfaces;

/** Interface used to define an entry in this project.
 */
public interface Entry<K extends Comparable<K>,V> {
    /** Returns the key corresponding to this entry.
     * @return the key corresponding to this entry.
     */
    public K getKey();

    /** Replaces the value corresponding to this entry with the specified value (optional operation).
     * @param value New value to be stored in this entry.
     * @return Old value corresponding to the entry.
     */
    public V setValue(V value);
    /** Returns the value corresponding to this entry.
     * @return the value corresponding to this entry.
     */
    public V getValue();
}