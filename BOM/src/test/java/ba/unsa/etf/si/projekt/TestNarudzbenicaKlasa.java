package ba.unsa.etf.si.projekt;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.projekt.Klase.Klijent;
import ba.unsa.etf.si.projekt.Klase.Menadzer;
import ba.unsa.etf.si.projekt.Klase.Narudzbenica;
import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Radnik;
import ba.unsa.etf.si.projekt.Klase.StavkaNarudzbenice;
import ba.unsa.etf.si.projekt.Klase.TipMaterijala;

public class TestNarudzbenicaKlasa {

	@Test
	public void testNarudzbenicaKonstruktor() {
		Narudzbenica n = new Narudzbenica();
		assertNotNull(n);
	}
	
	@Test
	public void testNarudzbenicaKonstruktor2() {
		try {
			String pattern = "MM/dd/yyyy";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
		    Date datumKreiranja = format.parse("12/31/2013");
		    List<StavkaNarudzbenice> st = null;
		   	Klijent k = new Klijent();
		   	Menadzer m = new Menadzer();
			Narudzbenica n = new Narudzbenica(st,k, datumKreiranja, m, "N9565");
			assertEquals(datumKreiranja, n.getDatumKreiranja());
			assertEquals(st, n.getStav_nar());
			assertNotNull(n);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
