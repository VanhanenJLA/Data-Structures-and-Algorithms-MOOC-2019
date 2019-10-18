import java.util.*;

public class Main {
    public static void main(String[] args) {
        Lista l = new Lista();
        l.lisaaLoppuun(3);
        l.lisaaLoppuun(5);
        System.out.println(l.haeAlkio(1)); // 5
        l.lisaaAlkuun(2);
        System.out.println(l.haeAlkio(1)); // 3 
    }
}
