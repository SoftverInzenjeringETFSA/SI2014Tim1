package ba.unsa.etf.si.projekt.Baza;
import java.util.List;

import ba.unsa.etf.si.projekt.Klase.Materijal;
import ba.unsa.etf.si.projekt.Klase.Menadzer;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.KompanijaFacade;
import ba.unsa.etf.si.projekt.ServisnaImplementacija.SkladisteFacade;

public class ProbnaKlasaZlatan {
	public static void main (String[] args) {
		KompanijaFacade kf = new KompanijaFacade();
		SkladisteFacade sf = new SkladisteFacade();
		List<Materijal> lm = sf.returnListaMaterijala();
		if(lm != null) {
			Materijal m = lm.get(0);
			if(m != null) {
				System.out.println(sf.obrišiMaterijal(m, new Menadzer()));
			}
		}
		/*List<Materijal> lm = sf.returnListaMaterijala();
		if(lm != null){
			for(Materijal m: lm) {
				System.out.println(m.getId());
			}
		}*/
		//ArrayList<Narudzbenica>
		/*Menadzer m = (Menadzer) kf.returnById(2, TipOsobe.menadzer);
		if(m != null) {
			Sastavnica s = sf.pretragaSastavnica("SAS003");
			if(s != null) {

				List<StavkaSastavnice> _ss = s.getStavke_sas();
				if(_ss != null) {
					//System.out.println(_ss.get(0).getId());
					System.out.println(s.getStavke_sas().size());
					s.getStavke_sas().remove(0);
					sf.izmijeniSastavnicu(s);
					Sastavnica s1 = sf.pretragaSastavnica("SAS003");
					if(s1 != null) {
						System.out.println(s1.getStavke_sas().size());
					}
				}
			}
		}*/
	}

}