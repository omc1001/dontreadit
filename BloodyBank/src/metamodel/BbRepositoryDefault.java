package metamodel;



import java.util.List;













import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entitati.Angajat;
import entitati.Centru;
import entitati.Donator;
import entitati.Spital;
import entitati.Utilizator;



public  class BbRepositoryDefault  extends AbstractRepository implements BbRepository{

	EntityManager manager=getEm();
	EntityManagerFactory emf=getEmf();
	
	

	@Override
	public Donator findDonatorbyCNP(String cnp) {
		@SuppressWarnings("unchecked")
		List<Donator> results = (List<Donator>) this.getEm().createQuery("Select d from Donator d where CNP=:cnp").setParameter("cnp", cnp).getResultList();
		if (!results.isEmpty()) return (Donator) results.get(0);
		else throw new IllegalArgumentException("nu");
		
	}
	
	public Donator adaugaDonator(Donator donator) {
	    	if(donator.getCnp()==null)
			return (Donator)this.create(donator);
	    	
	    	else
	    		return findDonatorbyCNP(donator.getCnp());
		
	}

	@Override
	public Donator actualizareDonator(Donator donator) {
		return null;
	}

	@Override
	public void stergeDonator(Donator donator) {
		this.delete(donator);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Donator> ListaDonatori() {
		return this.getEm().createQuery("Select d from Donator d").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Centru> ListaCentre() {
		 return (List<Centru>) this.getEm().createQuery("Select c from Centru c").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Angajat> ListaAngajati(){
		return (List<Angajat>) this.getEm().createQuery("Select a from Angajat a").getResultList();
	}

	@Override
	public Centru findCentruByNr(String numar) {
		return (Centru) this.getEm().createQuery("Select c from Centru c where nrCentru=:numar").setParameter("numar", numar).getSingleResult();
	}

	@Override
	public Angajat findAngajatByCnp(String cnp) {
		@SuppressWarnings("unchecked")
		List<Angajat> results = (List<Angajat>) this.getEm().createQuery("Select a from Angajat a where CNP=:cnp").setParameter("cnp", cnp).getResultList();
		if (!results.isEmpty()) return (Angajat) results.get(0);
		else throw new IllegalArgumentException("nu");
	}
	@Override
	public Utilizator autentificare(String user, String pass) {
		@SuppressWarnings("unchecked")
		List<Utilizator> rez=(List<Utilizator>)this.getEm().createQuery("Select u from Utilizator u where utilizator=:user and parola=:pass")
    			.setParameter("user", user).setParameter("pass", pass).getResultList();
		Utilizator u=rez.get(0);
		return u;
	}

	@Override
	public Angajat findAngajatByUser(Utilizator user) {
		@SuppressWarnings("unchecked")
		List<Angajat> results = (List<Angajat>) this.getEm().createQuery("Select a from Angajat a where utilizator=:user").setParameter("user", user).getResultList();
		if (!results.isEmpty()) return (Angajat) results.get(0);
		else throw new IllegalArgumentException("nu");
	}
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public Spital findSpitalByCif(String cif) {
		@SuppressWarnings("unchecked")
		List<Spital> results = (List<Spital>) this.getEm().createQuery("Select a from Spital a where CIF=:cif").setParameter("cif", cif).getResultList();
		if (!results.isEmpty()) return (Spital) results.get(0);
		else throw new IllegalArgumentException("nu");
	}

	

	
	
  
}
