package ba.unsa.etf.si.projekt;

import junit.framework.TestCase;

import org.junit.Test;

import ba.unsa.etf.si.projekt.Klase.Klijent;

public class TestKlijentKlasa extends TestCase {

	@Test
	public void testKlijent() {
		Klijent k = new Klijent();
		assertNotNull(k);
	}
	
	@Test
	public void testKlijentPodaci() {
	
		try
		{
			Klijent k = new Klijent("klijent1", "klijentić", "061-555-555", "adresa 1", "klijent1@email", null);
			assertEquals(k.getIme(), "klijent1");
			assertEquals(k.getPrezime(), "klijentić");
			assertNotNull(k);
			assertNull(k.getNarudzbe());
		}
		catch (Exception e){
			System.out.println("Nesto ne valja");
		}
	}
}
