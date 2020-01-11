import java.util.*;
 
public class Tehtavat {  
    public long laske(int x) {
        long[][] d = new long[15][85];
        d[0][0] = 1;
        for (int i = 1; i <= 14; i++) {
            for (int j = 3; j <= 84; j++) {
                for (int k = 3; k <= 6 && j-k >= 0; k++) {
                    d[i][j] += d[i-1][j-k];
                }
            }
        }
        return d[14][x];
    }
}