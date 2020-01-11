
public class Komponentit {

    private int[] elder;
    private int[] size;
    private int total;

    public Komponentit(int n) {
        total = n;
        n += 1;
        elder = new int[n];
        size = new int[n];
        
        for (int i = 1; i < n; i++) {
            elder[i] = i;
            size[i] = 1;
        }
    }

    public void yhdista(int a, int b) {
        a = root(a);
        b = root(b);
        if (a == b) {
            return;
        }
        if (size[a] < size[b]) {
            // swap(a,b);
            int temp = a;
            a = b;
            b = temp;
        }
        elder[b] = a;
        size[a] += size[b];
        total--;
    }

    public int laske() {
        return total;
    }

    boolean sameSet(int a, int b) {
        return root(a) == root(b);
    }

    int root(int x) {
        while (x != elder[x]) {
            x = elder[x];
        }
        return x;
    }

}
