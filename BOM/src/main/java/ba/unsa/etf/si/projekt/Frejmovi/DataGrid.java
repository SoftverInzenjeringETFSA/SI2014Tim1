package ba.unsa.etf.si.projekt.Frejmovi;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import ba.unsa.etf.si.projekt.Klase.Klijent;
import ba.unsa.etf.si.projekt.Klase.Osoba;
import ba.unsa.etf.si.projekt.Klase.Ovlasti;
import ba.unsa.etf.si.projekt.Klase.Radnik;
import ba.unsa.etf.si.projekt.Klase.TipOsobe;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.KompanijaFacade;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class DataGrid {
	
	private final String tipTabele;
	private JTable table;

	
	
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
				//ovdje ce se pozivati metoda koja uzima sve korisnike iz baze
				
				KompanijaFacade k = new KompanijaFacade();
				List<Osoba> osobe = k.listaOsoba(TipOsobe.menadzer);
				
				/*
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date d = new Date();
				String datum = dateFormat.format(d);
				*/
				
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
			List<Klijent> klijenti1 = new ArrayList<Klijent>();
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
		/*
		
		else if(tipTabele.equals("Sastavnica"))
		{
			List<Korisnik> ls = ....
			moze se sada ova lista prebaciti u matricu stringova
		}
		if(tipTabele.equals("Narudbenica"))
		{
			List<Korisnik> ls = ....
			moze se sada ova lista prebaciti u matricu stringova
		}
		if(tipTabele.equals("Materijal"))
		{
			List<Korisnik> ls = ....
			moze se sada ova lista prebaciti u matricu stringova
		}
		*/
		
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		for (int i = 0; i < table.getColumnCount(); i++) 
		{ 
			Class<?> col_class = table.getColumnClass(i); 
			table.setDefaultEditor(col_class, null);
		}
		
		return table;
		
	}
	
}
