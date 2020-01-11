
import java.util.*;

public class Labyrintti {

    public String etsi(char[][] laby) {
        return searchV2(new Laby(laby));
    }

    public String searchV2(Laby laby) {

        Tile start = laby.findX();
        Queue<Tile> q = new LinkedList<>();

        q.add(start);
        laby.moveTo(start);

        while (!q.isEmpty()) {
            Tile t = q.poll();
            if (laby.getCharIn(t) == 'y') {
                return t.path;
            }
            if (laby.getCharIn(t) == '#') {
                continue;
            }

            for (Tile n : t.neighbours()) {
                if (laby.visited(n)) {
                    continue;
                }
                q.add(n);
                laby.moveTo(n);
            }
        }
        return null;
    }
}

class Laby {

    char[][] laby;
    boolean[][] visited;

    public Laby(char[][] laby) {
        this.laby = laby;
        visited = createVisited(laby);
    }

    void moveTo(Tile t) {
        visited[t.y][t.x] = true;
    }

    private boolean[][] createVisited(char[][] laby) {
        int y = laby.length;
        int x = laby[0].length;
        return new boolean[y][x];
    }

    Tile findX() {
        for (int y = 0; y < laby.length; y++) {
            for (int x = 0; x < laby[0].length; x++) {
                if (laby[y][x] == 'x') {
                    return new Tile(y, x);
                }
            }
        }
        return null;
    }

    void print(char[][] laby, int y, int x) {
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        for (int i = 0; i < laby.length; i++) {
            for (int j = 0; j < laby[0].length; j++) {
                if (i == y && j == x) {
                    System.out.print('@');
                } else {
                    System.out.print(laby[i][j]);
                }
            }
            System.out.println();
        }

    }

    boolean visited(Tile n) {
        return visited[n.y][n.x];
    }

    char getCharIn(Tile t) {
        return laby[t.y][t.x];
    }

}

class Tile {

    int x;
    int y;
    String path;

    public Tile(int y, int x) {
        this.y = y;
        this.x = x;
        path = "";
    }

    List<Tile> neighbours() {
        ArrayList<Tile> neighbours = new ArrayList<>();
        neighbours.add(up());
        neighbours.add(down());
        neighbours.add(left());
        neighbours.add(right());
        return neighbours;
    }

    Tile up() {
        return new Tile(y - 1, x).setPath(this.path + "Y");
    }

    Tile down() {
        return new Tile(y + 1, x).setPath(this.path + "A");
    }

    Tile left() {
        return new Tile(y, x - 1).setPath(this.path + "V");
    }

    Tile right() {
        return new Tile(y, x + 1).setPath(this.path + "O");
    }

    public Tile setPath(String path) {
        this.path = path;
        return this;
    }

}
