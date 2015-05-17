package ba.unsa.etf.si.projekt.Klase;

import java.util.ArrayList;
import java.util.List;

public class Klijent extends Osoba{
	private List<Narudzbenica> narudzbe = new ArrayList<Narudzbenica> ();

	public List<Narudzbenica> getNarudzbe() {
		return narudzbe;
	}

	public void setNarudzbe(List<Narudzbenica> narudzbe) {
		this.narudzbe = narudzbe;
	}
}
