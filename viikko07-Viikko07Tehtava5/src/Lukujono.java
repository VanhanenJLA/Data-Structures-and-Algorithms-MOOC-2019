
import java.util.PriorityQueue;

public class Lukujono {

    PriorityQueue<Long> q;
    int counter;
    long n;

    public long laske(int pos) {
        prep();
        while (counter < pos) {
            n = q.poll();
            while (q.peek() == n) {
                q.poll();
            }
            q.add(2L * n);
            q.add(3L * n);
            q.add(5L * n);
            counter++;
        }
        return n;
    }

    private void prep() {
        counter = 0;
        n = 0;
        q = new PriorityQueue<>();
        q.add(2L);
        q.add(3L);
        q.add(5L);
    }
}
