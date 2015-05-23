package ba.unsa.etf.si.projekt.Klase;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Materijal {
	@Id
	@GeneratedValue
	@Column(name = "materijal_id")
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String serijskiBroj;
	private String opis;
	private double kolicina;
	private double granicnaKolicina;
	@Enumerated(EnumType.ORDINAL)
	private TipMaterijala tip;
	private double nabavnaCijena;
	private Date datumNabavke;
	@Enumerated(EnumType.ORDINAL)
	private Kategorija kategorija;
	private double prodajnaCijena;
	private Date datumIstekaRoka;
	@ManyToOne(cascade=CascadeType.ALL)
	private Radnik kreirao;
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
	public Radnik getKreirao() {
		return kreirao;
	}
	public void setKreirao(Radnik kreirao) {
		this.kreirao = kreirao;
	}
	public String getMjernaJedinica() {
		return mjernaJedinica;
	}
	public void setMjernaJedinica(String mjernaJedinica) {
		this.mjernaJedinica = mjernaJedinica;
	}
	public double getGranicnaKolicina() {
		return granicnaKolicina;
	}
	public void setGranicnaKolicina(double granicnaKolicina) {
		this.granicnaKolicina = granicnaKolicina;
	}
	
	public Materijal () {}
	
	public Materijal (String serijskiBroj, String opis, double kolicina, double granicnaKolicina, TipMaterijala tip, double nabavnaCijena, Date datumNabavke, Kategorija kategorija, double prodajnaCijena, Date datumIstekaRoka, Radnik kreirao, String mjernaJedinica) {
		this.setSerijskiBroj(serijskiBroj);
		this.setOpis(opis);
		this.setKolicina(kolicina);
		this.setGranicnaKolicina(granicnaKolicina);
		this.setTip(tip);
		this.setNabavnaCijena(nabavnaCijena);
		this.setDatumNabavke(datumNabavke);
		this.setKategorija(kategorija);
		this.setProdajnaCijena(prodajnaCijena);
		this.setDatumIstekaRoka(datumIstekaRoka);
		this.setKreirao(kreirao);
		this.setMjernaJedinica(mjernaJedinica);
	}
}
