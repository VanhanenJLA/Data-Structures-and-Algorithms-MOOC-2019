
import java.util.ArrayList;
import java.util.List;

// This solution is too slow.
// It's atleast O(n^3) time.

public class Alitaulukot {

    long laske(int[] t) {

        int n = t.length;
        long count = 0;

        for (int window = 0; window < n; window++) {
            List<Integer> distinctNumbers = new ArrayList<>();
            for (int outer = window; outer < n; outer++) {
                for (int inner = window; inner <= outer; inner++) {
//                    System.out.print(t[k] + " ");
                    if (!contains(distinctNumbers, t[inner])) {
                        distinctNumbers.add(t[inner]);
                    }
                    if (distinctNumbers.size() > 2) {
                        break;
                    }
                }
                if (distinctNumbers.size() < 3) {
                    count++;
                }
//                System.out.println();
            }
        }
//        System.out.println(count);
        return count;
    }

    private boolean contains(List<Integer> list, int i) {
        return list.stream().anyMatch((j) -> (j == i));
    }

}
