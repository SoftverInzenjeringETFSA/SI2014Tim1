package ba.unsa.etf.si.projekt.ServisnaImplementacija;

import java.util.ArrayList;
import java.util.List;

import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Menadzer;
import ba.unsa.etf.si.projekt.Klase.Narudzbenica;
import ba.unsa.etf.si.projekt.Klase.Proizvod;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;
import ba.unsa.etf.si.projekt.ServisniInterfejs.ISkladisteFacade;

public class SkladisteFacade implements ISkladisteFacade {
	
		// materijali
	
		public List<Materijal> returnListaMaterijala()
		{
			return new ArrayList<Materijal>();
		}
		
		public Boolean dodajMaterijal(Materijal materijal)
		{
			return true;
		}
		
		public Boolean obrišiMaterijal(Materijal materijal)
		{
			return true;
		}
		
		public Boolean izmijeniMaterijal(Materijal materijal)
		{
			return true;
		}
		
		public Materijal pretragaMaterijala(String serijskiBroj)
		{
			return new Materijal();
		}
		
		// proizvodi
		
		public List<Proizvod> returnListaProizvoda()
		{
			return new ArrayList<Proizvod>();
		}
		
		public Boolean dodajProizvod(Proizvod proizvod)
		{
			return true;
		}
		
		public Boolean obrišiProizvod(Proizvod proizvod)
		{
			return true;
		}
		
		public Boolean izmijeniProizvod(Proizvod proizvod)
		{
			return true;
		}
		
		public Proizvod pretragaProizvoda(String id)
		{
			return new Proizvod();
		}
		
		// narudzbenice
		
		public List<Narudzbenica> returnListaNarudzbenica()
		{
			return new ArrayList<Narudzbenica>();
		}
		
		public Boolean dodajNarudzbenicu(Narudzbenica narudzbenica)
		{
			return true;
		}
		
		public Boolean obrišiNarudzbenicu(Narudzbenica narudzbenica)
		{
			return true;
		}
		
		public Boolean izmijeniNarudzbenicu(Narudzbenica narudzbenica)
		{
			return true;
		}
		
		public Narudzbenica pretragaNarudzbenica(String id)
		{
			return new Narudzbenica();
		}
		
		// sastavnice
		
		public List<Sastavnica> returnListaSastavnica()
		{
			return new ArrayList<Sastavnica>();
		}
		
		public Boolean dodajSastavnicu(Sastavnica sastavnica)
		{
			return true;
		}
		
		public Boolean obrišiSastavnicu(Sastavnica sastavnica)
		{
			return true;
		}
		
		public Boolean izmijeniSastavnicu(Sastavnica sastavnica)
		{
			return true;
		}
		
		public Sastavnica pretragaSastavnica(String id)
		{
			return new Sastavnica();
		}
		
				
		public List<Menadzer> returnListaMenadzera()
		{
			return new ArrayList<Menadzer>();
		}

}
