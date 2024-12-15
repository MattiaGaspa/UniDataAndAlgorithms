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
    private int level;
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
    public int getLevel() { return this.level; }
    public void setLevel(int level) { this.level = level; }
    @Override
    public String toString() {
        return getElement() + ". Next: " + getNext() + ", prev: " + getPrev() + "above: " + getAbove() + ", below: " + getBelow();
    }

}

// Class my skip list
class MySkipList {
    final static private MyEntry leftGuard = new MyEntry(Integer.MIN_VALUE, "leftGuard");
    final static private MyEntry rightGuard = new MyEntry(Integer.MAX_VALUE, "rightGuard");
    private MyNode startPosition;
    private int height;
    public MySkipList() {
        MyNode leftSentinel = new MyNode(leftGuard);
        MyNode rightSentinel = new MyNode(rightGuard);
        leftSentinel.setNext(rightSentinel);
        rightSentinel.setPrev(leftSentinel);
        this.startPosition = leftSentinel;
        this.height = 1;
        add_height();
    }
    public int height() { return this.height; }
    public MyNode getStartPosition() { return this.startPosition; }

    public void add_height() {
        this.height++;
        MyNode t = next(getStartPosition());
        this.startPosition = insertAfterAbove(null, getStartPosition(), leftGuard, 0);
        insertAfterAbove(getStartPosition(), t, rightGuard, 0);
    }
    public void remove_height() {
        if (height() == 1) {
            return;
        }
        this.startPosition = below(getStartPosition());
        MyNode t = getStartPosition();
        while (t.getNext() != null) {
            t.setAbove(null);
            t = next(t);
        }
        this.height--;
    }
    public MyNode insertAfterAbove(MyNode p, MyNode q, MyEntry e, int level) {
        MyNode next, above;
        if (p == null) {
            next = null;
        }
        else { next = p.getNext(); }
        if (q == null) {
            above = null;
        }
        else { above = q.getAbove(); }
        MyNode r = new MyNode(e, next, p, above, q);
        r.setLevel(level);
        if (p != null) p.setNext(r);
        if (q != null) q.setAbove(r);
        return r;
    }

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
    public SearchResult skipSearchTraversedNodes(Integer key) {
        int traversedNodes = 1;
        MyNode p = getStartPosition();
        while (p.getBelow() != null) {
            p = p.getBelow();
            traversedNodes++;
            while (key >= p.getNext().getElement().getKey()) {
                p = p.getNext();
                traversedNodes++;
            }
        }
        return new SearchResult(p, traversedNodes);
    }
    public MyEntry remove(Integer key) {
        MyNode p = skipSearch(key);
        if ((int) p.getElement().getKey() != key) {
            return null;
        }
        MyEntry e = p.getElement();
        int towerHeight = 0;
        while (p != null) {
            prev(p).setNext(next(p));
            p = above(p);
            towerHeight++;
        }
        if (towerHeight == height()-1) {
            while (getStartPosition().getBelow().getNext().getElement() == rightGuard && height() > 1) {
                remove_height();
            }
        }
        return e;
    }
    public MyNode next(MyNode p) { return p.getNext(); }
    public MyNode prev(MyNode p) { return p.getPrev(); }
    public MyNode above(MyNode p) { return p.getAbove(); }
    public MyNode below(MyNode p) { return p.getBelow(); }

    static public class SearchResult {
        final private MyNode p;
        final private int traversedNodes;
        public SearchResult(MyNode p, int traversedNodes) {
            this.p = p;
            this.traversedNodes = traversedNodes;
        }
        public MyNode getP() { return this.p; }
        public int getTraversedNodes() { return this.traversedNodes; }
    }
}

//Class SkipListPQ
class SkipListPQ {
    private double alpha;
    private Random rand;
    private final MySkipList skipList;
    private int size = 0;

    public SkipListPQ(double alpha) {
        this.alpha = alpha;
        this.rand = new Random();
        this.skipList = new MySkipList();
    }

    public boolean isEmpty() { return this.size == 0; }
    public int size() { return this.size; }

    public MyEntry min() {
        MyNode p = minNode();
        if (p == null) {
            return null;
        }
        else {
            return p.getElement();
        }
    }
    private MyNode minNode() {
        MyNode p = skipList.getStartPosition();
        while (p.getBelow() != null) {
            p = p.getBelow();
        }
        if (p.getNext().getElement().getValue().equals("rightGuard")) {
            return null;
        }
        else {
            return p.getNext();
        }
    }

    public int insert(int key, String value) {
        MySkipList.SearchResult searchResult = skipList.skipSearchTraversedNodes(key);
        int traversedNodes = searchResult.getTraversedNodes();
        MyNode p = searchResult.getP();

        MyNode q = null;
        int level = generateEll(alpha, key);
        while (level+1 >= skipList.height()) {
            skipList.add_height();
        }
        for (int i = 0; i <= level; i++) {
            q = skipList.insertAfterAbove(p, q, new MyEntry(key, value), level+1);
            while (skipList.above(p) == null) {
                p = skipList.prev(p);
            }
            p = skipList.above(p);
        }
        size++;
        return traversedNodes - 1;
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
        MyEntry e = min();
        skipList.remove(e.getKey());
        this.size--;
        return e;
    }

    public void print() {
        StringBuilder output = new StringBuilder();
        MyNode p = minNode();
        for(int i = 0; i < size(); i++) {
            output.append(p.getElement().toString());
            output.append(" ").append(p.getLevel()).append(", ");
            p = p.getNext();
        }
        output.append("\b\b");
        System.out.println(output);
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

            long inserted = 0;
            long totalTraversed = 0;

            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                int operation = Integer.parseInt(line[0]);

                switch (operation) {
                    case 0:
                        System.out.println(skipList.min());
                        break;
                    case 1:
                        skipList.removeMin();
                        break;
                    case 2:
                        totalTraversed += skipList.insert(Integer.parseInt(line[1]), line[2]);
                        inserted++;
                        break;
                    case 3:
                        skipList.print();
                        break;
                    default:
                        System.out.println("Invalid operation code");
                        return;
                }
            }
            double averageTraversed = (double) totalTraversed / inserted;
            System.out.println(alpha + " " + skipList.size() + " " + inserted + " " + averageTraversed);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
