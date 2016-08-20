package entitati;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class PersoanaContact extends Angajat {
	
	@Column @ManyToOne
	private Spital spital;
	
	

	public PersoanaContact() {
		super();
	}

	
	
	
	public PersoanaContact(String nume, String cNP, String telefon,
			Utilizator utilizator, Spital spital) {
		super(nume, cNP, telefon, utilizator);
		this.spital = spital;
	}




	public Spital getSpital() {
		return this.spital;
	}
	
	

	public void setSpital(Spital spital) {
		this.spital = spital;
	}

	@Override
	public String toString() {
		return "Persoana de Contact " + getNume() + "";
	}
	
	
	
}
