
public class Nopanheitto {

    public long laske(int n) {
        long[] arr = new long[n + 6];
        for (int i = 1, p = 1; i <= 6; i++, p += p) {
            arr[i] = p;
        }
        for (int i = 7; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                arr[i] += arr[i - j];
            }
        }
        return arr[n];
    }
}
