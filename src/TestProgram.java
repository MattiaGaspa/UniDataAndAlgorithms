import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//Class my entry
class MyEntry {
    private Integer key;
    private String value;
    public MyEntry(Integer key, String value) {
        this.key = key;
        this.value = value;
    }
    public Integer getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }
    @Override
    public String toString() {
        return key + " " + value;
    }
}

// Class my node
class MyNode {
    private MyEntry element;
    private MyNode next;
    private MyNode prev;
    private MyNode above;
    private MyNode below;
    public MyNode(Integer key, String value) {
        setElement(new MyEntry(key, value));
        setNext(null);
        setPrev(null);
        setAbove(null);
        setBelow(null);
    }
    public MyNode(MyEntry entry) {
        setElement(entry);
        setNext(null);
        setPrev(null);
        setAbove(null);
        setBelow(null);
    }
    public MyNode(MyEntry entry, MyNode next, MyNode prev, MyNode above, MyNode below) {
        setElement(entry);
        setNext(next);
        setPrev(prev);
        setAbove(above);
        setBelow(below);
    }
    public MyNode(Integer key, String value, MyNode next, MyNode prev, MyNode above, MyNode below) {
        setElement(new MyEntry(key, value));
        setNext(next);
        setPrev(prev);
        setAbove(above);
        setBelow(below);
    }
    public MyEntry getElement() { return this.element; }
    public void setElement(MyEntry element) {
        this.element = element;
    }
    public MyNode getNext() { return this.next; }
    public MyNode getPrev() { return this.prev; }
    public MyNode getAbove() { return this.above; }
    public MyNode getBelow() { return this.below; }
    public void setNext(MyNode node) {
        this.next = node;
    }
    public void setPrev(MyNode node) {
        this.prev = node;
    }
    public void setAbove(MyNode node) {
        this.above = node;
    }
    public void setBelow(MyNode node) {
        this.below = node;
    }
    @Override
    public String toString() {
        return getElement() + ". Next: " + getNext() + ", prev: " + getPrev() + "above: " + getAbove() + ", below: " + getBelow();
    }

}

// Class my skip list
class MySkipList {
    private MyNode leftSentinel;
    private MyNode rightSentinel;
    private MyNode startPosition;
    private int size;
    private int height;
    private int coinFlip() {
        return new Random().nextInt(2);
    }
    public MySkipList() {
        this.leftSentinel = new MyNode(null);
        this.rightSentinel = new MyNode(null);
        this.leftSentinel.setNext(this.rightSentinel);
        this.rightSentinel.setPrev(this.leftSentinel);
        this.startPosition = this.leftSentinel;
    }
    public int size() { return this.size; }
    public int height() { return this.height; }
    public boolean isEmpty() { return this.size - 2 == 0; }
    public MyNode getStartPosition() { return this.startPosition; }
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
    public int skipInsert(Integer key, String value) {
        MyNode p = skipSearch(key);
        MyNode q = null;
        int i = -1;
        do {
            i++;
            if (i >= this.height) {
                this.height++;
                MyNode t = next(getStartPosition());
                MyNode s = insertAfterAbove(null, null, null); // Correggi
                insertAfterAbove(null, null, null); // Correggi
            }
            q = insertAfterAbove(null, null, null); // Correggi
            while (above(p) == null) {
                p = prev(p);
            }
            p = above(p);
        } while (coinFlip() == 1);
        this.size++;
        return 0; // Correggi. Deve ritornare un intero
    }
    private MyNode insertAfterAbove(MyNode p, MyNode q, MyEntry e) {
        MyNode r = new MyNode(e, null, p, null, q);
        p.setNext(r);
        q.setAbove(r);
        return r;
    }
    public MyNode next(MyNode p) { return p.getNext(); }
    public MyNode prev(MyNode p) { return p.getPrev(); }
    public MyNode above(MyNode p) { return p.getAbove(); }
    public MyNode below(MyNode p) { return p.getBelow(); }
}

//Class SkipListPQ
class SkipListPQ {

    private double alpha;
    private Random rand;

    public SkipListPQ(double alpha) {
        this.alpha = alpha;
        this.rand = new Random();
    }

    public int size() {
        // TO BE COMPLETED
    }

    public MyEntry min() {
        // TO BE COMPLETED
    }

    public int insert(int key, String value) {
        // TO BE COMPLETED
    }

    private int generateEll(double alpha_ , int key) {
        int level = 0;
        if (alpha_ >= 0. && alpha_< 1) {
            while (rand.nextDouble() < alpha_) {
                level += 1;
            }
        }
        else{
            while (key != 0 && key % 2 == 0){
                key = key / 2;
                level += 1;
            }
        }
        return level;
    }

    public MyEntry removeMin() {
        // TO BE COMPLETED
    }

    public void print() {
        // TO BE COMPLETED
    }
}

//TestProgram

public class TestProgram {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java TestProgram <file_path>");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String[] firstLine = br.readLine().split(" ");
            int N = Integer.parseInt(firstLine[0]);
            double alpha = Double.parseDouble(firstLine[1]);
            System.out.println(N + " " + alpha);

            SkipListPQ skipList = new SkipListPQ(alpha);

            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                int operation = Integer.parseInt(line[0]);

                switch (operation) {
                    case 0:
                        // TO BE COMPLETED
                        break;
                    case 1:
                        // TO BE COMPLETED
                        break;
                    case 2:
                        // TO BE COMPLETED
                        break;
                    case 3:
                        // TO BE COMPLETED
                        break;
                    default:
                        System.out.println("Invalid operation code");
                        return;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
