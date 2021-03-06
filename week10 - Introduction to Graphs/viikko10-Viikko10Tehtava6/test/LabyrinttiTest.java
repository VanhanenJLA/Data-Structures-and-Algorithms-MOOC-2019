import java.util.*;
import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("10.6")
public class LabyrinttiTest {
    private void testi(char[][] t, int a) {
        int n = t.length;
        int m = t[0].length;
        char[][] u = new char[n][m];
        for (int i = 0; i < n; i++) {
            u[i] = t[i].clone();
        }
        Labyrintti l = new Labyrintti();
        String s = l.etsi(t);
        if (a == 0 && s == null) return;
        if (a == 0) fail("Reittiä ei ole olemassa, mutta metodisi antaa reitin");
        if (s == null) fail("Reitti on olemassa, mutta metodisi ei anna reittiä");
        if (a != s.length()) fail("Metodisi antaa väärän pituisen reitin");
        int ay = 0, ax = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (u[i][j] == 'x') {ay = i; ax = j;}
            }
        }
        String v = "Metodisi antaa virheellisen reitin";
        boolean[] kk = new boolean[4];
        for (int i = 0; i < a; i++) {
            char c = s.charAt(i);
            if (c == 'Y') {
                ay--;
            } else if (c == 'A') {
                ay++;
            } else if (c == 'V') {
                ax--;
            } else if (c == 'O') {
                ax++;
            } else {
                fail(v);
            }
            if (u[ay][ax] == '#') fail(v);
            if (u[ay][ax] >= 'a' && u[ay][ax] <= 'd') {
                kk[u[ay][ax]-'a'] = true;
            }
            if (u[ay][ax] >= 'A' && u[ay][ax] <= 'D') {
                if (!kk[u[ay][ax]-'A']) fail(v);
            }
        }
        if (u[ay][ax] != 'y') fail(v);
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        char[][] t = {{'#','#','#','#'},
                      {'#','x','y','#'},
                      {'#','#','#','#'}};
        testi(t,1);
    }    

    @Test(timeout = 1000)
    public void testi2() {
        char[][] t = {{'#','#','#','#','#'},
                      {'#','x','#','y','#'},
                      {'#','#','#','#','#'}};
        testi(t,0);
    }    

    @Test(timeout = 1000)
    public void testi3() {
        char[][] t = {{'#','#','#','#','#'},
                      {'#','x','.','.','#'},
                      {'#','.','.','.','#'},
                      {'#','.','.','y','#'},
                      {'#','#','#','#','#'}};
        testi(t,4);
    }    

    @Test(timeout = 1000)
    public void testi4() {
        char[][] t = {{'#','#','#','#','#'},
                      {'#','x','#','y','#'},
                      {'#','.','#','.','#'},
                      {'#','.','.','.','#'},
                      {'#','#','#','#','#'}};
        testi(t,6);
    }    
    
    @Test(timeout = 1000)
    public void testi5() {
        int n = 50;
        char[][] t = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j] = '.';
                if (i == 0 || i == n-1) t[i][j] = '#';
                if (j == 0 || j == n-1) t[i][j] = '#';
            }
        }
        t[1][1] = 'x';
        t[n-2][n-2] = 'y';
        testi(t,2*n-6);
    }    

    @Test(timeout = 1000)
    public void testi6() {
        int n = 50;
        char[][] t = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j] = '.';
                if (i == 0 || i == n-1) t[i][j] = '#';
                if (j == 0 || j == n-1) t[i][j] = '#';
            }
        }
        t[1][1] = 'x';
        t[n-2][n-2] = 'y';
        t[n-3][n-2] = '#';
        t[n-2][n-3] = '#';
        t[n-3][n-3] = '#';
        testi(t,0);
    }    

    @Test(timeout = 1000)
    public void testi7() {
        int n = 47;
        char[][] t = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j] = '.';
                if (i == 0 || i == n-1) t[i][j] = '#';
                if (j == 0 || j == n-1) t[i][j] = '#';
                if (i%4 == 2 && j < n-2) t[i][j] = '#';
                if (i%4 == 0 && j > 1) t[i][j] = '#';
            }
        }
        t[1][1] = 'x';
        t[n-2][n-2] = 'y';
        testi(t,(n+1)/2*(n-3));
    }    

    @Test(timeout = 1000)
    public void testi8() {
        int n = 50;
        char[][] t = new char[n][n];
        try {
            Scanner input = new Scanner(new File("laby.txt"));
            for (int i = 0; i < n; i++) {
                String s = input.next();
                for (int j = 0; j < n; j++) {
                    t[i][j] = s.charAt(j);
                }
            }
        } catch (Exception e) {}
        testi(t,137);
    }    

    @Test(timeout = 1000)
    public void testi9() {
        char[][] t = {{'#','#','#','#','#','#'},
                      {'#','x','a','A','y','#'},
                      {'#','#','#','#','#','#'}};
        testi(t,3);
    }    

    @Test(timeout = 1000)
    public void testi10() {
        char[][] t = {{'#','#','#','#','#','#'},
                      {'#','x','A','a','y','#'},
                      {'#','#','#','#','#','#'}};
        testi(t,0);
    }    
    
    @Test(timeout = 1000)
    public void testi11() {
        char[][] t = {{'#','#','#','#','#','#'},
                      {'#','x','b','A','y','#'},
                      {'#','#','#','#','#','#'}};
        testi(t,0);
    }    

    @Test(timeout = 1000)
    public void testi12() {
        char[][] t = {{'#','#','#','#','#','#','#','#'},
                      {'#','x','a','A','A','A','y','#'},
                      {'#','#','#','#','#','#','#','#'}};
        testi(t,5);
    }    

    @Test(timeout = 1000)
    public void testi13() {
        char[][] t = {{'#','#','#','#','#','#','#','#'},
                      {'#','x','a','A','b','B','y','#'},
                      {'#','#','#','#','#','#','#','#'}};
        testi(t,5);
    }    
    
    @Test(timeout = 1000)
    public void testi14() {
        char[][] t = {{'#','#','#','#','#','#','#','#'},
                      {'#','x','a','B','b','A','y','#'},
                      {'#','#','#','#','#','#','#','#'}};
        testi(t,0);
    }    

    @Test(timeout = 1000)
    public void testi15() {
        int n = 50;
        char[][] t = new char[n][n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int c = r.nextInt(4);
                t[i][j] = i < n/2 ? (char)(c+'a') : (char)(c+'A');
                if (i == 0 || i == n-1) t[i][j] = '#';
                if (j == 0 || j == n-1) t[i][j] = '#';
            }
        }
        t[1][1] = 'x';
        t[n-2][n-2] = 'y';
        testi(t,2*n-6);
    }    

    @Test(timeout = 1000)
    public void testi16() {
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
        } catch (Exception e) {}
        testi(t,629);
    }    
    
}
