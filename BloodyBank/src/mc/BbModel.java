package mc;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import metamodel.BbRepository;
import metamodel.BbRepositoryDefault;
import entitati.Angajat;
import entitati.Centru;
import entitati.Donator;
import entitati.Utilizator;


public class BbModel {
	
	
	
//	EntityManagerFactory emf =Persistence.createEntityManagerFactory("$objectdb/db/BloodyBank.odb");
//    EntityManager manager = emf.createEntityManager();
	
	
	private BbRepository repo=new BbRepositoryDefault();

	public void addDonator(Donator donator) {
		repo.adaugaDonator(donator);
		}
	
	
	public List<Centru> ListaCentre(){
		return repo.ListaCentre();
		
	}
	
	public List<Angajat> ListaAngajati(){
		return repo.ListaAngajati();
	}
	
	public BbRepository getRepo() {
		return repo;
	}

	public void setRepo(BbRepository repo) {
		this.repo = repo;
	}
	
	public EntityManagerFactory getEmf(){
		return repo.getEmf();
	}
	
	public EntityManager getEm(){
		return repo.getEm();
	}
	
	public Utilizator getUtilizator(String user, String pass){
		return repo.autentificare(user, pass);
	}
	
	public Angajat findAngajatByUser(Utilizator user){
		return repo.findAngajatByUser(user);
	}
	
	public String autentificare(String user, String pass){
		String a="";
		try{
			a=repo.autentificare(user, pass).getTipUtilizator();
		}
		catch(Exception e) {
			a="neautentificat";
	}
		return a;
	
	}
	
}
