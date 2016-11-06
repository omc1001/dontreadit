<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entitati.Angajat"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="entitati.Spital"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<html xmlns:jsp="http://java.sun.com/JSP/Page"
      xmlns:c="http://java.sun.com/jsp/jstl/core"
      xmlns:tiles="http://tiles.apache.org/tags-tiles"
      xmlns:form="http://www.springframework.org/tags/form"
      xmlns:spring="http://www.springframework.org/tags"
      xmlns:util="urn:jsptagdir:/WEB-INF/tags/util"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/Stiluri.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form method="POST" action="BbServlet?action=admin">
	<div class="langa">
	<label id="numeAngajat" >Angajat: <%=((Angajat)request.getSession().getAttribute("lsangajat")).getNume()%></label><br>
	<label id="dataCurenta"> 
	<% SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
	out.print(sdf.format(new Date()));%></label>

	<h1>Cereri de transfer</h1>
	 
	<table>
	<tr> <td><label>Spital:</label></td>
    <td> 
    <select name="Spitale" id="Spitale">
   	<% List<Spital> s= (ArrayList<Spital>)request.getAttribute("Spitale");
   	for(Spital a : s){
   	out.print("<option>" + a.getDenumire().toString() + "</option>");
   	}
    %>		
    </select>
    </td></tr>
	<tr> <td>A+</td><td><input type="text" name="A+"></td></tr>
	<tr> <td>B+</td><td><input type="text" name="B+"></td></tr>
	<tr> <td>AB+</td><td><input type="text" name="AB+"></td></tr>
	<tr> <td>0+</td><td><input type="text" name="0+"></td></tr>
	<tr> <td>A-</td><td><input type="text" name="A-"></td></tr>
	<tr> <td>B-</td><td><input type="text" name="B-"></td></tr>
	<tr> <td>AB-</td><td><input type="text" name="AB-"></td></tr>
	<tr> <td>0-</td><td><input type="text" name="0-"></td></tr>
</table>
</div>
</form>

</body>
</html>