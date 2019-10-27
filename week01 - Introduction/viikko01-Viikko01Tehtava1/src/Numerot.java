
public class Numerot {

    int summa(int x) {

        int n, sum = 0;

        while (x > 0) {
            n = x % 10;
            sum = sum + n;
            x = x / 10;
        }
        return sum;
    }
}
