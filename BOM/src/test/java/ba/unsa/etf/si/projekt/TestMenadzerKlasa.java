package ba.unsa.etf.si.projekt;

import static org.junit.Assert.*;

import org.junit.Test;

import ba.unsa.etf.si.projekt.Klase.Menadzer;
import ba.unsa.etf.si.projekt.Klase.Ovlasti;

public class TestMenadzerKlasa {

	@Test
	public void testMenadzerKonstruktor() {
		Menadzer m = new Menadzer();
		assertNotNull(m);
	}
	
	@Test
	public void testMenadzerKonstruktor2() {
		try {
			Ovlasti ovlast = Ovlasti.kreiranjeIzvjestaja;
			Menadzer m = new Menadzer("menadzer1", "menadzerić", "061/menadzer", "menadzerska 5", "menadzer@email", "pozicija", ovlast, "user", "pass", "jmbg");
			assertEquals("menadzer1", m.getIme());
			assertEquals(ovlast, m.getOvlasti());
			assertNotNull(m);
			assertNotNull(m.getId());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
