
public class Inversiot {

    int[] muodosta(int n, long k) {
        int[] t = new int[n];
        int a = 0, b = n - 1;
        for (int i = 1; i <= n; i++) {
            if (k >= n - i) {
                t[b--] = i;
                k -= n - i;
            } else {
                t[a++] = i;
            }
        }
        return t;
    }
}
