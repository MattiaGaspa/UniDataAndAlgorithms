package interfaces;

/** Interface used to define a list in this project.
 */
public interface SkipList<E extends Node<E>> {
    /** Return the successor of the given position.
     * @param p The position in the list.
     * @return The successor of p or null if it's the right sentinel.
     */
    E next(E p);
    /** Return the predecessor of the given position.
     * @param p The position in the list.
     * @return The predecessor of p or null if it's the right sentinel.
     */
    E prev(E p);
    /** Return the position above of the given position.
     * @param p The position in the list.
     * @return The position above of p if it exists else null.
     */
    E above(E p);
    /** Return the position below of the given position.
     * @param p The position in the list.
     * @return The position below of p if it exists else null.
     */
    E below(E p);
}