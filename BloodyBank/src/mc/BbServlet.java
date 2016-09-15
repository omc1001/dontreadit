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
        String nextJSP = "/FormDonator.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);}
    	
    	
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
    	         
    	        //donator
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
    	         
    	         SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
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
    	         
    	        // response.sendRedirect("Eroare.jsp");
    	        
    	        }
    	        
    	        else if(action.equals("angajat")){
    	        	response.setContentType("text/html");
    	        	
    	        	request.setAttribute("numeAngajat", request.getAttribute("lsangajat").toString());
    	        	
    	        	//filtre donatii 
//    	        	Centru c=((Angajat)request.getSession().getAttribute("lsangajat")).getCentru();
//    	        	List<Donatie> donatii=model.getDonatiiByCentru(c);
//    	        	
//    	        	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
//       	        Date dataCol=null; 
//    	        try {
//   					dataCol=sdf.parse(request.getParameter("dataCol"));
//   				} catch (ParseException e) {
//   					// TODO Auto-generated catch block
//   					e.printStackTrace();
//   				}
//    	        
//    	        String cnp=request.getParameter("cnp");
//    	        List<Donatie> donatiiFiltre=model.getDonatii(dataCol, cnp);
//    	        
//    	        List<Donatie> common=new ArrayList<Donatie>(donatii);
//    	        common.retainAll(donatiiFiltre);
//    	        
//    	        request.setAttribute("donatii", common);
    	        
    	        
    	        	
        	         
    	        }
    	 }
     
    	        
     	
     	finally{
     		if (model.getEm().getTransaction().isActive())
                 {model.getEm().getTransaction().rollback();
     			model.getEm().close();}
     	}
    	 }
             
        
}