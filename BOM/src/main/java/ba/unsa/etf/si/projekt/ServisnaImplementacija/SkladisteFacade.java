package ba.unsa.etf.si.projekt.ServisnaImplementacija;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Iterator;
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
			Session session = HibernateUtil.getSessionFactory().openSession();
			Materijal m = null;
			try {
			
				Transaction t = session.beginTransaction();
				String hql = "FROM Materijal M WHERE M.serijskiBroj = '" + serijskiBroj+ "'";
				Query query = session.createQuery(hql);
				List rezultati = query.list();
				ArrayList<Materijal> lista = new ArrayList<Materijal> ();
				for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
				{
					Materijal m1 = (Materijal)iterator1.next(); 
				    lista.add(m1);
			    }
				if(lista.size() == 1) {
					m = lista.get(0);
				}
				t.commit();
				return m;
			
			
			}
			catch(Exception e) {
				return m;
			}
			finally {
				session.close();
			}
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
		
		public Proizvod pretragaProizvoda(String serijskiBroj)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Proizvod p = null;
			try {
				Transaction t = session.beginTransaction();
				String hql = "FROM Proizvod P WHERE P.serijskiBroj = '" + serijskiBroj+ "'";
				Query query = session.createQuery(hql);
				List rezultati = query.list();
				ArrayList<Proizvod> lista = new ArrayList<Proizvod> ();
				for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
				{
					Proizvod p1 = (Proizvod)iterator1.next(); 
				    lista.add(p1);
			    }
				if(lista.size() == 1) {
					p = lista.get(0);
				}
				t.commit();
				return p;
			}
			catch(Exception e) {
				return p;
			}
			finally {
				session.close();
			}
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
		
		public Narudzbenica pretragaNarudzbenica(String serijskiBroj)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Narudzbenica n = null;
			try {
				Transaction t = session.beginTransaction();
				String hql = "FROM Narudzbenica N WHERE N.serijskiBroj = '" + serijskiBroj+ "'";
				Query query = session.createQuery(hql);
				List rezultati = query.list();
				ArrayList<Narudzbenica> lista = new ArrayList<Narudzbenica> ();
				for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
				{
					Narudzbenica n1 = (Narudzbenica)iterator1.next(); 
				    lista.add(n1);
			    }
				if(lista.size() == 1) {
					n = lista.get(0);
				}
				t.commit();
				return n;
			}
			catch(Exception e) {
				return n;
			}
			finally {
				session.close();
			}
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
		
		public Sastavnica pretragaSastavnica(String serijskiBroj)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Sastavnica s = null;
			try {
				Transaction t = session.beginTransaction();
				String hql = "FROM Sastavnica S WHERE S.serijskiBroj = '" + serijskiBroj+ "'";
				Query query = session.createQuery(hql);
				List rezultati = query.list();
				ArrayList<Sastavnica> lista = new ArrayList<Sastavnica> ();
				for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
				{
					Sastavnica s1 = (Sastavnica)iterator1.next(); 
				    lista.add(s1);
			    }
				if(lista.size() == 1) {
					s = lista.get(0);
				}
				t.commit();
				return s;
			}
			catch(Exception e) {
				return s;
			}
			finally {
				session.close();
			}
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
