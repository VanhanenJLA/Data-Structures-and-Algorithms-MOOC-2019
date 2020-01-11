
public class LyhinReitti {

    int n, m;
    int[] a = new int[200001];
    int[] b = new int[200001];
    int[] p = new int[200001];

    public LyhinReitti(int n) {
        this.n = n;
    }

    public void lisaaTie(int a, int b, int p) {
        m++;
        this.a[m] = a;
        this.b[m] = b;
        this.p[m] = p;
        m++;
        this.a[m] = b;
        this.b[m] = a;
        this.p[m] = p;
    }

    public int laske(int x, int y) {
        int[] matka = new int[n + 1];
        int INF = 999999999;
        for (int i = 1; i <= n; i++) {
            matka[i] = INF;
        }
        matka[x] = 0;
        while (true) {
            boolean muutos = false;
            for (int i = 1; i <= m; i++) {
                if (matka[a[i]] + p[i] < matka[b[i]]) {
                    matka[b[i]] = matka[a[i]] + p[i];
                    muutos = true;
                }
            }
            if (!muutos) {
                break;
            }
        }
        return matka[y] == INF ? -1 : matka[y];
    }
}
