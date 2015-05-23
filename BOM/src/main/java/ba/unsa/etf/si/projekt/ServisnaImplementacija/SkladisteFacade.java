package ba.unsa.etf.si.projekt.ServisnaImplementacija;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.projekt.Klase.*;
import ba.unsa.etf.si.projekt.ServisniInterfejs.ISkladisteFacade;
import ba.unsa.etf.si.projekt.Util.HibernateUtil;

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
				return new ArrayList<Materijal>();
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
				String hql = "FROM Materijal M WHERE M.serijskiBroj = :serijskiBroj";
				Query query = session.createQuery(hql).setParameter("serijskiBroj", serijskiBroj);
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
				return new ArrayList<Proizvod>();
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
				String hql = "FROM Proizvod P WHERE P.serijskiBroj = :serijskiBroj";
				Query query = session.createQuery(hql).setParameter("serijskiBroj", serijskiBroj);
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
				return new ArrayList<Narudzbenica>();
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
				
				HashMap<Long, Double> listaMaterijala = new HashMap<Long, Double>();
				
				for(StavkaNarudzbenice stavkaN : narudzbenica.getStav_nar())
				{
					
					for (StavkaSastavnice stavkaS : stavkaN.getProizvod().getStavke_sas())
					{
						Long id = stavkaS.getMaterijal().getId();
						listaMaterijala.put(id, listaMaterijala.getOrDefault(id, 0.0) + (stavkaN.getKolicina() * stavkaS.getKolicina()));
					}
				}
				
				List<Materijal> bazaMaterijala = session.createCriteria(Materijal.class).list();				
				
				for (Materijal m : bazaMaterijala)
				{
					if (listaMaterijala.containsKey(m.getId()))
					{
							m.setKolicina(m.getKolicina() - listaMaterijala.get(m.getId()));
							session.update(m);
					}
				}
				
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
				String hql = "FROM Narudzbenica N WHERE N.serijskiBroj = :serijskiBroj";
				Query query = session.createQuery(hql).setParameter("serijskiBroj", serijskiBroj);
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
				String hql = "FROM Sastavnica S WHERE S.serijskiBroj = :serijskiBroj";
				Query query = session.createQuery(hql).setParameter("serijskiBroj", serijskiBroj);
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
		
		// lista menadzera		
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
				return new ArrayList<Menadzer>();
			}
			finally {
				session.close();
			}	
		}
		
		// validiraj narudzbenicu
		public Boolean validirajNarudzbenicu(Narudzbenica narudzbenica) 
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				HashMap<Long, Double> listaMaterijala = new HashMap<Long, Double>();
				
				for(StavkaNarudzbenice stavkaN : narudzbenica.getStav_nar())
				{
					
					for (StavkaSastavnice stavkaS : stavkaN.getProizvod().getStavke_sas())
					{
						Long id = stavkaS.getMaterijal().getId();
						listaMaterijala.put(id, listaMaterijala.getOrDefault(id, 0.0) + (stavkaN.getKolicina() * stavkaS.getKolicina()));
					}
				}
				
				Transaction t = session.beginTransaction();
				List<Materijal> bazaMaterijala = session.createCriteria(Materijal.class).list();				
				t.commit();
				
				for (Materijal m : bazaMaterijala)
				{
					if (listaMaterijala.containsKey(m.getId()))
					{
						if (listaMaterijala.get(m.getId()) > m.getKolicina())
							return false;
					}
				}
				
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
			finally
			{
				session.close();
			}

		}
		

		//sortiranje materijala
		public List<Materijal> sortirajMaterijale(String name, String value, String sort) 
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				//svi parametri null
				if((name == null || name.equals(" ")) && (value == null || value.equals(" ")) && (sort == null || sort.equals(" ")))
				{	
					Transaction t = session.beginTransaction();
					String hql = "FROM Materijal ORDER BY materijal_id ";
					Query query = session.createQuery(hql);
					List rezultati = query.list();
					ArrayList<Materijal> listaMaterijala = new ArrayList<Materijal> ();
					for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
					{
						Materijal m1 = (Materijal)iterator1.next(); 
					    listaMaterijala.add(m1);
				    }			
					t.commit();
					return listaMaterijala;
				}
				//sort null
				if(name != null && value != null && (sort == null || sort.equals(" ")))
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Materijal  WHERE " + name + " LIKE '" + value + "' ";
					Query query = session.createQuery(hql);//.setParameter("kolona", name).setParameter("vrijednost", value);
					List rezultati = query.list();
					ArrayList<Materijal> listaMaterijala = new ArrayList<Materijal> ();
					for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
					{
						Materijal m1 = (Materijal)iterator1.next(); 
					    listaMaterijala.add(m1);
				    }			
					
					t.commit();
					return listaMaterijala;	
				}
				//svi razliciti od null
				if(name != null && value != null && sort != null)
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Materijal  WHERE " +name + " LIKE '" + value + "' ORDER BY " + sort + " ASC";
					Query query = session.createQuery(hql);//.setParameter("kolona", name).setParameter("vrijednost", value);
					List rezultati = query.list();
					ArrayList<Materijal> listaMaterijala = new ArrayList<Materijal> ();
					for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
					{
						Materijal m1 = (Materijal)iterator1.next(); 
					    listaMaterijala.add(m1);
				    }			
					
					t.commit();
					return listaMaterijala;					
					
				}
				//sort razlicit od null
				if((name == null || name.equals(" ")) && (value == null || value.equals(" ")) && (sort != null))
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Materijal ORDER BY " + sort + " ";
					Query query = session.createQuery(hql);//.setParameter("kolona", name).setParameter("vrijednost", value);
					List rezultati = query.list();
					ArrayList<Materijal> listaMaterijala = new ArrayList<Materijal> ();
					for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
					{
						Materijal m1 = (Materijal)iterator1.next(); 
					    listaMaterijala.add(m1);
				    }			
					t.commit();
					return listaMaterijala;					
				}
				
				return new ArrayList<Materijal>();
			
			}
			catch (Exception e) {
				
				return new ArrayList<Materijal>();
			}
			finally {
				session.close();
			}
		}
		
		//sortiraj narudzbenice 
		public List<Narudzbenica> sortirajNarudzbenice(String name, String value, String sort) 
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				//svi parametri null
				if((name == null || name.equals(" ")) && (value == null || value.equals(" ")) && (sort == null || sort.equals(" ")))
				{	
					Transaction t = session.beginTransaction();
					String hql = "FROM Narudzbenica ORDER BY narudzbenica_id";
					Query query = session.createQuery(hql);
					List rezultati = query.list();
					ArrayList<Narudzbenica> listaNarudzbenica = new ArrayList<Narudzbenica> ();
					for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
					{
						Narudzbenica n1 = (Narudzbenica)iterator1.next(); 
					    listaNarudzbenica.add(n1);
				    }			
					t.commit();
					return listaNarudzbenica;
				}
				
				if(name != null && value != null && (sort == null || sort.equals(" ")))
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Narudzbenica  WHERE " +name + " LIKE '" + value + "' ";
					Query query = session.createQuery(hql);//.setParameter("kolona", name).setParameter("vrijednost", value);
					List rezultati = query.list();
					ArrayList<Narudzbenica> listaNarudzbenica = new ArrayList<Narudzbenica> ();
					for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
					{
						Narudzbenica n1 = (Narudzbenica)iterator1.next(); 
					    listaNarudzbenica.add(n1);
				    }			
					t.commit();
					return listaNarudzbenica;	
				}
				
				if(name != null && value != null && sort != null)
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Narudzbenica WHERE " + name + " LIKE '" + value + "' ORDER BY " + sort + " ASC";
					Query query = session.createQuery(hql);//.setParameter("kolona", name).setParameter("vrijednost", value);
					List rezultati = query.list();
					ArrayList<Narudzbenica> listaNarudzbenica = new ArrayList<Narudzbenica> ();
					for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
					{
						Narudzbenica n1 = (Narudzbenica)iterator1.next(); 
					    listaNarudzbenica.add(n1);
				    }			
					t.commit();
					return listaNarudzbenica;					
					
				}
				if((name == null || name.equals(" ")) && (value == null || value.equals(" ")) && (sort != null))
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Narudzbenica ORDER BY " + sort + "  ";
					Query query = session.createQuery(hql);//.setParameter("kolona", name).setParameter("vrijednost", value);
					List rezultati = query.list();
					ArrayList<Narudzbenica> listaNarudzbenica = new ArrayList<Narudzbenica> ();
					for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
					{
						Narudzbenica n1 = (Narudzbenica)iterator1.next(); 
					    listaNarudzbenica.add(n1);
				    }			
					
					t.commit();
					return listaNarudzbenica;					
				}
				
				return new ArrayList<Narudzbenica>();
			
			}
			catch (Exception e) {
				
				return new ArrayList<Narudzbenica>();
			}
			finally {
				session.close();
			}
		}
		
	
		//sortiraj sastavnice 
		public List<Sastavnica> sortirajSastavnice(String name, String value, String sort) 
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				//svi parametri null
				if((name == null || name.equals(" ")) && (value == null || value.equals(" ")) && (sort == null || sort.equals(" ")))
				{	
					Transaction t = session.beginTransaction();
					String hql = "FROM Sastavnica ORDER BY sastavnica_id";
					Query query = session.createQuery(hql);
					List rezultati = query.list();
					ArrayList<Sastavnica> listaSastavnica = new ArrayList<Sastavnica> ();
					for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
					{
						Sastavnica s1 = (Sastavnica)iterator1.next(); 
					    listaSastavnica.add(s1);
				    }			
					t.commit();
					return listaSastavnica;
				}
				
				if(name != null && value != null && (sort == null || sort.equals(" ")))
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Sastavnica  WHERE " +name + " LIKE '" + value + "' ";
					Query query = session.createQuery(hql);//.setParameter("kolona", name).setParameter("vrijednost", value);
					List rezultati = query.list();
					ArrayList<Sastavnica> listaSastavnica = new ArrayList<Sastavnica> ();
					for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
					{
						Sastavnica s1 = (Sastavnica)iterator1.next(); 
					    listaSastavnica.add(s1);
				    }			
					t.commit();
					return listaSastavnica;	
				}
				
				if(name != null && value != null && sort != null)
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Sastavnica WHERE " + name + " LIKE '" + value + "' ORDER BY " + sort + " ASC";
					Query query = session.createQuery(hql);//.setParameter("kolona", name).setParameter("vrijednost", value);
					List rezultati = query.list();
					ArrayList<Sastavnica> listaSastavnica = new ArrayList<Sastavnica> ();
					for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
					{
						Sastavnica s1 = (Sastavnica)iterator1.next(); 
					    listaSastavnica.add(s1);
				    }			
					t.commit();
					return listaSastavnica;					
					
				}
				if((name == null || name.equals(" ")) && (value == null || value.equals(" ")) && (sort != null))
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Sastavnica ORDER BY " + sort + " ";
					Query query = session.createQuery(hql);//.setParameter("kolona", name).setParameter("vrijednost", value);
					List rezultati = query.list();
					ArrayList<Sastavnica> listaSastavnica = new ArrayList<Sastavnica> ();
					for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
					{
						Sastavnica s1 = (Sastavnica)iterator1.next(); 
					    listaSastavnica.add(s1);
				    }			
					
					t.commit();
					return listaSastavnica;					
				}
				return new ArrayList<Sastavnica>();
			}
			catch (Exception e) {
				
				return new ArrayList<Sastavnica>();
			}
			finally {
				session.close();
			}
		}
		
		//sortiranje klijenata
		public List<Klijent> sortirajKlijenta(String name, String value, String sort) 
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				//svi parametri null
				if((name == null || name.equals(" ")) && (value == null || value.equals(" ")) && (sort == null || sort.equals(" ")))
				{	
					Transaction t = session.beginTransaction();
					String hql = "FROM Klijent ORDER BY klijent_id";
					Query query = session.createQuery(hql);
					List rezultati = query.list();
					ArrayList<Klijent> listaKlijenata = new ArrayList<Klijent> ();
					for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
					{
						Klijent k1 = (Klijent)iterator1.next(); 
					    listaKlijenata.add(k1);
				    }			
					t.commit();
					return listaKlijenata;
				}
				
				if(name != null && value != null && (sort == null || sort.equals(" ")))
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Klijent  WHERE " + name + " LIKE '" + value + "' ORDER BY " + value + " ASC";
					Query query = session.createQuery(hql);//.setParameter("kolona", name).setParameter("vrijednost", value);
					List rezultati = query.list();					
					ArrayList<Klijent> listaKlijenata = new ArrayList<Klijent>();
					for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
					{
						Klijent k1 = (Klijent)iterator1.next(); 
					    listaKlijenata.add(k1);
				    }			
					t.commit();
					return listaKlijenata;	
				}
				
				if(name != null && value != null && sort != null)
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Klijent WHERE " + name + " LIKE '" + value + "' ORDER BY " + sort + " ASC";
					Query query = session.createQuery(hql);//.setParameter("kolona", name).setParameter("vrijednost", value);
					List rezultati = query.list();
					ArrayList<Klijent> listaKlijenata = new ArrayList<Klijent> ();
					for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
					{
						Klijent k1 = (Klijent)iterator1.next(); 
					    listaKlijenata.add(k1);
				    }			
					t.commit();
					return listaKlijenata;					
					
				}
				if((name == null || name.equals(" ")) && (value == null || value.equals(" ")) && (sort != null))
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Klijent ORDER BY " + sort + " ";
					Query query = session.createQuery(hql);//.setParameter("kolona", name).setParameter("vrijednost", value);
					List rezultati = query.list();
					ArrayList<Klijent> listaKlijenata = new ArrayList<Klijent> ();
					for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
					{
						Klijent k1 = (Klijent)iterator1.next(); 
					    listaKlijenata.add(k1);
				    }			
					
					t.commit();
					return listaKlijenata;					
				}
				return new ArrayList<Klijent>();
			}
			catch (Exception e) {
				
				return new ArrayList<Klijent>();
			}
			finally {
				session.close();
			}
		}
		
		
		
}
