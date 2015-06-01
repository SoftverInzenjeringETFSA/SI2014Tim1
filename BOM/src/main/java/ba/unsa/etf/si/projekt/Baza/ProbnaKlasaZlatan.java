package ba.unsa.etf.si.projekt.Baza;
import java.util.List;

import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Menadzer;
import ba.unsa.etf.si.projekt.Klase.Osoba;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;
import ba.unsa.etf.si.projekt.Klase.TipOsobe;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.KompanijaFacade;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.SkladisteFacade;

public class ProbnaKlasaZlatan {
	public static void main (String[] args) {
		KompanijaFacade kf = new KompanijaFacade();
		SkladisteFacade sf = new SkladisteFacade();
		Sastavnica ls = sf.pretragaSastavnica("SAS001");
		if(ls != null)
			System.out.println(sf.obrišiSastavnicu(ls));
	}

}