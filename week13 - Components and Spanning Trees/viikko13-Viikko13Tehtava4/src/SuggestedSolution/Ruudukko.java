import java.util.*;
 
public class Ruudukko {     
    int n;
    int[] vanhempi, koko, tila;
    int maara;
 
    int edustaja(int x) {
        while (x != vanhempi[x]) x = vanhempi[x];
        return x;
    }
    
    void yhdista(int a, int b) {
        a = edustaja(a);
        b = edustaja(b);
        if (a == b) return;
        if (koko[a] > koko[b]) {
            koko[a] += koko[b];
            vanhempi[b] = a;
        } else {
            koko[b] += koko[a];
            vanhempi[a] = b;
        }
    }    
    
    public Ruudukko(int n) {
        this.n = n;
        vanhempi = new int[n*n];
        koko = new int[n*n];
        for (int i = 0; i < n*n; i++) {
            vanhempi[i] = i;
            koko[i] = 1;
        }
        tila = new int[n*n];
        maara = 0;
    }
    
    void tutki(int a, int b) {
        if (b >= 0 && b < n*n && tila[b] == 1 && edustaja(a) != edustaja(b)) {
            yhdista(a,b);
            maara--;
        }
    }
    
    public void teeLattia(int y, int x) {
        int k = (y-1)*n+x-1;
        if (tila[k] == 1) return;
        tila[k] = 1;
        maara++;
        tutki(k,k-n);
        tutki(k,k+n);
        if (k%n != 0) tutki(k,k-1);
        if (k%n != n-1) tutki(k,k+1);
    }
    
    public int laskeHuoneet() {
        return maara;
    }
 
}