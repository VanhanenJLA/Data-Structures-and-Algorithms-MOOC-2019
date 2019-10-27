
public class Poistot {

    int laske(int[] t) {
        int k = -1;
        for (int i = 0; i < t.length; i++) {
            if (k != -1 && t[k] == t[i]) {
                k--;
            } else {
                t[++k] = t[i];
            }
        }
        return k + 1;
    }
}
