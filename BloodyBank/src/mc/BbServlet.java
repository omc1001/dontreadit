package mc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import entitati.Angajat;
import entitati.Donatie;
import entitati.Donator;
import entitati.Centru;
 

public class BbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    
    BbModel model=new BbModel();
    
    
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	try{
    	String action = request.getParameter("action");
    	if (action.equals("donator"))
    	{    
        //centre
//    	
       response.setContentType("text/html");
//    	ArrayList<Centru> lista=new ArrayList();
//    	lista.clear();
//		for (Centru c:model.ListaCentre()){
//			lista.add(c);
//			;}
//		request.setAttribute("Centre", lista);
//		RequestDispatcher rd = request.getRequestDispatcher("FormDonator.jsp");
//        rd.forward(request, response);
    	
		//initierea unui nou donator
    		Centru centruCurent=model.ListaCentre().get(Integer.parseInt(request.getParameter("centre")));
    		Date dataProgramare=new Date();
        	Donator donatorCurent=new Donator();
        
            donatorCurent.setNume(request.getParameter("nume").toString());
            donatorCurent.setCnp(request.getParameter("CNP").toString());
            donatorCurent.setAdresa(request.getParameter("adresa").toString());
            donatorCurent.setEmail(request.getParameter("email").toString());
            donatorCurent.setGrupa(request.getParameter("grupa").toString());
            donatorCurent.setTelefon(request.getParameter("telefon").toString());
            
//            if (!request.getParameter("avertizare").isEmpty())
//            	donatorCurent.setAvertizare(request.getParameter("avertizare"));
            
            if (request.getParameter("salvare")!=null)
            	model.addDonator(donatorCurent);
            
            Donatie donatieCurenta=new Donatie(donatorCurent, centruCurent,  dataProgramare);
            
            
    	}
            
            
   
    else if (action.equals("angajat")){
    	
    	response.setContentType("text/html");
    	
    	Angajat a=(Angajat) request.getSession().getAttribute("lsangajat");
    	request.setAttribute("nume", "nume");
    	//request.setAttribute("nume", a.getNume().toString());
    	request.setAttribute("functie", a.getFunctie().toString());
    	request.setAttribute("centru", a.getCentru().getNumeCentru().toString());
    	
 		RequestDispatcher r = request.getRequestDispatcher("FormAngajat.jsp");
        //rd.forward(request, response);
    }
    	}
    	
    	finally{
    		if (model.getEm().getTransaction().isActive())
                model.getEm().getTransaction().rollback();
    			model.getEm().close();
    	}}
            
            
           
            
        
    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}