package ba.unsa.etf.si.projekt.ServisnaImplementacija;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si.projekt.Klase.Klijent;
import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Menadzer;
import ba.unsa.etf.si.projekt.Klase.Narudzbenica;
import ba.unsa.etf.si.projekt.Klase.ObrisaniMaterijal;
import ba.unsa.etf.si.projekt.Klase.Proizvod;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;
import ba.unsa.etf.si.projekt.Klase.StavkaNarudzbenice;
import ba.unsa.etf.si.projekt.Klase.StavkaSastavnice;
import ba.unsa.etf.si.projekt.ServisniInterfejs.ISkladisteFacade;
import ba.unsa.etf.si.projekt.Util.HibernateUtil;

public class SkladisteFacade implements ISkladisteFacade {
	
		// materijali
	
		public List<Materijal> returnListaMaterijala()
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				List<Materijal> materijali = null;
				materijali = session.createCriteria(Materijal.class).list();
				
				
				List<ObrisaniMaterijal> obrisani_materijali = session.createCriteria(ObrisaniMaterijal.class).list();
				
				List<Long> lista_id = new ArrayList<Long>();
				
				for(ObrisaniMaterijal om: obrisani_materijali) {
					lista_id.add(om.getMaterijal().getId());
				}
				List<Materijal> za_vratiti = new ArrayList<Materijal> ();
				
				for(Materijal mat: materijali) {
					if(!lista_id.contains(mat.getId())) {
						za_vratiti.add(mat);
					}
				}
				t.commit();
			return za_vratiti;
			}
			catch (Exception e) {
				
				throw new RuntimeException(e);
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
				throw new RuntimeException(e);
			}
			finally {
				session.close();
			}		
		}
		
		public Boolean obrišiMaterijal(Materijal materijal, Menadzer menadzer)
		{
			if(validirajBrisanjeMaterijala(materijal)) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				ObrisaniMaterijal m = new ObrisaniMaterijal();
				m.setMaterijal(materijal);
				m.setRazlogBrisanja("Zato jer treba");
				m.setObrisao(menadzer);
				m.setDatumBrisanja(new Date());
				session.save(m);
				t.commit();
				return true;
			}
			catch (Exception e) {
				throw new RuntimeException(e);
			}
			finally {
				session.close();
			}
			}
			else {
				return false;
			}
		}
		
		public boolean validirajBrisanjeMaterijala(Materijal materijal) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				List<StavkaSastavnice> ss = session.createCriteria(StavkaSastavnice.class).list();
				boolean istina = true;
				for(StavkaSastavnice s : ss) {
					if(materijal.getId() == s.getMaterijal().getId())
						istina = false;
				}
				t.commit();
				return istina;
			}
			catch (Exception e) {
				throw new RuntimeException(e);
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
				throw new RuntimeException(e);
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
				throw new RuntimeException(e);
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
				List<Proizvod> proizvodi = null;
				proizvodi = session.createCriteria(Proizvod.class).list();
				t.commit();
			return proizvodi;
			}
			catch (Exception e) {
				throw new RuntimeException(e);				
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
				throw new RuntimeException(e);
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
				throw new RuntimeException(e);
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
				throw new RuntimeException(e);
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
				throw new RuntimeException(e);
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
				List<Narudzbenica> narudzbenice = null;
				narudzbenice = session.createCriteria(Narudzbenica.class).list();
				t.commit();
			return narudzbenice;
			}
			catch (Exception e) {
				throw new RuntimeException(e);
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
				throw new RuntimeException(e);
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
				throw new RuntimeException(e);
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
				throw new RuntimeException(e);
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
				throw new RuntimeException(e);
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
				List<Sastavnica> sastavnice = null;
				sastavnice = session.createCriteria(Sastavnica.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
				t.commit();
			return sastavnice;
			}
			catch (Exception e) {
				throw new RuntimeException(e);
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
				throw new RuntimeException(e);
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
				throw new RuntimeException(e);
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
				throw new RuntimeException(e);
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
				throw new RuntimeException(e);
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
				List<Menadzer> menadzeri = null;
				menadzeri = session.createCriteria(Menadzer.class).list();
				t.commit();
			return menadzeri;
			}
			catch (Exception e) {
				throw new RuntimeException(e);
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
				throw new RuntimeException(e);
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
				//sort null, ostali razliciti od null
				else if(name != null && name != " " && value != null && value != " " && (sort == null || sort.equals(" ")))
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Materijal  WHERE " + name + " LIKE '" + value + "' ORDER BY "+ name;
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
				else if(name != null && name != " " && value != null && value != " " && sort != null && sort != " ")
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Materijal  WHERE " +name + " LIKE '" + value + "' ORDER BY " + sort;
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
				//sort razlicit od null, ostali null
				else if((name == null || name.equals(" ")) && (value == null || value.equals(" ")) && (sort != null))
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Materijal ORDER BY " + sort;
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
				else {
					List<Materijal> l =null;
					return l;
				}
			
			}
			catch (Exception e) {
				
				throw new RuntimeException(e);
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
				//sort null, ostali razliciti od null
				else if(name != null && name != " " && value != null && value != " " && (sort == null || sort.equals(" ")))
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Narudzbenica  WHERE " + name + " LIKE '" + value + "' ORDER BY " + name;
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
				//svi razliciti od null
				else if(name != null && name != " " && value != null && value != " " && sort != null && sort != " ")
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Narudzbenica WHERE " + name + " LIKE '" + value + "' ORDER BY " + sort;
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
				//sort razlicit od null, ostali null
				if((name == null || name.equals(" ")) && (value == null || value.equals(" ")) && (sort != null))
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Narudzbenica ORDER BY " + sort;
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
				else 
					return new ArrayList<Narudzbenica>();
			
			}
			catch (Exception e) {
				
				throw new RuntimeException(e);
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
				//sort null, ostali razliciti od null
				else if(name != null && name != " " && value != null && value != " " && (sort == null || sort.equals(" ")))
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Sastavnica  WHERE " +name + " LIKE '" + value + "' ORDER BY " + name;
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
				//svi razliciti od null
				else if(name != null && name != " " && value != null && value != " " && sort != null && sort != " ")
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Sastavnica WHERE " + name + " LIKE '" + value + "' ORDER BY " + sort;
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
				//sort razlicit od null, ostali null
				else if((name == null || name.equals(" ")) && (value == null || value.equals(" ")) && (sort != null))
				{
					Transaction t = session.beginTransaction();
					String hql = "FROM Sastavnica ORDER BY " + sort;
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
				else 
					return new ArrayList<Sastavnica>();
			}
			catch (Exception e) {
				throw new RuntimeException(e);
			}
			finally {
				session.close();
			}
		}		
		
}
