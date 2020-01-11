
import java.util.*;

public class Kierrokset {

    public ArrayList<Kaari> muodosta(int x) {
        ArrayList<Kaari> kaaret = new ArrayList<>();
        for (int i = x - 1; i >= 1; i--) {
            kaaret.add(new Kaari(i, i + 1, 1));
        }
        return kaaret;
    }

}
