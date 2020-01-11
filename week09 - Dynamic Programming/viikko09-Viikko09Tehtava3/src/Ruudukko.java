
import java.util.*;

public class Ruudukko {

    int[][] copy;

    public long laske(int[][] t) {
        int n = t.length;
        copy = new int[n][n];
        copy[0][0] = t[0][0];
        search(t);
        return copy[n - 1][n - 1];

    }

    void search(int[][] t) {
        int n = t.length;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (y == 0 && x == 0) {
                    continue;
                }
                int left = (x == 0) ? 0 : copy[y][x - 1];
                int upper = (y == 0) ? 0 : copy[y - 1][x];

                copy[y][x] = (t[y][x] + left > t[y][x] + upper)
                        ? (t[y][x] + left) : t[y][x] + upper;
            }
        }
    }

    boolean done(Point pos, int n) {
        return (pos.x == n && pos.y == n);
    }

    void printMatrix() {
        int[][] t = new int[][]{
            {1, 1, 1,},
            {2, 2, 2,},
            {3, 3, 3,}
        };

        for (int y = 0; y < t[y].length; y++) {
            for (int x = 0; x < t.length; x++) {
                System.out.print(t[y][x]);
            }
            System.out.println("");
        }
    }

}

class Point {

    int x;
    int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point moveRight() {
        this.x += 1;
        return this;
    }

    public Point moveDown() {
        this.y += 1;
        return this;
    }

}
