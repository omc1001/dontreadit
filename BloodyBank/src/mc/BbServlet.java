package mc;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.swing.JOptionPane;

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
		response.setContentType("text/html");
		
		//logarea utilizatorilor
    	
        String user = request.getParameter("utilizator");
        String pass = request.getParameter("parola");
        
        if (model.autentificare(user, pass).equalsIgnoreCase("regular"))
        		response.sendRedirect("FormAngajat.jsp");
        else if (model.autentificare(user, pass).equalsIgnoreCase("master"))
        		response.sendRedirect("FormAdmin.jsp");	        	
        else
        {
        	JOptionPane.showMessageDialog(null, "Ati introdus utilizatorul sau parola gresit");
        	response.sendRedirect("Logare.jsp");
        	
        }
    	
        //formular donator 
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("TestServlet says hi<br/>");
		for (Centru c:model.ListaCentre()){
        	request.setAttribute("Centre", c.getNumeCentru());}
		RequestDispatcher rd = request.getRequestDispatcher("FormDonator.jsp");
        rd.forward(request, response);
        	
        
        	
		//initierea unui nou donator
    	
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
            
            
                         	
            
            
            
            
	}
            
            
    	finally{
//    		if (model.manager.getTransaction().isActive())
//                model.manager.getTransaction().rollback();
//            model.manager.close();
    	}
           
            
    };
            
            
           
            
        
    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}