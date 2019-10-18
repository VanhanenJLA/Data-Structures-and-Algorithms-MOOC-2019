
public class Piirileikki {

    int viimeinen(int n) {
        int[] t = new int[2 * n];
        for (int i = 0; i < n; i++) {
            t[i] = i + 1;
        }
        int k = n - 1;
        for (int i = 0; i <= k; i++) {
            if (i % 2 == 0) {
                t[++k] = t[i];
            }
        }
        return t[k];
    }
}
