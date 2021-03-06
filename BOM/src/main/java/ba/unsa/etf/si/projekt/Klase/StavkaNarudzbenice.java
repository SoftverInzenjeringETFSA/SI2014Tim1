package ba.unsa.etf.si.projekt.Klase;

import javax.persistence.*;

@Entity
public class StavkaNarudzbenice {
	@Id
	@GeneratedValue
	@Column(name = "stavka_nar_id")
	private long id;
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "narudzbenica_id") 
	private Narudzbenica narudzbenica;
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "sastavnica_id") 
	private Sastavnica proizvod;
	private double kolicina;
	
	
	// c
	public StavkaNarudzbenice()
	{
		
	}
	
	public StavkaNarudzbenice(Sastavnica s, Narudzbenica n, double k)
	{
		this.proizvod = s;
		this.narudzbenica = n;
		this.kolicina = k;
	}
	
	public StavkaNarudzbenice(Sastavnica s, double k)
	{
		this.proizvod = s;
		this.kolicina = k;
	}
	
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
	public Sastavnica getProizvod() {
		return proizvod;
	}
	public void setProizvod(Sastavnica proizvod) {
		this.proizvod = proizvod;
	}
	public double getKolicina() {
		return kolicina;
	}
	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}


}
