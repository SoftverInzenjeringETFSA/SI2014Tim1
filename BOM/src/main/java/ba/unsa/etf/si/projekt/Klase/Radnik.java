package ba.unsa.etf.si.projekt.Klase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Radnik extends Osoba {
	@Id
	@GeneratedValue
	@Column(name = "radnik_id")
	private long id;
	private String pozicija;
	@Enumerated(EnumType.ORDINAL) 
	private Ovlasti nivoOvlasti;
	private String username;
	private String password;
	private String JMBG;
	public String getJMBG() {
		return JMBG;
	}
	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Radnik() {}
	
	public Radnik(String ime, String prezime, String brojTelefona, String adresa, String email, String pozicija, Ovlasti nivoOvlasti, String username, String password, String JMBG) {
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setBrojTelefona(brojTelefona);
		this.setAdresa(adresa);
		this.setEmail(email);
		this.setPozicija(pozicija);
		this.setNivoOvlasti(nivoOvlasti);
		this.setUsername(username);
		this.setPassword(password);
		this.setJMBG(JMBG);
	}
}
