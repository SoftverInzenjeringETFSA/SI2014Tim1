package ba.unsa.etf.si.projekt.ServisniInterfejs;

import java.util.List;

import ba.unsa.etf.si.projekt.Klase.*;

public interface ISkladisteFacade {
	
	// materijali
	public List<Materijal> returnListaMaterijala();
	
	public Boolean dodajMaterijal(Materijal materijal);
	
	public Boolean obrišiMaterijal(Materijal materijal, Menadzer menadzer);
	
	public Boolean izmijeniMaterijal(Materijal materijal);
	
	public Materijal pretragaMaterijala(String serijskiBroj);
	
	// proizvodi
	
	public List<Proizvod> returnListaProizvoda();
	
	public Boolean dodajProizvod(Proizvod proizvod);
	
	public Boolean obrišiProizvod(Proizvod proizvod);
	
	public Boolean izmijeniProizvod(Proizvod proizvod);
	
	public Proizvod pretragaProizvoda(String id);
	
	// narudzbenice
	
	public List<Narudzbenica> returnListaNarudzbenica();
	
	public Boolean dodajNarudzbenicu(Narudzbenica narudzbenica);
	
	public Boolean obrišiNarudzbenicu(Narudzbenica narudzbenica);
	
	public Boolean izmijeniNarudzbenicu(Narudzbenica narudzbenica);
	
	public Narudzbenica pretragaNarudzbenica(String id);
	
	// sastavnice
	
	public List<Sastavnica> returnListaSastavnica();
	
	public Boolean dodajSastavnicu(Sastavnica sastavnica);
	
	public Boolean obrišiSastavnicu(Sastavnica sastavnica);
	
	public Boolean izmijeniSastavnicu(Sastavnica sastavnica);
	
	public Sastavnica pretragaSastavnica(String id);
	
	
	
	public List<Menadzer> returnListaMenadzera();
	
	
	public Boolean validirajNarudzbenicu(Narudzbenica narudzbenica);
	

}
