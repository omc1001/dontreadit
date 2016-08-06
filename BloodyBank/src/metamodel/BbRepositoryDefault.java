package metamodel;


import java.util.List;

import javax.persistence.Query;

import entitati.Centru;
import entitati.Donator;



public  class BbRepositoryDefault  extends AbstractRepository implements BbRepository{

	
	@Override
	public Donator findDonatorbyCNP(String cnp) {
		List results = this.getEm().createQuery("Select d from Donator d where CNP=;cnp").setParameter("cnp", cnp).getResultList();
		if (!results.isEmpty()) return (Donator) results.get(0);
		else throw new IllegalArgumentException("nu");
		
	}
	
	public Donator adaugaDonator(Donator donator) {
	    	//if(donator.getCnp()==null)
			return (Donator)this.create(donator);
//	    	
//	    	else
//	    		return findDonatorbyCNP(donator.getCnp());
		
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
		return this.getEm().createQuery("Select c from Donator c").getResultList();
	}

	
	
  
}
