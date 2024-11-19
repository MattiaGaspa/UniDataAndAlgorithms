import interfaces.Entry;

/** Implementation of the interface Entry for this project. */
public class MyEntry implements Entry<Integer, String> {
    /** Constructor used to define an entry.
     * @param key Key corresponding to this entry.
     * @param value Value corresponding to this entry.
     */
    public MyEntry(Integer key, String value) {
        this.key = key;
        setValue(value);
    }

    /** Returns the key corresponding to this entry.
     * @return The key corresponding to this entry.
     */
    public Integer getKey() { return this.key; }

    /** Replaces the value corresponding to this entry with the specified value (optional operation).
     * @param value New value to be stored in this entry.
     * @return Old value corresponding to the entry.
     */
    public String setValue(String value) {
        String oldValue = this.value;
        this.value = value;
        return oldValue;
    }
    /** Returns the value corresponding to this entry.
     * @return The value corresponding to this entry.
     */
    public String getValue() { return this.value; }

    /** Variable used to store the key. */
    private int key = 0;
    /** Variable used to store the value. */
    private String value = "";
}
