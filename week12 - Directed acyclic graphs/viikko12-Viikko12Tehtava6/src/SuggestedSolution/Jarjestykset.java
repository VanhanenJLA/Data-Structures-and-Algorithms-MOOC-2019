import java.util.*;
 
public class Jarjestykset {     
    int n;
    ArrayList<Integer>[] verkko;
    int[] laskuri;
    int[] pino;
    int tulos;
    boolean kaikki;
    
    public Jarjestykset(int n) {
        this.n = n;
        verkko = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            verkko[i] = new ArrayList<>();
        }
        laskuri = new int[n+1];
        pino = new int[n+1];
    }
 
    public void lisaaKaari(int a, int b) {
        verkko[a].add(b);
        laskuri[b]++;
    }
    
    void haku(int a, int b) {
        if (a == n) {
            tulos++;
            return;
        }
        for (int i = a; i < b; i++) {
            int x = pino[a], y = pino[i];
            pino[a] = y; pino[i] = x;
            for (int u : verkko[y]) {
                laskuri[u]--;
                if (laskuri[u] == 0) {
                    pino[b++] = u;
                }
            }
            haku(a+1,b);
            for (int u : verkko[y]) {
                if (laskuri[u] == 0) {
                    b--;
                }
                laskuri[u]++;
            }
            pino[a] = x; pino[i] = y;
            if (!kaikki) break;
        }
    }
    
    public int laske() {
        int b = 0;
        for (int i = 1; i <= n; i++) {
            if (laskuri[i] == 0) {
                pino[b++] = i;
            }
        }
        kaikki = false;
        haku(0,b);
        if (tulos == 0) return 0;
        tulos = 0;
        kaikki = true;
        haku(0,b);
        return tulos;
    }
 
}