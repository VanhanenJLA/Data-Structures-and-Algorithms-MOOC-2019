import java.util.*;
 
public class OnkoPolkua {     
    int n;
    int[][] matka;
    int INF = 999999999;
    
    public OnkoPolkua(int n) {
        this.n = n;
        matka = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matka[i][j] = INF;
            }
        }
    }
    
    public void lisaaKaari(int a, int b, int p) {
        matka[a][b] = Math.min(matka[a][b],p);
    }
    
    public boolean tutki() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matka[i][k] < INF && matka[k][j] < INF) {
                        matka[i][j] = Math.min(matka[i][j],matka[i][k]+matka[k][j]);
                    }
                }
            }
        }
        if (matka[1][n] == INF) return false;
        for (int i = 1; i <= n; i++) {
            if (matka[1][i] < INF && matka[i][i] < 0 && matka[i][n] < INF) return false;
        }
        return true;
    }
}