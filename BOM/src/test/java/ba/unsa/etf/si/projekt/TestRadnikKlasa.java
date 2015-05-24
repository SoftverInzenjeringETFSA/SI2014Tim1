package ba.unsa.etf.si.projekt;

import junit.framework.TestCase;

import org.junit.Test;

import ba.unsa.etf.si.projekt.Klase.Ovlasti;
import ba.unsa.etf.si.projekt.Klase.Radnik;

public class TestRadnikKlasa extends TestCase {

	@Test
	public void testRadnik() {
		Radnik r = new Radnik();
		assertNotNull(r);
	}
	
	@Test
	public void testRadnikPodaci() {
		Ovlasti o = Ovlasti.modifikacijaMaterijala;
		try
		{
			Radnik r = new Radnik("ime","prezime","061radnik", "adresa", "email", "pozicija", o, "user", "pass", "jmbg");
			assertEquals(r.getIme(), "ime");
			assertEquals(r.getPassword(), "pass");
			assertEquals(r.getPrezime(), "prezime");
			assertEquals(r.getNivoOvlasti(), o);
			assertNotNull(r);
		}
		catch (Exception e){
			System.out.println("Nesto ne valja");
		}
	}


}
