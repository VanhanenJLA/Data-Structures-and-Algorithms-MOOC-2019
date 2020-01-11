

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArrayList<Algorithm> algorithms = new ArrayList<>();
        algorithms.add(new One());
        algorithms.add(new Two());
        algorithms.add(new Three());

        System.out.println("############## ROUND ONE #################");
        Benchmarker.k = 100;
        algorithms.forEach((a) -> {
            Benchmarker.benchmark(a);
        });

        System.out.println("############## ROUND TWO #################");
        Benchmarker.k = 400;
        algorithms.forEach((a) -> {
            Benchmarker.benchmark(a);
        });

        System.out.println("############## ROUND THREE ###############");
        algorithms.remove(0);
        Benchmarker.k = 99999999;
        algorithms.forEach((a) -> {
            Benchmarker.benchmark(a);
        });

    }

}
