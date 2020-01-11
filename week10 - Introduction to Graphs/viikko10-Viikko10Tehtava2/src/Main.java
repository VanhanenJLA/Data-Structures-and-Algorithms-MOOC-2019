import java.util.*;

public class Main {
    public static void main(String[] args) {
        Komponentit k = new Komponentit(6);
        k.lisaaYhteys(1,2); k.lisaaYhteys(1,3);
        k.lisaaYhteys(3,4); k.lisaaYhteys(2,3);
        k.lisaaYhteys(5,6);
        System.out.println(k.laske()); // 2
    }
}
