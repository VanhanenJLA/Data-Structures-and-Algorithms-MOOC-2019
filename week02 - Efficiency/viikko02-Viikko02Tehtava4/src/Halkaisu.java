
public class Halkaisu {

    public int laske(int[] t) {

        int count = 0;
        int right = sumArray(t);
        int left = 0;
        int n = t.length-1;

        for (int i = 0; i < n; i++) {

            left += t[i];
            right -= t[i];

            if (left == right) {
                count++;
            }
        }
        return count;
    }

    int sumArray(int[] t) {
        int sum = 0;
        for (int i = 0; i < t.length; i++) {
            sum += t[i];
        }
        return sum;
    }

}
