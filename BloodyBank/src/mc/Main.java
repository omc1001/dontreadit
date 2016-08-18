package mc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entitati.Angajat;
import entitati.Centru;
import entitati.Utilizator;

public class Main {

	
	public static void main(String[] args) {
		
		BbModel model = new BbModel();
		//List<Angajat> ang=new ArrayList<Angajat>();
		
		
		
		model.manager.getTransaction().begin();
		
		Angajat a5=new Angajat("Stiuca Vlad", "1851010321321", "0745123123", "Nicolina 3, bl. 280, ap. 5", "vlad_stiuca@yahoo.com", new Date(11-01-11), "asistent medical", model.getRepo().findCentruByNr("1001"), new Utilizator("vlads", "stiucavlad", "regular"));
		Angajat a2=new Angajat("Cursescu Adriana", "2750606214583", "0778256236", "Tudor Vladimirescu 78, sc. B, ap 3", "adrianacursescu@hotmail.com", new Date(11-01-11), "doctor", model.getRepo().findCentruByNr("A1002"), new Utilizator("adrianac", "cursescuadriana", "regular"));
		Angajat a3=new Angajat("Amariei Daniela Teodora", "2670303111222", "0751523697", "Tudor Neculai 3", "dana.amariei@gmail.com", new Date(11-01-11), "asistent medical", model.getRepo().findCentruByNr("A1002"), new Utilizator("danielaa", "amarieidaniela", "regular"));
		Angajat a4=new Angajat("Cristea Corneliu", "1900925132156", "0787546981", "Bld. Poitiers 36, bl. 28, ap. 30", "corneliuc@gmail.com", new Date(11-01-11), "doctor", model.getRepo().findCentruByNr("B2005"), new Utilizator("corneliuc", "cristeacorneliu", "regular"));
		
		Angajat a6=new Angajat("Andone Demetra", "2920123123123", "0723456456", "Moara de Foc 43, bl. 100, ap. 6", "andonedem@gmail.com", new Date(11-01-11), "asistent medical", model.getRepo().findCentruByNr("B2005"), new Utilizator("demetraa", "andonedemetra", "regular"));
		Angajat a7=new Angajat("Sima Claudiu", "1870203654789", "0748596596", "Pacurari nr. 6, bl 78, sc. A, ap. 3", "claudiusima@hotmail.com", new Date(11-01-11), "doctor", model.getRepo().findCentruByNr("B2005"), new Utilizator("claudius", "simaclaudiu", "regular"));
		Angajat a8=new Angajat("Ipatescu Emil", "1720220123056", "0788120365", "Pacurari nr. 21, bl. 135, ap. 15", "limeucsetapi@yahoo.com", new Date(11-01-11), "asistent medical", model.getRepo().findCentruByNr("A1003"), new Utilizator("emili", "ipatescuemil", "regular"));
		Angajat a9=new Angajat("Darie Elena", "2861213285689", "0742151248", "Lacului 46, bl. 345, ap. 12", "darie_elena@gmail.com", new Date(11-01-11), "doctor", model.getRepo().findCentruByNr("A1003"), new Utilizator("andreib", "bobicaandrei", "regular"));
		
		Angajat a10=new Angajat("Costin Adrian Dumitru", "1830215235658", "0332568954", "Garii 45, bl. 90, ap. 12", "dumitru.costin@gmail.com", new Date(11-01-11), "asistent medical", model.getRepo().findCentruByNr("A1003"), new Utilizator("dumitruc", "costindumitru", "regular"));
		Angajat a11=new Angajat("Oltenescu Livia", "2791201369568", "0232151586", "Palatului 2, bl. 211, ap. 7", "liviaolt@yahoo.com", new Date(11-01-11), "doctor", model.getRepo().findCentruByNr("C3002"), new Utilizator("liviao", "oltenesculivia", "regular"));
		Angajat a12=new Angajat("Terent Adina", "2831002159368", "0758753265", "Nicolina 3, bl. 78, ap. 65", "ad.terent@gmail.com", new Date(11-01-11), "doctor", model.getRepo().findCentruByNr("C3002"), new Utilizator("adinat", "terentadina", "regular"));
		
		
		Angajat[] angajati = {a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12};
		for(Angajat i:angajati){
			model.manager.persist(i);
		}
		
		model.manager.getTransaction().commit();
		
		
		
		
		
		
		model.manager.close();
		model.emf.close();
		
	}

}
