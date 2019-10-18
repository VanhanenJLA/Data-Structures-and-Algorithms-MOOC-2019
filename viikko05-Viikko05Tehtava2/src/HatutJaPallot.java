
import java.util.*;

public class HatutJaPallot {

    HashMap<Integer, Integer> map = new HashMap<>();
    int largestCount = 0;

    void lisaaPallo(int key) {
        int value = map.getOrDefault(key, 0);
        value++;
        if (value > largestCount) {
            largestCount = value;
        }
        map.put(key, value);
    }

    int monessakoYksi() {
        return map.values().size();
    }

    int suurinMaara() {
        return largestCount;
    }
}
