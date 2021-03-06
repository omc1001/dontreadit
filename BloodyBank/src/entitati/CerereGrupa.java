package entitati;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CerereGrupa {
	 @Id @GeneratedValue(strategy=GenerationType.AUTO) long id;
	
	@ManyToOne @Column
	private Cerere cerere;
	@Column
	private Double cantitate;
	 @Column
	private String tip;
	
	 
	public Cerere getCerere() {
		return cerere;
	}
	
	public void setCerere(Cerere cerere) {
		this.cerere = cerere;
	}

	public CerereGrupa() {
		super();
		
	}

	
	public CerereGrupa(Cerere cerere, Double cantitate, String tip) {
		super();
		this.cerere = cerere;
		this.cantitate = cantitate;
		this.tip = tip;
	}

	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}

	
}
