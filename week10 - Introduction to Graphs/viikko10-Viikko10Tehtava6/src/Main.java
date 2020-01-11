
import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Labyrintti l = new Labyrintti();
        char[][] t = {{'#', '#', '#', '#', '#', '#', '#'},
        {'#', 'x', '#', '.', 'y', 'b', '#'},
        {'#', '.', '#', 'A', '#', '#', '#'},
        {'#', 'b', 'B', '.', 'B', 'a', '#'},
        {'#', '#', '#', '#', '#', '#', '#'}};
        t = testi16();
        System.out.println(l.etsi(t)); // AAOOOOVVYYO
    }

    static char[][] testi15() {
        int n = 50;
        char[][] t = new char[n][n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int c = r.nextInt(4);
                t[i][j] = i < n / 2 ? (char) (c + 'a') : (char) (c + 'A');
                if (i == 0 || i == n - 1) {
                    t[i][j] = '#';
                }
                if (j == 0 || j == n - 1) {
                    t[i][j] = '#';
                }
            }
        }
        t[1][1] = 'x';
        t[n - 2][n - 2] = 'y';
        return t;
    }

    static char[][] testi16() {
        int n = 50;
        char[][] t = new char[n][n];
        try {
            Scanner input = new Scanner(new File("laby2.txt"));
            for (int i = 0; i < n; i++) {
                String s = input.next();
                for (int j = 0; j < n; j++) {
                    t[i][j] = s.charAt(j);
                }
            }
        } catch (Exception e) {
        }
        return t;
    }
}
