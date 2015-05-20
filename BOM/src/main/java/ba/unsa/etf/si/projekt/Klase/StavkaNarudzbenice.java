package ba.unsa.etf.si.projekt.Klase;

import javax.persistence.*;

@Entity
public class StavkaNarudzbenice {
	@Id
	@GeneratedValue
	@Column(name = "stavka_nar_id")
	private long id;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "narudzbenica_id") 
	private Narudzbenica narudzbenica;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proizvod_id") 
	private Proizvod proizvod;
	private double kolicina;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Narudzbenica getNarudzbenica() {
		return narudzbenica;
	}
	public void setNarudzbenica(Narudzbenica narudzbenica) {
		this.narudzbenica = narudzbenica;
	}
	public Proizvod getProizvod() {
		return proizvod;
	}
	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}
	public double getKolicina() {
		return kolicina;
	}
	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}


}
