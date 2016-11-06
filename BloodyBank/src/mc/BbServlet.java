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
import javax.swing.JOptionPane;

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
import entitati.Cerere;
import entitati.CerereGrupa;
import entitati.Donatie;
import entitati.Donator;
import entitati.Centru;
import entitati.PersoanaContact;



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
        dispatcher.forward(request,response);
        }
    	
    	else if(action.equals("angajat")){
    	Centru c=((Angajat)request.getSession().getAttribute("lsangajat")).getCentru();	
        request.setAttribute("donatii", model.getDonatiiByCentru(c));
        
        String nextJSP = "WEB-INF/FormAngajat.jsp";
	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    	}
    	
    	else if(action.equals("admin")){
    		 request.setAttribute("Spitale", model.getSpitale());
    		 String nextJSP = "WEB-INF/FormAdmin.jsp";
    		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
    	     dispatcher.forward(request,response);
    	}
    	else if(action.equals("rezultat")){
        	String actiune=request.getSession().getAttribute("rezultat").toString();
        	if (actiune.equals("inregDonator")){
        		request.getSession().setAttribute("mesaj", "Va asteptam sa donati la data aleasa!");
                String nextJSP = "WEB-INF/Rezultat.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                dispatcher.forward(request,response);
        	}
        	
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
 	        
    	        // recunoastere
    	        String buton= request.getParameter("buton");
    	        if (buton.equals("verificare")){
   	        	 if(model.findDonatorCnp(request.getParameter("CNP")).equals(null)){
   	        		JOptionPane.showConfirmDialog(null, "Donatorul nu a fost g&#259;sit", null, JOptionPane.YES_OPTION);
   	        		request.getRequestDispatcher("FormDonator.jsp").forward(request, response);
   	        		
   	        	 }
   	        	 else {
   	        		Donator d=model.findDonatorCnp(request.getParameter("CNP"));
   	        		request.setAttribute("CNP", d.getCnp().toString());
   	        		request.setAttribute("nume", d.getNume().toString());
   	        		request.setAttribute("telefon", d.getTelefon().toString());
   	        		request.setAttribute("adresa", d.getAdresa().toString());
   	        		request.setAttribute("email", d.getEmail().toString());
   	        		request.setAttribute("grupa", d.getGrupa().toString());
   	        		request.getRequestDispatcher("FormDonator.jsp").forward(request, response);
   	        		
   	        	 }
   	        	 
   	         }
    	        
    	        else if (buton.equals("salvare")){
    	        
        		//donator nou
    	         Donator donatorCurent=new Donator();
    	         donatorCurent.setNume(request.getParameter("nume"));
    	         donatorCurent.setCnp(request.getParameter("CNP"));
    	         donatorCurent.setAdresa(request.getParameter("adresa"));
    	         donatorCurent.setEmail(request.getParameter("email"));
    	         donatorCurent.setGrupa(request.getParameter("grupa"));
    	         donatorCurent.setTelefon(request.getParameter("telefon"));
    	         
        	 
    	         model.addDonator(donatorCurent);
    	         
    	         
    	         
    	         if (buton.equals("verificare")){
    	        	 model.findDonatorCnp(request.getParameter("CNP"));
    	        	 
    	        	 
    	        	 request.getRequestDispatcher("WEB-INF/Reusita.jsp").forward(request, response);
    	         }
    	         
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
//    	        
//    	        request.setAttribute("rezultat", "inregDonator");
    	        request.getRequestDispatcher("WEB-INF/Reusita.jsp").forward(request, response);
    	        
    	        }
    	        }
    	       // }
    	        else if(action.equals("angajat")){
    	        	response.setContentType("text/html");
    	        	    	        	
    	      }
    	        
    	        else if(action.equals("spital")){
    	        	response.setContentType("text/html");
    	        	
    	        	//cerere noua
    	        	Cerere cerereCurenta=new Cerere();
    	        	cerereCurenta.setCod(request.getParameter("numar"));
    	        	cerereCurenta.setDataInreg(new Date());
					
    	        	
    	        	//cererile pe fiecare grupa
    	        	String [] grupaL={"A", "B", "AB","0"};
    	        	String [] grupaS={"+","-"};
    	        	
    	        	List<String> grupa=new ArrayList<String>();
    	        	
    	        	for(String i:grupaL){
    	        		for(String j:grupaS){
    	        			grupa.add(i+j);
    	        		}
    	        	}
    	        	List<CerereGrupa> linii=new ArrayList<CerereGrupa>();
    	        	for (String g:grupa){
    	        		if(!((request.getParameter(g)).isEmpty())){
    	        			CerereGrupa cg=new CerereGrupa();
    	        			cg.setCerere(cerereCurenta);
    	        			cg.setTip(g);
    	        			cg.setCantitate(Double.parseDouble(request.getParameter(g)));
    	        			linii.add(cg);
    	        		};
    	        	}
    	        	cerereCurenta.setLinii(linii);
    	        	cerereCurenta.setStatus(false);
    	        	PersoanaContact pc=(PersoanaContact)request.getSession().getAttribute("lsangajat");	
    	        	cerereCurenta.setDestinatar(pc.getSpital());
    	        	model.addCerere(cerereCurenta);
    	        	
    	        }
    	        
    	        else if(action.equals("admin")){
    	        	response.setContentType("text/html");
    	        	
    	        	
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