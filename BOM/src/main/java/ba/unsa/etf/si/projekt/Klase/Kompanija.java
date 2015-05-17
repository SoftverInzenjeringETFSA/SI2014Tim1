package ba.unsa.etf.si.projekt.Klase;

import java.util.ArrayList;
import java.util.List;

public class Kompanija {
	private List<Klijent> listaKlijent = new ArrayList<Klijent> ();
	private List<Radnik> listaRadnik = new ArrayList<Radnik> ();
	private List<Menadzer> listaMenadzer = new ArrayList<Menadzer> ();
	private Skladiste skladiste;
	
	public List<Radnik> getListaRadnik() {
		return listaRadnik;
	}

	public void setListaRadnik(List<Radnik> listaRadnik) {
		this.listaRadnik = listaRadnik;
	}

	public List<Menadzer> getListaMenadzer() {
		return listaMenadzer;
	}

	public void setListaMenadzer(List<Menadzer> listaMenadzer) {
		this.listaMenadzer = listaMenadzer;
	}

	public Skladiste getSkladiste() {
		return skladiste;
	}

	public void setSkladiste(Skladiste skladiste) {
		this.skladiste = skladiste;
	}

	public List<Klijent> getListaKlijent() {
		return listaKlijent;
	}

	public void setListaKlijent(List<Klijent> listaKlijent) {
		this.listaKlijent = listaKlijent;
	}
}
