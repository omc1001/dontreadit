package entitati;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Spital {
	@Column @Id
    private String CIF;
    @Column
    private String denumire;
     @Column  
    private String adresa;
    @OneToMany(cascade=CascadeType.PERSIST)@Column
    private List<PersoanaContact> Responsabili=new ArrayList<PersoanaContact>();
    
        public Spital(String cIF, String denumire, String adresa, List<PersoanaContact> responsabili) {
		super();
		CIF = cIF;
		this.denumire = denumire;
		this.adresa = adresa;
		Responsabili = responsabili;
	}

        
        
	public Spital(String cIF, String denumire, String adresa) {
			super();
			CIF = cIF;
			this.denumire = denumire;
			this.adresa = adresa;
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

	

	public void addResponsabil(PersoanaContact responsabil){
        if (!this.Responsabili.contains(responsabil)){
            this.Responsabili.add(responsabil);
        }
    }
    
    public void removeResponsabil(PersoanaContact responsabil)
    {if (this.Responsabili.contains(responsabil)){
        this.Responsabili.remove(responsabil);
    }}
}
