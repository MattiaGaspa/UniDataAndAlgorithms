import interfaces.Node;

/** Implementation of the interface Node for this project. */
public class MyNode<MyEntry> implements Node<MyEntry> {
    /** Constructor used to define a node.
     * @param entry The entry to store in the node
     */
    public MyNode(MyEntry entry) {
        this.element = entry;
    }
    /** Constructor used to define a node and its surrounding.
     * @param entry The entry to store in the node
     * @param next The node next to this
     * @param prev The node previous to this
     * @param above The node above this
     * @param below The node below this
     */
    public MyNode(MyEntry entry, MyNode next, MyNode prev, MyNode above, MyNode below) {
        setElement(entry);
        setNext(next);
        setPrev(prev);
        setAbove(above);
        setBelow(below);
    }

    /** Return the element stored int the position.
     * @return The element stored.
     */
    @Override
    public MyEntry getElement() { return this.element; }

    /** Return the next node.
     * @return The next node or null if right sentinel.
     */
    @Override
    public MyNode getNext() { return this.next; }
    /** Return the previous node.
     * @return The previous node or null if left sentinel.
     */
    @Override
    public MyNode getPrev() { return this.prev; }
    /** Return the node above.
     * @return The node above or null if there are no nodes.
     */
    @Override
    public MyNode getAbove() { return this.above; }
    /** Return the node below.
     * @return The node below or null if there are no nodes.
     */
    @Override
    public MyNode getBelow() { return this.below; }

    /** Set the next node.
     * @param node The next node.
     */
    @Override
    public void setNext(Node<MyEntry> node) {
        this.next = (MyNode) node;
    }
    /** Set the previous node.
     * @param node The previous node.
     */
    @Override
    public void setPrev(Node<MyEntry> node) {
        this.prev = (MyNode) node;
    }
    /** Set the node above.
     * @param node The node above.
     */
    @Override
    public void setAbove(Node<MyEntry> node) {
        this.above = (MyNode) node;
    }
    /** Set the node below.
     * @param node The node below.
     */
    @Override
    public void setBelow(Node<MyEntry> node) {
        this.below = (MyNode) node;
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
    private MyNode next = null;
    /** Variable used to store the previous node. */
    private MyNode prev = null;
    /** Variable used to store the node above. */
    private MyNode above = null;
    /** Variable used to store the node below. */
    private MyNode below = null;
}
