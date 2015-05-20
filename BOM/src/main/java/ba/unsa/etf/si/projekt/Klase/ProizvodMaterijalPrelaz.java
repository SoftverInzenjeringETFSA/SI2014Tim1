package ba.unsa.etf.si.projekt.Klase;

import javax.persistence.*;

@Entity
public class ProizvodMaterijalPrelaz {
	@Id
	@GeneratedValue
	@Column(name = "pr_mat_id")
	private long id;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proizvod_id") 
	private Proizvod proizvod;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "materijal_id") 
	private Materijal materijal;
	private double kolicina;
	public double getKolicina() {
		return kolicina;
	}
	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Proizvod getProizvod() {
		return proizvod;
	}
	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}
	public Materijal getMaterijal() {
		return materijal;
	}
	public void setMaterijal(Materijal materijal) {
		this.materijal = materijal;
	}


}
