public class Akcja {

	private String nazwaAkcji;
	private String skrotAkcji;
	private String waluta;
	private double kursAkcji;

	public Akcja(String na, String sa, String wa, double ka) {
		nazwaAkcji = na;
		skrotAkcji = sa;
		waluta = wa;
		kursAkcji = ka;

	}

	public String getNazwaAkcji() {
		return nazwaAkcji;
	}

	public String getSkrotAkcji() {
		return skrotAkcji;
	}

	public String getWaluta() {
		return waluta;
	}

	public double getKursAkcji() {
		return kursAkcji;
	}

}
