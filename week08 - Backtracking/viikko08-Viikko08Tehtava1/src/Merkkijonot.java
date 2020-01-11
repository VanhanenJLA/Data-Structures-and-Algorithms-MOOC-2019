
import java.util.*;

public class Merkkijonot {

    ArrayList<String> permutations;

    void permute(String s, int n) {
        if (s.length() == n) {
            permutations.add(s);
        } else {
            permute(s + "A", n);
            permute(s + "B", n);
        }
    }

    public ArrayList<String> muodosta(int n) {
        permutations = new ArrayList<>();
        permute("", n);
        return permutations;
    }
}
