
import java.util.ArrayList;
import java.util.HashSet;

public class Viestinta {

    ArrayList<Integer>[] graph;
    HashSet<Integer> nodes;
    boolean[] machines, networks;
    boolean[][] connections;
    
    boolean isFirstTimeSearch = true;

    public Viestinta(int n) {
        n += 1;
        graph = new ArrayList[n];
        nodes = new HashSet<>();
        // machines = networks = new boolean[n]; java pls
        machines = new boolean[n];
        networks = new boolean[n];
        connections = new boolean[n][n];

        for (int i = 1; i <= n - 1; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    void search() {
        isFirstTimeSearch = false;
        
        nodes.forEach(i -> {
            if (machines[i] == false) {
                r(i);
                connect();
            }
        });
    }

    void r(int n) {
        if (networks[n]) {
            return;
        }
        networks[n] = true;
        machines[n] = true;
        graph[n].forEach(i -> {
            if (!machines[i]) {
                machines[i] = true;
            }
            r(i);
        });

    }

    void connect() {
        int n = machines.length;
        for (int i = 1; i < n; i++) {
            if (machines[i] == false) {
                continue;
            }
            for (int j = 1; j < n; j++) {
                if (machines[j] == false) {
                    continue;
                }
                connections[i][j] = true;
            }
        }
        machines = new boolean[n];
    }

    public void lisaaYhteys(int a, int b) {
        nodes.add(a);
        nodes.add(b);
        if (!graph[a].contains(b)) {
            graph[a].add(b);
        }
        if (!graph[b].contains(a)) {
            graph[b].add(a);
        }
    }

    public boolean tarkasta(int y, int x) {
        if (isFirstTimeSearch) search();
        return connections[y][x];
    }
}
