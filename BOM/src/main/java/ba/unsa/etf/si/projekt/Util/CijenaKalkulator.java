package ba.unsa.etf.si.projekt.Util;

import ba.unsa.etf.si.projekt.Klase.*;

public class CijenaKalkulator {
	
	public static double RekalkulisiCijenuSastavnice(Sastavnica sastavnica)
	{
		double cijena = 0;
		
		for (StavkaSastavnice stavkaS : sastavnica.getStavke_sas())
		{
			cijena = cijena + (stavkaS.getMaterijal().getProdajnaCijena() * stavkaS.getKolicina());
		}
		
		double cijenaRada = sastavnica.getTrajanjeProizvodnje() * sastavnica.getCijenaObavljenogRada();
		
		double cijenaDodatnihTroskova = sastavnica.getDodatniTroskovi();
		
		return cijena + cijenaRada + cijenaDodatnihTroskova;
	}
	
	public static double RekalkulisiCijenuNarudzbenice(Narudzbenica narudzbenica, Boolean rekalkulisiSastavnice)
	{
		double cijena = 0;
		double cijenaStavke = 0;
		for(StavkaNarudzbenice stavkaN : narudzbenica.getStav_nar())
		{
			cijenaStavke = rekalkulisiSastavnice ? stavkaN.getProizvod().getUkupnaCijena() : RekalkulisiCijenuSastavnice(stavkaN.getProizvod());
			
			cijena = cijena + cijenaStavke;
		}
		
		return cijena;
	}
	
	public static double RekalkulisiTrajanje(Narudzbenica narudzbenica)
	{
		double trajanje = 0;
		
		for(StavkaNarudzbenice stavkaN : narudzbenica.getStav_nar())
		{
			trajanje = trajanje + (stavkaN.getProizvod().getTrajanjeProizvodnje() * stavkaN.getKolicina());
		}
		
		return trajanje;
	}

}
