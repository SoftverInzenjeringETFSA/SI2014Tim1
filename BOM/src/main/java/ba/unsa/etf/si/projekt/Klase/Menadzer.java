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
	private String username;
	private String password;
	private String JMBG;
	public String getJMBG() {
		return JMBG;
	}
	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}
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
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Menadzer() {}
	
	public Menadzer(String ime, String prezime, String brojTelefona, String adresa, String email, String pozicija, Ovlasti nivoOvlasti, String username, String password, String JMBG) {
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setBrojTelefona(brojTelefona);
		this.setAdresa(adresa);
		this.setEmail(email);
		this.setPozicija(pozicija);
		this.setOvlasti(nivoOvlasti);
		this.setTipOsobe(TipOsobe.menadzer);
		this.setUsername(username);
		this.setPassword(password);
		this.setJMBG(JMBG);
	}
	
}
