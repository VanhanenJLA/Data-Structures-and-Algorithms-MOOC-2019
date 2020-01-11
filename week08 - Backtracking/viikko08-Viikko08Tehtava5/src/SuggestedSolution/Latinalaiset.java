import java.util.*;
 
public class Latinalaiset {  
    boolean[][] rivi;
    boolean[][] sarake;
    int laskuri;
    
    // metodi sijoittaa luvun kohtaan (y,x) ja jatkaa seuraavaan kohtaan
    void haku(int y, int x, int n) {
        if (y == n) {
            // ruudukko on täynnä -> kasvatetaan laskuria
            laskuri++;
        } else if (x == n) {
            // rivi on täynnä -> siirrytään seuraavalle riville
            haku(y+1,0,n);
        } else {
            for (int i = 1; i <= n; i++) {
                // koetetaan sijoittaa luku i kohtaan (y,x)
                // rivi[y][i] tarkoittaa: rivillä y esiintyy luku i
                // sarake[x][i] tarkoittaa: sarakkeessa x esiintyy luku i
                if (rivi[y][i] || sarake[x][i]) continue;
                rivi[y][i] = sarake[x][i] = true;
                // siirrytään seuraavaan sarakkeeseen
                haku(y,x+1,n);
                rivi[y][i] = sarake[x][i] = false;
            }
        }
    }
    
    public int laske(int n) {
        rivi = new boolean[n][n+1];
        sarake = new boolean[n][n+1];
        laskuri = 0;
        haku(0,0,n);
        return laskuri;
    }
}