import java.util.*;

public class Main {
    public static void main(String[] args) {
        Viestinta v = new Viestinta(6);
        v.lisaaYhteys(1,2);
        v.lisaaYhteys(2,3);
        v.lisaaYhteys(1,3);
        v.lisaaYhteys(3,4);
        v.lisaaYhteys(5,6);
        System.out.println(v.tarkasta(1,4)); // true
        System.out.println(v.tarkasta(2,5)); // false
        System.out.println(v.tarkasta(5,6)); // true
    }
}
