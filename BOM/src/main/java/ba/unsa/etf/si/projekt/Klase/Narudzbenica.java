package ba.unsa.etf.si.projekt.Klase;

import java.util.Date;

public class Narudzbenica {
	private Proizvod proizvod;
	private Klijent klijent;
	private Date datumKreiranja;
	private Menadzer odgovornoLice;
	private String serijskiBroj;
	
	public Proizvod getProizvod() {
		return proizvod;
	}
	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}
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
}
