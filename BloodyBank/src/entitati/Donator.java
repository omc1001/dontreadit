package entitati;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Donator {
	@Column
	private String nume;
	@Column @Id
	private String CNP;
	@Column
	private String adresa;
	@Column
	private String email;
	@Column
	private String telefon;
	@Column
	private String grupa;
	@Column
	private String avertizare;
	
	public Donator() {
	}

	public Donator(String nume, String cnp, String adresa, String email,
			String telefon, String grupa) {
		super();
		this.nume = nume;
		this.CNP = cnp;
		this.adresa = adresa;
		this.email = email;
		this.telefon = telefon;
		this.grupa = grupa;
	}

	public Donator(String cod, String grupa) {
		super();
		this.CNP = cod;
		this.grupa = grupa;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getCnp() {
		return CNP;
	}

	public void setCnp(String cod) {
		this.CNP = cod;
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

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getGrupa() {
		return grupa;
	}

	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}

	public String getAvertizare() {
		return avertizare;
	}

	public void setAvertizare(String avertizare) {
		this.avertizare = avertizare;
	}
	
	
	
	
	
	
}
