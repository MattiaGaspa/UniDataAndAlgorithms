import interfaces.Node;
import interfaces.SkipList;

public class MySkipList implements SkipList<MyNode> {
    public MySkipList() {
        this.leftSentinel = new MyNode(null);
        this.rightSentinel = new MyNode(null);
        this.leftSentinel.setNext(this.rightSentinel);
        this.rightSentinel.setPrev(this.leftSentinel);
        this.startPosition = this.leftSentinel;
    }

    /** Method to get skip list size.
     * @return Skip list size.
     */
    @Override
    public int size() { return this.size; }
    /** Method to get skip list height.
     * @return Skip list height.
     */
    @Override
    public int height() { return this.height; }
    /** Method used to check if a skip list is empty or not (sentinel excluded).
     * @return A boolean: true if the skip list is empty else false.
     */
    @Override
    public boolean isEmpty() { return this.size - 2 == 0; }

    /** Method used to get th starting point of the skip list.
     * @return The starting point of the skip list.
     */
    public MyNode getStartPosition() { return this.startPosition; }
    /** Implementation of the algorithm SkipSearch, to search a node in the Skip list.
     * @param key The key to search
     * @return The node searched or null if the node is not present.
     */
    public MyNode skipSearch(Integer key) {
        MyNode p = getStartPosition();
        while (p.getBelow() != null) {
            p = p.getBelow();
            while (key >= p.getNext().getElement().getKey()) {
                p = p.getNext();
            }
        }
        return p;
    }

    /** Implementation of the algorithm SkipInsert, to insert a node in the Skip list.
     * @param key The key to insert.
     * @param value The value to insert.
     * @return The highest position of the new entry tower.
     */
    public int skipInsert(Integer key, String value) {
        return 0; // TODO with insertAfterAbove() and coinflip() (private method)
    }

    /**
     * @param p The position in the list. 
     * @return The successor of p or null if it's the right sentinel.
     */
    @Override
    public MyNode next(MyNode p) { return p.getNext(); }
    /**
     * @param p The position in the list. 
     * @return The predecessor of p or null if it's the right sentinel.
     */
    @Override
    public MyNode prev(MyNode p) { return p.getPrev(); }
    /**
     * @param p The position in the list. 
     * @return The position above of p if it exists else null.
     */
    @Override
    public MyNode above(MyNode p) { return p.getAbove(); }
    /**
     * @param p The position in the list. 
     * @return The position below of p if it exists else null.
     */
    @Override
    public MyNode below(MyNode p) { return p.getBelow(); }

    /** Variable used to store the left sentinel (-infinity) */
    private MyNode leftSentinel;
    /** Variable used to store the right sentinel (+infinity) */
    private MyNode rightSentinel;
    /** Variable used to store the start position */
    private MyNode startPosition;
    /** Variable used to store the size of the skip list */
    private int size = 0;
    /** Variable used to store the height of the skip list */
    private int height = 0;
}
