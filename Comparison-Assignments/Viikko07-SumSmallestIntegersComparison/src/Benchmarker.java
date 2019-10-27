
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jouni
 */

class Benchmarker {

    static int[] testSample = generateTestSample(1337);
    static int k;

    static public void benchmark(Algorithm a) {
        long elapsed = a.benchmark(testSample, k);
        printResults(a, elapsed, k);
    }

    public static int[] generateTestSample(int seed) {
        int n = (int) 1E8;
        int[] arr = new int[n];
        Random r = new Random(seed);
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(100);
        }
        return arr;
    }

    public static void printResults(Algorithm a, long elapsed, int k) {
        System.out.println("========================================");
        System.out.println(a.getClass().toString());
        System.out.println("k: " + k);
        printElapsedTime(elapsed);
        printElapsedNanoTime(elapsed);
        System.out.println("========================================");
        System.out.println();
    }

    public static void printElapsedTime(long elapsed) {
        System.out.println("Time elapsed: " + (elapsed / 1e9) + " s");
    }

    public static void printElapsedNanoTime(long elapsed) {
        System.out.println("Elapsed nanotime: " + elapsed + " ns");
    }

}
