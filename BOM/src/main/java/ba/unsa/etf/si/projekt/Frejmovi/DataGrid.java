package ba.unsa.etf.si.projekt.Frejmovi;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import ba.unsa.etf.si.projekt.Klase.Klijent;
import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Narudzbenica;
import ba.unsa.etf.si.projekt.Klase.Osoba;
import ba.unsa.etf.si.projekt.Klase.Ovlasti;
import ba.unsa.etf.si.projekt.Klase.Radnik;
import ba.unsa.etf.si.projekt.Klase.Menadzer;
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
	public static List<Klijent> klijenti;
	public 	 static List<Materijal> materijali;
	public static List<Sastavnica> sastavnice;
	public static List<Radnik> radnici;
	public static List<Menadzer> menadzeri;
	public  static List<Narudzbenica> narudzbenice;

	
	public DataGrid(String t)
	{
		tipTabele = t;//tip tabele
	}
	
	public JTable getTable(String name, String value, String sort)
	{
		
		if(tipTabele.equals("Korisnik"))
		{
			KompanijaFacade k = new KompanijaFacade();
			radnici = k.sortirajRadnika(name, value, sort);
			menadzeri = k.sortirajMenadzera(name, value, sort);
			
			
				Object columnsName[] = { "Ime", "Prezime", "Telefon", "Korisnicko ime", "Email", "Pozicija"};
				Object rows[][] = new Object[radnici.size() + menadzeri.size()][6];
				
				int i = 0;
				for(Menadzer m : menadzeri)
				{
					rows[i][0] = m.getIme();
					rows[i][1] = m.getPrezime();
					rows[i][2] = m.getBrojTelefona();
					rows[i][3] = m.getUsername();
					rows[i][4] = m.getEmail();
					rows[i][5] = "Menadzer";
					i++;
				}
				for(Radnik r : radnici)
				{
					rows[i][0] = r.getIme();
					rows[i][1] = r.getPrezime();
					rows[i][2] = r.getBrojTelefona();
					rows[i][3] = r.getUsername();
					rows[i][4] = r.getEmail();
					rows[i][5] = "Zaposlenik";
					i++;
				}
				
				table = new JTable(rows, columnsName);
				
		}
		else if(tipTabele.equals("Klijent"))
		{
			KompanijaFacade kf=new KompanijaFacade();
			List<Osoba> osobeK = new ArrayList<Osoba>();
			klijenti = new ArrayList<Klijent>();
			if(name != null && value != null)
			{
				
			}
			else
			{
		
				osobeK = kf.listaOsoba(TipOsobe.klijent);
				for(int i=0;i<osobeK.size();i++)
					klijenti.add((Klijent)osobeK.get(i));
		
			}
			Object columnsName[] = { "ID", "Ime i prezime", "Telefon", " Adresa","Email"};
			Object rows[][] = new Object[klijenti.size()][5];
			
			for(int i=0; i<klijenti.size(); i++)
			{
				rows[i][0] = klijenti.get(i).getId();
				rows[i][1] = klijenti.get(i).getIme()+ " "+klijenti.get(i).getPrezime();
				rows[i][2] =  klijenti.get(i).getBrojTelefona();
				rows[i][3] =  klijenti.get(i).getAdresa();
				rows[i][4] =  klijenti.get(i).getEmail();
			}
			
			table = new JTable(rows, columnsName);
		}
		
		
		else if(tipTabele.equals("Sastavnica"))
		{
			SkladisteFacade sf = new SkladisteFacade();
		       sastavnice = new ArrayList<Sastavnica>();
			
			if(name != null && value != null)
			{
				
				sastavnice=sf.sortirajSastavnice(name,value,sort);
				
			}
			else
			{
				
				 sastavnice=sf.returnListaSastavnica();
			}
				Object columnsName[] = { "Serijski broj", "Izdao", "Cijena", "Trajanje", "Kreirana"};
				Object rows[][] = new Object[sastavnice.size()][5];
				
				for(int i=0; i<sastavnice.size(); i++)
				{
					rows[i][0] = sastavnice.get(i).getSerijskiBroj();
					rows[i][1] = sastavnice.get(i).getIzdao().getIme() + " " + 
							sastavnice.get(i).getIzdao().getPrezime();
					rows[i][2] =sastavnice.get(i).getCijenaObavljenogRada();
				    rows[i][3] = sastavnice.get(i).getTrajanjeProizvodnje();
					rows[i][4] = sastavnice.get(i).getDatumKreiranja();
				}
				
				table = new JTable(rows, columnsName);
				
			
			
			
		}
		
		else if(tipTabele.equals("Narudzbenica"))
		{
			
			SkladisteFacade sf = new SkladisteFacade();
			 narudzbenice = new ArrayList<Narudzbenica>();
			if(name != null && value != null)
			{
				narudzbenice=sf.sortirajNarudzbenice(name, value, sort);
			}
			else
			{
				 narudzbenice=sf.returnListaNarudzbenica();
			}
				
				 Object columnsName[] = { "Serijski broj", "Klijent", "Odgovorno lice", "Datum kreiranje"};
				Object rows[][] = new Object[narudzbenice.size()][4];
				
				for(int i=0; i<narudzbenice.size(); i++)
				{
				
					rows[i][0] = narudzbenice.get(i).getSerijskiBroj();
					rows[i][1] = narudzbenice.get(i).getKlijent().getIme() + " "+narudzbenice.get(i).getKlijent().getPrezime();
				    rows[i][2] =narudzbenice.get(i).getOdgovornoLice().getIme() + " "+ narudzbenice.get(i).getOdgovornoLice().getPrezime();
					rows[i][3] = narudzbenice.get(i).getDatumKreiranja();	
				}
				
				table = new JTable(rows, columnsName);
				
			
		}
		else if(tipTabele.equals("Materijal"))
		{
			SkladisteFacade sf = new SkladisteFacade();
			 materijali = new ArrayList<Materijal>();
			if(name != null && value != null)
			{
				
				
				materijali=sf.sortirajMaterijale(name, value, sort);
			}
			else
			{
				 materijali=sf.returnListaMaterijala();
			}
				
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
		
		
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		for (int i = 0; i < table.getColumnCount(); i++) 
		{ 
			Class<?> col_class = table.getColumnClass(i); 
			table.setDefaultEditor(col_class, null);
		}
		
		return table;
		
	}
	
}
