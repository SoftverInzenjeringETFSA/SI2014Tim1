package ba.unsa.etf.si.projekt.Frejmovi;

public class ComboItems {
	
	public static String[] getKlijentCBItems(String name, String value, String sort)
	{
		String[] niz =  {null, value, null};
		if(sort != null)
		{
			if(sort.equals("imenu"))
				niz[2] = "ime";
			else if(sort.equals("prezimenu"))
				niz[2] = "prezime";
			else if(sort.equals("e-mail-u"))
				niz[2] = "email";
		}
		if(name != null && value != null)
		{
			if(name.equals("imenu"))
				niz[0] = "ime";
			else if(name.equals("prezimenu"))
				niz[0] = "prezime";
			else if(name.equals("e-mail-u"))
				niz[0] = "email";
		}
		if(niz[0] == null)
			niz[1]=null;
		
		return niz;
	}
	public static String[] getSastavnicaCBItems(String name, String value, String sort)
	{
		//sastavnica Sort : datumKreiranja, otpad, naziv, cijena
		//sastavnica Pret : naziv, serijskiBroj, id
		String[] niz =  {null, value, null};
		
		if(sort != null)
		{
			if(sort.equals("datumu"))
				niz[2] = "datumKreiranja";
			else if(sort.equals("nazivu"))
				niz[2] = "naziv";
		}
		if(name != null && value != null)
		{
			if(name.equals("nazivu"))
				niz[0] = "naziv";
			else if(name.equals("id-u"))
				niz[0] = "sastavnica_id";
		}
		if(niz[0] == null)
			niz[1]=null;
		
		return niz;
	}
	public static String[] getNarudzbenciaCBItems(String name, String value, String sort)
	{
		//nar. Sort : datumKreiranja,
		//nar. Pret : serijskiBroj
		String[] niz =  {null, value, null};
		
		if(sort != null)
		{
			if(sort.equals("datumu"))
				niz[2] = "datumKreiranja";
		}
		if(name != null && value != null)
		{
			if(name.equals("ser. broju"))
				niz[0] = "serijskiBroj";
		}
		if(niz[0] == null)
			niz[1]=null;
		
		return niz;
	}
	public static String[] getMaterijalCBItems(String name, String value, String sort)
	{
		String[] niz =  {null, value, null};
		
		if(sort != null)
		{
			if(sort.equals("cijeni"))
				niz[2] = "prodajnaCijena";
			else if(sort.equals("nazivu"))
				niz[2] = "opis";
		}
		if(name != null && value != null)
		{
			if(name.equals("ser. broju"))
				niz[0] = "serijskiBroj";
			else if(name.equals("nazivu"))
				niz[0] = "opis";
		}
		if(niz[0] == null)
			niz[1]=null;
		
		return niz;
	}
	public static String[] getKorisnikCBItems(String name, String value, String sort)
	{
		String[] niz =  {null, value, null};
		
		if(sort != null)
		{
			if(sort.equals("imenu"))
				niz[2] = "ime";
			else if(sort.equals("prezimenu"))
				niz[2] = "prezime";
			else if(sort.equals("kor. imenu"))
				niz[2] = "username";
		}
		if(name != null && value != null)
		{
			if(name.equals("imenu"))
				niz[0] = "ime";
			else if(name.equals("prezimenu"))
				niz[0] = "prezime";
			else if(name.equals("kor. imenu"))
				niz[0] = "username";
		}
		if(niz[0] == null)
			niz[1]=null;
		
		return niz;
	}
}
