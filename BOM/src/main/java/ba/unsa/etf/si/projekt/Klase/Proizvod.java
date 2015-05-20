package ba.unsa.etf.si.projekt.Klase;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Proizvod {
	@Id
	@GeneratedValue
	@Column(name = "proizvod_id")
	private long id;
	
	/*@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ProizvodMaterijaliPrelaz", joinColumns = { @JoinColumn(name = "proizvod_id") }
	, inverseJoinColumns = { @JoinColumn(name = "materijal_id") })*/
	@OneToMany(mappedBy = "proizvod")
	private List<ProizvodMaterijalPrelaz> pmp;
	
	public List<ProizvodMaterijalPrelaz> getPmp() {
		return pmp;
	}
	public void setPmp(List<ProizvodMaterijalPrelaz> pmp) {
		this.pmp = pmp;
	}
	//private List<Materijal> materijali;
	private String naziv;
	private Integer kolicina;
	private String serijskiBroj;

	/*public List<Materijal> getMaterijali() {
		return materijali;
	}
	public void setMaterijali(List<Materijal> materijali) {
		this.materijali = materijali;
	}*/
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Integer getKolicina() {
		return kolicina;
	}
	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}
	public String getSerijskiBroj() {
		return serijskiBroj;
	}
	public void setSerijskiBroj(String serijskiBroj) {
		this.serijskiBroj = serijskiBroj;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
