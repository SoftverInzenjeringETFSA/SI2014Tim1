package ba.unsa.etf.si.projekt.ServisnaImplementacija;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;

import ba.unsa.etf.si.projekt.Util.HibernateUtil;
import ba.unsa.etf.si.projekt.Klase.*;
import ba.unsa.etf.si.projekt.ServisniInterfejs.*;

public class KompanijaFacade implements IKompanijaFacade {
	
		public List<Osoba> listaOsoba(TipOsobe tip)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			List<Osoba> _osobe = null;
			if(tip.equals(TipOsobe.menadzer)) {
				_osobe = session.createCriteria(Menadzer.class).list();
			}
			else if(tip.equals(TipOsobe.klijent)) {
				_osobe = session.createCriteria(Klijent.class).list();
			}
			else if(tip.equals(TipOsobe.radnik)) {
				_osobe = session.createCriteria(Radnik.class).list();
			}
			t.commit();
			session.close();
			return _osobe;
		}
		
		public Osoba returnById(long id, TipOsobe tip) 
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Osoba osoba = null;
			try {
				Transaction t = session.beginTransaction();
				if(tip == TipOsobe.klijent)
					osoba = (Klijent)session.get(Klijent.class, id);
				else if(tip == TipOsobe.radnik)
					osoba = (Radnik)session.get(Radnik.class, id);
				else if(tip == TipOsobe.menadzer)
					osoba = (Menadzer)session.get(Menadzer.class, id);
				t.commit();
				return osoba;
			}
			catch(Exception e) {
				return osoba;
			}
			finally {
				session.close();
			}
		}
		
		public Osoba returnByImePrezime(String ime, String prezime)
		{
			return new Osoba();
		}
		
		public Boolean dodajKlijenta(String ime, String prezime, String brojTelefona, String adresa, String email, List<Narudzbenica> narudzbe)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				Klijent k = new Klijent(ime, prezime, brojTelefona, adresa, email, narudzbe);
				Long id = (Long) session.save(k);
				k.setId(id);
				t.commit();
				return true;
			}
			catch(Exception e) {
				return false;
			}
			finally {
				session.close();
			}
		}
		
		public Boolean dodajRadnika(String ime, String prezime, String brojTelefona, String adresa, String email, String pozicija, Ovlasti nivoOvlasti)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				Radnik m = new Radnik(ime, prezime, brojTelefona, adresa, email, pozicija, nivoOvlasti);
				Long id = (Long) session.save(m);
				m.setId(id);
				t.commit();
				return true;
			}
			catch(Exception e) {
				return false;
			}
			finally {
				session.close();
			}
		}
		
		public Boolean dodajMenadzera(String ime, String prezime, String brojTelefona, String adresa, String email, String pozicija, Ovlasti nivoOvlasti)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				Menadzer m = new Menadzer(ime, prezime, brojTelefona, adresa, email, pozicija, nivoOvlasti);
				Long id = (Long) session.save(m);
				m.setId(id);
				t.commit();
				return true;
			}
			catch(Exception e) {
				return false;
			}
			finally {
				session.close();
			}
			
		}
		
		public Boolean obrisiOsobu(Osoba osoba)
		{
			if(osoba.getTipOsobe() == TipOsobe.klijent)
				osoba = (Klijent) osoba;
			else if(osoba.getTipOsobe() == TipOsobe.radnik)
				osoba = (Radnik) osoba;
			else if(osoba.getTipOsobe() == TipOsobe.menadzer)
				osoba = (Menadzer) osoba;
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.delete(osoba);
				t.commit();
				return true;
			}
			catch (Exception e) {
				return false;
			}
			finally {
				session.close();
			}
		}

}
