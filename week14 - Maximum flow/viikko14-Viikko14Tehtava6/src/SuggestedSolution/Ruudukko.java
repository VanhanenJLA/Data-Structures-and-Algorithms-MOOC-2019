import java.util.*;
 
public class Ruudukko {     
    int n;
    int[][] alku;
    int[][] paino;
 
    void lisaaKaari(int a, int b, int p) {
        alku[a][b] = p;
        paino[a][b] = p;
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
    
    public ArrayList<Siirto> muodosta(int[][] ruudukko) {
        n = ruudukko.length;
        alku = new int[2*n+2][2*n+2];
        paino = new int[2*n+2][2*n+2];
        for (int i = 1; i <= n; i++) lisaaKaari(0,i,1);
        for (int i = 1; i <= n; i++) lisaaKaari(n+i,2*n+1,1);
        int INF = 999999999;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ruudukko[i][j] == 1) lisaaKaari(i+1,n+j+1,INF);
            }
        }
        while (true) {
            tila = new int[2*n+2];
            int u = haku(0,1);
            if (u == 0) break;
        }
        tila = new int[2*n+2];
        haku(0,1);
        ArrayList<Siirto> tulos = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (tila[i] == 0 && alku[0][i] == 1 && paino[0][i] == 0) {
                tulos.add(new Siirto("V",i));
            }
            if (tila[n+i] == 1 && alku[n+i][2*n+1] == 1 && paino[n+i][2*n+1] == 0) {
                tulos.add(new Siirto("P",i));
            }
        }
        return tulos;
    }    
}