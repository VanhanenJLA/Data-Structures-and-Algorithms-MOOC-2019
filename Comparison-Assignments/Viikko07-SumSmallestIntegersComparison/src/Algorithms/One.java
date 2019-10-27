
class One extends Algorithm {

    private int getSmallest(int[] arr) {

        int i_of_smallest = 0;
        int smallest = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
                i_of_smallest = i;
            }
        }
        // This is very LIDL. Pls Fix.
        arr[i_of_smallest] = Integer.MAX_VALUE;
        return smallest;
    }

    private int countSumOfKSmallestIntegers(int[] arr, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += getSmallest(arr);
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
