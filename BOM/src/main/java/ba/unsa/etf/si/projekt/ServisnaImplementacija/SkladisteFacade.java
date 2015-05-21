package ba.unsa.etf.si.projekt.ServisnaImplementacija;
import org.hibernate.Transaction;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.List;
import ba.unsa.etf.si.projekt.Util.HibernateUtil;
import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Menadzer;
import ba.unsa.etf.si.projekt.Klase.Narudzbenica;
import ba.unsa.etf.si.projekt.Klase.Proizvod;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;
import ba.unsa.etf.si.projekt.ServisniInterfejs.ISkladisteFacade;

public class SkladisteFacade implements ISkladisteFacade {
	
		// materijali
	
		public List<Materijal> returnListaMaterijala()
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			
			return new ArrayList<Materijal>();
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
			//preskocio
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			materijal=null;			
			session.save(materijal);
			t.commit();
			session.close();
			return true;
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
			return new Materijal();
		}
		
		// proizvodi
		
		public List<Proizvod> returnListaProizvoda()
		{
			return new ArrayList<Proizvod>();
		}
		
		public Boolean dodajProizvod(Proizvod proizvod)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.save(proizvod);
				t.commit();
				session.close();	
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
			//preskocio
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			proizvod=null;			
			session.save(proizvod);
			t.commit();
			session.close();
			return true;
		}
		
		public Boolean izmijeniProizvod(Proizvod proizvod)
		{
			
			return true;
		}
		
		public Proizvod pretragaProizvoda(String id)
		{
			return new Proizvod();
		}
		
		// narudzbenice
		
		public List<Narudzbenica> returnListaNarudzbenica()
		{
			return new ArrayList<Narudzbenica>();
		}
		
		public Boolean dodajNarudzbenicu(Narudzbenica narudzbenica)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.save(narudzbenica);
				t.commit();
				session.close();	
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
			Transaction t = session.beginTransaction();
						
			session.save(narudzbenica);
			t.commit();
			session.close();
			return true;
		}
		
		public Boolean izmijeniNarudzbenicu(Narudzbenica narudzbenica)
		{
			return true;
		}
		
		public Narudzbenica pretragaNarudzbenica(String id)
		{
			return new Narudzbenica();
		}
		
		// sastavnice
		
		public List<Sastavnica> returnListaSastavnica()
		{
			return new ArrayList<Sastavnica>();
		}
		
		public Boolean dodajSastavnicu(Sastavnica sastavnica)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.save(sastavnica);
				t.commit();
				session.close();	
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
			Transaction t = session.beginTransaction();
			sastavnica=null;			
			session.save(sastavnica);
			t.commit();
			session.close();
			return true;
		}
		
		public Boolean izmijeniSastavnicu(Sastavnica sastavnica)
		{
			return true;
		}
		
		public Sastavnica pretragaSastavnica(String id)
		{
			return new Sastavnica();
		}
		
				
		public List<Menadzer> returnListaMenadzera()
		{
			return new ArrayList<Menadzer>();
		}

}
