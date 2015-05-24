package ba.unsa.etf.si.projekt;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

import ba.unsa.etf.si.projekt.Klase.Proizvod;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.SkladisteFacade;

public class TestSkladisteFacadeProizvod extends TestCase {
	SkladisteFacade sf = new SkladisteFacade();
	
	@Test	
	public void testReturnListaProizvoda () {
		try {
				int size= sf.returnListaProizvoda().size();
				Proizvod p = new Proizvod();
				p.setKolicina(24);
				p.setNaziv("Proizvod A");
				p.setSerijskiBroj("P032");
				Proizvod p1 = new Proizvod();
				sf.dodajProizvod(p);
				sf.dodajProizvod(p1);
				ArrayList<Proizvod> list = new ArrayList<Proizvod>();
				list.add(p);
				list.add(p1);
				size = size + list.size();
				assertEquals(size,sf.returnListaProizvoda().size());
			}
		catch (Exception e) {
			System.out.println("Exception");
		}
	}
	
	@Test
	public void testListaProizvodaNijePrazna() {
		try {
			Proizvod p = new Proizvod();
			sf.dodajProizvod(p);
			int size = sf.returnListaProizvoda().size();
			assertTrue(size > 0);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testDodavanjeProizvoda() {
		try {
			int size=sf.returnListaProizvoda().size();
			
			Proizvod p = new Proizvod ();
			p.setSerijskiBroj("P001");
			p.setKolicina(451);
			sf.dodajProizvod(p);
			assertEquals((size+1),sf.returnListaProizvoda().size());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testDodavanjeProizvoda2() {
		try {
			Proizvod p = new Proizvod();
			p.setSerijskiBroj("P55");
			Boolean r = sf.dodajProizvod(p);
			assertTrue(r);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testBrisanjeProizvoda() {
		try {
			Proizvod p = new Proizvod();
			Proizvod p1 = new Proizvod();
			sf.dodajProizvod(p);
			sf.dodajProizvod(p1);
			int size = sf.returnListaProizvoda().size();
			sf.obrišiProizvod(p1);
			assertEquals((size-1), sf.returnListaProizvoda().size());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testBrisanjeProizvoda2() {
		try {
			Proizvod p = new Proizvod();
			sf.dodajProizvod(p);
			Boolean r = sf.obrišiProizvod(p);
			assertTrue(r);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void testIzmjenaProizvoda() {
		try {
			Proizvod p = new Proizvod();
			p.setSerijskiBroj("P201");
			sf.dodajProizvod(p);
			p.setSerijskiBroj("P222");
			sf.izmijeniProizvod(p);
			assertEquals(p.getSerijskiBroj(),"P222");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testPretragaProizvodaPoSerijskomBroju() {
		try {
			Proizvod p = new Proizvod();
			p.setSerijskiBroj("P1132");
			sf.dodajProizvod(p);
			Proizvod p1 = sf.pretragaProizvoda("P1132");
			assertEquals("P1132", p1.getSerijskiBroj());		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
