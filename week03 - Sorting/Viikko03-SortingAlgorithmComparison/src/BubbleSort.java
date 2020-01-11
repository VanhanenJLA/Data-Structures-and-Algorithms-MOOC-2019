/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jouni
 */
public class BubbleSort implements IBenchmarkable {

    int[] bubbleSort(int arr[], int n) {
        int i, j, swapHolder;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapHolder = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swapHolder;
                    swapped = true;
                }
            }

            if (swapped == false) {
                break;
            }
        }
        return arr;
    }

    @Override
    public void benchmark(int arr[]) {
        bubbleSort(arr, arr.length);
    }
}
