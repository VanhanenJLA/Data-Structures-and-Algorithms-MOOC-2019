import java.util.*;

public class Main {
    public static void main(String[] args) {
        Taulukko t = new Taulukko();
        System.out.println(t.laske(new int[] {1,2,3,2})); // 18
        System.out.println(t.laske(new int[] {5})); // 5
        System.out.println(t.laske(new int[] {4,2,9,1,9,2,5})); // 323
    }
}
