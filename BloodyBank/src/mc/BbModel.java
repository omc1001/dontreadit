package mc;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import metamodel.BbRepository;
import metamodel.BbRepositoryDefault;
import entitati.Angajat;
import entitati.Centru;
import entitati.Donatie;
import entitati.Donator;
import entitati.Spital;
import entitati.Utilizator;


public class BbModel {
	
	
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
	
	public  Donator findDonatorCnp(String cnp){
		try{
		return repo.findDonatorbyCNP(cnp);
		}
		catch(NullPointerException np){
			return null;
		}
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
	
	public void addDonatie(Donatie donatie) {
		repo.adaugaDonatie(donatie);
		}
	
	public Centru findCentruByNr(String nrCentru){
		return repo.findCentruByNr(nrCentru);
	}


	public Centru findCentruByNume(String nume) {
		// TODO Auto-generated method stub
		return repo.findCentruByNume(nume);
	}
	
	
	public List<Donatie> getDonatiiByCentru(Centru c){
		return repo.ListaDonatiiByCentru(c);
	}
	
	
	public List<Donatie> getDonatii(Date data, String cnp){
		if((!(cnp==null))&&(!(data==null))){
			List<Donatie> listaCnp=repo.ListaDonatiiByCNP(cnp);
			List<Donatie> listaData=repo.ListaDonatiiByData(data);
			listaCnp.retainAll(listaData);
			return listaCnp;
		}
		else if ((!(cnp==null))&&(data==null)){
			return repo.ListaDonatiiByCNP(cnp);
		}
		else if ((cnp==null)&&(!(data==null))){
			return repo.ListaDonatiiByData(data);
		}
		else {
			return repo.ListaDonatii();
		}
	}
	
	public List<Spital> getSpitale(){
		return repo.ListaSpitale();
	}


	public List<Donatie> getDonatii() {
		return repo.ListaDonatii();
	}


	public List<Donator> ListaDonatori() {
		// TODO Auto-generated method stub
		return repo.ListaDonatori();
	}
}
