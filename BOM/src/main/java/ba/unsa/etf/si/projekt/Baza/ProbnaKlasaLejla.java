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
		/*List<Materijal> _materijali = sf.sortirajMaterijale(" ", " ", "kolicina");
		for(int i=0; i<_materijali.size(); i++) {
			System.out.println(_materijali.get(i).getKolicina());
		}*/
		
		 
		/*List<Menadzer> _k = kf.sortirajMenadzera(" ", " ", "brojTelefona ");
		for(int i=0; i<_k.size(); i++) {
			System.out.println(_k.get(i).getPrezime()+ " " + _k.get(i).getIme());
		}*/
		/*
		List<Narudzbenica> _n = sf.sortirajNarudzbenice(" ", " ", " serijskiBroj");
		for(int i=0; i<_n.size(); i++) {
			System.out.println(_n.get(i).getId() + " " +_n.get(i).getSerijskiBroj() + " " + _n.get(i).getDatumKreiranja());
		}		
		*/
		/*
		List<Sastavnica> _s = sf.sortirajSastavnice("serijskiBroj ", "0S112", " datumKreiranja");
		for(int i=0; i<_s.size(); i++) {
			System.out.println(_s.get(i).getId() + " " +_s.get(i).getSerijskiBroj() + " " + _s.get(i).getDatumKreiranja());
		}*/
		/*
		List<Klijent> _k = kf.sortirajKlijenta(" ", " ", " ");
		for(int i=0; i<_k.size(); i++) {
			System.out.println(_k.get(i).getPrezime()+ " " + _k.get(i).getIme());
		}
		*/
	/*	List<Osoba> ls = kf.listaOsoba(TipOsobe.menadzer);
		if(ls != null) {
			System.out.println(ls.size());
		}
		Menadzer mgr = (Menadzer) ls.get(1);
		List<Materijal> lm = sf.returnListaMaterijala();
		if(lm != null) {
			Materijal mat = lm.get(19);
			System.out.println(mat.getId());
			if(mat != null) {
				System.out.println(sf.obrišiMaterijal(mat, mgr));
				//System.out.println(m.getId());
			}
		}
		*/
		/*List<Materijal> _materijali = sf.sortirajMaterijale(" ", " ", "opis");
		if(!(_materijali.isEmpty()))
		for(int i=0; i<_materijali.size(); i++) {
			
			System.out.println(_materijali.get(i).getOpis());
			
		}
		else System.out.println("prazno"); */
	}
	

}