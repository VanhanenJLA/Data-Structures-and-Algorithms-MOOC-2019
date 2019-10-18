
import java.util.*;

public class PieninEtaisyys {

    TreeSet<Integer> tree = new TreeSet<>();
    int distance = Integer.MAX_VALUE;

    public int laske() {
        return distance;
    }

    public void lisaa(int x) {

        tree.add(x);
        int start;
        int end;

        if (tree.first() != x) {
            start = Math.abs(tree.lower(x) - x);
            distance = distance >= start ? start : distance;
        }

        if (tree.last() != x) {
            end = Math.abs(tree.higher(x) - x);
            distance = distance >= end ? end : distance;
        }

    }

}
