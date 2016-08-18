package entitati;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Donatie {
	 @Id @GeneratedValue(strategy=GenerationType.AUTO) long id;
	@ManyToOne(cascade=CascadeType.PERSIST) @Column 
	private Donator donator;
	@ManyToOne @Column
	private Centru centru;
	@ManyToOne @Column
	private Angajat angajat;
	@Column
	private Double cantitate;
	@Column
	private String tip;
	@Column
	private Date dataPreluare;
	@Column 
	private String status;
	
	
	
	public Donatie(Donator donator, Centru centru, Angajat angajat,
			Double cantitate, String tip) {
		super();
		this.donator = donator;
		this.centru = centru;
		this.angajat = angajat;
		this.cantitate = cantitate;
		this.tip = tip;
	}
	public Donatie() {
		super();
		
	}
	public Donator getDonator() {
		return donator;
	}
	public void setDonator(Donator donator) {
		this.donator = donator;
	}
	public Centru getCentru() {
		return centru;
	}
	public void setCentru(Centru centru) {
		this.centru = centru;
	}
	public Angajat getAngajat() {
		return angajat;
	}
	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
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
	
	public Date getDataPreluare() {
		return dataPreluare;
	}
	public void setDataPreluare(Date dataPreluare) {
		this.dataPreluare = dataPreluare;}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
