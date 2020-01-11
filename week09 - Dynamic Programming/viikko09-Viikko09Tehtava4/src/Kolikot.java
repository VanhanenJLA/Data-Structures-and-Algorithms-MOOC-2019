
public class Kolikot {

    public int laske(int[] t) {
        int n = t.length;
        int m = 10000;
        boolean[] d = new boolean[m + 1];
        d[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                if (d[j]) {
                    d[j + t[i]] = true;
                }
            }
        }
        int r = 0;
        for (int i = 1; i <= m; i++) {
            if (d[i]) {
                r++;
            }
        }
        return r;
    }
}
