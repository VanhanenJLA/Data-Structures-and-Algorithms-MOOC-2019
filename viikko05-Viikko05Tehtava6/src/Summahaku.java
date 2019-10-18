
import java.util.*;

public class Summahaku {

    long laske(int[] arr, int sum) {
        HashMap<Long, Long> previousSum = new HashMap<>();
        int n = arr.length;
        long result = 0;
        long currentSum = 0;

        for (int i = 0; i < n; i++) {

            currentSum += arr[i];

            if (currentSum == sum) result++;
            
            if (previousSum.containsKey(currentSum - sum)) 
                result += previousSum.get(currentSum - sum);            

            Long count = previousSum.get(currentSum);
            
            if (count == null) {
                previousSum.put(currentSum, 1L);
            } else {
                previousSum.put(currentSum, count + 1);
            }
        }
        return result;
    }

}
