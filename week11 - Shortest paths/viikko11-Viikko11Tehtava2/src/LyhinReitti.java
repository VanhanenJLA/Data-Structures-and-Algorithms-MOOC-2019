
import java.util.*;

class Edge {

    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class LyhinReitti {

    final int INF = Integer.MAX_VALUE / 2;

    ArrayList<Edge> edges;
    int[] distance;
    int[] paths;

    public LyhinReitti(int n) {
        edges = new ArrayList<>();
        n += 1;
        paths = new int[n];
        distance = new int[n];
        for (int i = 1; i < n; i++) {
            distance[i] = INF;
        }
    }

    public void lisaaTie(int a, int b, int p) {
        edges.add(new Edge(a, b, p));
        edges.add(new Edge(b, a, p));
    }

    private ArrayList<Integer> cornerCase(int x) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(x);
        return l;
    }

    public ArrayList<Integer> muodosta(int x, int y) {

        if (x == y) {
            return cornerCase(x);
        }

        distance[x] = 0;
        while (true) {
            boolean changed = false;
            for (Edge k : edges) {
                if (distance[k.start] + k.weight < distance[k.end]) {
                    distance[k.end] = distance[k.start] + k.weight;
                    changed = true;
                    paths[k.end] = k.start;
                }
            }
            if (!changed) {
                break;
            }
        }

        if (distance[y] == INF) {
            return null;
        }

        return makePath(x, y);

    }

    private ArrayList<Integer> makePath(int x, int y) {

        ArrayList<Integer> path = new ArrayList<>();
        while (true) {
            if (y == x) {
                path.add(x);
                break;
            }
            path.add(y);
            y = paths[y];
        }
        Collections.reverse(path);
        return path;
    }

}
