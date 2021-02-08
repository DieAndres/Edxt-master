 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
<style>#page {margin:200px auto;width: 75%; color: white;opacity: 0.7;}</style>  
<style>.btn {background-color: DodgerBlue;color: white;padding: 3px 20px;font-size: 16px;cursor: pointer;}</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script>
	function goBack(){window.history.back();}
</script> 
<!-- -----------Search Bar---------------- -->
 <style>.topnav input[type=text] {padding: 5px;margin-top: 8px;font-size: 15px;border: none;float: top;}</style>
<style>.topnav .search-container button {float: right;padding: 5px 9px;margin-top: 8px;margin-right: 16px;background: #ddd;font-size: 13px;border: none;cursor: pointer;}}</style>
  <style> .topnav .search-container {float: right;} </style>
  <!-- --------------------------------------- -->
</head>
<body  background="https://us.123rf.com/450wm/yamabikay/yamabikay1705/yamabikay170500120/78105857-textura-de-cuero-verde-oscuro-en-macro-fondo-cuadrado-transparente-listo-para-el-azulejo-foto-de-alt.jpg?ver=6">
<!-- --------------------SEARCH BAR----------------------------------------- -->

<div class="row mr-auto navbar-expand-sm bg-dark navbar-dark">
<div class="col">
<ul class="nav justify-content-end">
	<div class="topnav">
		<div class="search-container">
		  <input id="barraBuscar" type="text" placeholder="Search..">
		  <button id="botonBuscar" type="submit"><i class="fa fa-search"></i></button>
		</div>
		</div>
</ul>		
</div>
</div>
<!-- ------------------------------------------------------------- -->
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
<div id="page" >
	<form action="ConsultaUsuario" method="get">
	<h2>Consultar Usuario</h2>
	<div class="dropdown" align="left">
	    <select id="dropdownlist" name="usuario" class="form-control">
	    	<option selected="true" value="" disabled>Seleccionar Usuario</option>
	    </select>  
	    <br/><br/>
	</div>
	  <div class="form-row">
	    <div class="col">
	      <label for="OutputNombre" class="text-white">Nombre</label>
	      <input type="text" class="form-control" id="OutputNombre" readonly>
	    </div>
	    <div class="col">
	      <label for="OutputApellido">Apellido</label>
	      <input type="text" class="form-control" id="OutputApellido" readonly>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="OutputEmail">Email address</label>
	    <input type="email" class="form-control" id="OutputEmail" aria-describedby="emailHelp" readonly>
	  </div>
	  <div class="form-group">
      	<label for="OutputFecha">Fecha de nacimiento</label>
        <input type="text" class="form-control" id="OutputFecha" name="fFin" readonly>
      </div>
	</form>
</div>

<script type="text/javascript">
	$(document).ready(function(){
         console.log("hola4");
    	 $.ajax({
    		  method: "GET",
    		  url: "http://localhost:8080/edextweb/ConsultaUsuario"
    		  
    		}).done(function(data) {
    		 	var array=[];
    		 	 function cargar_provincias()
  	        	{
  	            		for(var i in data)
  	            		{ 
  	            			document.getElementById("dropdownlist").innerHTML += "<option value='"+data[i]+"'>"+data[i]+"</option>"; 
							console.log(data[i])
  	                		//document.getElementById("previas").innerHTML += "<option value='"+data[i]+"'>"+data[i]+"</option>"; 
  	           			 }
  	    		}
  	    		cargar_provincias();// imprimimos la respuesta
    		}).fail(function() {
    			 console.log("Algo salió mal");
    		}).always(function() {
    		  console.log("Siempre se ejecuta");
    		});
	

	});
</script>
<script type="text/javascript">
$('select#dropdownlist').on('change',function(){
    var valor = $(this).val();
    $.get("http://localhost:8080/edextweb/ConsultaUsuario", { Cusuario:"Cdatos", usr:valor },
            function(data){
              console.log(data);
              $("#OutputNombre").val(data.nombre);
              $("#OutputApellido").val(data.apellido);
              $("#OutputEmail").val(data.email);
              $("#OutputFecha").val(data.fNac);
              }
           );
});
</script>  
<script type="text/javascript">
document.getElementById("botonBuscar").addEventListener('click',function ()
		{var buscar=document.getElementById("barraBuscar").value;
		console.log(buscar);
		localStorage.setItem("consulta", buscar);
		window.location = 'busqueda.jsp';
		   }  );
</script>




</body>
</html>