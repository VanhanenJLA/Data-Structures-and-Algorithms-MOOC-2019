
import java.util.*;

public class Mediaani {

    PriorityQueue<Integer> left, right;

    public Mediaani() {
        left = new PriorityQueue<>();
        right = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void lisaa(int x) {

        left.add(x);
        right.add(left.poll());
        
        if (left.size() < right.size()) left.add(right.poll());
        
    }

    public int mediaani() {
        return (left.size() > right.size() ? left.peek() : right.peek());
    }

}
