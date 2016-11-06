package metamodel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public abstract class AbstractRepository implements Tranzactii {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/BloodyBank.odb");
	private static EntityManager em=emf.createEntityManager();
	

	public void beginTransaction() {
		this.getEm().getTransaction().begin();
	}

	public void commitTransaction() {
		this.getEm().getTransaction().commit();
	}

	public Object create(Object o) {
		this.beginTransaction();
		this.getEm().persist(o);
		this.commitTransaction();
		return o;
	}

	public Object update(Object o) {
		Object managedEntity = AbstractRepository.em.merge(o);
		return managedEntity;
	}

	public void delete(Object o) {
		this.getEm().remove(o);

	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		AbstractRepository.em = em;
	}
	
	public  EntityManagerFactory getEmf(){
		return emf;
	}
}
