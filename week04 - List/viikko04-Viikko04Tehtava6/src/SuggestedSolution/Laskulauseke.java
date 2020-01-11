public class Laskulauseke {
    public long laske(String s) {
        if (s.contains("(")) {
            int alku = s.lastIndexOf("(");
            int loppu = s.indexOf(")",alku);
            return laske(s.substring(0,alku) +
                         laske(s.substring(alku+1,loppu)) +
                         s.substring(loppu+1));
        } else if (s.contains("+")) {
            String[] osat = s.split("\\+");
            long tulos = 0;
            for (String osa : osat) {
                tulos += laske(osa);
            }
            return tulos;
        } else if (s.contains("*")) {
            String[] osat = s.split("\\*");
            long tulos = 1;
            for (String osa : osat) {
                tulos *= Long.parseLong(osa);
            }
            return tulos;
        } else {
            return Long.parseLong(s);
        }
    }
}