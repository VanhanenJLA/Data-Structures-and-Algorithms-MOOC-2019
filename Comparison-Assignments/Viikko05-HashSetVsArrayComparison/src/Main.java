
import java.util.Arrays;
import java.util.HashSet;
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
public class Main {

    public static void main(String[] args) {

        int[] arr = generateTestSample(1337);

        System.out.println("HashSet:");
        benchmarkHashSet(arr);
        System.out.println("Array:");
        benchmarkArray(arr);

    }

    private static void printElapsedTime(long start, long finish) {
        System.out.println("Time elapsed " + ((finish - start) / 1e9) + " s");
    }

    private static void printElapsedNanoTime(long start, long finish) {
        System.out.println("Time elapsed " + (finish - start) + " ns");
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

    private static void benchmarkHashSet(int[] arr) {
        long start = System.nanoTime();
        HashSet<Integer> hs = new HashSet<>();
        for (int i : arr) {
            hs.add(i);
        }
        hs.size();
        long finish = System.nanoTime();
        printElapsedTime(start, finish);
    }

    private static void benchmarkArray(int[] arr) {
        long start = System.nanoTime();
        int count = 0;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                count++;
            }
        }
        long finish = System.nanoTime();
        printElapsedTime(start, finish);
    }
}
