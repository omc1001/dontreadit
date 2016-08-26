package mc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
 
  
    BbModel model=new BbModel();
	 
    @Autowired
    private BbValidator validator; 
   
    
    @RequestMapping(value="/list", method=RequestMethod.POST) 
    public String onSubmit(@ModelAttribute("cboCentre")Centru c, 
        BindingResult result) { 
         if (result.hasErrors()) 
            return "Eroare.jsp"; 
        
        return "redirect:index.jsp"; 
        
    } 
    
    @RequestMapping(value="/list", method=RequestMethod.GET) 
    public String initializeForm(Model m) { 
    	
        // Perform and Model / Form initialization
        List<Centru> cboCentre=model.ListaCentre();
        m.addAttribute("toateCentrele", cboCentre);
        m.addAttribute("cboCentre", model.ListaCentre());
        return "refresh:FormDonator.jsp"; 
    } 
    
    

		//initierea unui nou donator
    		
  
        	
    @RequestMapping(value="/donator", params = {"nume", "CNP", "adresa", "email", "grupa", "telefon"})
        			public @ResponseBody Donator d(
        			@RequestParam(value = "nume") String nume, 
        			@RequestParam(value = "CNP") String CNP, 
        			@RequestParam(value = "adresa") String adresa, 
        			@RequestParam(value = "email") String email, 
        			@RequestParam(value = "grupa") String grupa, 
        			@RequestParam(value = "telefon") String telefon) {
    					Donator donatorCurent=new Donator();
				        donatorCurent.setNume("nume");
				        donatorCurent.setCnp("CNP");
				        donatorCurent.setAdresa("adresa");
				        donatorCurent.setEmail("email");
				        donatorCurent.setGrupa("grupa");
				        donatorCurent.setTelefon("telefon");
				        model.addDonator(donatorCurent);
				        return donatorCurent;
        			}
        	
//            
//            
//   
//    else if (action.equals("angajat")){
//    	
//    	response.setContentType("text/html");
//    	
//    	Angajat a=(Angajat) request.getSession().getAttribute("lsangajat");
//    	request.setAttribute("nume", "nume");
//    	//request.setAttribute("nume", a.getNume().toString());
//    	request.setAttribute("functie", a.getFunctie().toString());
//    	request.setAttribute("centru", a.getCentru().getNumeCentru().toString());
//    	
// 		RequestDispatcher r = request.getRequestDispatcher("FormAngajat.jsp");
//        //rd.forward(request, response);
//    }
//    	}
//    	
//    	finally{
//    		if (model.getEm().getTransaction().isActive())
//                model.getEm().getTransaction().rollback();
//    			model.getEm().close();
//    	}}
            
            
           
            
        
//    @Override
//    protected void doPost(
//        HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        doGet(request, response);
//    }
}