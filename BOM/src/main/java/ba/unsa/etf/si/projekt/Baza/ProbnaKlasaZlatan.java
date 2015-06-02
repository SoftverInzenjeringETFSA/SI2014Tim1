package ba.unsa.etf.si.projekt.Baza;
import java.util.List;

import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Menadzer;
import ba.unsa.etf.si.projekt.Klase.Osoba;
import ba.unsa.etf.si.projekt.Klase.Ovlasti;
import ba.unsa.etf.si.projekt.Klase.Radnik;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;
import ba.unsa.etf.si.projekt.Klase.TipOsobe;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.KompanijaFacade;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.SkladisteFacade;

public class ProbnaKlasaZlatan {
	public static void main (String[] args) {
		KompanijaFacade kf = new KompanijaFacade();
		SkladisteFacade sf = new SkladisteFacade();
		Sastavnica ls = sf.pretragaSastavnica("SAS001");
		Radnik r = new Radnik();
		r.setAdresa("asadad");
		r.setBrojTelefona("565656565");
		r.setEmail("sdda@dsd.ds");
		r.setIme("Vatko");
		r.setPrezime("Debeli");
		r.setJMBG("2006993150008");
		r.setNivoOvlasti(null);
		r.setTipOsobe(TipOsobe.radnik);
		r.setPassword("sdsdsdsdsd");
		r.setUsername("dbvatko");
		
		
		kf.dodajRadnika(r.getIme(), r.getPrezime(), r.getBrojTelefona(), r.getAdresa(), r.getEmail(), r.getPozicija(), Ovlasti.brisanjeMaterijala, r.getUsername(), r.getPassword(), r.getJMBG());
	}

}