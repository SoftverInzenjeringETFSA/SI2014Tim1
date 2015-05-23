package ba.unsa.etf.si.projekt.Klase;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ObrisaniMaterijal {
	@Id
	@GeneratedValue
	@Column(name = "obrisaniMaterijal_id")
	private long id;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="materijal_id")
	private Materijal materijal;
	private Date datumBrisanja;
	private String razlogBrisanja;
	@ManyToOne(cascade=CascadeType.ALL)
	private Menadzer obrisao;
	
	public ObrisaniMaterijal()
	{
		
	}
	
	public ObrisaniMaterijal(Materijal m, Date datumBrisanja, String razlogBrisanja, Menadzer menadzer)
	{
		this.materijal = m;
		this.datumBrisanja = datumBrisanja;
		this.razlogBrisanja = razlogBrisanja;
		this.obrisao = menadzer;
	}
	
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
	public Menadzer getObrisao() {
		return obrisao;
	}
	public void setObrisao(Menadzer obrisao) {
		this.obrisao = obrisao;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Materijal getMaterijal() {
		return materijal;
	}
	public void setMaterijal(Materijal materijal) {
		this.materijal = materijal;
	}
}
