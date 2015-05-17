package ba.unsa.etf.si.projekt.ServisniInterfejs;

import java.util.List;

import ba.unsa.etf.si.projekt.Klase.*;

public interface IKompanijaFacade {
	
	// vraća sve osobe koje su tipa prosljeđenog parametra TipOsobe
	public List<Osoba> listaOsoba(TipOsobe tip);
	
	// vraća osobu po prosljeđenom parametru ID
	public Osoba returnById(String id);
	
	// vraća osobu po prosljeđenom parametru ime
	public Osoba returnByIme(String ime);
	
	// kreira i dodaje novog klijenta
	public Boolean dodajKlijenta(String ime, String prezime, String brojTelefona, String adresa, String email, Narudzbenica narudzba);
	
	// kreira i dodaje novog radnika
	public Boolean dodajRadnika(String ime, String prezime, String brojTelefona, String adresa, String email, String pozicija, Ovlasti nivoOvlasti);
	
	// kreira i dodaje novog menadzera
	public Boolean dodajMenadzera(String ime, String prezime, String brojTelefona, String adresa, String email, String pozicija, Ovlasti nivoOvlasti);
	
	// brise osobu prosljeđenu kao parametar
	public Boolean obrisiOsobu(Osoba osoba);
}
