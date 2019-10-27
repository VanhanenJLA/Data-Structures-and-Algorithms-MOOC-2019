
import java.util.*;

public class VainYksi {

    int etsi(int[] t) {

        Arrays.sort(t);
        int n = t.length;

        if (n == 1) {
            return t[0];
        }
        
        for (int i = 0; i < n - 1; i++) {
            // Current != Next
            if (t[i] != t[i + 1]) {
                // First index doesn't have a previous
                if (i == 0) {
                    return t[i];
                }
                // Current != Previous
                if (t[i] != t[i - 1]) {
                    return t[i];
                }
            }
        }
        return t[n - 1];
    }
}
