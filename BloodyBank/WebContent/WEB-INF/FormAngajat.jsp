<%@page import="entitati.Angajat"%>
<%@page import="entitati.Donatie"%>
<%@page import="java.text.SimpleDateFormat" %> 
<%@page import="java.util.Date" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Angajat</title>
<link href="${pageContext.request.contextPath}/Stiluri.css" rel="stylesheet" type="text/css">
</head>
<body>
<form method="post" action = "BbServlet?action=angajat" class="langa" >
	<div style="align: right">
	
	<label id="numeAngajat" >Angajat: <%=((Angajat)request.getSession().getAttribute("lsangajat")).getNume()%></label><br>
	
	<label id="dataCurenta"> 
	<% SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
	out.print(sdf.format(new Date()));%></label>
	</div>
	<table>
	
	
	<tr><td><label>Introduce&#355;i CNP:</label></td>
    <td><input name="cnp" type="text" size="18"></td></tr>
	</table>
	
	
	<table id="tblDonatii">
  <tr>
    <th>CNP</th>
    <th>Donator</th>
    <th>Data programare</th>
    <th>Data colectare</th>
    <th>Cantitate</th>
  </tr>
  <%
  	List<Donatie> donatii=(List<Donatie>)request.getAttribute("donatii");
  	for (Donatie d: donatii){
  		out.print("<tr><td>"+d.getDonator().getCnp().toString()+"</td><td>"+d.getDonator().getNume().toString()+"</td><td>"+d.getDataProgramata().toString()+"</td><td>"+d.getDataColectare().toString()+"</td><td>"+d.getCantitate().toString()+"</td></tr>");
  	}
  %>
  </table>
	<div>
	
	</div>
	
	
	
</form>
</body>
</html>