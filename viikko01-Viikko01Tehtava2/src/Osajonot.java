
public class Osajonot {

    int laske(String a, String b) {

        int count = 0, fromIndex = 0;

        while ((fromIndex = a.indexOf(b, fromIndex)) != -1) {
            count++;
            fromIndex++;
        }
        return count;

    }
}
