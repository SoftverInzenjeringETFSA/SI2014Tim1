package ba.unsa.etf.si.projekt.Frejmovi;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import ba.unsa.etf.si.projekt.Klase.Klijent;
import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Narudzbenica;
import ba.unsa.etf.si.projekt.Klase.Radnik;
import ba.unsa.etf.si.projekt.Klase.Menadzer;
import ba.unsa.etf.si.projekt.Klase.Sastavnica;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.KompanijaFacade;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.SkladisteFacade;
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
		tipTabele = t;
	}
	
	public JTable getTable(String name, String value, String sort)
	{
		
		if(tipTabele.equals("Korisnik"))
		{
			KompanijaFacade k = new KompanijaFacade();
			radnici = k.sortirajRadnika(name, value, sort);
			menadzeri = k.sortirajMenadzera(name, value, sort);
			int brojNultih = 0;
			for(Menadzer m : menadzeri)
				if(m == null)
					brojNultih++;
			
			for(Radnik r : radnici)
				if(r == null)
					brojNultih++;
			
			
				Object columnsName[] = { "Ime", "Prezime", "Telefon", "Korisnicko ime", "Email", "Pozicija"};
				Object rows[][] = new Object[radnici.size() + menadzeri.size() - brojNultih][6];
				
				int i = 0;
				for(Menadzer m : menadzeri)
				{
					if(m != null)
					{
						rows[i][0] = m.getIme();
						rows[i][1] = m.getPrezime();
						rows[i][2] = m.getBrojTelefona();
						rows[i][3] = m.getUsername();
						rows[i][4] = m.getEmail();
						rows[i][5] = "Menadzer";
						i++;
					}
				}
				for(Radnik r : radnici)
				{
					if(r != null)
					{
						rows[i][0] = r.getIme();
						rows[i][1] = r.getPrezime();
						rows[i][2] = r.getBrojTelefona();
						rows[i][3] = r.getUsername();
						rows[i][4] = r.getEmail();
						rows[i][5] = "Zaposlenik";
						i++;
					}
				}
				
				table = new JTable(rows, columnsName);
				
		}
		else if(tipTabele.equals("Klijent"))
		{
			KompanijaFacade kf=new KompanijaFacade();
			klijenti = kf.sortirajKlijenta(name, value, sort);
			int brojNultih = 0;
			for(Klijent k : klijenti)
				if(k == null)
					brojNultih++;
			
			Object columnsName[] = {"Ime","Prezime", "Telefon", " Adresa","Email"};
			Object rows[][] = new Object[klijenti.size() - brojNultih][5];
			
			int i = 0;
			for(Klijent k : klijenti)
			{
				if(k != null)
				{
					rows[i][0] = k.getIme();
					rows[i][1] = k.getPrezime();
					rows[i][2] =  k.getBrojTelefona();
					rows[i][3] =  k.getAdresa();
					rows[i][4] =  k.getEmail();
					i++;
				}
			}
			
			table = new JTable(rows, columnsName);
		}
		
		
		else if(tipTabele.equals("Sastavnica"))
		{
			SkladisteFacade sf = new SkladisteFacade();
		       sastavnice=sf.sortirajSastavnice(name,value,sort);
		       int brojNultih=0;
		       for(Sastavnica s : sastavnice)
		    	   if(s == null)
		    		   brojNultih++;
		       
				Object columnsName[] = { "ID", "Naziv","Izdao", "Cijena", "Kreirana"};
				Object rows[][] = new Object[sastavnice.size() - brojNultih][5];
				int i = 0;
				for(Sastavnica s : sastavnice)
				{
					if(s != null)
					{
						rows[i][0] = s.getId();
						rows[i][1] = s.getNaziv();
						if(s.getIzdao() != null)
							rows[i][2] = s.getIzdao().getUsername();
						rows[i][3] = s.getUkupnaCijena();
						rows[i][4] = s.getDatumKreiranja();
						i++;
					}
				}
				
				table = new JTable(rows, columnsName);
		}
		
		else if(tipTabele.equals("Narudzbenica"))
		{
			
			SkladisteFacade sf = new SkladisteFacade();
			narudzbenice = sf.sortirajNarudzbenice(name, value, sort);
			int brojNultih = 0;
			for(Narudzbenica n : narudzbenice)
				if(n == null)
					brojNultih++;
			
				Object columnsName[] = { "Serijski broj", "Klijent", "Odgovorno lice", "Datum kreiranje"};
				Object rows[][] = new Object[narudzbenice.size()-brojNultih][4];
				int i = 0;
				for(Narudzbenica n : narudzbenice)
				{
					if(n != null)
					{
						rows[i][0] = n.getSerijskiBroj();
						if(n.getKlijent() != null)
							rows[i][1] = n.getKlijent().getIme() + " "+n.getKlijent().getPrezime();
						if(n.getOdgovornoLice() != null)
							rows[i][2] = n.getOdgovornoLice().getUsername();
						rows[i][3] = n.getDatumKreiranja();	
						i++;
					}
				}
				
				table = new JTable(rows, columnsName);
				
			
		}
		else if(tipTabele.equals("Materijal"))
		{
			SkladisteFacade sf = new SkladisteFacade();
			materijali=sf.sortirajMaterijale(name, value, sort);
			int brojNultih = 0;
			for(Materijal m : materijali)
				if(m == null)
					brojNultih++;
				
				 Object columnsName[] = { "Serijski broj", "Naziv", "Količina", "Prodajna cijena", "Stanje"};
				 Object rows[][] = new Object[materijali.size()-brojNultih][5];
				int i = 0;
				for(Materijal m : materijali)
				{
					if(m != null)
					{
						rows[i][0] = m.getSerijskiBroj();
				        rows[i][1] = m.getOpis();
					    rows[i][2] = m.getKolicina();
						rows[i][3] = m.getProdajnaCijena();
						if(m.getKolicina() < m.getGranicnaKolicina())
						{
							rows[i][4] = "Manjak!";
						}
						i++;
					}
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
	public boolean postojiManjakMaterijala()
	{
		SkladisteFacade sf = new SkladisteFacade();
		List<Materijal> mat = new ArrayList<Materijal>();
		mat = sf.sortirajMaterijale(null, null, null);
		for(Materijal m : mat){
			if(m != null)
			{
				if(m.getKolicina() < m.getGranicnaKolicina())
				{
					return true;
				}
			}
		}
		
		return false;
		
	}
	
}
