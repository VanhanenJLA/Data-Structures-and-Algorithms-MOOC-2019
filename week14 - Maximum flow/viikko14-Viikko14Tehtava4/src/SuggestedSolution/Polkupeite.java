import java.util.*;
 
public class Polkupeite {     
    int n;
    int[][] alku;
    int[][] paino;
    
    public Polkupeite(int n) {
        this.n = n;
        alku = new int[2*n+2][2*n+2];
        paino = new int[2*n+2][2*n+2];
        for (int i = 1; i <= n; i++) paino[0][i] = 1;
        for (int i = 1; i <= n; i++) paino[n+i][2*n+1] = 1;
    }
 
    public void lisaaKaari(int a, int b) {
        if (alku[a][n+b] == 1) return;
        alku[a][n+b] = 1;
        paino[a][n+b] = 1;
    }
    
    int[] tila;
    
    int haku(int s, int u) {
        if (s == 2*n+1) return u;
        if (tila[s] == 1) return 0;
        tila[s] = 1;
        for (int i = 0; i <= 2*n+1; i++) {
            if (paino[s][i] > 0) {
                int h = haku(i,Math.min(u,paino[s][i]));
                if (h > 0) {
                    paino[s][i] -= h;
                    paino[i][s] += h;
                    return h;
                }
            }
        }
        return 0;
    }
    
    public ArrayList<Polku> muodosta() {
        while (true) {
            tila = new int[2*n+2];
            int u = haku(0,1);
            if (u == 0) break;
        }
        ArrayList<Polku> tulos = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean eka = true;
            for (int j = 1; j <= n; j++) {
                if (alku[j][n+i] == 1 && paino[j][n+i] == 0) {
                    eka = false;
                }
            }
            if (!eka) continue;
            Polku p = new Polku();
            int s = i;
            while (true) {
                p.lisaaSolmu(s);
                boolean uusi = false;
                for (int j = 1; j <= n; j++) {
                    if (alku[s][n+j] == 1 && paino[s][n+j] == 0) {
                        s = j;
                        uusi = true;
                        break;
                    }
                }
                if (!uusi) break;
            }
            tulos.add(p);
        }
        return tulos;
    }    
}