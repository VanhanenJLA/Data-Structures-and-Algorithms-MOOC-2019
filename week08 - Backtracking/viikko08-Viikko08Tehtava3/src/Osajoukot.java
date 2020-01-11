
public class Osajoukot {

    int n;
    int x;
    int[] inclusion;
    int[] t;
    int count;

    public int laske(int[] t, int x) {
        
        this.t = t;
        n = t.length;
        inclusion = new int[n];
        this.x = x;
        count = 0;

        return oof(0);
    }

    int oof(int k) {
        if (k == n) {
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (inclusion[i] == 1) {
                    sum += t[i];
                }
            }
            if (sum == x) {
                count++;
            }
        } else {
            for (int i = 0; i < 2; i++) {
                inclusion[k] = i;
                oof(k + 1);
            }
        }

        return count;
    }
}
