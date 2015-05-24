package ba.unsa.etf.si.projekt;

import static org.junit.Assert.*;

import org.junit.Test;

import ba.unsa.etf.si.projekt.Klase.Sastavnica;

public class TestSastavnicaKlasa {

	@Test
	public void testSastavnicaKonstruktor() {
		Sastavnica s = new Sastavnica();
		assertNotNull(s);
	}

}
