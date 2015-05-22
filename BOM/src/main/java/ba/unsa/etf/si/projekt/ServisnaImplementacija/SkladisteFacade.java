package ba.unsa.etf.si.projekt.ServisnaImplementacija;
import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

import ba.unsa.etf.si.projekt.Util.HibernateUtil;
import ba.unsa.etf.si.projekt.Klase.*;
import ba.unsa.etf.si.projekt.ServisniInterfejs.ISkladisteFacade;

public class SkladisteFacade implements ISkladisteFacade {
	
		// materijali
	
		public List<Materijal> returnListaMaterijala()
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				List<Materijal> _materijali = null;
				_materijali = session.createCriteria(Materijal.class).list();
				t.commit();
			return _materijali;
			}
			catch (Exception e) {
				return (List<Materijal>) e;
			}
			finally {
				session.close();
			}	
		}
		
		public Boolean dodajMaterijal(Materijal materijal)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.save(materijal);
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
		
		public Boolean obrišiMaterijal(Materijal materijal)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.delete(materijal);
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
		
		public Boolean izmijeniMaterijal(Materijal materijal)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.update(materijal);
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
		
		public Materijal pretragaMaterijala(String serijskiBroj)
		{
			//nije gotova
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
						
				t.commit();
				
					
		//		return true;
			}
			catch (Exception e) {
		//		return false;
			}
			finally {
				session.close();
			}	
			return new Materijal();
		}
		
		// proizvodi
		
		public List<Proizvod> returnListaProizvoda()
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				List<Proizvod> _proizvodi = null;
				_proizvodi = session.createCriteria(Proizvod.class).list();
				t.commit();
			return _proizvodi;
			}
			catch (Exception e) {
				return (List<Proizvod>) e;
			}
			finally {
				session.close();
			}	
			//return new ArrayList<Proizvod>();
		}
		
		public Boolean dodajProizvod(Proizvod proizvod)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.save(proizvod);
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
		
		public Boolean obrišiProizvod(Proizvod proizvod)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.delete(proizvod);
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
		
		public Boolean izmijeniProizvod(Proizvod proizvod)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.update(proizvod);
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
		
		public Proizvod pretragaProizvoda(String id)
		{
			return new Proizvod();
		}
		
		// narudzbenice
		
		public List<Narudzbenica> returnListaNarudzbenica()
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				List<Narudzbenica> _narudzbenice = null;
				_narudzbenice = session.createCriteria(Narudzbenica.class).list();
				t.commit();
			return _narudzbenice;
			}
			catch (Exception e) {
				return (List<Narudzbenica>) e;
			}
			finally {
				session.close();
			}	
		}
		
		public Boolean dodajNarudzbenicu(Narudzbenica narudzbenica)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.save(narudzbenica);
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
		
		public Boolean obrišiNarudzbenicu(Narudzbenica narudzbenica)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.delete(narudzbenica);
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
		
		public Boolean izmijeniNarudzbenicu(Narudzbenica narudzbenica)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.update(narudzbenica);
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
		
		public Narudzbenica pretragaNarudzbenica(String id)
		{
			return new Narudzbenica();
		}
		
		// sastavnice
		
		public List<Sastavnica> returnListaSastavnica()
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				List<Sastavnica> _sastavnice = null;
				_sastavnice = session.createCriteria(Sastavnica.class).list();
				t.commit();
			return _sastavnice;
			}
			catch (Exception e) {
				return (List<Sastavnica>) e;
			}
			finally {
				session.close();
			}	
		}
		
		public Boolean dodajSastavnicu(Sastavnica sastavnica)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.save(sastavnica);
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
		
		public Boolean obrišiSastavnicu(Sastavnica sastavnica)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.delete(sastavnica);
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
		
		public Boolean izmijeniSastavnicu(Sastavnica sastavnica)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.update(sastavnica);
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
		
		public Sastavnica pretragaSastavnica(String id)
		{
			return new Sastavnica();
		}
		
				
		public List<Menadzer> returnListaMenadzera()
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				List<Menadzer> _menadzeri = null;
				_menadzeri = session.createCriteria(Menadzer.class).list();
				t.commit();
			return _menadzeri;
			}
			catch (Exception e) {
				return (List<Menadzer>) e;
			}
			finally {
				session.close();
			}	
		}

}
