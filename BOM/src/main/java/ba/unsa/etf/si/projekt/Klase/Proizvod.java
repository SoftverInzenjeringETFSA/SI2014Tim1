package ba.unsa.etf.si.projekt.Klase;

import java.util.ArrayList;
import java.util.List;

public class Proizvod {
	private List<Materijal> materijali = new ArrayList<Materijal> ();
	private String naziv;
	private Integer kolicina;
	private String serijskiBroj;

	public List<Materijal> getMaterijali() {
		return materijali;
	}
	public void setMaterijali(List<Materijal> materijali) {
		this.materijali = materijali;
	}
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
}
