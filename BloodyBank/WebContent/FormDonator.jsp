<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html xmlns:jsp="http://java.sun.com/JSP/Page"
      xmlns:c="http://java.sun.com/jsp/jstl/core"
      xmlns:tiles="http://tiles.apache.org/tags-tiles"
      xmlns:form="http://www.springframework.org/tags/form"
      xmlns:spring="http://www.springframework.org/tags"
      xmlns:util="urn:jsptagdir:/WEB-INF/tags/util"
      html:xhtml><jsp:directive.page import="entitati.Centru"/>
<jsp:directive.page import="java.util.ArrayList"/>
 
      
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language="javascript" type="text/javascript" src="datetimepicker.js">


</script>
<title>Donator</title>
<link href="${pageContext.request.contextPath}/Stiluri.css" rel="stylesheet" type="text/css">
</head>

<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div><b>${reply}</b></div>
<form method="POST" action="BbServlet?action=donator">
<div class="langa">
<h1> Donator</h1>
<br>

    <table>
  	<tr> 
  	<td><label>CNP: </label></td>
    <td><input type="text" name="CNP"></td>
    <td><input type="image" name="buton" value="read" src="${pageContext.request.contextPath}/images/checksign.png" width="20px" height="20px"></td></tr>
    
    <tr>
    <td> <% if (request.getSession().getAttribute("eroare").equals("dInexistent")){
    	out.print("<label>" + "Nu exista donatorul in baza de date" + "</label>");
    }
    else if (request.getSession().getAttribute("eroare").equals("")) 
    	out.print("<label>" + "Apasati butonul verde pentru a verifica daca sunteti inregistrat in baza de date" + "</label>");  
    	else out.print("<label>" + "Am gasit CNP-ul in baza de date." + "</label>");%></td>
    </tr>
    
    <tr><td><label>Nume &#351;i prenume:</label></td>
    <td><input type="text" name="nume" value=${nume} /></td></tr>  
    
    <tr><td><label>Grup&#259;:</label></td> 
    <td><input type="text" name="grupa" value=${grupa}></td> </tr>
  
   	<tr> <td><label>Telefon:</label> </td>
    <td><input type="text" name="telefon" value=${telefon}></td></tr>
    
   	<tr> <td><label>Adresa: </label></td>
    <td><input type="text" name="adresa" value=${adresa} ></td></tr>
    
    <tr><td><label>Email:</label></td>
    <td><input type="text" name="email" value=${email}></td></tr>
    
    
    
		<tr> <td><label>Centrul ales:</label></td>
    	<td> 
    	<select name="Centre" id="Centre">
   		<% ArrayList<Centru> c= (ArrayList<Centru>)request.getAttribute("Centre");
   		for(Centru a:c){
   			out.print("<option>" + a.getNumeCentru().toString() + "</option>");
   			
   		}
        %>		
        </select>
    	</td></tr>
    
    <tr><td><label>Alege&#355;i data &#351;i ora:</label></td>
    <td><input name="dataProgr" id="demo3" type="text" size="18"><a href="javascript:NewCal('demo3','ddmmmyyyy',true,24)"><img src="images/cal.gif" width="16" height="16" border="0" alt="Alege o data"></a></td></tr>
	
	<tr><td><label>Avertizare:</label> </td>
    <td><input type="text" name="avertizare"></td></tr>
    
</table>

<br><br>
<button type="submit" class="button" name="buton" value="create">Salveaz&#259;</button>&ensp;
<a href="index.jsp"><button type="button" class="button" name="anulare">Anuleaz&#259;</button></a>



</div>
</form>
</body>
</html>