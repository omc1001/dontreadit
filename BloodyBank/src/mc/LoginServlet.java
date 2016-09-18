package mc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entitati.Angajat;
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		BbModel model=new BbModel();
		
			String user = request.getParameter("utilizator");
	        String pass = request.getParameter("parola");
	       
	        if (!model.autentificare(user, pass).equalsIgnoreCase("neautentificat")){
	        	
	        	Angajat a= model.findAngajatByUser(model.getUtilizator(user, pass));
  	       		request.getSession().setAttribute("lsangajat", a);
	         		
	        		
	         		if (model.autentificare(user, pass).equalsIgnoreCase("regular"))
	         		{
		        	request.getRequestDispatcher("/WEB-INF/FormAngajat.jsp").forward(request, response);
		        	return;
	         		}
				         else if (model.autentificare(user, pass).equalsIgnoreCase("master"))
				        		{request.getRequestDispatcher("WEB-INF/FormAdmin.jsp").forward(request, response);       	
				        		}
	        }
	        else
	        {
	        	response.sendRedirect("Eroare.jsp");
	        	
	        }
	        
	        

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	        doGet(request, response);
	}

}
