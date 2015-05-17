package ba.unsa.etf.si.projekt.Klase;

import java.util.ArrayList;
import java.util.List;

public class Skladiste {
	private List<Materijal> listaMaterijala = new ArrayList<Materijal> ();
	private List<Menadzer> menadzeri = new ArrayList<Menadzer> ();
	private List<Narudzbenica> listaNarudzbenica = new ArrayList<Narudzbenica> ();
	private List<Sastavnica> listaSpremljenihSastavnica = new ArrayList<Sastavnica> ();
	private List<Proizvod> listaProizvoda = new ArrayList<Proizvod> ();
	private List<Radnik> listaRadnika = new ArrayList<Radnik> ();
	
	public List<Materijal> getListaMaterijala() {
		return listaMaterijala;
	}
	public void setListaMaterijala(List<Materijal> listaMaterijala) {
		this.listaMaterijala = listaMaterijala;
	}
	public List<Menadzer> getMenadzeri() {
		return menadzeri;
	}
	public void setMenadzeri(List<Menadzer> menadzeri) {
		this.menadzeri = menadzeri;
	}
	public List<Narudzbenica> getListaNarudzbenica() {
		return listaNarudzbenica;
	}
	public void setListaNarudzbenica(List<Narudzbenica> listaNarudzbenica) {
		this.listaNarudzbenica = listaNarudzbenica;
	}
	public List<Sastavnica> getListaSpremljenihSastavnica() {
		return listaSpremljenihSastavnica;
	}
	public void setListaSpremljenihSastavnica(
			List<Sastavnica> listaSpremljenihSastavnica) {
		this.listaSpremljenihSastavnica = listaSpremljenihSastavnica;
	}
	public List<Proizvod> getListaProizvoda() {
		return listaProizvoda;
	}
	public void setListaProizvoda(List<Proizvod> listaProizvoda) {
		this.listaProizvoda = listaProizvoda;
	}
	public List<Radnik> getListaRadnika() {
		return listaRadnika;
	}
	public void setListaRadnika(List<Radnik> listaRadnika) {
		this.listaRadnika = listaRadnika;
	}
}
