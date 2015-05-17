package ba.unsa.etf.si.projekt.ServisnaImplementacija;

import java.util.ArrayList;
import java.util.List;

import ba.unsa.etf.si.projekt.Klase.Narudzbenica;
import ba.unsa.etf.si.projekt.Klase.Osoba;
import ba.unsa.etf.si.projekt.Klase.Ovlasti;
import ba.unsa.etf.si.projekt.Klase.TipOsobe;
import ba.unsa.etf.si.projekt.ServisniInterfejs.*;

public class KompanijaFacade implements IKompanijaFacade {
	
		public List<Osoba> listaOsoba(TipOsobe tip)
		{
			return new ArrayList<Osoba>();
		}
		
		public Osoba returnById(String id) 
		{
			return new Osoba();
		}
		
		public Osoba returnByIme(String ime)
		{
			return new Osoba();
		}
		
		public Boolean dodajKlijenta(String ime, String prezime, String brojTelefona, String adresa, String email, Narudzbenica narudzba)
		{
			return true;
		}
		
		public Boolean dodajRadnika(String ime, String prezime, String brojTelefona, String adresa, String email, String pozicija, Ovlasti nivoOvlasti)
		{
			return true;
		}
		
		public Boolean dodajMenadzera(String ime, String prezime, String brojTelefona, String adresa, String email, String pozicija, Ovlasti nivoOvlasti)
		{
			return true;
		}
		
		public Boolean obrisiOsobu(Osoba osoba)
		{
			return true;
		}

}
