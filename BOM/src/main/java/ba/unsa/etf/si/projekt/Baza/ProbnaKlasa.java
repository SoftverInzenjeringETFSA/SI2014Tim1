package ba.unsa.etf.si.projekt.Baza;
import java.util.Scanner;
import org.hibernate.Transaction;
import org.hibernate.Session;
import ba.unsa.etf.si.projekt.Util.HibernateUtil;
import ba.unsa.etf.si.projekt.Klase.*;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.*;

public class ProbnaKlasa {
	public static void main (String[] args) {
		Materijal m1 = new Materijal();
		Materijal m = new Materijal();
		m1.setSerijskiBroj("01CC");
		m1.setOpis("opis materijala 2");
		m1.setKolicina(15.654);
		m1.setTip(TipMaterijala.proizvod);
		m1.setNabavnaCijena(86.20);
		m.setSerijskiBroj("000");
		m.setOpis("opis materij11aa");
		m.setKolicina(75.654);
		m.setTip(TipMaterijala.poluproizvod);
		m.setNabavnaCijena(26.20);
		SkladisteFacade sf=new SkladisteFacade();
		//sf.dodajMaterijal(m1);
		//sf.dodajMaterijal(m);
		m.setId(1);
		sf.izmijeniMaterijal(m);
	}

}
