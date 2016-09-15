package entitati;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity 
public class TransferEsuat extends Transfer{
	@OneToOne @Column
	private Transfer transfer;
	@ManyToOne @Column
	private Donator donatorResp;
	@Column @ManyToMany
	private List<Angajat>angajatiResp;
	@Column
	private String explicatie;
	
	
	public TransferEsuat() {
		super();
		
	}
	public TransferEsuat(Donator donatorResp, List<Angajat> angajatiResp,
			String explicatie) {
		super();
		this.donatorResp = donatorResp;
		this.angajatiResp = angajatiResp;
		this.explicatie = explicatie;
	}
	public Donator getDonatorResp() {
		return donatorResp;
	}
	public void setDonatorResp(Donator donatorResp) {
		this.donatorResp = donatorResp;
	}
	public List<Angajat> getAngajatiResp() {
		return angajatiResp;
	}
	
	public String getExplicatie() {
		return explicatie;
	}
	public void setExplicatie(String explicatie) {
		this.explicatie = explicatie;
	}
	
	public void addResponsabil(Angajat responsabil){
        if (!this.angajatiResp.contains(responsabil)){
            this.angajatiResp.add(responsabil);
        }
    }
    
    public void removeResponsabil(Angajat responsabil)
    {if (this.angajatiResp.contains(responsabil)){
        this.angajatiResp.remove(responsabil);
    }}
}
