<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logare</title>
<link href="${pageContext.request.contextPath}/Stiluri.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="langa">
<h1> Autentificare</h1><br>

        <form method="post" action="LoginServlet">        
        Utilizator:&nbsp;<input type="text" id="utilizator" name="utilizator"/><br/><br/>
        Parol&#259;:&nbsp;<input type="password" id="parola" name="parola" /><br/><br/>
        <input type="submit" class="button" value="Logare" />
        </form>
</div>
</body>
</html>