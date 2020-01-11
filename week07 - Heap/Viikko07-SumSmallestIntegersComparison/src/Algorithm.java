abstract class Algorithm implements IBenchmarkable {

    @Override
    public abstract long benchmark(int[] arr, int k);

}