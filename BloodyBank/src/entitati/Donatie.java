package entitati;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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
	
	@Column @Temporal(TemporalType.TIMESTAMP)
	private Date dataProgramata;
	@Column @Temporal(TemporalType.TIMESTAMP)
	private Date dataColectare;
	@Column 
	private String status;
	
	
	
	
	public Donatie(Donator donator, Centru centru, Date dataProgramata) {
		super();
		this.donator = donator;
		this.centru = centru;
		this.dataProgramata = dataProgramata;
	}
	public Donatie(Donator donator, Centru centru, Angajat angajat,
			Double cantitate) {
		super();
		this.donator = donator;
		this.centru = centru;
		this.angajat = angajat;
		this.cantitate = cantitate;
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
	
	
	public Date getDataProgramata() {
		return dataProgramata;
	}
	public void setDataProgramata(Date dataProgramata) {
		this.dataProgramata = dataProgramata;}
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
	public Date getDataColectare() {
		return dataColectare;
	}
	public void setDataColectare(Date dataColectare) {
		this.dataColectare = dataColectare;
	}
	
	
}
