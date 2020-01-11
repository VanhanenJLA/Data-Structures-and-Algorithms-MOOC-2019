
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArrayList<IBenchmarkable> algorithms = new ArrayList();

        algorithms.add(new CountingSort());
        algorithms.add(new BubbleSort());
        algorithms.add(new QuickSort());

        algorithms.forEach((algorithm) -> {
            benchmarkAlgorithm(algorithm);
        });
//        Arrays.sort(arr);
    }

    private static void benchmarkAlgorithm(IBenchmarkable algorithm) {
        int[] arr = generateTestSample(1337);

        long start = System.nanoTime();
        algorithm.benchmark(arr);
        long finish = System.nanoTime();

        printElapsedTime(start, finish);
    }

    private static int[] generateTestSample(int seed) {
        int n = 1000000;
        int[] arr = new int[n];
        Random r = new Random(seed);
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(100);
        }
        return arr;
    }

    private static void printElapsedTime(long start, long finish) {
        System.out.println("Time elapsed " + ((finish - start) / 1e9) + " s");
    }

    private static void printElapsedNanoTime(long start, long finish) {
        System.out.println("Time elapsed " + (finish - start) + " ns");
    }

}
