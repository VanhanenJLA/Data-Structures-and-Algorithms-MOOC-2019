
import java.util.*;

public class Jarjestys {

    int[] postOrder;
    int cursor = 0;
    int c = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] muodosta(int[] a, int[] b) {
        int n = a.length;
        postOrder = new int[b.length];
        for (int i = 0; i < n; i++) {
            map.put(b[i], i);
        }
        return fillPostOrder(a, b, 0, n - 1);
    }

    int[] fillPostOrder(int[] a, int[] b, int x, int y) {

        if (x > y) {
            return postOrder;
        }

        int v = map.get(a[this.c++]);
        fillPostOrder(a, b, x, v - 1);
        fillPostOrder(a, b, v + 1, y);
        postOrder[cursor++] = b[v];
        return postOrder;
    }
}
