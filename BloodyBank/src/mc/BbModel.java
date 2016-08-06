package mc;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import metamodel.BbRepository;
import metamodel.BbRepositoryDefault;
import entitati.Donator;


public class BbModel {
	private Donator donatorCurent;
	
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("$objectdb/db/BloodyBank.odb");
    EntityManager manager = emf.createEntityManager();
	
	
	private BbRepository repo=new BbRepositoryDefault();

	public void saveDonator(Donator donator) {
		repo.adaugaDonator(donator);
		}
	
	public Donator getDonatorCurent() {
		return donatorCurent;
	}

	public void setDonatorCurent(Donator donatorCurent) {
		this.donatorCurent = donatorCurent;
	}

	public BbRepository getRepo() {
		return repo;
	}

	public void setRepo(BbRepository repo) {
		this.repo = repo;
	}
	
	
   
   
	
			
}
