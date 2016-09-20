package mc;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;












import entitati.Angajat;
import entitati.Donatie;
import entitati.Donator;
import entitati.Centru;



@Controller@RequestMapping("/FormDonator") 
public class BbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
   
    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String action = request.getParameter("action");
    	BbModel model=new BbModel();
    	
    	if (action.equals("donator")) {
    	 //centre
    	request.setAttribute("Centre", model.ListaCentre());
    	request.setAttribute("eroare", "");
        String nextJSP = "/FormDonator.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
        }
    	
    	
    	
    	if(action.equals("angajat")){
    	Centru c=((Angajat)request.getSession().getAttribute("lsangajat")).getCentru();	
        request.setAttribute("donatii", model.getDonatiiByCentru(c));
        
        
        String nextJSP = "WEB-INF/FormAngajat.jsp";
	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    	}
    }
  
   
    
    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 BbModel model=new BbModel();
    	  
    	 try {
    		 	EntityManager m=model.getEm();
    	        String action = request.getParameter("action");
    	       
    	        if (action.equals("donator")) {
    	        response.setContentType("text/html");
    	        
    	        if (request.getParameter("buton").equals("read")){
    	        	
    	        	Donator dform=model.findDonatorCnp(request.getParameter("CNP"));
    	        	
    	        	if (!(dform==null))
    	        	{
    	        		//daca exista, trimitere catre jsp
    	        		request.setAttribute("reply", "User Already Exists"); // Just an example
    	        		request.setAttribute("CNP", dform.getCnp().toString());
    	        		request.setAttribute("nume", dform.getNume().toString());
    	        		request.setAttribute("telefon", dform.getTelefon().toString());
    	        		request.setAttribute("adresa", dform.getAdresa().toString());
    	        		request.setAttribute("email", dform.getEmail().toString());
    	        		
    	        		
    	        	}
    	        	else{
    	        		//eroare daca nu este gasit
    	        		request.setAttribute("eroare", "Donatorul nu a fost gasit");
    	        		
    	        	}
    	        	
    	        }
        	 else {
        		//donator nou
    	         Donator donatorCurent=new Donator();
    	         donatorCurent.setNume(request.getParameter("nume"));
    	         donatorCurent.setCnp(request.getParameter("CNP"));
    	         donatorCurent.setAdresa(request.getParameter("adresa"));
    	         donatorCurent.setEmail(request.getParameter("email"));
    	         donatorCurent.setGrupa(request.getParameter("grupa"));
    	         donatorCurent.setTelefon(request.getParameter("telefon"));
    	         
        	 
    	         model.addDonator(donatorCurent);
    	         
    	         // donatie
    	         Donatie donatieCurenta=new Donatie();
    	         Centru centruAles=model.findCentruByNume(request.getParameter("Centre"));
    	         donatieCurenta.setCentru(centruAles);
    	         
    	         SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY HH:mm");
    	         Date dataP=new Date();
    	         try {
					dataP=sdf.parse(request.getParameter("dataProgr"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	        donatieCurenta.setDataProgramata(dataP);
    	        
    	        donatieCurenta.setDonator(donatorCurent);
    	         
    	        model.addDonatie(donatieCurenta);
    	        
    	        }
    	        }
    	        else if(action.equals("angajat")){
    	        	response.setContentType("text/html");
    	        	
    	        	request.setAttribute("numeAngajat", request.getAttribute("lsangajat").toString());
    	        	
    	      }
    	 }
     
    	        
     	
     	finally{
     		if (model.getEm().getTransaction().isActive())
                 {
     			model.getEm().getTransaction().rollback();
     			model.getEm().close();}
     	}
    	 }
             
        
}