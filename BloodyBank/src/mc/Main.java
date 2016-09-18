package mc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entitati.Angajat;
import entitati.Centru;
import entitati.Donatie;
import entitati.Donator;
import entitati.PersoanaContact;
import entitati.Spital;
import entitati.Utilizator;

public class Main {

	
	public static void main(String[] args) {
		
		BbModel model = new BbModel();
		
		
		model.getEm().getTransaction().begin();
		
		
		
		model.getEm().getTransaction().commit();
	
		model.getEm().close();

		
	}

}
