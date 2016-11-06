package mc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import entitati.Angajat;
import entitati.Centru;
import entitati.Cerere;
import entitati.CerereGrupa;
import entitati.Donatie;
import entitati.Donator;
import entitati.PersoanaContact;
import entitati.Spital;
import entitati.Utilizator;

public class Main {

	
	public static void main(String[] args) {
		
		BbModel model = new BbModel();
		
		SimpleDateFormat d= new SimpleDateFormat("dd/MM/YYYY");
		Date a=new Date();
		try {
			a = d.parse("10/05/2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.getEm().getTransaction().begin();
		//Angajat b=new Angajat("Lavinia Ciobanu", "2900213155236", "0751996332", new Utilizator("laviniac", "ciobanulavinia", "master"));
		Angajat b=model.getEm().find(Angajat.class, "2900213155236");
		b.getUtilizator().setAngajat(b);
		//model.getEm().persist(b);
		model.getEm().getTransaction().commit();
	
		model.getEm().close();

		
	}

}
