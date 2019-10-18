
public class Lista {

    int[] arr;
    int start, size;

    public Lista() {
        arr = new int[(int) 1E8];
        start = arr.length / 2 - 1;
        size = 0;
    }

    void lisaaAlkuun(int x) {
        start--;
        arr[start] = x;
        size++;
    }

    void lisaaLoppuun(int x) {
        arr[start + size] = x;
        size++;
    }

    int haeAlkio(int k) {
        return arr[start + k];
    }
}
