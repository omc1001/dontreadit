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
	
	<tr><td><label>Alege&#355;i data &#351;i ora:</label></td>
    <td><input name="dataCol" id="demo3" type="text" size="18">
    <a href="javascript:NewCal('demo3','ddmmmyyyy',true,24)"><img src="images/cal.gif" width="16" height="16" border="0" alt="Alege o data"></a></td></tr>
	
	<tr><td><label>Introduce&#355;i CNP:</label></td>
    <td><input name="cnp" type="text" size="18"></td></tr>
	</table>
	<table>
  <tr>
    <th>CNP</th>
    <th>Donator</th>
    <th>Data programare</th>
    <th>Cantitate</th>
  </tr>
  <%
  	for (Donatie d: (List<Donatie>)request.getSession().getAttribute("donatii")){
  		out.print("<tr><td>"+d.getDonator().getCnp()+"</td>	<td>"+d.getDonator().getNume()+"</td><td>"+d.getDataProgramata().toString()+"</td><td>"+d.getCantitate()+"</td></tr>");
  	}
  %>
  </table>
	<div>
	
	</div>
	
	
	
</form>
</body>
</html>