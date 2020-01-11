import java.util.*;
 
public class Peli {  
    public int voittaja(int n) {
        int k = 1;
        while (n+1 > k) k *= 2;
        return n+1 == k ? 2 : 1;
    }
}