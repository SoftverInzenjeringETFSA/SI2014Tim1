package ba.unsa.etf.si.projekt.Klase;

import java.util.Date;

public class Materijal {
	private String serijskiBroj;
	private String opis;
	private double kolicina;
	private TipMaterijala tip;
	private double nabavnaCijena;
	private Date datumNabavke;
	private Kategorija kategorija;
	private double prodajnaCijena;
	private Date datumIstekaRoka;
	private Osoba kreirao;
	private String mjernaJedinica;
	
	public String getSerijskiBroj() {
		return serijskiBroj;
	}
	public void setSerijskiBroj(String serijskiBroj) {
		this.serijskiBroj = serijskiBroj;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public double getKolicina() {
		return kolicina;
	}
	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}
	public TipMaterijala getTip() {
		return tip;
	}
	public void setTip(TipMaterijala tip) {
		this.tip = tip;
	}
	public double getNabavnaCijena() {
		return nabavnaCijena;
	}
	public void setNabavnaCijena(double nabavnaCijena) {
		this.nabavnaCijena = nabavnaCijena;
	}
	public Date getDatumNabavke() {
		return datumNabavke;
	}
	public void setDatumNabavke(Date datumNabavke) {
		this.datumNabavke = datumNabavke;
	}
	public Kategorija getKategorija() {
		return kategorija;
	}
	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}
	public double getProdajnaCijena() {
		return prodajnaCijena;
	}
	public void setProdajnaCijena(double prodajnaCijena) {
		this.prodajnaCijena = prodajnaCijena;
	}
	public Date getDatumIstekaRoka() {
		return datumIstekaRoka;
	}
	public void setDatumIstekaRoka(Date datumIstekaRoka) {
		this.datumIstekaRoka = datumIstekaRoka;
	}
	public Osoba getKreirao() {
		return kreirao;
	}
	public void setKreirao(Osoba kreirao) {
		this.kreirao = kreirao;
	}
	public String getMjernaJedinica() {
		return mjernaJedinica;
	}
	public void setMjernaJedinica(String mjernaJedinica) {
		this.mjernaJedinica = mjernaJedinica;
	}
}
