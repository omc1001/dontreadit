package mc;
import java.io.IOException;
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

        String nextJSP = "/FormDonator.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
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
    	           
    	        
    	        //centre
    	        request.setAttribute("Centre", model.ListaCentre());
    	        
    	        
    	 		

    	         //donator
    	         Donator donatorCurent=new Donator();
    	         donatorCurent.setNume(request.getParameter("nume"));
    	         donatorCurent.setCnp(request.getParameter("CNP"));
    	         donatorCurent.setAdresa(request.getParameter("adresa"));
    	         donatorCurent.setEmail(request.getParameter("email"));
    	         donatorCurent.setGrupa(request.getParameter("grupa"));
    	         donatorCurent.setTelefon(request.getParameter("telefon"));
    	         model.addDonator(donatorCurent);
    	         
    	         //m.close();
    	         
    	         String nextJSP = "/FormDonator.jsp";
     	        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
    	         dispatcher.forward(request, response);
    	        
    	        }
    	 }
     
    	        
     	
     	finally{
     		if (model.getEm().getTransaction().isActive())
                 {model.getEm().getTransaction().rollback();
     			model.getEm().close();}
     	}
    	 }
             
        
}