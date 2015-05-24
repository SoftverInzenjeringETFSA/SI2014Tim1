package ba.unsa.etf.si.projekt.Klase;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Narudzbenica {
	@Id
	@GeneratedValue
	@Column(name = "narudzbenica_id")
	private long id;
	
	
	/*@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "StavkaNarudzbenice", joinColumns = { @JoinColumn(name = "narudzbenica_id") }
	, inverseJoinColumns = { @JoinColumn(name = "proizvod_id") })*/
	
	//private List<Proizvod> proizvodi;
	@OneToMany(mappedBy = "narudzbenica", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<StavkaNarudzbenice> stav_nar;
	
	public List<StavkaNarudzbenice> getStav_nar() {
		return stav_nar;
	}
	public void setStav_nar(List<StavkaNarudzbenice> stav_nar) {
		this.stav_nar = stav_nar;
	}
	@ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "klijent")
	private Klijent klijent;
	
	private Date datumKreiranja;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Menadzer odgovornoLice;
	private String serijskiBroj;
	
	/*public List<Proizvod> getProizvodi() {
		return proizvodi;
	}
	public void setProizvodi(List<Proizvod> proizvodi) {
		this.proizvodi = proizvodi;
	}*/
	public Klijent getKlijent() {
		return klijent;
	}
	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}
	public Date getDatumKreiranja() {
		return datumKreiranja;
	}
	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}
	public Menadzer getOdgovornoLice() {
		return odgovornoLice;
	}
	public void setOdgovornoLice(Menadzer odgovornoLice) {
		this.odgovornoLice = odgovornoLice;
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
	
	public Narudzbenica () {}
	
	public Narudzbenica(List<StavkaNarudzbenice> stav_nar, Klijent klijent, Date datumKreiranja, Menadzer menadzer, String serijskiBroj) {
		this.setStav_nar(stav_nar);
		this.setKlijent(klijent);
		this.setDatumKreiranja(datumKreiranja);
		this.setOdgovornoLice(menadzer);
		this.setSerijskiBroj(serijskiBroj);
	}
}
