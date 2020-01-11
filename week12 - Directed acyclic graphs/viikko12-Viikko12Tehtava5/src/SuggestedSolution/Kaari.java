public class Kaari {
    int alku; // mistä solmusta kaari alkaa
    int loppu; // mihin solmuun kaari päättyy
    
    public Kaari(int alku, int loppu) {
        this.alku = alku;
        this.loppu = loppu;
    }
    
    public String toString() {
        return "("+alku+","+loppu+")";
    }
}