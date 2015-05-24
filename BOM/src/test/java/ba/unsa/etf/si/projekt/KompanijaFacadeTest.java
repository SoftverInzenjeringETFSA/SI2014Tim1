package ba.unsa.etf.si.projekt;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ba.unsa.etf.si.projekt.Klase.*;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.KompanijaFacade;

public class KompanijaFacadeTest {
	
	private static KompanijaFacade kf;
	
	// initialize
	@BeforeClass public static void initialize() {
		kf = new KompanijaFacade();
		kf.dodajMenadzera("ime", "prezime", "broj", "adresa", "email", "poz", Ovlasti.brisanjeMaterijala, "moze", "ne moze", "jmbg");
		kf.dodajKlijenta("test", "test", "0995234", "Adresa 12", "F", null);
		kf.dodajRadnika("testni", "testni", "225", "adresa", "a@b.c", "b", Ovlasti.unosMaterijala, "a", "b", "42342");
		
		kf.dodajMenadzera("rese", "rve", "broj", "adresa", "email", "poz", Ovlasti.brisanjeMaterijala, "moze", "ne moze", "jmbg");
		kf.dodajKlijenta("rezervni", "r", "0995234", "Adresa 12", "F", null);
		kf.dodajRadnika("za", "brisat", "225", "adresa", "a@b.c", "b", Ovlasti.unosMaterijala, "a", "b", "42342");
	}
	
	// tests
	@Test
	public final void testListaOsoba() {
		List<Osoba> listaOsoba = kf.listaOsoba(TipOsobe.menadzer);		
		assertNotNull(listaOsoba);		
	}
	
	@Test
	public final void testListaOsobaNotEmpty() {
		KompanijaFacade kf = new KompanijaFacade();
		
		List<Osoba> listaOsoba = kf.listaOsoba(TipOsobe.menadzer);
		
		assertTrue(listaOsoba.size() > 0);
	}
	
	
	@Test
	public final void testReturnMenadzerById() {
		Menadzer m = (Menadzer)kf.returnById(1, TipOsobe.menadzer);
		
		assertNotNull(m);
	}

	@Test
	public final void testReturnMenadzerByImePrezime() {
		Menadzer m = (Menadzer)kf.returnByImePrezime("ime", "prezime", TipOsobe.menadzer);
		
		assertNotNull(m);
	}

	@Test
	public final void testDodajKlijenta() {
		Boolean result = kf.dodajKlijenta("Meho", "Mehic", "0995234", "Adresa 12", "F", null);
		
		assertTrue(result);
	}

	@Test
	public final void testDodajRadnika() {
		Boolean result = kf.dodajRadnika("a", "b", "225", "adresa", "a@b.c", "b", Ovlasti.unosMaterijala, "a", "b", "42342");
		assertTrue(result);
	}

	@Test
	public final void testDodajMenadzera() {
		Boolean result = kf.dodajMenadzera("ime", "prezime", "broj", "adresa", "email", "poz", Ovlasti.brisanjeMaterijala, "moze", "ne moze", "jmbg");
		assertTrue(result);
	}

	@Test
	public final void testMijenjajKlijenta() {
		Klijent k = (Klijent)kf.returnById(1, TipOsobe.klijent);
		k.setIme("nestonovo");
		kf.mijenjajKlijenta(k);
		Klijent nk = (Klijent)kf.returnById(1, TipOsobe.klijent);
		assertEquals(nk.getIme(), "nestonovo");
	}

	@Test
	public final void testMijenjajRadnika() {
		Radnik r = (Radnik)kf.returnById(1, TipOsobe.radnik);
		r.setIme("nestonovo");
		kf.mijenjajRadnika(r);
		Radnik nr = (Radnik)kf.returnById(1, TipOsobe.radnik);
		assertEquals(nr.getIme(), "nestonovo");
	}

	@Test
	public final void testMijenjajMenadzera() {
		Menadzer m = (Menadzer)kf.returnById(1, TipOsobe.menadzer);
		m.setIme("nestonovo");
		kf.mijenjajMenadzera(m);
		Menadzer nm = (Menadzer)kf.returnById(1, TipOsobe.menadzer);
		assertEquals(nm.getIme(), "nestonovo");
	}

	@Test
	public final void testObrisiOsobu() {
		kf.dodajMenadzera("novi", "novi", "broj", "adresa", "email", "poz", Ovlasti.brisanjeMaterijala, "men", "password", "jmbg");
		Osoba o = kf.returnByImePrezime("novi", "novi", TipOsobe.menadzer);
		Boolean result = kf.obrisiOsobu(o);
	}

	@Test
	public final void testReturnByUsernamePassword() {
		kf.dodajRadnika("za", "passworda", "225", "adresa", "a@b.c", "b", Ovlasti.unosMaterijala, "novi", "pass", "42342");
		Osoba o = kf.returnByUsernamePassword("novi", "pass");
		
		assertNotNull(o);
	}

	@Test
	public final void testDajMenadzeraUsernamePassword() {
		kf.dodajMenadzera("rese", "rve", "broj", "adresa", "email", "poz", Ovlasti.brisanjeMaterijala, "men", "password", "jmbg");
		Osoba o = kf.dajMenadzeraUsernamePassword("men", "password");
		
		assertNotNull(o);
	}
	
	@Test
	public final void testSortirajKlijentaParametri() {
		try {
			List<Klijent> l = kf.sortirajKlijenta(null, "nesto", null);
			assertNull(l);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public final void testSortirajKlijentaParametri2() {
		try {
			List<Klijent> l = kf.sortirajKlijenta("nesto", null, null);
			assertNull(l);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	//(expected=Exception.class)
	public void testSortirajKlijentaParametri3() {
		try {
			List<Klijent> l, l1, l2, l3;
			l = kf.sortirajKlijenta("nesto", "nesto", null);		
			assertNotNull(l);
			l1 = kf.sortirajKlijenta("nesto", "nesto", "nesto");
			assertNotNull(l1);
			l2 = kf.sortirajKlijenta(null, null, null);
			assertNotNull(l2);
			l3 = kf.sortirajKlijenta(null, null, "nesto");
			assertNotNull(l3);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public final void testSortirajRadnikaParametri() {
		try {
			List<Radnik> l = kf.sortirajRadnika(null, "nesto", null);
			assertNull(l);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public final void testSortirajRadnikaParametri2() {
		try {
			List<Radnik> l = kf.sortirajRadnika("nesto", null, null);
			assertNull(l);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	//(expected=Exception.class)
	public void testSortirajRadnikaParametri3() {
		try {
			List<Radnik> l, l1, l2, l3;
			l = kf.sortirajRadnika("nesto", "nesto", null);		
			assertNotNull(l);
			l1 = kf.sortirajRadnika("nesto", "nesto", "nesto");
			assertNotNull(l1);
			l2 = kf.sortirajRadnika(null, null, null);
			assertNotNull(l2);
			l3 = kf.sortirajRadnika(null, null, "nesto");
			assertNotNull(l3);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public final void testSortirajRadnikaParametri() {
		try {
			List<Radnik> l = kf.sortirajRadnika(null, "nesto", null);
			assertNull(l);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public final void testSortirajMenadzeraParametri2() {
		try {
			List<Menadzer> l = kf.sortirajMenadzera("nesto", null, null);
			assertNull(l);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	//(expected=Exception.class)
	public void testSortirajMenadzeraParametri3() {
		try {
			List<Menadzer> l, l1, l2, l3;
			l = kf.sortirajMenadzera("nesto", "nesto", null);		
			assertNotNull(l);
			l1 = kf.sortirajMenadzera("nesto", "nesto", "nesto");
			assertNotNull(l1);
			l2 = kf.sortirajMenadzera(null, null, null);
			assertNotNull(l2);
			l3 = kf.sortirajMenadzera(null, null, "nesto");
			assertNotNull(l3);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
