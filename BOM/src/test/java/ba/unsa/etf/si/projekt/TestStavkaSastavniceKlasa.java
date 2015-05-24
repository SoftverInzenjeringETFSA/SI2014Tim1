package ba.unsa.etf.si.projekt;

import static org.junit.Assert.*;

import org.junit.Test;

import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;
import ba.unsa.etf.si.projekt.Klase.StavkaSastavnice;

public class TestStavkaSastavniceKlasa {

	@Test
	public void testStavkaSastavniceKonstruktor() {
		StavkaSastavnice ss = new StavkaSastavnice();
		assertNotNull(ss);
	}
	
	@Test
	public void testStavkaSastavniceKonstruktor2() {
		try {
			Materijal m = new Materijal();
			m.setSerijskiBroj("M454");
			Sastavnica s = new Sastavnica();
			s.setSerijskiBroj("S778");
			StavkaSastavnice ss = new StavkaSastavnice(m,s,89.4);
			assertEquals(m, ss.getMaterijal());
			assertNotNull(ss);
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
