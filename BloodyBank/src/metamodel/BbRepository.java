package metamodel;

import java.util.List;

import entitati.Centru;
import entitati.Donator;

public interface BbRepository extends Tranzactii{
	
		public Donator adaugaDonator(Donator donator);
		public Donator actualizareDonator (Donator donator);
		public void stergeDonator(Donator donator);
		public List<Donator> ListaDonatori();
		public Donator findDonatorbyCNP(String cnp);
		
		public List<Centru> ListaCentre();
		
}
