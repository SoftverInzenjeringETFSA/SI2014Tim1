package ba.unsa.etf.si.projekt.Klase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sastavnica {
	@Id
	@GeneratedValue
	@Column(name = "sastavnica_id")
	private long id;
	
	/*@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "StavkaSastavnice", joinColumns = { @JoinColumn(name = "sastavnica_id") }
	, inverseJoinColumns = { @JoinColumn(name = "materijal_id") })*/
	//private List<Materijal> materijali;
	@OneToMany(mappedBy = "sastavnica", fetch = FetchType.EAGER)
	private List<StavkaSastavnice> stavke_sas;
	
	public List<StavkaSastavnice> getStavke_sas() {
		return stavke_sas;
	}
	public void setStavke_sas(List<StavkaSastavnice> stavke_sas) {
		this.stavke_sas = stavke_sas;
	}
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Menadzer izdao;
	private String serijskiBroj;
	private double otpad;
	private Date datumKreiranja;
	private double trajanjeProizvodnje;
	private double cijenaObavljenogRada;
	private double dodatniTroskovi;
	private double ukupnaCijena;
	private String naziv;
	
	
	//c
	public Sastavnica()
	{
		this.stavke_sas = new ArrayList<StavkaSastavnice>();
	}
	
	public Sastavnica(List<StavkaSastavnice> stavke, Menadzer m, String sb, Date dk, double tp, double co, double dt, double uc, String naziv)
	{
		this.stavke_sas = stavke;
		this.izdao = m;
		this.serijskiBroj = sb;
		this.datumKreiranja = dk;
		this.trajanjeProizvodnje = tp;
		this.cijenaObavljenogRada = co;
		this.dodatniTroskovi = dt;
		this.ukupnaCijena = uc;
		this.naziv = naziv;		
	}
	
	
	public double getUkupnaCijena() {
		return ukupnaCijena;
	}
	public void setUkupnaCijena(double ukupnaCijena) {
		this.ukupnaCijena = ukupnaCijena;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	/*
	public List<Materijal> getMaterijali() {
		return materijali;
	}
	public void setMaterijali(List<Materijal> materijali) {
		this.materijali = materijali;
	}*/
	public Menadzer getIzdao() {
		return izdao;
	}
	public void setIzdao(Menadzer izdao) {
		this.izdao = izdao;
	}
	public String getSerijskiBroj() {
		return serijskiBroj;
	}
	public void setSerijskiBroj(String serijskiBroj) {
		this.serijskiBroj = serijskiBroj;
	}
	public double getOtpad() {
		return otpad;
	}
	public void setOtpad(double otpad) {
		this.otpad = otpad;
	}
	public Date getDatumKreiranja() {
		return datumKreiranja;
	}
	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}
	public double getTrajanjeProizvodnje() {
		return trajanjeProizvodnje;
	}
	public void setTrajanjeProizvodnje(double trajanjeProizvodnje) {
		this.trajanjeProizvodnje = trajanjeProizvodnje;
	}
	public double getCijenaObavljenogRada() {
		return cijenaObavljenogRada;
	}
	public void setCijenaObavljenogRada(double cijenaObavljenogRada) {
		this.cijenaObavljenogRada = cijenaObavljenogRada;
	}
	public double getDodatniTroskovi() {
		return dodatniTroskovi;
	}
	public void setDodatniTroskovi(double dodatniTroskovi) {
		this.dodatniTroskovi = dodatniTroskovi;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
