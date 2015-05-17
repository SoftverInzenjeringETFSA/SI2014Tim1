package ba.unsa.etf.si.projekt.Klase;

public class Radnik extends Osoba {
	private String pozicija;
	private Ovlasti nivoOvlasti;
	public String getPozicija() {
		return pozicija;
	}
	public void setPozicija(String pozicija) {
		this.pozicija = pozicija;
	}
	public Ovlasti getNivoOvlasti() {
		return nivoOvlasti;
	}
	public void setNivoOvlasti(Ovlasti nivoOvlasti) {
		this.nivoOvlasti = nivoOvlasti;
	}
}
