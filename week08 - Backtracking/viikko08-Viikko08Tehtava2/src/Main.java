import java.util.*;

public class Main {
    public static void main(String[] args) {
        Merkkijonot m = new Merkkijonot();
        System.out.println(m.muodosta(2,1)); // [AA]
        System.out.println(m.muodosta(2,2)); // [AA, AB, BA, BB]
        System.out.println(m.muodosta(2,3)); // [AA, AB, AC, BA, BB, BC, CA, CB, CC]
        System.out.println(m.muodosta(3,2)); // [AAA, AAB, ABA, ABB, BAA, BAB, BBA, BBB]
    }
}
