package entitati;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Utilizator {
	@Column
	@Id @GeneratedValue(strategy=GenerationType.AUTO) long id;
	private String utilizator;
	@Column
	private String parola;
	@OneToOne@Column
	private Angajat angajat;
	@Column
	private String tipUtilizator;
	
	
	public Angajat getAngajat() {
		return angajat;
	}


	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}


	public Utilizator() {
		super();
	}
	
	

	public Utilizator(String utilizator, String parola, String tipUtilizator) {
		super();
		this.utilizator = utilizator;
		this.parola = parola;
		this.tipUtilizator = tipUtilizator;
	}


	public String getUtilizator() {
		return utilizator;
	}
	public void setUtilizator(String utilizator) {
		this.utilizator = utilizator;
	}


	public String getParola() {
		return parola;
	}


	public void setParola(String parola) {
		this.parola = parola;
	}


	public String getTipUtilizator() {
		return tipUtilizator;
	}


	public void setTipUtilizator(String tipUtilizator) {
		this.tipUtilizator = tipUtilizator;
	}
	
	
}
