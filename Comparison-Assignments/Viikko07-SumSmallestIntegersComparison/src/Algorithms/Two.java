
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jouni
 */
class Two extends Algorithm {

    private int countSumOfKSmallestIntegers(int[] arr, int k) {
        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        return sum;
    }

    @Override
    public long benchmark(int[] arr, int k) {
        long start = System.nanoTime();
        countSumOfKSmallestIntegers(arr, k);
        long finish = System.nanoTime();
        return finish - start;
    }

}
