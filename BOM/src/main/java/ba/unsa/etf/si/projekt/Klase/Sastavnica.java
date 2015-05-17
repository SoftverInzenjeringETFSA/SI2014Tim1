package ba.unsa.etf.si.projekt.Klase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sastavnica {
	private List<Materijal> materijali = new ArrayList<Materijal> ();
	private Menadzer izdao;
	private String serijskiBroj;
	private double otpad;
	private Date datumKreiranja;
	private double trajanjeProizvodnje;
	private double cijenaObavljenogRada;
	private double dodatniTroskovi;
	
	public List<Materijal> getMaterijali() {
		return materijali;
	}
	public void setMaterijali(List<Materijal> materijali) {
		this.materijali = materijali;
	}
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
}
