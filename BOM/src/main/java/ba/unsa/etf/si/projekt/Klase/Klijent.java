package ba.unsa.etf.si.projekt.Klase;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Klijent extends Osoba{
	@Id
	@GeneratedValue
	@Column(name = "klijent_id")
	private long id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "klijent")
	private List<Narudzbenica> narudzbe;

	public List<Narudzbenica> getNarudzbe() {
		return narudzbe;
	}

	public void setNarudzbe(List<Narudzbenica> narudzbe) {
		this.narudzbe = narudzbe;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
