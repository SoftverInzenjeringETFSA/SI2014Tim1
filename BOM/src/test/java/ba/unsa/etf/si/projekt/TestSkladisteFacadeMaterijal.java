package ba.unsa.etf.si.projekt;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.SkladisteFacade;
import ba.unsa.etf.si.projekt.Util.HibernateUtil;

public class TestSkladisteFacadeMaterijal extends TestCase {

	SkladisteFacade sf = new SkladisteFacade();
	
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
	public void testBrisanjeMaterijala() {
		try {
			Materijal m = new Materijal();
			Materijal m1 = new Materijal();
			sf.dodajMaterijal(m);
			sf.dodajMaterijal(m1);
			int size = sf.returnListaMaterijala().size();
			sf.obrišiMaterijal(m1);
			assertEquals((size-1), sf.returnListaMaterijala().size());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testBrisanjeMaterijala2() {
		try {
			Materijal m = new Materijal();
			sf.dodajMaterijal(m);
			Boolean r = sf.obrišiMaterijal(m);
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
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
