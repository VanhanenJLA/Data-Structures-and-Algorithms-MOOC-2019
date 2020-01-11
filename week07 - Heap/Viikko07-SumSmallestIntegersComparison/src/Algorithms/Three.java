
import java.util.Comparator;
import java.util.PriorityQueue;

class Three extends Algorithm {

    private int countSumOfKSmallestIntegers(int[] arr, int k) {
        PriorityQueue<Integer> q
                = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i : arr) {
            q.add(i);
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += q.poll();
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
