
import java.util.*;

public class Tehdas {

    public long laske(int[] machineArr, int target) {

        PriorityQueue<Machine> q = new PriorityQueue<>();
        int produced = 0;

        for (int i : machineArr) {
            q.add(new Machine(i));
        }

        while (true) {
            Machine m = q.poll();
            produced++;

            if (produced >= target) {
                return m.next;
            }

            m.next += m.speed;
            q.add(m);
        }
    }
}

class Machine implements Comparable<Machine> {

    long speed;
    long next;

    public Machine(long time) {
        this.speed = this.next = time;
    }

    @Override
    public int compareTo(Machine o) {
        return next > o.next ? 1 : next < o.next ? -1 : 0;
    }

}
