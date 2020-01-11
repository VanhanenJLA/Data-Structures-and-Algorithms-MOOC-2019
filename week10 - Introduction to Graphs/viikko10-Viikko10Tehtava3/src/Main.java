import java.util.*;

public class Main {
    public static void main(String[] args) {
        Lentoreitti l = new Lentoreitti(6);
        l.lisaaYhteys(1,2);
        l.lisaaYhteys(2,3);
        l.lisaaYhteys(3,4);
        l.lisaaYhteys(3,5);
        l.lisaaYhteys(1,3);
        l.lisaaYhteys(5,6);
        System.out.println(l.laske(1,6)); // 2
    }
}
