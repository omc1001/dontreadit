package metamodel;



import java.util.List;


import entitati.Centru;
import entitati.Donator;
import entitati.Utilizator;



public  class BbRepositoryDefault  extends AbstractRepository implements BbRepository{

	
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

	@Override
	public Centru findCentruByNr(String numar) {
		return (Centru) this.getEm().createQuery("Select c from Centru c where nrCentru=:numar").setParameter("numar", numar).getSingleResult();
	
	}

	@Override
	public Utilizator autentificare(String user, String pass) {
		List<Utilizator> rez=(List<Utilizator>)this.getEm().createQuery("Select u from Utilizator u where utilizator=:user and parola=:pass")
    			.setParameter("user", user).setParameter("pass", pass).getResultList();
		Utilizator u=rez.get(0);
		return u;
	}

	
	
  
}
