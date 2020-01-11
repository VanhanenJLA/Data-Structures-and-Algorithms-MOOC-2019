
import java.util.*;

public class Labyrintti {

    char[][] laby;

    public String etsi(char[][] l) {
        this.laby = l;
        Mover m = new Mover("", createVisited(l), new HashMap<>());
        return search(Util.findX(l), m);
    }

    public String search(Tile start, Mover m) {

        ArrayDeque<Tile> q = new ArrayDeque<>();
        q.add(start);
        m.visit(start);

        while (!q.isEmpty()) {
            Tile t = q.poll();
            char c = Util.getCharIn(t, laby);
            if (Util.isAKey(c)) {
                if (!m.keys.contains(c)) {
                    m.keys.add(c);
                }
            }
            if (c == 'y') {
                return t.path;
            }
            if (c == '#') {
                continue;
            }

//            laby.print(t);
            if (Util.isADoor(c)) {
                if (!m.keys.contains(Character.toLowerCase(c))) {
                    continue;
                }
            }

            for (Tile n : t.neighbours()) {
                if (m.visited(n)) {
                    continue;
                }
                q.add(n);
                m.visit(n);
            }
        }
        return null;
    }

    private HashSet<Character>[][] createVisited(char[][] laby) {
        int y = laby.length;
        int x = laby[0].length;
        return new HashSet[y][x];
    }

}

class Mover {

    String path;
    HashSet<Character>[][] visited;
    HashSet<Character> keys;
    HashMap<Tile, Character> moves;
    Tile t;

    public Mover(Tile t, String path, HashSet<Character>[][] visited, HashSet<Character> keys) {
        this.t = t;
        this.path = path;
        this.visited = visited;
        this.keys = keys;
    }

    void visit(Tile t, String d) {
        visited[t.y][t.x] = keys;
        path = t.path;
    }

    boolean visited(Tile n) {
        return keys == visited[n.y][n.x];
    }

    HashMap<Tile, Character> moves() {
        HashMap<Tile, Character> moves = new HashMap<>();
        moves.put(new Tile(t.y - 1, t.x), 'Y');
        moves.put(new Tile(t.y + 1, t.x), 'A');
        moves.put(new Tile(t.y, t.x - 1), 'V');
        moves.put(new Tile(t.y, t.x + 1), 'O');
        return moves;
    }

}

class Tile {

    int x;
    int y;

    public Tile(int y, int x) {
        this.y = y;
        this.x = x;
    }

}

class Util {

    static char[] doors = {'A', 'B', 'C', 'D'};
    static char[] keys = {'a', 'b', 'c', 'd'};

    static char getCharIn(Tile t, char[][] laby) {
        return laby[t.y][t.x];
    }

    static boolean isADoor(char c) {
        for (char door : Util.doors) {
            if (c == door) {
                return true;
            }
        }
        return false;
    }

    static boolean isAKey(char c) {
        for (char key : Util.keys) {
            if (c == key) {
                return true;
            }
        }
        return false;
    }

    static Tile findX(char[][] laby) {
        for (int y = 0; y < laby.length; y++) {
            for (int x = 0; x < laby[0].length; x++) {
                if (laby[y][x] == 'x') {
                    return new Tile(y, x);
                }
            }
        }
        return null;
    }

    void print(Tile t, Mover m, char[][] l) {
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        int y = t.y;
        int x = t.x;
        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < l[0].length; j++) {
                if (i == y && j == x) {
                    System.out.print('@');
                } else {
                    System.out.print(l[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println(m.keys);

    }

}
