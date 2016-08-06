package entitati;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class PersoanaContact {
	public List<Spital> getSpitale() {
		return Spitale;
	}

	@Column 
	private String nume;
	@Column 
	private String functie;
	@Column @Id
	private String CNP;
	@Column
	private String telefon;
	@Column 
	private String adresa;
	@Column @ManyToMany
	private List<Spital> Spitale;
	
	public PersoanaContact(String nume, String functie, String cNP,
			String telefon, String adresa, List<Spital> spitale) {
		super();
		this.nume = nume;
		this.functie = functie;
		CNP = cNP;
		this.telefon = telefon;
		this.adresa = adresa;
		Spitale = spitale;
	}

	public PersoanaContact() {
		super();
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getFunctie() {
		return functie;
	}

	public void setFunctie(String functie) {
		this.functie = functie;
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String cNP) {
		CNP = cNP;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	public void addSpital(Spital spital){
        if (!this.Spitale.contains(spital)){
            this.Spitale.add(spital);
        }
    }
    
    public void removeIBAN(Spital spital)
    {if (this.Spitale.contains(spital)){
        this.Spitale.remove(spital);
    }}

	@Override
	public String toString() {
		return "Persoana de Contact " + nume + "";
	}
	
	
	
}
