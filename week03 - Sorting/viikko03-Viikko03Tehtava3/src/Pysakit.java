
import java.util.*;

public class Pysakit {

    // k = maximum distance between a house and a stop.
    int laske(int[] houses, int k) {

        int n = houses.length;
        int counter = 0;
        int position = Integer.MIN_VALUE / 2;

        Arrays.sort(houses);

        for (int i = 0; i < n; i++) {
            if (houses[i] - position > k) {
                counter++;
                position = houses[i] + k;
            }
        }
        return counter;
    }

}
