
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jouni
 */
public class Main {

    public static void main(String[] args) {

        for (int i = 3; i < 8; i++) {
            int n = (int) Math.pow(10, i);
            spaghetti(n);
        }

    }

    static void spaghetti(int n) {

        Bellman_Ford bf = new Bellman_Ford(n);
        Dijkstra d = new Dijkstra(n);

        System.out.println("BELLMANFORD");
        time(bf, n);
        System.out.println("");
        System.out.println("DIJKSTRA");
        time(d, n);
        System.out.println("");
    }

    static void time(Algorithm a, int n) {
        long s = System.nanoTime();
        a.count(1, n*(4/5));
        long e = System.nanoTime();
        System.out.println("Time elapsed: " + ((e - s) / 1e9) + " s");

    }

}

interface Algorithm {

    int count(int x, int y);
}

class Dijkstra implements Algorithm {

    boolean[] visited;
    int[] distance;
    ArrayList<Road>[] graph;
    PriorityQueue<Road> q;

    public Dijkstra(int n) {
        n += 1;
        graph = new ArrayList[n];
        visited = new boolean[n];
        distance = new int[n];
        q = new PriorityQueue<>();

        for (int i = 1; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void addRoad(int a, int b, int p) {
        graph[a].add(new Road(b, p));
        graph[b].add(new Road(a, p));
    }

// keko.push((0,alku)) 
//while not keko.empty() 
//        solmu = keko.pop()[1] 
//        if kasitelty[solmu] continue 
//        kasitelty[solmu] = true 
//        for kaari in verkko[solmu] 
//        nyky = etaisyys[kaari.loppu] 
//        uusi = etaisyys[solmu]+kaari.paino 
//        if uusi < nyky 
//        etaisyys[kaari.loppu] = uusi 
//        keko.push((uusi,kaari.loppu))
    @Override
    public int count(int x, int y) {

        if (x == y) {
            return 0;
        }

        q.add(new Road(x, 0));

        while (!q.isEmpty()) {

            Road node = q.poll();
            if (visited[node.end] == true) {
                continue;
            }
            visited[node.end] = true;

            graph[node.end].forEach(road -> {
                if (node.end == road.end) {
                    return;
                }
                int currentDist = distance[road.end];
                int nextDist = distance[node.end] + road.distance;
                if (currentDist == 0 || nextDist < currentDist) {
                    distance[road.end] = nextDist;
                    q.add(new Road(road.end, nextDist));
                }
            });

        }
        return distance[y] == 0 ? -1 : distance[y];
    }

}

class Road implements Comparable<Road> {

    int end;
    int distance;

    public Road(int destination, int distance) {
        this.end = destination;
        this.distance = distance;
    }

    @Override
    public int compareTo(Road other) {
        return this.distance - other.distance;
    }

}

class Bellman_Ford implements Algorithm {

    ArrayList<Edge> edges;
    int[] distance;
    int[] paths;
    int n;
    int INF = Integer.MAX_VALUE / 2;

    public Bellman_Ford(int n) {
        n += 1;
        this.n = n;
        this.edges = makeEdges(n);
        this.distance = new int[n];
        this.paths = new int[n];
    }

    @Override
    public int count(int x, int y) {

        for (int i = 1; i < n; i++) {
            distance[i] = INF;
        }

        distance[x] = 0;
        while (true) {
            boolean changed = false;
            for (Edge k : edges) {
                if (distance[k.start] + k.weight < distance[k.end]) {
                    distance[k.end] = distance[k.start] + k.weight;
                    changed = true;
                }
            }
            if (!changed) {
                break;
            }
        }

        return distance[y] == INF ? -1 : distance[y];
    }

    ArrayList<Edge> makeEdges(int n) {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            edges.add(new Edge(i, i + 1, i));
        }
        return edges;
    }

}

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
