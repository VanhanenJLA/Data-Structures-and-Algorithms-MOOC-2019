
public class Kierrokset {

    int laske(int[] t) {
        int laps = 1;
        int n = t.length;

        int[] helper = new int[n];

        for (int i = 0; i < n; i++) {
            helper[t[i] - 1] = i;
        }

        for (int i = 1; i < helper.length; i++) {
            if (helper[i - 1] > helper[i]) {
                laps++;
            }
        }

        return laps;
    }

}
