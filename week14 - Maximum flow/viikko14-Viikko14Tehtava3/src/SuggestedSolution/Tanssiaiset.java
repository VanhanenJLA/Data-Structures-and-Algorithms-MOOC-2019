import java.util.*;
 
public class Tanssiaiset {     
    int N = 100;
    int n, m;
    int[][] alku;
    int[][] paino;
    
    public Tanssiaiset(int n, int m) {
        this.n = n;
        this.m = m;
        alku = new int[2*N+2][2*N+2];
        paino = new int[2*N+2][2*N+2];
        for (int i = 1; i <= n; i++) paino[0][i] = 1;
        for (int i = 1; i <= m; i++) paino[N+i][2*N+1] = 1;
    }
 
    public void lisaaPari(int a, int b) {
        if (alku[a][N+b] == 1) return;
        alku[a][N+b] = 1;
        paino[a][N+b] = 1;
    }
    
    int[] tila;
    
    int haku(int s, int u) {
        if (s == 2*N+1) return u;
        if (tila[s] == 1) return 0;
        tila[s] = 1;
        for (int i = 0; i <= 2*N+1; i++) {
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
    
    public ArrayList<Pari> muodosta() {
        while (true) {
            tila = new int[2*N+2];
            int u = haku(0,1);
            if (u == 0) break;
        }
        ArrayList<Pari> tulos = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (alku[i][N+j] == 1 && paino[i][N+j] == 0) {
                    tulos.add(new Pari(i,j));
                }
            }
        }
        return tulos;
    }    
}