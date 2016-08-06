package entitati;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Spital {
	@Column @Id
    private String CIF;
    @Column
    private String denumire;
     @Column  
    private String adresa;
    @Column
    private String localitate;
    @ManyToMany@Column
    private List<PersoanaContact> Responsabili;
    
        public Spital(String cIF, String denumire, String adresa,
			String localitate, List<PersoanaContact> responsabili) {
		super();
		CIF = cIF;
		this.denumire = denumire;
		this.adresa = adresa;
		this.localitate = localitate;
		Responsabili = responsabili;
	}

        
        
	public Spital() {
			super();
		}



	@Override
	public String toString() {
		return "Spital [denumire=" + denumire + "]";
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getLocalitate() {
		return localitate;
	}

	public void setLocalitate(String localitate) {
		this.localitate = localitate;
	}

	public void addResponsabil(PersoanaContact responsabil){
        if (!this.Responsabili.contains(responsabil)){
            this.Responsabili.add(responsabil);
        }
    }
    
    public void removeIBAN(PersoanaContact responsabil)
    {if (this.Responsabili.contains(responsabil)){
        this.Responsabili.remove(responsabil);
    }}
}
