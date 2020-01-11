import java.util.*;

public class Main {
    public static void main(String[] args) {
        Ruudukko r = new Ruudukko();
        int[][] t = {{2,3,1},
                     {1,4,5},
                     {2,3,4}};
        System.out.println(r.laske(t)); // 18
    }
}
