package entitati;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity @Inheritance
public class Transfer {
	 @Id @GeneratedValue(strategy=GenerationType.AUTO) long id;
	@ManyToMany @Column
	private List<Angajat> respTransfer;
	@Column
	@OneToMany
	private List<TransferGrupa> linii;
	@Column
	private Date dataTransfer;
	@Column
	private String stare;
	@Column
	private String explicatii;
	
	
	
	
	public List<Angajat> getRespTransfer() {
		return respTransfer;
	}
	public void setRespTransfer(List<Angajat> respTransfer) {
		this.respTransfer = respTransfer;
	}
	public List<TransferGrupa> getLinii() {
		return linii;
	}
	public void setLinii(List<TransferGrupa> linii) {
		this.linii = linii;
	}
	
	
	public Date getDataTransfer() {
		return dataTransfer;
	}
	public void setDataTransfer(Date dataTransfer) {
		this.dataTransfer = dataTransfer;
	}
	public String getStare() {
		return stare;
	}
	public void setStare(String stare) {
		this.stare = stare;
	}
	public String getExplicatii() {
		return explicatii;
	}
	public void setExplicatii(String explicatii) {
		this.explicatii = explicatii;
	}
	
	public void addGrupa(TransferGrupa transferGrupa){
        if (!this.linii.contains(transferGrupa)){
            this.linii.add(transferGrupa);
        }
    }
    
    public void removeGrupa(TransferGrupa transferGrupa)
    {if (this.linii.contains(transferGrupa)){
        this.linii.remove(transferGrupa);
    }}
    
    public void addResponsabil(Angajat responsabil){
        if (!this.respTransfer.contains(responsabil)){
            this.respTransfer.add(responsabil);
        }
    }
    
    public void removeResponsabil(Angajat responsabil)
    {if (this.respTransfer.contains(responsabil)){
        this.respTransfer.remove(responsabil);
    }}
	
	
	
	
	
}
