import interfaces.Node;

/** Implementation of the interface Node for this project. */
public class MyNode implements Node<MyEntry> {
    /** Return the element stored int the position.
     * @return The element stored.
     */
    @Override
    public MyEntry getElement() { return this.element; }

    /** Return the next node.
     * @return The next node or null if right sentinel.
     */
    @Override
    public Node<MyEntry> getNext() { return this.next; }
    /** Return the previous node.
     * @return The previous node or null if left sentinel.
     */
    @Override
    public Node<MyEntry> getPrev() { return this.prev; }
    /** Return the node above.
     * @return The node above or null if there are no nodes.
     */
    @Override
    public Node<MyEntry> getAbove() { return this.above; }
    /** Return the node below.
     * @return The node below or null if there are no nodes.
     */
    @Override
    public Node<MyEntry> getBelow() { return this.below; }

    /** Set the next node.
     * @param node The next node.
     */
    @Override
    public void setNext(Node<MyEntry> node) {
        this.next = node;
    }
    /** Set the previous node.
     * @param node The previous node.
     */
    @Override
    public void setPrev(Node<MyEntry> node) {
        this.prev = node;
    }
    /** Set the node above.
     * @param node The node above.
     */
    @Override
    public void setAbove(Node<MyEntry> node) {
        this.above = node;
    }
    /** Set the node below.
     * @param node The node below.
     */
    @Override
    public void setBelow(Node<MyEntry> node) {
        this.below = node;
    }

    /** Set the element stored in the node.
     * @param element The element to store.
     */
    @Override
    public void setElement(MyEntry element) {
        this.element = element;
    }

    /** Variable used to store the element. */
    private MyEntry element = null;
    /** Variable used to store the next node. */
    private Node<MyEntry> next = null;
    /** Variable used to store the previous node. */
    private Node<MyEntry> prev = null;
    /** Variable used to store the node above. */
    private Node<MyEntry> above = null;
    /** Variable used to store the node below. */
    private Node<MyEntry> below = null;
}
