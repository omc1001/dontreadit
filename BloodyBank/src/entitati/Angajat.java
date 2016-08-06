package entitati;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Angajat {
	
	private String nume;
	@Id@Column
	private String CNP;
	private String telefon;
	private String adresa;
	private String email;
	private Date data_angajare;
	private String functie;
	@ManyToOne
	private Centru centru;	
	
	
	public Angajat(String nume, String cNP, String telefon, String Adresa,
			String Email, Date data_angajare, Centru centru) {
		super();
		this.nume = nume;
		CNP = cNP;
		this.telefon = telefon;
		adresa = Adresa;
		email = Email;
		this.data_angajare = data_angajare;
		this.centru = centru;
	}
	public Angajat() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
	
}