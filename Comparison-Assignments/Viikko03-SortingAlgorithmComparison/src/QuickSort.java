/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jouni
 */
public class QuickSort implements IBenchmarkable {

    public int[] quickSort(int[] arr, int start, int end) {

        if (start < end) {
            int partitionIndex = partition(arr, start, end);

            quickSort(arr, start, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
        return arr;
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = (start - 1);

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapHolder = arr[i];
                arr[i] = arr[j];
                arr[j] = swapHolder;
            }
        }

        int swapHolder = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapHolder;

        return i + 1;
    }

    @Override
    public void benchmark(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

}
