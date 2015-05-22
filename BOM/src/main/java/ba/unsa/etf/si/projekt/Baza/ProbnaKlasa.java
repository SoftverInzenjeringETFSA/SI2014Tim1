package ba.unsa.etf.si.projekt.Baza;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Transaction;
import org.hibernate.Session;

import ba.unsa.etf.si.projekt.Util.HibernateUtil;
import ba.unsa.etf.si.projekt.Klase.*;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.*;

public class ProbnaKlasa {
	public static void main (String[] args) {
		KompanijaFacade kf = new KompanijaFacade();
		Klijent m = (Klijent)kf.returnByImePrezime("AbidKlijent", "S", TipOsobe.klijent);
		if(m != null) {
			System.out.println(m.getIme() + m.getPrezime() + m.getAdresa());
		}
		m.setAdresa("BBBB");
		kf.mijenjajKlijenta(m);
		Klijent m1 = (Klijent)kf.returnByImePrezime("AbidKlijent", "S", TipOsobe.klijent);
		if(m1 != null) {
			System.out.println(m1.getIme() + m1.getPrezime() + m1.getAdresa());
		}
		//System.out.println((String)kf.returnById((long)7, TipOsobe.menadzer).getIme());
		//List<Osoba> _osobe = kf.listaOsoba(TipOsobe.menadzer);
		//Menadzer m = (Menadzer)_osobe.get(0);
		//m.setTipOsobe(TipOsobe.menadzer);
		//kf.obrisiOsobu(m);
		//kf.dodajKlijenta("AbidKlijent", "S", "dsf", "Fds", "d@g.d", null);
		//kf.dodajRadnika("AbidRadnik", "Sakalas", "+654", "Hametko", "asd@sdf.sdf", "mandzer", Ovlasti.kreiranjeIzvjestaja);
	}

}
