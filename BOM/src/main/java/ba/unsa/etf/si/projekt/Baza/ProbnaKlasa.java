package ba.unsa.etf.si.projekt.Baza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Transaction;
import org.hibernate.Session;

import ba.unsa.etf.si.projekt.Util.HibernateUtil;
import ba.unsa.etf.si.projekt.Klase.*;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.*;

public class ProbnaKlasa {
	
	public static void main(String[] args) {
		KompanijaFacade kf = new KompanijaFacade();
		//kf.dodajMenadzera("Hamo2", "Hamic", "+36", "Dzinina", "a@a.a", "menadzer", Ovlasti.upravljanjeSastavnicama);
		ArrayList<Osoba> _a = (ArrayList<Osoba>) kf.listaOsoba(TipOsobe.menadzer);
		for(int i = 0; i < _a.size(); i++) {
			System.out.println(((Menadzer)_a.get(i)).getId());
		}
	}

}
