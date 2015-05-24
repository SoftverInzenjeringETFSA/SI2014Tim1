package ba.unsa.etf.si.projekt;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import ba.unsa.etf.si.projekt.Klase.Kategorija;
import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Radnik;
import ba.unsa.etf.si.projekt.Klase.TipMaterijala;
import java.text.SimpleDateFormat;

public class TestMaterijalKlasa {

	@Test
	public void testMaterijalKonstruktor() {
		Materijal m = new Materijal();
		assertNotNull(m);
	}
	
	@Test
	public void testMaterijalKonstruktor2() {
		try {
			String pattern = "MM/dd/yyyy";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
		    Date datumNabavke = format.parse("12/31/2013");
		    Date datumIsteka = format.parse("10/02/2016");
			TipMaterijala tm = TipMaterijala.proizvod;
			Kategorija k = Kategorija.metal;
			Radnik r = new Radnik();
			Materijal m = new Materijal("M997","opis materijala", 56.87, 10, tm, 78, datumNabavke, k, 85, datumIsteka, r, "kg");
			assertEquals(tm, m.getTip());
			assertEquals(datumNabavke, m.getDatumNabavke());
			assertNotNull(m);
			assertNotNull(m.getKreirao());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
