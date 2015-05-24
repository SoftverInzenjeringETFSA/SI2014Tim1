package ba.unsa.etf.si.projekt;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.projekt.Klase.Radnik;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;
import ba.unsa.etf.si.projekt.Klase.StavkaSastavnice;

import java.text.SimpleDateFormat;
public class TestSastavnicaKlasa {

	@Test
	public void testSastavnicaKonstruktor() {
		Sastavnica s = new Sastavnica();
		assertNotNull(s);
	}
	
	@Test
	public void testSastavnicaKonstruktor2() {
		try {
			String pattern = "MM/dd/yyyy";
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			Date datum = format.parse("05/31/2014");
			List<StavkaSastavnice> ss = null;
			Radnik r = new Radnik();
			Sastavnica s = new Sastavnica(ss, r, "S547", datum, 54, 12, 22, 45, "sastavnica1");;
			assertEquals("S547", s.getSerijskiBroj());
			assertNotNull(s);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
