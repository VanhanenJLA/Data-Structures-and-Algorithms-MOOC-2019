import java.util.*;
 
public class Yhteydet {     
    int n;
    int[] vanhempi, koko, milloin;
    int paiva;
 
    int edustaja(int x) {
        while (x != vanhempi[x]) x = vanhempi[x];
        return x;
    }
    
    void yhdista(int a, int b, int p) {
        a = edustaja(a);
        b = edustaja(b);
        if (a == b) return;
        if (koko[a] > koko[b]) {
            koko[a] += koko[b];
            vanhempi[b] = a;
            milloin[b] = p;
        } else {
            koko[b] += koko[a];
            vanhempi[a] = b;
            milloin[a] = p;
        }
    }    
    
    public Yhteydet(int n) {
        this.n = n;
        vanhempi = new int[n+1];
        koko = new int[n+1];
        milloin = new int[n+1];
        for (int i = 1; i <= n; i++) {
            vanhempi[i] = i;
            koko[i] = 1;
        }
    }
    
    public void yhdista(int a, int b) {
        paiva++;
        yhdista(a,b,paiva);
    }
    
    public int tutki(int a, int b) {
        if (edustaja(a) != edustaja(b)) return -1;
        int tulos = 0;
        while (a != b) {
            if (koko[a] < koko[b]) {
                tulos = Math.max(tulos,milloin[a]);
                a = vanhempi[a];
            } else {
                tulos = Math.max(tulos,milloin[b]);
                b = vanhempi[b];                
            }
        }
        return tulos;
    }
 
}