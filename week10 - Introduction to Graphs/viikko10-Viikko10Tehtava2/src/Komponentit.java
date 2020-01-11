
import java.util.*;

public class Komponentit {

    HashSet<Integer> nodes;
    List<Integer>[] connections;
    boolean[] states;
    int n;
    int count;

    public Komponentit(int n) {
        this.n = n;
        connections = new ArrayList[n + 1];
        states = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            connections[i] = new ArrayList<>();
        }
        count = 0;
        this.nodes = new HashSet<>();
    }

    public void lisaaYhteys(int a, int b) {
        nodes.add(a);
        nodes.add(b);
        if (!connections[a].contains(b)) {
            connections[a].add(b);
        }
        if (!connections[b].contains(a)) {
            connections[b].add(a);
        }
    }

    void depthSearch(int i) {
        if (states[i]) {
            return;
        }
        states[i] = true;
        connections[i].forEach((adjacent) -> {
            depthSearch(adjacent);
        });
    }

    public int laske() {
        for (int i = 1; i < states.length; i++) {
            if (!states[i]) {
                count++;
                depthSearch(i);
            }
        }
        return count;
    }
}
