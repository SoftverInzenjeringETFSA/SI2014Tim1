package ba.unsa.etf.si.projekt;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import ba.unsa.etf.si.projekt.Klase.Klijent;
import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Narudzbenica;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;
import ba.unsa.etf.si.projekt.Klase.StavkaNarudzbenice;
import ba.unsa.etf.si.projekt.Klase.StavkaSastavnice;
import ba.unsa.etf.si.projekt.Klase.TipOsobe;
import ba.unsa.etf.si.projekt.Util.CijenaKalkulator;

public class CijenaKalkulatorTest {
	
	private static Narudzbenica narudzbenica;
	@BeforeClass
	public static void setUpBeforeClass() {
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
		
		Sastavnica s2 = new Sastavnica();
		StavkaSastavnice st4 = new StavkaSastavnice();
		st4.setMaterijal(m1);
		st4.setKolicina(4);
		StavkaSastavnice st5 = new StavkaSastavnice();
		st5.setMaterijal(m3);
		st5.setKolicina(20);
		StavkaSastavnice st6 = new StavkaSastavnice();
		st6.setMaterijal(m4);
		st6.setKolicina(10);
		ArrayList<StavkaSastavnice> stavke2= new ArrayList<StavkaSastavnice>();
		stavke2.add(st4);
		stavke2.add(st5);
		stavke2.add(st6);
		s2.setStavke_sas(stavke2);
		s2.setTrajanjeProizvodnje(6);
		
		Sastavnica s3 = new Sastavnica();
		StavkaSastavnice st7 = new StavkaSastavnice();
		st7.setMaterijal(m2);
		st7.setKolicina(24);
		StavkaSastavnice st8 = new StavkaSastavnice();
		st8.setMaterijal(m3);
		st8.setKolicina(20);
		StavkaSastavnice st9 = new StavkaSastavnice();
		st9.setMaterijal(m4);
		st9.setKolicina(10);
		ArrayList<StavkaSastavnice> stavke3= new ArrayList<StavkaSastavnice>();
		stavke3.add(st7);
		stavke3.add(st8);
		stavke3.add(st9);
		s3.setStavke_sas(stavke3);
		s3.setTrajanjeProizvodnje(6);
		
		StavkaNarudzbenice stn1 = new StavkaNarudzbenice();
		stn1.setProizvod(s1);
		stn1.setKolicina(3);
		
		StavkaNarudzbenice stn2 = new StavkaNarudzbenice();
		stn2.setProizvod(s2);
		stn2.setKolicina(4);
		
		StavkaNarudzbenice stn3 = new StavkaNarudzbenice();
		stn3.setProizvod(s3);
		stn3.setKolicina(1);
		
		ArrayList<StavkaNarudzbenice> stavkeN = new ArrayList<StavkaNarudzbenice>();
		stavkeN.add(stn1);
		stavkeN.add(stn2);
		stavkeN.add(stn3);
		
		narudzbenica.setStav_nar(stavkeN);
	}

	@Test
	public final void testRekalkulisiCijenuSastavnice() {
		
		double cijena = CijenaKalkulator.RekalkulisiCijenuSastavnice(narudzbenica.getStav_nar().get(0).getProizvod());
		
		assertTrue(cijena == 70.0);
	}
	
	@Test
	public final void testRekalkulisiCijenuNarudzbenice() {
		
		double cijena = CijenaKalkulator.RekalkulisiCijenuNarudzbenice(narudzbenica, false);
		
		assertTrue(cijena == 250.0);
	}
	
	@Test
	public final void RekalkulisiTrajanje() {
		
		double cijena = CijenaKalkulator.RekalkulisiTrajanje(narudzbenica);
		
		assertTrue(cijena == 42.0);
	}

}
