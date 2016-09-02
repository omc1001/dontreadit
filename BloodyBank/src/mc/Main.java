package mc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entitati.Angajat;
import entitati.Centru;
import entitati.Donator;
import entitati.PersoanaContact;
import entitati.Spital;
import entitati.Utilizator;

public class Main {

	
	public static void main(String[] args) {
		
		BbModel model = new BbModel();
		
		model.getEm().getTransaction().begin();
		Donator a=new Donator("Ana Aremere", "2781201223002","Nicolina 2","rachita@micsunele.com", "0745123012","B+");
		model.getEm().persist(a);
		model.getEm().getTransaction().commit();
	
		model.getEm().close();

		
	}

}
