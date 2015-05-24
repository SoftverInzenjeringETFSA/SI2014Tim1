package ba.unsa.etf.si.projekt;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import ba.unsa.etf.si.projekt.Klase.*;
public class TestTest extends TestCase {

	@Test
	public void testRadnik() {
		Radnik r = new Radnik();
		assertNotNull(r);
	}
	public void testRadnikPodaci() {
		Ovlasti o = Ovlasti.modifikacijaMaterijala;
		try
		{
			Radnik r = new Radnik("ime","prezime","061radnik", "adresa", "email", "pozicija", o, "user", "pass", "jmbg");
			assertEquals(r.getIme(), "ime");
			assertEquals(r.getPassword(), "pass");
			assertEquals(r.getPrezime(), "prezime");
			assertEquals(r.getNivoOvlasti(), o);
		}
		catch (Exception e){
			System.out.println("Nesto ne valja");
		}
	}

}
