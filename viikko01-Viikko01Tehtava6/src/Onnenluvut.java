
import java.util.Arrays;

public class Onnenluvut {

    int laske(int min, int max) {
        //TODO: Find a way count the lowest amount of digits required.
        int[] arr = new int[9];
        return countLuckyNumbers(arr, min, max, 0);
    }

    int countLuckyNumbers(int[] arr, int min, int max, int count) {
        arr = push(arr, 0);
        if (isLuckyNumber(arr, min, max)) {
            count++;
        }
        if (arrayIsFull(arr)) {
            return count;
        }
        return countLuckyNumbers(arr, min, max, count);
    }

    int[] push(int[] arr, int i) {
        if (arr[i] == 0) {
            arr[i] = 3;
            return arr;
        }
        if (arr[i] == 3) {
            arr[i] = 7;
            return arr;
        }
        if (arr[i] == 7) {
            arr[i] = 3;
            push(arr, ++i);
        }
        return arr;
    }

    boolean isLuckyNumber(int[] arr, int min, int max) {
        String s = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            s += arr[i];
        }
        return isWithinBounds(Integer.valueOf(s), min, max);
    }

    boolean isWithinBounds(int number, int min, int max) {
        if (number < min) {
            return false;
        }
        return number <= max;
    }

    boolean arrayIsFull(int[] arr) {
        for (int i : arr) {
            if (i != 7) {
                return false;
            }
        }
        return true;
    }

    int findDigitCount(int min, int max) {
        return String.valueOf(max).length() - String.valueOf(min).length();
    }

}
