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
			t.commit();
			session.close();
			return _osobe;
		}
		
		public Osoba returnById(String id) 
		{
			return new Osoba();
		}
		
		public Osoba returnByIme(String ime)
		{
			return new Osoba();
		}
		
		public Boolean dodajKlijenta(String ime, String prezime, String brojTelefona, String adresa, String email, Narudzbenica narudzba)
		{
			return true;
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
				//session.close();
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
			Transaction t = session.beginTransaction();
			Menadzer m = new Menadzer(ime, prezime, brojTelefona, adresa, email, pozicija, nivoOvlasti);
			Long id = (Long) session.save(m);
			m.setId(id);
			t.commit();
			session.close();
			return true;
		}
		
		public Boolean obrisiOsobu(Osoba osoba)
		{
			return true;
		}

}
