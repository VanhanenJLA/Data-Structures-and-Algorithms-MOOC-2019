
import java.util.*;

public class Kunnostus {

    private final int[] elder;
    private final int[] size;
    private final ArrayList<Edge> edges;
    private int total;
    private int weight = 0;

    public Kunnostus(int n) {
        total = n;
        edges = new ArrayList<>();
        n += 1;
        elder = new int[n];
        size = new int[n];
        for (int i = 1; i < n; i++) {
            elder[i] = i;
            size[i] = 1;
        }
    }

    public void lisaaTie(int a, int b, int weight) {
        edges.add(new Edge(a, b, weight));
    }

    public int laske() {
        Collections.sort(edges);
        edges.forEach((edge) -> {
            int a = root(edge.start);
            int b = root(edge.end);
            if (a == b) return;
            connect(a, b);
            weight += edge.weight;
        });
        return total == 1 ? weight : -1;
    }
    
    void connect(int a, int b) {
        a = root(a);
        b = root(b);
        if (a == b) return;
        if (size[a] < size[b]) {
            // swap(a,b);
            int temp = a;
            a = b;
            b = temp;
        }
        elder[b] = a;
        size[a] += size[b];
        total--;
    }

    int root(int x) {
        while (x != elder[x]) x = elder[x];
        return x;
    }

}
