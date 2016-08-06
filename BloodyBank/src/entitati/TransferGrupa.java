package entitati;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TransferGrupa {
	 @Id @GeneratedValue(strategy=GenerationType.AUTO) long id;
	@ManyToOne @Column
	private Spital spital;
	@ManyToOne @Column
	private Transfer transfer;
	@Column 
	private String tip;
	@Column
	private Double cantitate;
	public Spital getSpital() {
		return spital;
	}
	public void setSpital(Spital spital) {
		this.spital = spital;
	}
	public Transfer getTransfer() {
		return transfer;
	}
	public void setTransfer(Transfer transfer) {
		this.transfer = transfer;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public TransferGrupa(Spital spital, Transfer transfer, String tip,
			Double cantitate) {
		super();
		this.spital = spital;
		this.transfer = transfer;
		this.tip = tip;
		this.cantitate = cantitate;
	}
	public TransferGrupa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
