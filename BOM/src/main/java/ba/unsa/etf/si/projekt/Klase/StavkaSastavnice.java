package ba.unsa.etf.si.projekt.Klase;

import javax.persistence.*;

@Entity
public class StavkaSastavnice {
	@Id
	@GeneratedValue
	@Column(name = "stavka_sas")
	private long id;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sastavnica_id") 
	private Sastavnica sastavnica;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "materijal_id") 
	private Materijal materijal;
	private double kolicina;
	
	public StavkaSastavnice()
	{
		
	}
	
	// c
	public StavkaSastavnice(Materijal m, Sastavnica s, double k)
	{
		this.materijal = m;
		this.sastavnica = s;
		this.kolicina = k;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Sastavnica getSastavnica() {
		return sastavnica;
	}
	public void setSastavnica(Sastavnica sastavnica) {
		this.sastavnica = sastavnica;
	}
	public Materijal getMaterijal() {
		return materijal;
	}
	public void setMaterijal(Materijal materijal) {
		this.materijal = materijal;
	}
	public double getKolicina() {
		return kolicina;
	}
	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}
	

}
