import java.util.*;

public class Main {
    public static void main(String[] args) {
        Jarjestykset j = new Jarjestykset(5);
        j.lisaaKaari(1,2);
        j.lisaaKaari(2,5);
        j.lisaaKaari(3,2);
        j.lisaaKaari(3,5);
        j.lisaaKaari(4,5);
        System.out.println(j.laske()); // 8
    }
}
