package ba.unsa.etf.si.projekt.Baza;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Transaction;
import org.hibernate.Session;

import ba.unsa.etf.si.projekt.Util.HibernateUtil;
import ba.unsa.etf.si.projekt.Klase.*;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.*;

public class ProbnaKlasaLejla {
	public static void main (String[] args) {
		KompanijaFacade kf = new KompanijaFacade();
		//System.out.println((String)kf.returnById((long)7, TipOsobe.menadzer).getIme());
		//List<Osoba> _osobe = kf.listaOsoba(TipOsobe.menadzer);
		//Menadzer m = (Menadzer)_osobe.get(0);
		//m.setTipOsobe(TipOsobe.menadzer);
		//kf.obrisiOsobu(m);
		//kf.dodajKlijenta("AbidKlijent", "S", "dsf", "Fds", "d@g.d", null);
		//kf.dodajRadnika("AbidRadnik", "Sakalas", "+654", "Hametko", "asd@sdf.sdf", "mandzer", Ovlasti.kreiranjeIzvjestaja);
	
		Materijal m1 = new Materijal();
		Materijal m = new Materijal();
		m1.setSerijskiBroj("01CC");
		m1.setOpis("opis materijala 2 izmjena");
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
		//m1.setId(10);
		//sf.izmijeniMaterijal(m1);
		//sf.obrišiMaterijal(m1);
	/*	List<Materijal> _materijali = sf.returnListaMaterijala();
		for(int i=0; i<_materijali.size(); i++) {
			System.out.println(_materijali.get(i).getSerijskiBroj());
		}
	*/
		/*Sastavnica p2=new Sastavnica();
		p2 = sf.pretragaSastavnica("00S1");
		if(p2 != null)
			System.out.println(p2.getDatumKreiranja());
		else
			System.out.println("ne valja");
		//sf.dodajMaterijal(m2);
		Radnik r = new Radnik();
		kf.dodajRadnika("radnik", "vatkić", "061/vato", "adresa", "email", "pozicija", null, "user", "sifra");
		
		*/
		List<Materijal> _materijali = sf.sortirajMaterijale(null, "", "materijal_id");
		for(int i=0; i<_materijali.size(); i++) {
			System.out.println(_materijali.get(i).getId());
		}
		
		List<Materijal> _mat = sf.sortirajMaterijale("serijskiBroj ", "005", "materijal_id");
		for(int i=0; i<_mat.size(); i++) {
			System.out.println(_mat.get(i).getId());
		}
	}

}