<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entitati.Angajat"%>
<%@page import="java.util.Date" %>
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
<label id="data"> <%=new Date() %></label>
<h1>Cerere transfer</h1>
	
	<table>
	<tr> <td><label>Nr. Cerere:</label> </td>
    <td><input type="text" name="numar" value=${nrCerere }></td></tr>
    
    <tr> <td><h2>Cantitati </h2></td>
    <td></td></tr>
    
   	<tr> <td></td>
    <td><input type="text" name="adresa" value=${adresa } ></td></tr>
    </table>
</form>
</body>
</html>