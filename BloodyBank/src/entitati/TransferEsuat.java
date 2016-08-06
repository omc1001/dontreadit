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
	private List<Angajat>angajatResp;
	@Column
	private String explicatie;
	
	
	public TransferEsuat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransferEsuat(Donator donatorResp, List<Angajat> angajatResp,
			String explicatie) {
		super();
		this.donatorResp = donatorResp;
		this.angajatResp = angajatResp;
		this.explicatie = explicatie;
	}
	public Donator getDonatorResp() {
		return donatorResp;
	}
	public void setDonatorResp(Donator donatorResp) {
		this.donatorResp = donatorResp;
	}
	public List<Angajat> getAngajatResp() {
		return angajatResp;
	}
	public void setAngajatResp(List<Angajat> angajatResp) {
		this.angajatResp = angajatResp;
	}
	public String getExplicatie() {
		return explicatie;
	}
	public void setExplicatie(String explicatie) {
		this.explicatie = explicatie;
	}
}
