import java.util.*;

public class Main {
    public static void main(String[] args) {
        Osajoukot o = new Osajoukot();
        System.out.println(o.laske(new int[] {1,2,1,3}, 4)); // 3
        System.out.println(o.laske(new int[] {1,1,1,1}, 4)); // 1
        System.out.println(o.laske(new int[] {4,4,4,4}, 4)); // 4
    }
}
