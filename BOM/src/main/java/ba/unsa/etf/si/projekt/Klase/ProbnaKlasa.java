package ba.unsa.etf.si.projekt.Klase;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


// Komentar
@Entity
public class ProbnaKlasa {
	@Id
	@GeneratedValue
	private long id;
	private String naziv;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
}
