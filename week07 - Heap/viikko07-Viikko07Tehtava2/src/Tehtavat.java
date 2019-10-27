
import java.util.*;

public class Tehtavat {

    TreeMap<Integer, PriorityQueue<String>> tasks = new TreeMap<>();

    public void lisaa(String name, int priority) {
        PriorityQueue<String> q = tasks.getOrDefault(priority, new PriorityQueue<>());
        q.add(name);
        tasks.put(priority, q);
    }

    public String hae() {
        PriorityQueue<String> q = tasks.lastEntry().getValue();
        String s = q.poll();
        if (q.size() <= 0) {
            tasks.pollLastEntry();
        }
        return s;
    }
}
