package ba.unsa.etf.si.projekt.Frejmovi;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import ba.unsa.etf.si.projekt.Klase.Ovlasti;
import ba.unsa.etf.si.projekt.Klase.Radnik;

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
				
				//korisnici = getAllUsers();
				
				//ovo je sada samo neki primjer bzze
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date d = new Date();
				String datum = dateFormat.format(d);
				
				
				korisnici.add(new Radnik("Ime", "Prezime", "123345678", "adresa", "mail", "poyicija", null));
				korisnici.add(new Radnik("Ime", "Prezime", "123345678", "adresa", "mail", "poyicija", null));
				korisnici.add(new Radnik("Ime", "Prezime", "123345678", "adresa", "mail", "poyicija", null));
			}
			
			Object columnsName[] = { "ID", "Ime i prezime", "Telefon", "Korisnièko ime", "Kreiran"};
			Object rows[][] = new Object[korisnici.size()][5];
			
			for(int i=0; i<korisnici.size(); i++)
			{
				rows[i][0] = "1";
				rows[i][1] = "ime";
				rows[i][2] = "12323232";
				rows[i][3] = "korIme";
				rows[i][4] = "dssd";
			}
			
			table = new JTable(rows, columnsName);
		}
		/*
		else if(tipTabele.equals("Klijent"))
		{
			List<Korisnik> ls = ....
			moze se sada ova lista prebaciti u matricu stringova
		}
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
