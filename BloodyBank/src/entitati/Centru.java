package entitati;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Centru {
	@Column@Id
	private String nrCentru;
	@Column 
	private String numeCentru;
	@Column
	private String adresa;
	@Column
	private String telefon;
	@Column @OneToMany(cascade=CascadeType.ALL)
	private List<Angajat> angajati=new ArrayList<Angajat>();
	
	
	
	
	public Centru() {
		super();
	}
	
	
	public Centru(String nrCentru, String numeCentru, String adresa,
			String telefon, List<Angajat> angajati) {
		super();
		this.nrCentru = nrCentru;
		this.numeCentru = numeCentru;
		this.adresa = adresa;
		this.telefon = telefon;
		this.angajati=angajati;
	}


	
	
	public void addAngajat(Angajat angajat){
        if (!this.angajati.contains(angajat)){
            this.angajati.add(angajat);
        }
    }
	
	public void removeAngajat(Angajat angajat){
        if (this.angajati.contains(angajat)){
            this.angajati.remove(angajat);
        }
    }
	
	public String getNrCentru() {
		return nrCentru;
	}
	public void setNrCentru(String nrCentru) {
		this.nrCentru = nrCentru;
	}
	public String getNumeCentru() {
		return numeCentru;
	}
	public void setNumeCentru(String numeCentru) {
		this.numeCentru = numeCentru;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public List<Angajat> getAngajati() {
		return angajati;
	}
	
	
	
}
