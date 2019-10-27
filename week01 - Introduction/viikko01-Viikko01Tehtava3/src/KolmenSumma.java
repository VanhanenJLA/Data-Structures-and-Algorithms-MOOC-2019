
public class KolmenSumma {

    int laske(int luku) {

        int count = 0;

        for (int x = 1; x <= luku; x++) {
            for (int y = x + 1; y <= luku; y++) {
                for (int z = y + 1; z < luku; z++) {
                    if (x + y + z == luku) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
