package ba.unsa.etf.si.projekt;

import static org.junit.Assert.*;

import org.junit.Test;

import ba.unsa.etf.si.projekt.Klase.Narudzbenica;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;
import ba.unsa.etf.si.projekt.Klase.StavkaNarudzbenice;

public class TestStavkaNarudzbeniceKlasa {

	@Test
	public void testStavkaNarudzbeniceKonstruktor() {
		StavkaNarudzbenice sn = new StavkaNarudzbenice();
		assertNotNull(sn);
	}
	
	@Test
	public void testStavkaNarudzbeniceKonstruktor2() {
		try {
			Sastavnica s = new Sastavnica();
			s.setSerijskiBroj("S321");
			Narudzbenica n = new Narudzbenica();
			StavkaNarudzbenice sn = new StavkaNarudzbenice(s,n,15);
			assertNotNull(sn);
			assertEquals(s, sn.getProizvod());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testStavkaNarudzbeniceKonstruktor3() {
		try {
			Sastavnica s = new Sastavnica();
			s.setSerijskiBroj("S321");
			double k = 158.2;
			StavkaNarudzbenice sn = new StavkaNarudzbenice(s,k);
			assertNotNull(sn);
			assertEquals(s, sn.getProizvod());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
