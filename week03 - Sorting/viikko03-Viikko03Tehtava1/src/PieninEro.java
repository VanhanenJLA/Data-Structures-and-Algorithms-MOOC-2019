
import java.util.*;

public class PieninEro {

    int laske(int[] t) {

        Arrays.sort(t);
        int smallestDifference = t[1] - t[0];

        for (int i = 1; i < t.length; i++) {
            int differenceAtCursot = t[i] - t[i - 1];
            if (differenceAtCursot < smallestDifference) {
                smallestDifference = differenceAtCursot;
            }
        }
        return smallestDifference;
    }
}
