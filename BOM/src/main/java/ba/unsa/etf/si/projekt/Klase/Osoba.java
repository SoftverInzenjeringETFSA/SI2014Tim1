package ba.unsa.etf.si.projekt.Klase;

public class Osoba {
	private String ime;
	private String prezime;
	private String brojTelefona;
	private String adresa;
	private String email;
	private String id;//u bazi ce biti integer??
	private TipOsobe tipOsobe;
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getBrojTelefona() {
		return brojTelefona;
	}
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TipOsobe getTipOsobe() {
		return tipOsobe;
	}
	public void setTipOsobe(TipOsobe tipOsobe) {
		this.tipOsobe = tipOsobe;
	}
}
