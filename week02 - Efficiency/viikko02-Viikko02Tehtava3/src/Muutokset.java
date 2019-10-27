public class Muutokset {
    int laske(int[] t) {
        int n = t.length;
        int tulos = 0;
        for (int i = 1; i < n; i++) {
            if (t[i-1] == t[i]) {
                tulos++;
                i++;
            }
        }
        return tulos;
    }
}