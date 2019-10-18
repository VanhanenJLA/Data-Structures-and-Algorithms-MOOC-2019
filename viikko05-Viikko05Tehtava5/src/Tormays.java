
import java.util.*;

public class Tormays {

    String a;
    String b;

    char[] arr;
    HashMap<Integer, String> map;

    public Tormays() {
        arr = new char[1024];
        map = new HashMap<>();
        recurse();

    }

    char[] push(int i) {

        if (arr[i] == 0) {
            arr[i] = 'a';
            return arr;
        }
        if (arr[i] == 'a') {
            arr[i] = 'b';
            return arr;
        }
        if (arr[i] == 'b') {
            arr[i] = 'a';
            push(++i);
        }
        return arr;
    }

    String stringify() {
        String s = "";
        for (char c : arr) {
            if (c == 0) {
                return s;
            }
            s += c;
        }
        return s;
    }

    String merkkijono1() {
        return a;
    }

    String merkkijono2() {
        return b;
    }

    private void recurse() {
        push(0);
        String s = stringify();
        int h = s.hashCode();

        if (map.containsKey(h)) {
            a = s;
            b = map.get(h);
            return;
        } else {
            map.put(h, s);
        }
        recurse();
    }

}
