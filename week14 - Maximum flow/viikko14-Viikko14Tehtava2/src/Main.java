import java.util.*;

public class Main {
    public static void main(String[] args) {
        Maksimivirtaus m = new Maksimivirtaus(5);
        m.lisaaKaari(1,2,4);
        m.lisaaKaari(1,3,6);
        m.lisaaKaari(2,3,8);
        m.lisaaKaari(2,4,3);
        m.lisaaKaari(3,5,4);
        m.lisaaKaari(4,5,5);
        System.out.println(m.laske()); // 7
    }
}
