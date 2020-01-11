
import java.util.*;

interface IBenchmarkable {

    int solve();
}

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        int n, e;

        n = 1000;
        e = 5000;

        for (int i = 1; i < 4; i++) {
            System.out.println("### " + i + ". ROUND ###");
            m.run(n, e);
            n += n * i;
            e += e * i;
        }

    }

    void run(int n, int e) {
        Breadth(n, e);
        System.out.println("");
        Depth(n, e);
        System.out.println("");
    }

    void Depth(int n, int edges) {
        System.out.println("Ford Fulkerson - Depth");
        System.out.println("n: " + n + ", edges " + edges);
        int[][] graph = createGraph(n, edges);
        Depth d = new Depth(graph, 1, n);
        int result = benchmarkAlgorithm(d);
        System.out.println("Maximum flow: " + result);
    }

    void Breadth(int n, int edges) {
        System.out.println("Ford Fulkerson - Breadth");
        System.out.println("n: " + n + ", edges " + edges);
        int[][] graph = createGraph(n, edges);
        Breadth b = new Breadth(graph, 1, n);
        int result = benchmarkAlgorithm(b);
        System.out.println("Maximum flow: " + result);
    }

    void printElapsedTime(long start, long finish) {
        System.out.println("Time elapsed " + ((finish - start) / 1e9) + " s");
    }

    void printElapsedNanoTime(long start, long finish) {
        System.out.println("Time elapsed " + (finish - start) + " ns");
    }

    int benchmarkAlgorithm(IBenchmarkable algo) {
        long start = System.nanoTime();
        int result = algo.solve();
        long finish = System.nanoTime();
        printElapsedTime(start, finish);
        return result;
    }

    int[][] createGraph(int n, int edges) {
        Random r = new Random(1337);
        int[][] graph = new int[n + 1][n + 1];
        int a, b, p;
        for (int i = 1; i <= edges; i++) {
            a = r.nextInt(n) + 1;
            b = r.nextInt(n) + 1;
            p = r.nextInt(1000);
            graph[a][b] = p;
        }
        return graph;
    }

}

class Breadth implements IBenchmarkable {

    int[][] graph;
    boolean[] visited;
    int V, source, sink;
    int residualGraph[][];
    LinkedList<Integer> queue;

    Breadth(int graph[][], int source, int sink) {
        this.graph = graph;
        this.source = source;
        this.sink = sink;
        V = sink + 1;
        visited = new boolean[V];
        residualGraph = new int[V][V];
        queue = new LinkedList<>();
    }

    boolean search(int residualGraph[][], int parent[]) {
        visited = new boolean[V];
        for (int i = 0; i < V; ++i) {
            visited[i] = false;
        }
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int i = 0; i < V; i++) {
                if (visited[i] != false) {
                    continue;
                }
                if (residualGraph[u][i] > 0) {
                    visited[i] = true;
                    queue.add(i);
                    parent[i] = u;
                }
            }
        }
        return (visited[sink] == true);
    }

    @Override
    public int solve() {
        int maximumFlow = 0;
        int u, v;
        for (u = 0; u < V; u++) {
            for (v = 0; v < V; v++) {
                residualGraph[u][v] = graph[u][v];
            }
        }
        int[] parent = new int[V];
        while (search(residualGraph, parent)) {
            int _flow = Integer.MAX_VALUE;
            for (v = sink; v != source; v = parent[v]) {
                u = parent[v];
                _flow = Math.min(_flow, residualGraph[u][v]);
            }
            for (v = sink; v != source; v = parent[v]) {
                u = parent[v];
                residualGraph[v][u] += _flow;
                residualGraph[u][v] -= _flow;
            }
            maximumFlow += _flow;
        }
        return maximumFlow;
    }
}

class Depth implements IBenchmarkable {

    int[][] graph;
    int[] visited;
    int source, sink, maximumFlow, flow;

    public Depth(int[][] graph, int source, int sink) {
        this.graph = graph;
        this.visited = new int[graph.length];
        this.source = source;
        this.sink = sink;
        this.maximumFlow = 0;
    }

    int visitedToken = 1;

    @Override
    public int solve() {
        while (true) {
            int flow = Integer.MAX_VALUE;
            flow = search(graph, visited, source, sink, flow);
            if (flow == 0) {
                return maximumFlow;
            }
            visitedToken++;
            maximumFlow += flow;
        }
    }

    private int search(int[][] graph, int[] visited, int node, int sink, int flow) {
        if (node == sink) {
            return flow;
        }

        int[] capacities = graph[node];
        visited[node] = visitedToken;

        for (int i = 0; i < capacities.length; i++) {
            if (visited[i] != visitedToken && capacities[i] > 0) {
                if (capacities[i] < flow) {
                    flow = capacities[i];
                }
                int _flow = search(graph, visited, i, sink, flow);
                if (_flow > 0) {
                    graph[node][i] -= _flow;
                    graph[i][node] += _flow;
                    return _flow;
                }
            }
        }
        return 0;
    }
}
