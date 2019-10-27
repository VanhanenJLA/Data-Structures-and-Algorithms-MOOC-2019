
import java.util.*;

public class SamatLuvut {

    TreeMap<Integer, Integer> tree = new TreeMap<>();

    public void lisaa(int key) {
        tree.put(key, tree.getOrDefault(key, 0) + 1);
    }

    public void poista(int key) {
        int value = tree.getOrDefault(key,0);
        if (value == 0) return;
        if (value == 1) tree.remove(key);
        else tree.put(key, --value);

    }

    public int pienin() {
        return tree.firstKey();
    }

}
