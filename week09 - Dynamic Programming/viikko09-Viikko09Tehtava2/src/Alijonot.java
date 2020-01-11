
// Tirakijra.pdf
//for k = 0 to n-1 
//    pisin[k] = 1 
//    for x = 0 to k-1 
//        if taulu[x] < taulu[k] 
//            if pisin[x]+1 > pisin[k] 
//                  pisin[k] = pisin[x]+1

public class Alijonot {

    public long laske(int[] t) {
        int n = t.length;
        int[] longest = new int[n];

        for (int k = 0; k < n; k++) {
            longest[k] = 1;

            for (int x = 0; x < k; x++) {
                if (differByOne(t[k], t[x])) {
                    if (longest[x] + 1 > longest[k]) {
                        longest[k] = longest[x] + 1;
                    }
                }
            }
        }

        int z = 1;
        for (int i = 0; i < n; i++) {
            if (longest[i] > z) {
                z = longest[i];
            }
        }
        return z;

    }

    private boolean differByOne(int a, int b) {
        return Math.abs(a - b) == 1;
    }

}
