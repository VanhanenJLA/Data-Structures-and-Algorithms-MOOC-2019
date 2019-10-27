
public class PisinToisto {

    int laske(int[] arr) {

        int highscore = 1;
        int streak = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                streak++;
            } else {
                streak = 1;
            }
            if (streak > highscore) {
                highscore = streak;
            }
        }
        return highscore;
    }

}
