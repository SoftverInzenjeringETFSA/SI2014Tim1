package ba.unsa.etf.si.projekt;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import ba.unsa.etf.si.projekt.Klase.Klijent;
import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Narudzbenica;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;
import ba.unsa.etf.si.projekt.Klase.StavkaNarudzbenice;
import ba.unsa.etf.si.projekt.Klase.StavkaSastavnice;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.SkladisteFacade;

public class SkladisteFacadeNarudzbenicaTest {
	
	private static SkladisteFacade sf;
	private static Narudzbenica narudzbenica;
	@BeforeClass
	public static void setUpBeforeClass() {
		sf = new SkladisteFacade();
		
		Materijal m = new Materijal();		
		m.setId(1);
		m.setProdajnaCijena(5);
		
		Materijal m1 = new Materijal();
		m1.setId(2);
		m1.setProdajnaCijena(7);
		
		Materijal m2 = new Materijal();
		m2.setId(3);
		m2.setProdajnaCijena(3);
		
		Materijal m3 = new Materijal();
		m3.setId(4);
		m3.setProdajnaCijena(2);
		
		Materijal m4 = new Materijal();
		m4.setId(5);
		m.setProdajnaCijena(4);
		
		narudzbenica = new Narudzbenica();
		
		Klijent k = new Klijent();
		k.setId(1);
		k.setIme("This");
		
		narudzbenica.setKlijent(k);
		
		Sastavnica s1 = new Sastavnica();
		StavkaSastavnice st1 = new StavkaSastavnice();
		st1.setMaterijal(m);
		st1.setKolicina(5);
		StavkaSastavnice st2 = new StavkaSastavnice();
		st2.setMaterijal(m2);
		st2.setKolicina(10);
		StavkaSastavnice st3 = new StavkaSastavnice();
		st3.setMaterijal(m3);
		st3.setKolicina(10);
		ArrayList<StavkaSastavnice> stavke1= new ArrayList<StavkaSastavnice>();
		stavke1.add(st1);
		stavke1.add(st2);
		stavke1.add(st3);
		s1.setStavke_sas(stavke1);
		s1.setTrajanjeProizvodnje(4);
		
		sf.dodajSastavnicu(s1);
			
		StavkaNarudzbenice stn1 = new StavkaNarudzbenice();
		stn1.setProizvod(s1);
		stn1.setKolicina(3);
		
		
		ArrayList<StavkaNarudzbenice> stavkeN = new ArrayList<StavkaNarudzbenice>();
		stavkeN.add(stn1);
		
		narudzbenica.setStav_nar(stavkeN);
		
		Boolean result = sf.dodajNarudzbenicu(narudzbenica);
	}

	@Test
	public final void testReturnListaNarudzbenicaNotNull() {
		List<Narudzbenica> lista = sf.returnListaNarudzbenica();
		assertNotNull(lista);
	}
	
	@Test
	public final void testReturnListaNarudzbenicaNotEmpty() {
		List<Narudzbenica> lista = sf.returnListaNarudzbenica();
		assertTrue(lista.size() > 0);
	}
	
	@Test
	public final void testDodajNarudzbenicu() {
		Boolean result = sf.dodajNarudzbenicu(narudzbenica);
		
		assertTrue(result);
	}

	@Test
	public final void testObrišiNarudzbenicu() {
		narudzbenica.setSerijskiBroj("fs");
		sf.dodajNarudzbenicu(narudzbenica);;
		Narudzbenica n = sf.pretragaNarudzbenica("fs");
		
		Boolean result = sf.obrišiNarudzbenicu(n);
		assertTrue(result);
	}

	@Test
	public final void testIzmijeniNarudzbenicu() {
		narudzbenica.setSerijskiBroj("aaa123");
		Boolean result = sf.izmijeniNarudzbenicu(narudzbenica);
		
		assertTrue(result);
	}

	@Test
	public final void testPretragaNarudzbenica() {
		narudzbenica.setSerijskiBroj("test123");
		sf.dodajNarudzbenicu(narudzbenica);;
		Narudzbenica n = sf.pretragaNarudzbenica("test123");
		
		assertNotNull(n);
	}
	
	@Test
	public void testSortiranjeNarudzbenica() {
		try {
			Narudzbenica n = new Narudzbenica();
			Narudzbenica n1 = new Narudzbenica();
			n.setSerijskiBroj("N11");
			n1.setSerijskiBroj("N11");
			sf.dodajNarudzbenicu(n);
			sf.dodajNarudzbenicu(n1);
			sf.sortirajNarudzbenice("serijskiBroj", "N11", "narudzbenica_id");
			long id1 = n.getId();
			long id2 = n1.getId();
			assertTrue(id1<id2);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	//(expected=Exception.class)
	public void testSortNarudzbenicaParametri() {
		try {
			List<Narudzbenica> l = sf.sortirajNarudzbenice(null, "nesto", null);		
			assertNull(l);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	//(expected=Exception.class)
	public void testSortNarudzbenicaParametri2() {
		try {
			List<Narudzbenica> l = sf.sortirajNarudzbenice("nesto", null, null);		
			assertNull(l);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	//(expected=Exception.class)
	public void testSortNarudzbenicaParametri3() {
		try {
			List<Narudzbenica> l, l1, l2, l3;
			l = sf.sortirajNarudzbenice("nesto", "nesto", null);		
			assertNotNull(l);
			l1 = sf.sortirajNarudzbenice("nesto", "nesto", "nesto");
			assertNotNull(l1);
			l2 = sf.sortirajNarudzbenice(null, null, null);
			assertNotNull(l2);
			l3 = sf.sortirajNarudzbenice(null, null, "nesto");
			assertNotNull(l3);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
