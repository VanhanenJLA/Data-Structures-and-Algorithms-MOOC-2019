import java.util.*;
 
public class Polut {  
    boolean[][] este; // mihin ruutuihin ei saa enää mennä
    int laskuri; // ratkaisujen lukumäärä
    
    // (y,x) = nykyinen ruutu, n = ruudukon koko, k = nykyisen polun pituus
    void haku(int y, int x, int n, int k) {
        if (k == n*n) {
            // jos polku on valmis, kasvatetaan laskuria
            laskuri++;
        } else {
            // jos ruudukko on jakautunut kahteen erilliseen osaan,
            // ratkaisu ei ole mahdollinen ja poistutaan metodista
            if (este[y][x-1] && este[y][x+1] && !este[y-1][x] && !este[y+1][x]) return;
            if (!este[y][x-1] && !este[y][x+1] && este[y-1][x] && este[y+1][x]) return;
            // muuten tehdään peruuttava haku kaikkiin suuntiin
            este[y][x] = true;
            if (!este[y-1][x]) haku(y-1,x,n,k+1);
            if (!este[y+1][x]) haku(y+1,x,n,k+1);
            if (!este[y][x-1]) haku(y,x-1,n,k+1);
            if (!este[y][x+1]) haku(y,x+1,n,k+1);
            este[y][x] = false;
        }
    }
    
    public int laske(int n) {
        este = new boolean[n+2][n+2];
        // luodaan ruudukolle reunat, jotta polku ei mene ruudukon ulkopuolelle
        for (int i = 0; i < n+2; i++) {
            for (int j = 0; j < n+2; j++) {
                if (i == 0 || i == n+1) este[i][j] = true;
                if (j == 0 || j == n+1) este[i][j] = true;
            }
        }
        laskuri = 0;
        haku(1,1,n,1);
        return laskuri;
    }
}