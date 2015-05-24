package ba.unsa.etf.si.projekt;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import ba.unsa.etf.si.projekt.Klase.Klijent;
import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Narudzbenica;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;
import ba.unsa.etf.si.projekt.Klase.StavkaNarudzbenice;
import ba.unsa.etf.si.projekt.Klase.StavkaSastavnice;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.SkladisteFacade;

public class SkladisteFacadeNarudzbenicaTest {
	
	private static SkladisteFacade sf;
	private static Narudzbenica narudzbenica;
	@BeforeClass
	public static void setUpBeforeClass() {
		sf = new SkladisteFacade();
		
		Materijal m = new Materijal();		
		m.setId(1);
		m.setProdajnaCijena(5);
		
		Materijal m1 = new Materijal();
		m1.setId(2);
		m1.setProdajnaCijena(7);
		
		Materijal m2 = new Materijal();
		m2.setId(3);
		m2.setProdajnaCijena(3);
		
		Materijal m3 = new Materijal();
		m3.setId(4);
		m3.setProdajnaCijena(2);
		
		Materijal m4 = new Materijal();
		m4.setId(5);
		m.setProdajnaCijena(4);
		
		narudzbenica = new Narudzbenica();
		
		Klijent k = new Klijent();
		k.setId(1);
		k.setIme("This");
		
		narudzbenica.setKlijent(k);
		
		Sastavnica s1 = new Sastavnica();
		StavkaSastavnice st1 = new StavkaSastavnice();
		st1.setMaterijal(m);
		st1.setKolicina(5);
		StavkaSastavnice st2 = new StavkaSastavnice();
		st2.setMaterijal(m2);
		st2.setKolicina(10);
		StavkaSastavnice st3 = new StavkaSastavnice();
		st3.setMaterijal(m3);
		st3.setKolicina(10);
		ArrayList<StavkaSastavnice> stavke1= new ArrayList<StavkaSastavnice>();
		stavke1.add(st1);
		stavke1.add(st2);
		stavke1.add(st3);
		s1.setStavke_sas(stavke1);
		s1.setTrajanjeProizvodnje(4);
		
		sf.dodajSastavnicu(s1);
			
		StavkaNarudzbenice stn1 = new StavkaNarudzbenice();
		stn1.setProizvod(s1);
		stn1.setKolicina(3);
		
		
		ArrayList<StavkaNarudzbenice> stavkeN = new ArrayList<StavkaNarudzbenice>();
		stavkeN.add(stn1);
		
		narudzbenica.setStav_nar(stavkeN);
		
		Boolean result = sf.dodajNarudzbenicu(narudzbenica);
	}

	@Test
	public final void testReturnListaNarudzbenicaNotNull() {
		List<Narudzbenica> lista = sf.returnListaNarudzbenica();
		assertNotNull(lista);
	}
	
	@Test
	public final void testReturnListaNarudzbenicaNotEmpty() {
		List<Narudzbenica> lista = sf.returnListaNarudzbenica();
		assertTrue(lista.size() > 0);
	}
	
	@Test
	public final void testDodajNarudzbenicu() {
		Boolean result = sf.dodajNarudzbenicu(narudzbenica);
		
		assertTrue(result);
	}

	@Test
	public final void testObrišiNarudzbenicu() {
		narudzbenica.setSerijskiBroj("test123");
		sf.dodajNarudzbenicu(narudzbenica);;
		Narudzbenica n = sf.pretragaNarudzbenica("test123");
		
		Boolean result = sf.obrišiNarudzbenicu(n);
		assertTrue(result);
	}

	@Test
	public final void testIzmijeniNarudzbenicu() {
		narudzbenica.setSerijskiBroj("aaa123");
		Boolean result = sf.izmijeniNarudzbenicu(narudzbenica);
		
		assertTrue(result);
	}

	@Test
	public final void testPretragaNarudzbenica() {
		narudzbenica.setSerijskiBroj("test123");
		sf.dodajNarudzbenicu(narudzbenica);;
		Narudzbenica n = sf.pretragaNarudzbenica("test123");
		
		assertNotNull(n);
	}

}
