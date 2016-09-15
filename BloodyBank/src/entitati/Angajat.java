package entitati;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Angajat {
	
	private String nume;
	@Id@Column
	private String CNP;
	private String telefon;
	private String adresa;
	private String email;
	 @Temporal(TemporalType.TIMESTAMP)
	private Date data_angajare;
	private String functie;
	@ManyToOne
	private Centru centru;	
	@OneToOne(cascade=CascadeType.PERSIST)
	private Utilizator utilizator;
	
	
	
	
	public Angajat(String nume, String cNP, String telefon,
			Utilizator utilizator) {
		super();
		this.nume = nume;
		CNP = cNP;
		this.telefon = telefon;
		this.utilizator = utilizator;
	}
	public Angajat(String nume, String cNP, String telefon, String Adresa,
			String Email, Date data_angajare, String functie, Utilizator utilizator) {
		super();
		this.nume = nume;
		CNP = cNP;
		this.telefon = telefon;
		adresa = Adresa;
		email = Email;
		this.data_angajare = data_angajare;
		this.functie=functie;
		this.utilizator=utilizator;
	}
	public Angajat() {
		super();
		
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
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
	public String getadresa() {
		return adresa;
	}
	public void setadresa(String Adresa) {
		adresa = Adresa;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String Email) {
		email = Email;
	}
	public Date getData_angajare() {
		return data_angajare;
	}
	public void setData_angajare(Date data_angajare) {
		this.data_angajare = data_angajare;
	}
	public Centru getCentru() {
		return centru;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFunctie() {
		return functie;
	}
	public void setFunctie(String functie) {
		this.functie = functie;
	}
	public Utilizator getUtilizator() {
		return utilizator;
	}
	public void setUtilizator(Utilizator utilizator) {
		this.utilizator = utilizator;
	}
	public void setCentru(Centru centru) {
		this.centru = centru;
	}
	@Override
	public String toString() {
		return  nume;
	}
	
	
	
}
