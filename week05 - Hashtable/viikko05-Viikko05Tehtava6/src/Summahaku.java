
import java.util.*;

public class Summahaku {

    HashMap<Long, Integer> h = new HashMap<>();

    long laske(int[] arr, int x) {
        
        long sum = 0, result = 0;

        h.put(0L, 1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            result += h.getOrDefault(sum - x, 0);
            h.put(sum, h.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

}
