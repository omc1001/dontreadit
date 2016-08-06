package mc;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.jws.WebService;
import javax.persistence.*;

import entitati.Donator;
 

public class BbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    
    BbModel model=new BbModel();
   
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        	
    	 EntityManagerFactory emf =
    	           (EntityManagerFactory)getServletContext().getAttribute("emf");
    	        EntityManager em = emf.createEntityManager();
    	        
    	try{
    	Donator donatorCurent=new Donator();
        
            donatorCurent.setNume(request.getParameter("nume"));
            donatorCurent.setCnp(request.getParameter("CNP"));
            donatorCurent.setAdresa(request.getParameter("adresa"));
            donatorCurent.setEmail(request.getParameter("email"));
            donatorCurent.setGrupa(request.getParameter("grupa"));
            donatorCurent.setTelefon(request.getParameter("telefon"));
            if (!request.getParameter("avertizare").isEmpty())
            	donatorCurent.setAvertizare(request.getParameter("avertizare"));
        
            model.setDonatorCurent(donatorCurent);
            
            if (request.getParameter("salveaza")!=null)
            	model.saveDonator(donatorCurent);}
    	
    	
    	finally{
    		if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            em.close();
    	}
           
            
    };
            
            
           
            
        
    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}