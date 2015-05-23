package ba.unsa.etf.si.projekt.Frejmovi;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import ba.unsa.etf.si.projekt.Klase.Klijent;
import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Narudzbenica;
import ba.unsa.etf.si.projekt.Klase.Osoba;
import ba.unsa.etf.si.projekt.Klase.Ovlasti;
import ba.unsa.etf.si.projekt.Klase.Radnik;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;
import ba.unsa.etf.si.projekt.Klase.TipOsobe;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.KompanijaFacade;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.SkladisteFacade;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class DataGrid {
	
	private final String tipTabele;
	private JTable table;
	public List<Klijent> klijenti1;

	
	
	public DataGrid(String t)
	{
		tipTabele = t;//tip tabele
	}
	
	public JTable getTable(String name, String value, String sort)
	{
		
		if(tipTabele.equals("Korisnik"))
		{
			List<Radnik> korisnici = new ArrayList<Radnik>();
			
			if(name != null && value != null)
			{
				//sada pozivamo neku metodu za pretragu
				//korisnici = getUsersFor(name, value);
				//name je po cemu se vrsi pretraga
				
				
			}
			else
			{
				KompanijaFacade k = new KompanijaFacade();
				List<Osoba> osobe = k.listaOsoba(TipOsobe.menadzer);
				Object columnsName[] = { "ID", "Ime i prezime", "Telefon", "Korisnicko ime", "Email"};
				Object rows[][] = new Object[osobe.size()][5];
				
				for(int i=0; i<osobe.size(); i++)
				{
					rows[i][0] = i;
					rows[i][1] = osobe.get(i).getIme() + ' ' + osobe.get(i).getPrezime();
					rows[i][2] = osobe.get(i).getBrojTelefona();
					rows[i][3] = "Korisnicko ime";
					rows[i][4] = osobe.get(i).getEmail();
				}
				
				table = new JTable(rows, columnsName);
				
			}
			
			
		}
		else if(tipTabele.equals("Klijent"))
		{
			List<Osoba> klijenti = new ArrayList<Osoba>();
			klijenti1 = new ArrayList<Klijent>();
			if(name != null && value != null)
			{
				
			}
			else
			{
		
			KompanijaFacade kf=new KompanijaFacade();
				klijenti = kf.listaOsoba(TipOsobe.klijent);
				for(int i=0;i<klijenti.size();i++)
					klijenti1.add((Klijent)klijenti.get(i));
		
			}
			Object columnsName[] = { "ID", "Ime i prezime", "Telefon", " Adresa","Email"};
			Object rows[][] = new Object[klijenti1.size()][5];
			
			for(int i=0; i<klijenti1.size(); i++)
			{
				rows[i][0] = klijenti1.get(i).getId();
				rows[i][1] = klijenti1.get(i).getIme()+ " "+klijenti1.get(i).getPrezime();
				rows[i][2] =  klijenti1.get(i).getBrojTelefona();
				rows[i][3] =  klijenti1.get(i).getAdresa();
				rows[i][4] =  klijenti1.get(i).getEmail();
			}
			
			table = new JTable(rows, columnsName);
		}
		
		
		else if(tipTabele.equals("Sastavnica"))
		{
        
			
			if(name != null && value != null)
			{
				//sada pozivamo neku metodu za pretragu
				//korisnici = getUsersFor(name, value);
				//name je po cemu se vrsi pretraga
				
				
			}
			else
			{
				SkladisteFacade sf = new SkladisteFacade();
				 List<Sastavnica> sastavnice = new ArrayList<Sastavnica>();
				 sastavnice=sf.returnListaSastavnica();
				Object columnsName[] = { "Serijski broj", "Izdao", "Cijena", "Trajanje", "Kreirana"};
				Object rows[][] = new Object[sastavnice.size()][5];
				
				for(int i=0; i<sastavnice.size(); i++)
				{
					rows[i][0] = sastavnice.get(i).getSerijskiBroj();
					rows[i][1] = sastavnice.get(i).getIzdao();
					rows[i][2] =sastavnice.get(i).getCijenaObavljenogRada();
				    rows[i][3] = sastavnice.get(i).getTrajanjeProizvodnje();
					rows[i][4] = sastavnice.get(i).getDatumKreiranja();
				}
				
				table = new JTable(rows, columnsName);
				
			}
			
			
		}
		
		else if(tipTabele.equals("Narudzbenica"))
		{
			/*
			SkladisteFacade sf = new SkladisteFacade();
			 List<Sastavnica> sastavnice = new ArrayList<Sastavnica>();
			 sastavnice=sf.returnListaSastavnica();
			Object columnsName[] = { "Serijski broj", "Izdao", "Cijena", "Trajanje", "Kreirana"};
			Object rows[][] = new Object[sastavnice.size()][5];
			
			for(int i=0; i<sastavnice.size(); i++)
			{
				rows[i][0] = sastavnice.get(i).getSerijskiBroj();
				rows[i][1] = sastavnice.get(i).getIzdao();
				rows[i][2] =sastavnice.get(i).getCijenaObavljenogRada();
			    rows[i][3] = sastavnice.get(i).getTrajanjeProizvodnje();
				rows[i][4] = sastavnice.get(i).getDatumKreiranja();
			}
			
			table = new JTable(rows, columnsName);
			*/
			
			
			if(name != null && value != null)
			{
				//sada pozivamo neku metodu za pretragu
				//korisnici = getUsersFor(name, value);
				//name je po cemu se vrsi pretraga
				
				
			}
			else
			{
				SkladisteFacade sf = new SkladisteFacade();
				 List<Narudzbenica> narudzbenice = new ArrayList<Narudzbenica>();
				 narudzbenice=sf.returnListaNarudzbenica();
				
				 Object columnsName[] = { "Serijski broj", "Klijent", "Odgovorno lice", "Datum kreiranje"};
				Object rows[][] = new Object[narudzbenice.size()][4];
				
				for(int i=0; i<narudzbenice.size(); i++)
				{
					/*
					rows[i][0] = narudzbenice.get(i).getSerijskiBroj();
					rows[i][1] = narudzbenice.get(i).getKlijent().getIme(); //+ " "+narudzbenice.get(i).getKlijent().getPrezime();
				    rows[i][2] =narudzbenice.get(i).getOdgovornoLice().getIme(); //+ " "+ narudzbenice.get(i).getOdgovornoLice().getPrezime();
					rows[i][3] = narudzbenice.get(i).getDatumKreiranja();
					*/
					
					rows[i][0] = narudzbenice.get(i).getSerijskiBroj();
					
					String s = "789";
					try{
						//greska----------------------------
						s = narudzbenice.get(i).getKlijent().getIme();
					}catch(Exception e)
					{
						s = "error";
					}
					rows[i][1] = s;
				    rows[i][2] = "";
					rows[i][3] = "sd";
					
				}
				
				table = new JTable(rows, columnsName);
				
				
				
			}
			
		}
		else if(tipTabele.equals("Materijal"))
		{
			if(name != null && value != null)
			{
				//sada pozivamo neku metodu za pretragu
				//korisnici = getUsersFor(name, value);
				//name je po cemu se vrsi pretraga
				
				
			}
			else
			{
				SkladisteFacade sf = new SkladisteFacade();
				 List<Materijal> materijali = new ArrayList<Materijal>();
				 materijali=sf.returnListaMaterijala();
				
				 Object columnsName[] = { "ID", "Opis", "Količina", "Prodajna cijena"};
				 Object rows[][] = new Object[materijali.size()][4];
				
				for(int i=0; i<materijali.size(); i++)
				{
					rows[i][0] = materijali.get(i).getId();
			        rows[i][1] = materijali.get(i).getOpis();
				    rows[i][2] =materijali.get(i).getKolicina();
					rows[i][3] = materijali.get(i).getProdajnaCijena();
					
				}
				
				table = new JTable(rows, columnsName);
				
			}
		}
		
		
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		for (int i = 0; i < table.getColumnCount(); i++) 
		{ 
			Class<?> col_class = table.getColumnClass(i); 
			table.setDefaultEditor(col_class, null);
		}
		
		return table;
		
	}
	
}
