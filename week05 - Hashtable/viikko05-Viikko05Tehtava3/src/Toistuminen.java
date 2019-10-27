
import java.util.*;

public class Toistuminen {

    HashMap<Integer, Integer> map = new HashMap();
    int cursor = 1;

    int uusiLuku(int x) {
        int v = map.getOrDefault(x, 0);
        if (v == 0) {
            map.put(x, cursor);
            cursor++;
            return -1;
        } else {
            int dist = cursor - v - 1;
            map.put(x, cursor);
            cursor++;
            return dist;
        }

    }

}
