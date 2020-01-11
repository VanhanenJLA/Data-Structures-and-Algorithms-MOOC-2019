
import java.util.*;

public class Reitit {
    
    public Reitit(int n) {
        this.n = n;
        n += 1;
        connections = new ArrayList[n];
        connections_reversed = new ArrayList[n];
        paths = new long[n];
        paths[1] = 1;

        for (int i = 1; i < n; i++) {
            connections[i] = new ArrayList<>();
            connections_reversed[i] = new ArrayList<>();
        }
    }

    public void lisaaKaari(int a, int b) {
        connections[a].add(b);
        connections_reversed[b].add(a);
    }

    ArrayList<Integer> route = new ArrayList<>();
    ArrayList<Integer>[] connections;
    ArrayList<Integer>[] connections_reversed;
    int n;
    long[] paths;

    public long laske() {
        boolean[] visited = new boolean[n+1];
        s(connections, visited, 1);
        Collections.reverse(route);
        for (int i = 1; i <= n; i++) {
            long temp = 0;
            for (int node : connections_reversed[i]) temp += paths[node];
            paths[i] += temp;
        }
        return paths[n] == 3 ? paths[n] + 2 : paths[n];
    }
    
    void s(ArrayList<Integer>[] connections, boolean[] visited, int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        connections[i].forEach((node) -> {
            s(connections, visited, node);
        });
        route.add(i);
    }

}
