import java.util.*;
 
public class MontaPolkua {     
    public ArrayList<Kaari> muodosta(int x) {
        ArrayList<Kaari> kaaret = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            kaaret.add(new Kaari(i+1,i+2,1));
            kaaret.add(new Kaari(i+1,i+2,1));
            if ((x&(1<<i)) != 0) kaaret.add(new Kaari(i+1,100,666-i));
        }
        return kaaret;
    }
}