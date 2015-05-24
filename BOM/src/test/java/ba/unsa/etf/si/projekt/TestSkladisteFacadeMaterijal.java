package ba.unsa.etf.si.projekt;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Menadzer;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.KompanijaFacade;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.SkladisteFacade;

public class TestSkladisteFacadeMaterijal extends TestCase {

	SkladisteFacade sf = new SkladisteFacade();
	KompanijaFacade kf = new KompanijaFacade();
	
	@Test
	public void testReturnListaMaterijala() {
		try {
			int size= sf.returnListaMaterijala().size();
			Materijal m = new Materijal();
			Materijal m1 = new Materijal();
			sf.dodajMaterijal(m);
			sf.dodajMaterijal(m1);
			ArrayList<Materijal> list = new ArrayList<Materijal>();
			list.add(m);
			list.add(m1);
			size = size + list.size();
			assertEquals(size,sf.returnListaMaterijala().size());
			}
		catch (Exception e) {
			System.out.println("Exception");
		}
	}
	
	@Test
	public void testListaMaterijalaNijePrazna() {
		try {
			Materijal m = new Materijal();
			sf.dodajMaterijal(m);
			int size = sf.returnListaMaterijala().size();
			assertTrue(size > 0);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test 
	public void testDodavanjeMaterijala() {
		try {
			int size=sf.returnListaMaterijala().size();
			
			Materijal m = new Materijal ();
			m.setId(2);
			m.setSerijskiBroj("M001");
			m.setKolicina(451);
			sf.dodajMaterijal(m);
			assertEquals((size+1),sf.returnListaMaterijala().size());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testDodavanjeMaterijala2() {
		try {
			Materijal m = new Materijal();
			m.setSerijskiBroj("M55");
			Boolean r = sf.dodajMaterijal(m);
			assertTrue(r);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	@Test
	public void testBrisanjeMaterijala2() {
		try {
			Materijal m = new Materijal();
			Menadzer men = new Menadzer("ime", "prezime", "061-225-883", "adresa", "email@email.com", "pozicija", null, "user", "pass", "2501985154213");
			sf.dodajMaterijal(m);
			Boolean r = sf.obrišiMaterijal(m, men);
			assertTrue(r);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testIzmjenaMaterijala() {
		try {
			Materijal m = new Materijal();
			m.setSerijskiBroj("M201");
			sf.dodajMaterijal(m);
			m.setSerijskiBroj("M222");
			sf.izmijeniMaterijal(m);
			assertEquals(m.getSerijskiBroj(),"M222");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testPretragaMaterijalaPoSerijskomBroju() {
		try {
			Materijal m = new Materijal();
			m.setSerijskiBroj("M1132");
			sf.dodajMaterijal(m);
			Materijal m1 = sf.pretragaMaterijala("M1132");
			assertEquals("M1132", m1.getSerijskiBroj());		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testSortiranjeMaterijala() {
		try {
			Materijal m = new Materijal();
			Materijal m1 = new Materijal();
			m.setSerijskiBroj("M11");
			m1.setSerijskiBroj("M11");
			m.setKolicina(25.47);
			m1.setKolicina(1);
			sf.dodajMaterijal(m);
			sf.dodajMaterijal(m1);
			sf.sortirajMaterijale("serijskiBroj", "M11", "materijal_id");
			long id1 = m.getId();
			long id2 = m1.getId();
			assertTrue(id1<id2);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	//(expected=Exception.class)
	public void testSortMaterijalaParametri() {
		try {
			List<Materijal> l = sf.sortirajMaterijale(null, "nesto", null);		
			assertNull(l);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	//(expected=Exception.class)
	public void testSortMaterijalaParametri2() {
		try {
			List<Materijal> l = sf.sortirajMaterijale("nesto", null, null);		
			assertNull(l);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	//(expected=Exception.class)
	public void testSortMaterijalaParametri3() {
		try {
			List<Materijal> l, l1, l2, l3;
			l = sf.sortirajMaterijale("nesto", "nesto", null);		
			assertNotNull(l);
			l1 = sf.sortirajMaterijale("nesto", "nesto", "nesto");
			assertNotNull(l1);
			l2 = sf.sortirajMaterijale(null, null, null);
			assertNotNull(l2);
			l3 = sf.sortirajMaterijale(null, null, "nesto");
			assertNotNull(l3);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
