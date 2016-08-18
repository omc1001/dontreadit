package mc;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import metamodel.BbRepository;
import metamodel.BbRepositoryDefault;
import entitati.Centru;
import entitati.Donator;


public class BbModel {
	
	
	
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("$objectdb/db/BloodyBank.odb");
    EntityManager manager = emf.createEntityManager();
	
	
	private BbRepository repo=new BbRepositoryDefault();

	public void addDonator(Donator donator) {
		repo.adaugaDonator(donator);
		}
	
	public List<Centru> ListaCentre(){
		return(List<Centru>)repo.ListaCentre();
		
	}
	public BbRepository getRepo() {
		return repo;
	}

	public void setRepo(BbRepository repo) {
		this.repo = repo;
	}
	
	
	public String autentificare(String user, String pass){
		String a="";
		try{
			
			a=repo.autentificare(user, pass).getTipUtilizator();
		}
		catch(NoResultException e) {
			
			a="neautentificat";
			
	}
		return a;
	
	}
	
}
