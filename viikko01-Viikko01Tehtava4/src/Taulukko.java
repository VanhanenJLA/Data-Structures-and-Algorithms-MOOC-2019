
import java.util.*;

public class Taulukko {

    int laske(int[] t) {
        

        while (t.length > 1) {
            int[] copy = new int[t.length - 1];

            for (int i = 0; i < t.length - 1; i++) {
                copy[i] = t[i] + t[i + 1];
            }

            t = copy;

        }
        return t[0];
    }
}
