import java.util.*;

public class Main {
    public static void main(String[] args) {
        Tormays t = new Tormays();
        String x = t.merkkijono1();
        String y = t.merkkijono2();
        if (x.matches("[ab]+") && y.matches("[ab]+") && !x.equals(y) && x.hashCode() == y.hashCode()) {
            System.out.println("Hyvää työtä :)");
        }
    }
}
