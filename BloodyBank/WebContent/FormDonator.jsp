<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Donator</title>
<link href="${pageContext.request.contextPath}/Stiluri.css" rel="stylesheet" type="text/css">
</head>

<body>
<form method="post" action="/BbServlet">
<div class="langa">


<h1> Donator</h1>
<br>
<table>
  <tr>
    <td><label>Nume &#351;i prenume:</label></td>
    <td><input type="text" name="nume" ></td>
  </tr>  
    <tr><td><label>Grup&#259;:</label></td> 
    <td><input type="text" name="grupa"></td> </tr>
  <tr>
    <td><label>CNP: </label></td>
    <td><input type="text" name="CNP"></td></tr>
   <tr> <td><label>Telefon:</label> </td>
    <td><input type="text" name="telefon"></td></tr>
   <tr> <td><label>Adresa: </label></td>
    <td><input type="text" name="adresa"></td></tr>
    <tr> <td><label>Centrul ales:</label></td>
    <td><optgroup label="centre"></optgroup></td></tr>
    <tr><td><label>Avertizare:</label> </td>
    <td><input type="text" name="avertizare"></td>
  </tr>
    
</table>

<br><br>
<button type="submit" class="button" name="salvare">Salveaz&#259;</button>&ensp;
<a href="PaginaPrincipala.jsp"><button type="button" class="button" name="anulare">Anuleaz&#259;</button></a>



</div>
</form>
</body>
</html>