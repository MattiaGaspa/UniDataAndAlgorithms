package interfaces;

/** Interface used to define a node in this project. */
public interface Node<E> extends Position<E> {
    /** Return the next node.
     * @return The next node or null if right sentinel.
    */
    Node<E> getNext();
    /** Return the previous node.
     * @return The previous node or null if left sentinel.
    */
    Node<E> getPrev();
    /** Return the node above.
     * @return The node above or null if there are no nodes.
    */
    Node<E> getAbove();
    /** Return the node below.
     * @return The node below or null if there are no nodes.
    */
    Node<E> getBelow();

    /** Set the next node.
     * @param node The next node.
    */
    void setNext(Node<E> node);
    /** Set the previous node.
     * @param node The previous node.
    */
    void setPrev(Node<E> node);
    /** Set the node above.
     * @param node The node above.
    */
    void setAbove(Node<E> node);
    /** Set the node below.
     * @param node The node below.
    */
    void setBelow(Node<E> node);

    /** Set the element stored in the node.
     * @param element The element to store.
     */
    void setElement(E element);
}