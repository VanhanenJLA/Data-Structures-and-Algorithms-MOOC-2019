
import java.util.*;

public class Saavutettavuus {

    List<Integer>[] connections;
    boolean[] states;
    int n;

    public Saavutettavuus(int n) {
        this.n = n;
        connections = new ArrayList[n + 1];
        states = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            connections[i] = new ArrayList<>();
        }
    }

    public void lisaaYhteys(int a, int b) {
        if (!connections[a].contains(b)) {
            connections[a].add(b);
        }
        if (!connections[b].contains(a)) {
            connections[b].add(a);
        }
    }

    public int laske(int x) {
        depthSearch(x);
        int count = 0;
        for (int i = 0; i < states.length; i++) {
            if (states[i]) count++;
        }
        return count - 1;
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
}
