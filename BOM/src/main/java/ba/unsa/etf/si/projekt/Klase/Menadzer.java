package ba.unsa.etf.si.projekt.Klase;

public class Menadzer extends Osoba {
	private String pozicija;
	private Ovlasti ovlasti;
	public String getPozicija() {
		return pozicija;
	}
	public void setPozicija(String pozicija) {
		this.pozicija = pozicija;
	}
	public Ovlasti getOvlasti() {
		return ovlasti;
	}
	public void setOvlasti(Ovlasti ovlasti) {
		this.ovlasti = ovlasti;
	}
	
}
