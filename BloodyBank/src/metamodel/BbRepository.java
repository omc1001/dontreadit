package metamodel;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entitati.Angajat;
import entitati.Centru;
import entitati.Donator;
import entitati.Spital;
import entitati.Utilizator;

public interface BbRepository extends Tranzactii{
	
		public EntityManagerFactory getEmf();
		public EntityManager getEm();
		
		public Donator adaugaDonator(Donator donator);
		public Donator actualizareDonator (Donator donator);
		public void stergeDonator(Donator donator);
		public List<Donator> ListaDonatori();
		public Donator findDonatorbyCNP(String cnp);
		
		public Centru findCentruByNr(String numar);
		public List<Centru> ListaCentre();
		
		public List<Angajat> ListaAngajati();
		public Angajat findAngajatByCnp(String cnp);
		
		public Angajat findAngajatByUser(Utilizator user);
		public Utilizator autentificare(String user, String pass);
		
		public Spital findSpitalByCif(String cif);
		
		
}
