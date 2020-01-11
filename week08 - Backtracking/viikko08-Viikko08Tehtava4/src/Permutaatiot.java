
public class Permutaatiot {

    int count;

    public int laske(int n) {
        count = 0;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        permute(arr, 0, n - 1);
        return count;
    }

    private void permute(int[] arr, int beg, int end) {
        if (beg == end) {
            if (!containsSequentialNumbers(arr)) count++;
        } else {
            for (int i = beg; i <= end; i++) {
                arr = swap(arr, beg, i);
                permute(arr, beg + 1, end);
                arr = swap(arr, beg, i);
            }
        }
    }

    private int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    private boolean containsSequentialNumbers(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int difference = arr[i] - arr[i - 1];
            if (Math.abs(difference) == 1) {
                return true;
            }
        }
        return false;
    }

}
