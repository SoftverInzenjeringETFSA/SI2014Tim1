package ba.unsa.etf.si.projekt.Klase;

import java.util.Date;

public class ObrisaniMaterijal extends Materijal {
	private Date datumBrisanja;
	private String razlogBrisanja;
	private Osoba obrisao;
	
	public Date getDatumBrisanja() {
		return datumBrisanja;
	}
	public void setDatumBrisanja(Date datumBrisanja) {
		this.datumBrisanja = datumBrisanja;
	}
	public String getRazlogBrisanja() {
		return razlogBrisanja;
	}
	public void setRazlogBrisanja(String razlogBrisanja) {
		this.razlogBrisanja = razlogBrisanja;
	}
	public Osoba getObrisao() {
		return obrisao;
	}
	public void setObrisao(Osoba obrisao) {
		this.obrisao = obrisao;
	}
}
