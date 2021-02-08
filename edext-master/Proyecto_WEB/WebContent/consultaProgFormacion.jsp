<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
<meta charset="ISO-8859-1">
<style>#page {margin:200px auto;width: 75%; color: white;opacity: 0.7;}</style>
<style>.btn {background-color: DodgerBlue;color: white;padding: 3px 20px;font-size: 16px;cursor: pointer;opacity: 0.7;}</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script>
	function goBack(){window.history.back();}
</script> 
<!-- -----------Search Bar---------------- -->
 <style>.topnav input[type=text] {padding: 5px;margin-top: 8px;font-size: 15px;border: none;float: top;}</style>
<style>.topnav .search-container button {float: right;padding: 5px 9px;margin-top: 8px;margin-right: 16px;background: #ddd;font-size: 13px;border: none;cursor: pointer;}}</style>
  <style> .topnav .search-container {float: right;} </style>
  <!-- --------------------------------------- -->
<title>Insert title here</title>
</head>
<body background="https://us.123rf.com/450wm/yamabikay/yamabikay1705/yamabikay170500120/78105857-textura-de-cuero-verde-oscuro-en-macro-fondo-cuadrado-transparente-listo-para-el-azulejo-foto-de-alt.jpg?ver=6">
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
<form action="" method="post">

	 <div class="form-group">
    	<label for="exampleFormControlSelect1">Programas</label>
    	<select class="form-control" id="programas">
   
    	</select>
  	</div>
        
	  <div class="form-group">
	    <label for="exampleInputEmail1">Nombre</label>
	    <input type="text" class="form-control" id="InputNombre" aria-describedby="emailHelp" name="P_nombre" readonly>
	    
	  </div>
	  	  <div class="form-group">
	    <label for="exampleInputEmail1">Descripcion</label>
	    <input type="text" class="form-control" id="InputDescripcion" aria-describedby="emailHelp" name="D_apellido" readonly>
	    
	  </div>
	  
	  <div class="form-group">
	    <label for="exampleInputPassword1">Periodo de Vigencia</label><br>
	    <label for="exampleInputPassword1">Fecha Inicio</label>
	    <input type="text" class="form-control" id="InputInicio" name="F_Inicio" readonly>
	     <label for="exampleInputPassword1">Fecha Fin</label>
	    <input type="text" class="form-control" id="InputFin" name="F_Fin" readonly>
	  </div>
	  
	  
	  <div class="form-group">
	    <label for="exampleInputEmail1">Foto</label>
	    <div>
	    </div>
	   
	    
	  </div>
	<div class="form-group">
    	<label for="exampleFormControlSelect1">Cursos</label>
    	<select class="form-control" id="cursos">
   
    	</select>
  	</div>
	
	</form>
	<input type="button" value="consulta" id="enviar"  onclick="myFunction()">
	<input type="button" value="consulta2" id="enviar"  onclick="myFunction2()">
</div>
	<script type="text/javascript">
	/*$(document).ready(function() {
         console.log("hola1");
    	 $.ajax({
    		  method: "GET",
    		  url: "http://localhost:8080/edextweb/ConsultaProgramas"
    		  
    		}).done(function(data) {
    		 	
    		 	 function cargar_provincias()
  	        	{
  	           			
  	            		for(var i in data)
  	            		{ 
  	                		document.getElementById("programas").innerHTML += "<option value='"+data[i]+"'>"+data[i]+"</option>"; 
  	           			 }
  	    		}
  	    		cargar_provincias();// imprimimos la respuesta
    		}).fail(function() {
    			 console.log("Algo salió mal");
    		}).always(function() {
    		  console.log("Siempre se ejecuta")
    		});

	});*/
</script>  

<script type="text/javascript">
$('select#programas').on('change',function(){
    var valor = $(this).val();
    $.get("http://localhost:8080/edextweb/ConsultaProgramas", { Cprograma:"Cdatos", prog:valor },
            function(data){
              console.log(data);
              $("#InputNombre").val(data.nombre);
              $("#InputDescripcion").val(data.descripcion);
              $("#InputInicio").val(data.fInicio);
              $("#InputFin").val(data.fFin);
              
            

               }
           );
    $.get("http://localhost:8080/edextweb/ConsultaProgramas", { Cprograma:"cursos", prog:valor  },
            function(data)
            	{
    	 for(var i in data)
					{ 
						document.getElementById("cursos").innerHTML += "<option value='"+data[i]+"'>"+data[i]+"</option>"; 
					 };
			
			   }

             
           );
});

	
	function myFunction2() { 
		console.log("click");
		$.get("http://localhost:8080/edextweb/ConsultaProgramas", { idioma:"esp" },
	            function(data){
	                alert(data);

	               }
	           );
	}
</script>  
<script type="text/javascript">
$(document).ready(function() {		
	 
		
		$.get("http://localhost:8080/edextweb/ConsultaProgramas", { Cprograma:"Programa" },
	            function(data)
	            {
			 		
			 for(var i in data)
	       				{ 
	           		document.getElementById("programas").innerHTML += "<option value='"+data[i]+"'>"+data[i]+"</option>"; 
	      			 };

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