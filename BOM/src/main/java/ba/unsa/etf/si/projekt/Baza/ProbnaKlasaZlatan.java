package ba.unsa.etf.si.projekt.Baza;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Transaction;
import org.hibernate.Session;

import ba.unsa.etf.si.projekt.Util.HibernateUtil;
import ba.unsa.etf.si.projekt.Klase.*;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.*;

public class ProbnaKlasaZlatan {
	public static void main (String[] args) {
		KompanijaFacade kf = new KompanijaFacade();
		kf.dodajMenadzera("Acdfč", "fdsfĆĆĆ", "rf", "fsdf", "dsf", "menadzer", Ovlasti.brisanjeMaterijala, "primjer", "primjer");
		
		/*Osoba a = kf.returnByUsernamePassword("prviradnik", "prviradnik");
		if(a != null) {
			System.out.println(a.getIme());
		}
		else {
			System.out.println("null je");
		}*/
	}

}