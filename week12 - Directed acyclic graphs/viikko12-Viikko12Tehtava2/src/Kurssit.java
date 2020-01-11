
import java.util.*;

public class Kurssit {

    public void lisaaKurssi(String node) {
        if (!graph.contains(node)) {
            graph.add(node);
            connections.put(node, new ArrayList<>());
        }
    }

    public void lisaaVaatimus(String a, String b) {
        connections.get(a).add(b);
    }

    ArrayList<String> graph = new ArrayList<>();
    ArrayList<String> current = new ArrayList<>();
    ArrayList<String> route = new ArrayList<>();
    HashMap<String, ArrayList<String>> connections = new HashMap<>();
    HashSet<String> visited = new HashSet<>();
    
    boolean cycle = false;

    public Kurssit() {
        graph = new ArrayList<>();
        current = new ArrayList<>();
        route = new ArrayList<>();
        connections = new HashMap<>();
        visited = new HashSet<>();
    }

    public ArrayList<String> muodosta() {
        int n = graph.size();
        for (int i = 0; i < n; i++) {
            String node = graph.get(i);
            depthSearch(node);
        }

        if (cycle) return null;
        
        Collections.reverse(route);
        return route;

    }

    void depthSearch(String node) {

        if (current.contains(node)) {
            cycle = true;
            return;
        }
        if (visited.contains(node)) return;
        
        current.add(node);
        visited.add(node);

        connections.get(node).forEach((_node) -> {
            depthSearch(_node);
        });

        current.remove(node);
        route.add(node);
    }

}
