
public class Edge {

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
