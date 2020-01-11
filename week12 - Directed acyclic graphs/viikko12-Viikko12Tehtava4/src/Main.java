
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        Yhtenaisyys a = new Yhtenaisyys(3);
//        a.lisaaKaari(1,2);
//        a.lisaaKaari(2,3);
//        a.lisaaKaari(3,1);
//        System.out.println(a.tutki()); // true
//        Yhtenaisyys b = new Yhtenaisyys(3);
//        b.lisaaKaari(1,2);
//        b.lisaaKaari(2,3);
//        b.lisaaKaari(1,3);
//        System.out.println(b.tutki()); // false
    }

    void fail(String s) {
        System.out.println(s);
    }

    void testi(Yhtenaisyys y, boolean a) {
        boolean b = y.tutki();
        if (a == b) {
            return;
        }
        if (a) {
            fail("Koodisi toimii väärin, kun verkko on vahvasti yhtenäinen");
        }
        if (!a) {
            fail("Koodisi toimii väärin, kun verkko ei ole vahvasti yhtenäinen");
        }
    }

    public void testi15() {
        int n = 100;
        Yhtenaisyys y = new Yhtenaisyys(n);
        Random r = new Random(1337);
        int m = 100000;
        for (int i = 1; i <= m / 2; i++) {
            int a = r.nextInt(n / 2) + 1;
            int b = r.nextInt(n / 2) + 1;
            y.lisaaKaari(a, b);
        }
        for (int i = 1; i <= m / 2; i++) {
            int a = r.nextInt(n / 2) + n / 2 + 1;
            int b = r.nextInt(n / 2) + n / 2 + 1;
            y.lisaaKaari(a, b);
        }
        testi(y, false);
    }

    public void testi16() {
        int n = 100;
        Yhtenaisyys y = new Yhtenaisyys(n);
        Random r = new Random(1337);
        int m = 100000;
        for (int i = 1; i <= m / 2 - 1; i++) {
            int a = r.nextInt(n / 2) + 1;
            int b = r.nextInt(n / 2) + 1;
            y.lisaaKaari(a, b);
        }
        for (int i = 1; i <= m / 2 - 1; i++) {
            int a = r.nextInt(n / 2) + n / 2 + 1;
            int b = r.nextInt(n / 2) + n / 2 + 1;
            y.lisaaKaari(a, b);
        }
        y.lisaaKaari(n / 2, n / 2 + 1);
        y.lisaaKaari(n / 2 + 1, n / 2);
        testi(y, true);
    }
}
