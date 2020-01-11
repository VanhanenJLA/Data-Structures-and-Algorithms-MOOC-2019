
import java.util.*;

public class Lentoreitti {

    ArrayList<Integer>[] connections;
    Queue<Integer> q;

    boolean[] visited;
    int[] distance;

    public Lentoreitti(int n) {
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        connections = new ArrayList[n + 1];
        q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            connections[i] = new ArrayList<>();
        }
    }

    public int laske(int x, int y) {
        return width(x, y);
    }

    public int width(int origin, int destination) {

        q.add(origin);
        visited[origin] = true;
        distance[origin] = 0;

        while (!q.isEmpty()) {

            int solmu = q.poll();

            for (int n : connections[solmu]) {
                if (visited[n] == true) {
                    continue;
                }
                visited[n] = true;
                q.add(n);
                distance[n] = distance[solmu] + 1;
            }
        }
        return visited[destination] ? distance[destination] - 1 : -1;
    }

    public void lisaaYhteys(int a, int b) {
        if (!connections[a].contains(b)) {
            connections[a].add(b);
        }
        if (!connections[b].contains(a)) {
            connections[b].add(a);
        }
    }

}
