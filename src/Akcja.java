public class Akcja {

    private final String nazwaAkcji;
    private final String skrotAkcji;
    private final double kursAkcji;

    public Akcja(String na, String sa, double ka) {
        nazwaAkcji = na;
        skrotAkcji = sa;
        kursAkcji = ka;
    }

    public String getNazwaAkcji() {
        return nazwaAkcji;
    }

    public String getSkrotAkcji() {
        return skrotAkcji;
    }

    public double getKursAkcji() {
        return kursAkcji;
    }

}
