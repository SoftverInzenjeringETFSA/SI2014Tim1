package ba.unsa.etf.si.projekt.Klase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Menadzer extends Osoba {
	@Id
	@GeneratedValue
	@Column(name = "menadzer_id")
	private long id;
	private String pozicija;
	@Enumerated(EnumType.ORDINAL)
	private Ovlasti ovlasti;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	
	public Menadzer() {}
	
	public Menadzer(String ime, String prezime, String brojTelefona, String adresa, String email, String pozicija, Ovlasti nivoOvlasti) {
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setBrojTelefona(brojTelefona);
		this.setAdresa(adresa);
		this.setEmail(email);
		this.setPozicija(pozicija);
		this.setOvlasti(nivoOvlasti);
	}
	
}
