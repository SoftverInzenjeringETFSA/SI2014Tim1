package ba.unsa.etf.si.projekt;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;
import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Menadzer;
import ba.unsa.etf.si.projekt.Klase.ObrisaniMaterijal;
import java.text.SimpleDateFormat;

public class TestObrisaniMaterijalKlasa {

	@Test
	public void testObrisaniMaterijalKonstruktor1() {
			ObrisaniMaterijal om = new ObrisaniMaterijal();
			assertNotNull(om);
			}
	
	@Test
	public void testObrisaniMaterijalKonstruktor2() {
		try {
			Materijal m = new Materijal();
			String pattern = "MM/dd/yyyy";
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			Date datumBrisanja = format.parse("12/31/2013");
			Menadzer men = new Menadzer();			
			ObrisaniMaterijal om = new ObrisaniMaterijal(m,datumBrisanja,"brisalomise",men);
			assertEquals("brisalomise", om.getRazlogBrisanja());
			assertNotNull(om);
			assertEquals(datumBrisanja, om.getDatumBrisanja());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
