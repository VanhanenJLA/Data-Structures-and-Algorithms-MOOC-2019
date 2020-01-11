
import java.util.*;

public class Main {

    public static void main(String[] args) {
       new Main().testi8();
    }

    public void originell() {
        Reitit r = new Reitit(5);
        r.lisaaKaari(1, 2);
        r.lisaaKaari(2, 3);
        r.lisaaKaari(2, 4);
        r.lisaaKaari(3, 5);
        r.lisaaKaari(4, 5);
    }

    public void testi8() {
        Reitit r = new Reitit(6);
        r.lisaaKaari(1, 2);
        r.lisaaKaari(1, 3);
        r.lisaaKaari(2, 3);
        r.lisaaKaari(2, 4);
        r.lisaaKaari(3, 5);
        r.lisaaKaari(5, 4);
        r.lisaaKaari(4, 6);
        r.lisaaKaari(5, 6);
        testi(r, 5);
    }

    public void testi5() {
        Reitit r = new Reitit(2);
        testi(r, 0);
    }

    void testi(Reitit r, long a) {
        long b = r.laske();
        if (a == b) {
            return;
        }
        fail("Oikea vastaus on " + a + ", mutta koodisi antaa " + b);
    }

    private void fail(String string) {
        System.out.println(string);
    }
}
