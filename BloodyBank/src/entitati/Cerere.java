package entitati;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Embedded;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cerere {
	@ManyToOne @Column
	private Spital destinatar;
	@Column@Id
	private String cod;
	@Column
	private Boolean status;
	@Column
	private Date dataInreg;
	@Column @OneToMany(cascade=CascadeType.PERSIST)@Embedded
	private List<CerereGrupa> linii= new ArrayList<CerereGrupa>();
	
	
	
	public Cerere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Spital getDestinatar() {
		return destinatar;
	}
	public void setDestinatar(Spital destinatar) {
		this.destinatar = destinatar;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Date getDataInreg() {
		return dataInreg;
	}
	public void setDataInreg(Date dataInreg) {
		this.dataInreg = dataInreg;
	}

	public List<CerereGrupa> getLinii() {
		return linii;
	}

	public void setLinii(List<CerereGrupa> linii) {
		this.linii = linii;
	}
	
	

}
