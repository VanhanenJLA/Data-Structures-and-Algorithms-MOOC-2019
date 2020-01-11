import java.util.*;
 
public class Suunnat {     
    ArrayList<Kaari> tulos = new ArrayList<>();
    boolean virhe;
    
    public Suunnat(int n) {
    }
 
    public void lisaaKaari(int a, int b) {
        if (a == b) virhe = true;
        if (a > b) {int t = a; a = b; b = t;}
        tulos.add(new Kaari(a,b));
    }
    
    public ArrayList<Kaari> muodosta() {
        return virhe ? null : tulos;
    }
 
}