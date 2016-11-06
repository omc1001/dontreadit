package metamodel;



import java.util.Date;
import java.util.List;


























import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entitati.Angajat;
import entitati.Centru;
import entitati.Cerere;
import entitati.Donatie;
import entitati.Donator;
import entitati.PersoanaContact;
import entitati.Spital;
import entitati.Utilizator;



public  class BbRepositoryDefault  extends AbstractRepository implements BbRepository{

	
	EntityManager manager=getEm();
	EntityManagerFactory emf=getEmf();
	
	

	@Override
	public Donator findDonatorbyCNP(String cnp) {
		
		@SuppressWarnings("unchecked")
		List<Donator> results = (List<Donator>) this.getEm().createQuery("Select d from entitati.Donator d where CNP=:cnp").setParameter("cnp", cnp).getResultList();
		if(!results.isEmpty()){
			return (Donator) results.get(0);
		}
		else{
			return null;
		}
		
		}
		
	
	
	public Donator adaugaDonator(Donator donator) {
	    	
		if(findDonatorbyCNP(donator.getCnp())==null)
			{
			this.create(donator);
			return donator;
			}
			
		else{
			return findDonatorbyCNP(donator.getCnp());
		}
		
		
	}
	
	public Donatie adaugaDonatie(Donatie donatie) {
    	
			return (Donatie)create(donatie);
		
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
		return this.getEm().createQuery("Select d from entitati.Donator d").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Centru> ListaCentre() {
		 return (List<Centru>) this.getEm().createQuery("Select c from entitati.Centru c").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Angajat> ListaAngajati(){
		return (List<Angajat>) this.getEm().createQuery("Select a from entitati.Angajat a").getResultList();
	}

	@Override
	public Centru findCentruByNr(String numar) {
		return (Centru) this.getEm().createQuery("Select c from entitati.Centru c where nrCentru=:numar").setParameter("numar", numar).getSingleResult();
	}
	
	@Override
	public Centru findCentruByNume(String numar) {
		return (Centru) this.getEm().createQuery("Select c from entitati.Centru c where numeCentru=:numar").setParameter("numar", numar).getSingleResult();
	}

	@Override
	public Angajat findAngajatByCnp(String cnp) {
		@SuppressWarnings("unchecked")
		List<Angajat> results = (List<Angajat>) this.getEm().createQuery("Select a from entitati.Angajat a where CNP=:cnp").setParameter("cnp", cnp).getResultList();
		if (!results.isEmpty()) return (Angajat) results.get(0);
		else throw new IllegalArgumentException("nu");
	}
	@Override
	public Utilizator autentificare(String user, String pass) {
		@SuppressWarnings("unchecked")
		List<Utilizator> rez=(List<Utilizator>)this.getEm().createQuery("Select u from entitati.Utilizator u where utilizator=:user and parola=:pass")
    			.setParameter("user", user).setParameter("pass", pass).getResultList();
		Utilizator u=rez.get(0);
		return u;
	}

	@Override
	public Angajat findAngajatByUser(Utilizator user) {
		@SuppressWarnings("unchecked")
		List<Angajat> results = (List<Angajat>) this.getEm().createQuery("Select a from entitati.Angajat a where utilizator=:user").setParameter("user", user).getResultList();
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
		List<Spital> results = (List<Spital>) this.getEm().createQuery("Select a from entitati.Spital a where CIF=:cif").setParameter("cif", cif).getResultList();
		if (!results.isEmpty()) return (Spital) results.get(0);
		else throw new IllegalArgumentException("nu");
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Donatie> ListaDonatii() {
		return (List<Donatie>) this.getEm().createQuery("Select d from entitati.Donatie d").getResultList();
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Donatie> ListaDonatiiByCNP(String cnp) {
		return (List<Donatie>) this.getEm().createQuery("Select d from entitati.Donatie d where donator=:don").
				setParameter("don", this.findDonatorbyCNP(cnp)).getResultList();
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Donatie> ListaDonatiiByData(Date data) {
		 return (List<Donatie>) this.getEm().createQuery("Select d from entitati.Donatie d where dataColectare=:data").
				setParameter("data", data).getResultList();
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Donatie> ListaDonatiiByCentru(Centru c) {
		
		return (List<Donatie>) this.getEm().createQuery("Select d from entitati.Donatie d where centru=:centru").
				setParameter("centru", c).getResultList();
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Spital> ListaSpitale() {
		return (List<Spital>) this.getEm().createQuery("Select s from entitati.Spital s").getResultList();
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<PersoanaContact> findPcBySpital(Spital s) {
		return (List<PersoanaContact>)this.getEm().createQuery("Select pc from entitati.PersoanaContact pc where spital=:s").setParameter("s", s).getResultList();
	}



	@Override
	public Cerere adaugaCerere(Cerere c) {
		//if(findCerereByCod(c.getCod()).getClass().equals("Cerere")){
//			return null;
//		}
//		else
		 return (Cerere) this.create(c);
	}



	@Override
	public Cerere findCerereByCod(String cod) {
		return (Cerere) this.getEm().createQuery("Select from entitati.Cerere where cod=:cod").setParameter("cod", cod).getSingleResult();
		
	}
	
	

	

	
	
  
}
