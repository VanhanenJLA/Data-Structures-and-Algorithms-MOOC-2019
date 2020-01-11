import java.util.*;

public class Main {
    public static void main(String[] args) {
        Yhteydet y = new Yhteydet(6);
        y.yhdista(1,2);
        y.yhdista(1,3);
        y.yhdista(4,6);
        y.yhdista(2,6);
        y.yhdista(2,3);
        System.out.println(y.tutki(2,3)); // 2
        System.out.println(y.tutki(3,5)); // -1
        System.out.println(y.tutki(1,6)); // 4
    }
}
