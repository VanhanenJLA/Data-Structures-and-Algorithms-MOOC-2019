
import java.util.*;

public class Merkkijonot {

    ArrayList<String> permutations;
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ";

    void permute(String s, int n, int k) {
        if (s.length() == n) {
            permutations.add(s);
        } else {
            for (int i = 0; i < k; i++) {
                permute(s + alphabet.charAt(i), n, k);
            }
        }
    }

    public ArrayList<String> muodosta(int n, int k) {
        permutations = new ArrayList<>();
        permute("", n, k);
        return permutations;
    }
}
