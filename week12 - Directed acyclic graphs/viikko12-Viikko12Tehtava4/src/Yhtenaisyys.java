
import java.util.*;

class Edge {

    int start;
    int end;

    public Edge(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "(" + start + "," + end + ")";
    }
}

public class Yhtenaisyys {

    ArrayList<Edge> requirements = new ArrayList<>();
    ArrayList<Integer> route = new ArrayList<>();
    
    ArrayList<Integer>[] connections;
    ArrayList<Integer>[] connections_reversed;
    
    boolean[] visited;
    boolean[] visited_reversed;
    
    int n;

    public Yhtenaisyys(int n) {
        this.n = n;
        n += 1;
        visited = new boolean[n];
        visited_reversed = new boolean[n];
        connections = new ArrayList[n];
        connections_reversed = new ArrayList[n];
        init();
    }

    private void init() {
        for (int i = 1; i <= n; i++) {
            connections[i] = new ArrayList<>();
            connections_reversed[i] = new ArrayList<>();
        }
    }

    public void lisaaKaari(int a, int b) {
        connections[a].add(b);
        requirements.add(new Edge(a, b));
    }

    public boolean tutki() {
        for (int i = 1; i <= n; i++) search(connections, visited, i);
        requirements.forEach((e) -> {connections_reversed[e.end].add(e.start);});
        search(connections_reversed, visited_reversed, route.get(route.size() - 1));
        return Arrays.equals(visited, visited_reversed);
    }

    void search(ArrayList<Integer>[] connections, boolean[] visited,  int i) {
        if (visited[i] == true) return;
        visited[i] = true;
        connections[i].forEach((node) -> {search(connections, visited, node);});
        route.add(i);
    }

}
