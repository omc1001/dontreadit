<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entitati.Angajat"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/Stiluri.css" rel="stylesheet" type="text/css">

<title>Cerere Transfer</title>
</head>
<body>
<form method="post" action = "BbServlet?action=spital" class="langa" >

<label id="numeAngajat" >Angajat: <%=((Angajat)request.getSession().getAttribute("lsangajat")).getNume()%></label><br>
<label id="data"> <% SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
	out.print(sdf.format(new Date()));
	%></label>
	
	<h1>Cerere de transfer</h1>
	
	<table>
	<tr> <td><label>Nr. Cerere:</label> </td>
    <td><input type="text" name="numar" value=${nrCerere }></td></tr>
    
    <tr> <td><h2>Cantitati </h2></td>
    <td></td></tr>
    
   	<tr> <td>A+</td><td><input type="text" name="A+"></td></tr>
	<tr> <td>B+</td><td><input type="text" name="B+"></td></tr>
	<tr> <td>AB+</td><td><input type="text" name="AB+"></td></tr>
	<tr> <td>0+</td><td><input type="text" name="0+"></td></tr>
	<tr> <td>A-</td><td><input type="text" name="A-"></td></tr>
	<tr> <td>B-</td><td><input type="text" name="B-"></td></tr>
	<tr> <td>AB-</td><td><input type="text" name="AB-"></td></tr>
	<tr> <td>0-</td><td><input type="text" name="0-"></td></tr>
	
    </table>
    <button type="submit" class="button" name="buton">Salveaz&#259;</button>&ensp;
	<a href="index.jsp"><button type="button" class="button" name="anulare">Anuleaz&#259;</button></a>
   
</form>
</body>
</html>