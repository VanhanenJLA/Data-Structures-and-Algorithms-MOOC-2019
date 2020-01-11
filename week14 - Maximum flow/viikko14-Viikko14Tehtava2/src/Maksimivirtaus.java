
import java.util.*;

public class Maksimivirtaus {

    int n;
    int[][] paino;
    int tulos;

    public Maksimivirtaus(int n) {
        this.n = n;
        paino = new int[n + 1][n + 1];
    }

    public void lisaaKaari(int a, int b, int p) {
        paino[a][b] += p;
    }

    int[] tila;

    int haku(int s, int u) {
        if (s == n) {
            return u;
        }
        if (tila[s] == 1) {
            return 0;
        }
        tila[s] = 1;
        for (int i = 1; i <= n; i++) {
            if (paino[s][i] > 0) {
                int h = haku(i, Math.min(u, paino[s][i]));
                if (h > 0) {
                    paino[s][i] -= h;
                    paino[i][s] += h;
                    return h;
                }
            }
        }
        return 0;
    }

    public int laske() {
        while (true) {
            tila = new int[n + 1];
            int u = haku(1, 1 << 20);
            if (u == 0) {
                break;
            }
            tulos += u;
        }
        return tulos;
    }
}
