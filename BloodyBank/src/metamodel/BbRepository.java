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
		Centru findCentruByNume(String numar);
		
		
		public List<Angajat> ListaAngajati();
		public Angajat findAngajatByCnp(String cnp);
		
		public Angajat findAngajatByUser(Utilizator user);
		public Utilizator autentificare(String user, String pass);
		
		public Spital findSpitalByCif(String cif);
		public List<Spital> ListaSpitale();
		
		public Donatie adaugaDonatie(Donatie donatie);
		public List<Donatie> ListaDonatii();
		public List<Donatie> ListaDonatiiByCNP(String cnp);
		public List<Donatie> ListaDonatiiByData(Date data);
		public List<Donatie> ListaDonatiiByCentru(Centru c);
		
		public List<PersoanaContact> findPcBySpital(Spital s);
		
		public Cerere adaugaCerere(Cerere c);
		public Cerere findCerereByCod(String cod);
		
		
		
		
		
}
