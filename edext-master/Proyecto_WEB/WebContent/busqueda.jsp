<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "Interface.*,java.util.List,java.util.ArrayList,com.google.gson.Gson,Logica.Manejador,Logica.Curso"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
<meta charset="ISO-8859-1">
<!--------------------->
<style>#page {margin:200px auto;width: 75%; color: white;opacity: 0.7;}</style> 
<style>.btn {background-color: DodgerBlue;color: white;padding: 3px 20px;font-size: 16px;cursor: pointer;}</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script>
	function goBack(){window.history.back();}
</script> 
<!--------------------->
<title>Insert title here</title>
</head>
<body background="https://us.123rf.com/450wm/yamabikay/yamabikay1705/yamabikay170500120/78105857-textura-de-cuero-verde-oscuro-en-macro-fondo-cuadrado-transparente-listo-para-el-azulejo-foto-de-alt.jpg?ver=6">

<!-------Barra-------------->
<div class="row navbar navbar-expand-sm bg-dark navbar-dark">
	<div class="col">
	<ul class="navbar-nav">
	 </ul></div>
	        <div class="col">
		<ul class="nav justify-content-end">
		<li class="nav-item"><button class="btn" onclick="goBack()"><i class="fa fa-home"></i></button></li>
		</ul>
	</div>
</div>
<!--------------------->
<div id="page">

<h3>Ordenar por:</h3>

<select class="custom-select" id="inputGroupSelect01" name="A_tipoUsuario">
				<option selected> Filtro </option>
				<option id="ascendente" value="asc">Alfabeticamente (asc)</option>
				<option id="descendente" value="desc">Por Fecha (desc)</option>
			</select>
 
<br>
<br>
<br>

<h3>Cursos</h3>
<br>

	<ul class="list-group" id="lista">
  
</ul>
</div>	

<script type="text/javascript">
 				var select="Filtro"
 	 			
     	    	var valor = localStorage.getItem("consulta");
     	    	console.log(valor);
        	   $.ajax({
          		  method: "GET",
          		  url: "http://localhost:8080/edextweb/Busqueda",
          		  data: { usr:valor, Filtro:select }
          		}).done(function(data) {
          						for(var i in data)
        	            		{ 	
          							document.getElementById("lista").innerHTML += "<li style=\"color:#525150\" class=\"list-group-item\" value='"+data[i]+"'>"+data[i]+"</li><br>"; 
 
        	           			 }
          		}).fail(function() {
          			 console.log("Algo salió mal");
          		}).always(function() {
          		  console.log("Siempre se ejecuta")
          		});
</script> 
          		  
<script type="text/javascript">
$('select#inputGroupSelect01').on('change',function(){
	 var listBox = document.getElementById("lista");
	   //listBox.options.length = 0;
	   listBox.innerHTML = '';
				var select = $(this).val();
				var valor = localStorage.getItem("consulta");
        	   $.ajax({
          		  method: "GET",
          		  url: "http://localhost:8080/edextweb/Busqueda",
          		  data: { usr:valor, Filtro:select }
          		}).done(function(data) {
          						for(var i in data)
        	            		{ 
        	                		//document.getElementById("listaBus").innerHTML += "<option value='"+data[i]+"'>"+data[i]+"</option>"; 
          							document.getElementById("lista").innerHTML += "<li style=\"color:#525150\" class=\"list-group-item\" value='"+data[i]+"'>"+data[i]+"</li><br>";  
        	           			 }
          		}).fail(function() {
          			 console.log("Algo salió mal");
          		}).always(function() {
          		  console.log("Siempre se ejecuta")
          		});
});
</script> 

</body>
</html>