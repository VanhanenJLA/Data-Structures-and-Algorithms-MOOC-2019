import java.util.*;
 
public class Labyrintti {  
    /*
        Ideana on suorittaa leveyshaku verkossa, jonka jokainen solmu on
        tila labyrintin kulkemisessa: missä kohdassa pelaaja on, mitä avaimia
        hän on kerännyt ja mistä tilasta hän on päässyt tähän tilaan.
    
        Tieto avaimista tallennetaan int-muuttujaan neljänä bittinä:
        bitit 0-3 vastaavat avaimia a-d. Esimerkiksi luku 5 on bittimuodossa
        0101, mikä tarkoittaa, että pelaajalla on avaimet a ja c.
    */
    
    class Tila {
        int y, x;
        int avaimet;
        char merkki;
        Tila aiempi;
        
        public Tila(int y, int x, int avaimet, char merkki, Tila aiempi) {
            this.y = y; this.x = x;
            this.avaimet = avaimet;
            this.merkki = merkki;
            this.aiempi = aiempi;
        }
    }
    
    public String etsi(char[][] laby) {
        int n = laby.length, m = laby[0].length;
        int alkuY = 0, alkuX = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (laby[i][j] == 'x') {alkuY = i; alkuX = j;}
            }
        }
        boolean[][][] nahty = new boolean[n][m][1<<4];
        ArrayList<Tila> jono = new ArrayList<>();
        nahty[alkuY][alkuX][0] = true;
        jono.add(new Tila(alkuY,alkuX,0,' ',null));
        int[][] suunta = {{-1,0},{1,0},{0,-1},{0,1}};
        char[] merkki = {'Y','A','V','O'};
        for (int i = 0; i < jono.size(); i++) {
            if (laby[jono.get(i).y][jono.get(i).x] == 'y') {
                String kuvaus = "";
                Tila tila = jono.get(i);
                while (tila.aiempi != null) {
                    kuvaus = tila.merkki+kuvaus;
                    tila = tila.aiempi;
                }
                return kuvaus;
            }
            for (int j = 0; j < 4; j++) {
                int uusiY = jono.get(i).y+suunta[j][0];
                int uusiX = jono.get(i).x+suunta[j][1];
                int avaimet = jono.get(i).avaimet;
                if (laby[uusiY][uusiX] >= 'a' && laby[uusiY][uusiX] <= 'd') {
                    avaimet |= (1<<(laby[uusiY][uusiX]-'a'));
                }
                if (laby[uusiY][uusiX] >= 'A' && laby[uusiY][uusiX] <= 'D') {
                    if ((avaimet&(1<<(laby[uusiY][uusiX]-'A'))) == 0) continue;
                }
                if (!nahty[uusiY][uusiX][avaimet] && laby[uusiY][uusiX] != '#') {
                    nahty[uusiY][uusiX][avaimet] = true;
                    jono.add(new Tila(uusiY,uusiX,avaimet,merkki[j],jono.get(i)));
                }
            }
        }
        return null;
    }
}