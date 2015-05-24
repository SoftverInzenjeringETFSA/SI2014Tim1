package ba.unsa.etf.si.projekt;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

import ba.unsa.etf.si.projekt.Klase.*;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.SkladisteFacade;

public class TestSkladisteFacadeSastavnica extends TestCase{

	SkladisteFacade sf = new SkladisteFacade();
	
	@Test	
	public void testReturnListaSastavnica () {
		try {
				int size= sf.returnListaSastavnica().size();
				Sastavnica s = new Sastavnica();
				s.setNaziv("sastavnica 1");
				s.setSerijskiBroj("S732");
				Sastavnica s1 = new Sastavnica();
				sf.dodajSastavnicu(s);
				sf.dodajSastavnicu(s1);
				ArrayList<Sastavnica> list = new ArrayList<Sastavnica>();
				list.add(s);
				list.add(s1);
				size = size + list.size();
				assertEquals(size,sf.returnListaSastavnica().size());
			}
		catch (Exception e) {
			System.out.println("Exception");
		}
	}
	
	@Test
	public void testListaSastavnicaNijePrazna() {
		try {
			Sastavnica s = new Sastavnica();
			sf.dodajSastavnicu(s);
			int size = sf.returnListaSastavnica().size();
			assertTrue(size > 0);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testDodavanjeSastavnica() {
		try {
			int size=sf.returnListaSastavnica().size();
			Sastavnica s = new Sastavnica ();
			s.setSerijskiBroj("S001");
			s.setDodatniTroskovi(87);
			sf.dodajSastavnicu(s);
			assertEquals((size+1),sf.returnListaSastavnica().size());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testDodavanjeSastavnica2() {
		try {
			Sastavnica s = new Sastavnica();
			s.setSerijskiBroj("S55");
			Boolean r = sf.dodajSastavnicu(s);
			assertTrue(r);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testBrisanjeSastavnica() {
		try {
			Sastavnica s = new Sastavnica();
			Sastavnica s1 = new Sastavnica();
			sf.dodajSastavnicu(s);
			sf.dodajSastavnicu(s1);
			int size = sf.returnListaSastavnica().size();
			sf.obrišiSastavnicu(s1);
			assertEquals((size-1), sf.returnListaSastavnica().size());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testBrisanjeSastavnica2() {
		try {
			Sastavnica s = new Sastavnica();
			sf.dodajSastavnicu(s);
			Boolean r = sf.obrišiSastavnicu(s);
			assertTrue(r);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testIzmjenaSastavnica() {
		try {
			Sastavnica s = new Sastavnica();
			s.setSerijskiBroj("S201");
			sf.dodajSastavnicu(s);
			s.setSerijskiBroj("S222");
			sf.izmijeniSastavnicu(s);
			assertEquals(s.getSerijskiBroj(),"S222");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testPretragaSastavnicaPoSerijskomBroju() {
		try {
			Sastavnica s = new Sastavnica();
			s.setSerijskiBroj("S1132");
			sf.dodajSastavnicu(s);
			Sastavnica s1 = sf.pretragaSastavnica("S1132");
			assertEquals("S1132", s1.getSerijskiBroj());		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	} 

}
