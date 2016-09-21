


var model = '@Html.Raw(Json.Encode(BbModel))';

function checkCNP(){
	
	 var xhttp = new XMLHttpRequest();
	 xhttp.onreadystatechange = function(){
	
	if (!(model.findDonatorCnp(cod).equals(null))){
		var cod=document.getElementById("CNP").value;
		Donator d=model.findDonatorCnp(cod);
		document.getElementByName("nume").value=d.getNume().toString();
		document.getElementByName("grupa").value=d.getNume().toString();
		document.getElementByName("telefon").value=d.getNume().toString();
		document.getElementByName("adresa").value=d.getNume().toString();
		document.getElementByName("email").value=d.getNume().toString();
		
	}
	else window.alert("Donatorul nu a fost g&#259;sit");}
	 xhttp.open("POST", '@Url.Action("donator","BbServlet")', true);
	 xhttp.send();
	 
	
}
