package ba.unsa.etf.si.projekt.ServisniInterfejs;

import java.util.List;

import ba.unsa.etf.si.projekt.Klase.*;

public interface IKompanijaFacade {
	
	// vraća sve osobe koje su tipa prosljeđenog parametra TipOsobe
	public List<Osoba> listaOsoba(TipOsobe tip);
	
	// vraća osobu po prosljeđenom parametru ID
	public Osoba returnById(long id, TipOsobe tip);
	
	// vraća osobu po prosljeđenom parametru ime
	public Osoba returnByImePrezime(String ime, String Prezime, TipOsobe tip);
	
	// kreira i dodaje novog klijenta
	public Boolean dodajKlijenta(String ime, String prezime, String brojTelefona, String adresa, String email, List<Narudzbenica> narudzbe);
	
	// kreira i dodaje novog radnika
	public Boolean dodajRadnika(String ime, String prezime, String brojTelefona, String adresa, String email, String pozicija, Ovlasti nivoOvlasti, String username, String password, String JMBG);
	
	// kreira i dodaje novog menadzera
	public Boolean dodajMenadzera(String ime, String prezime, String brojTelefona, String adresa, String email, String pozicija, Ovlasti nivoOvlasti, String username, String password, String JMBG);
	
	//mijenja klijenta
	public Boolean mijenjajKlijenta(Klijent k);
	
	//mijenja radnika
	public Boolean mijenjajRadnika(Radnik r);
	
	//mijenja radnika
	public Boolean mijenjajMenadzera(Menadzer m);
	
	// brise osobu prosljeđenu kao parametar
	public Boolean obrisiOsobu(Osoba osoba);
	
	//vraca osobu za login
	public Osoba returnByUsernamePassword(String username, String password);
	
	public Osoba dajMenadzeraUsernamePassword(String username, String password);

}
