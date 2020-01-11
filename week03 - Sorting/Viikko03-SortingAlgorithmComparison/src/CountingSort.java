/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jouni
 */
public class CountingSort implements IBenchmarkable {

    public void countingSort(int[] arr, int k) {

        int counter[] = new int[k + 1];

        for (int i : arr) {
            counter[i]++;
        }

        int ndx = 0;
        for (int i = 0; i < counter.length; i++) {
            while (0 < counter[i]) {
                arr[ndx++] = i;
                counter[i]--;
            }
        }
    }

    @Override
    public void benchmark(int arr[]) {
        countingSort(arr, arr.length);
    }
}
