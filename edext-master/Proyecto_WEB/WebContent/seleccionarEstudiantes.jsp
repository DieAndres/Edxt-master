<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "Interface.*,java.util.List,java.util.ArrayList,com.google.gson.Gson,Logica.Manejador,Logica.Curso, Logica.InscripcionEd"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td { border: solid 3px #DDD;
            border-collapse: collapse; padding: 2px 3px; text-align: center;
        }
</style>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
	<style>#page {margin:200px auto;width: 75%; color: white;opacity: 0.7;}</style>
	<!--------------------->
<style>.btn {background-color: DodgerBlue;color: white;padding: 3px 20px;font-size: 16px;cursor: pointer;}</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script>
	function goBack(){window.history.back();}
</script> 
<!--------------------->
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
<form action="ConsultaCurso" method="get">
	<h2>Seleccionar Estudiantes </h2>
	<br/><br/>
	<div class="dropdown" align="left">
	  <select id="dropdownlist" name="curso" class="form-control"> 
	   	<option selected="true" value="" disabled>Seleccionar Instituto</option>
	  </select>
	</div>
	<br/><br/>
	<div class=row>
	 <div class="col form-group">
	  <label for="ediciones">Cursos</label>
	  <select class="form-control" id="listacursos" name="curso"></select>
	 </div>
	  <div class="col form-group">
        <label for="ediciones">Ediciones del Curso</label>
   	    <select class="form-control" id="ediciones" name="edi"></select>
  	  </div>  
	 </div>
   <br/><br/>
     <div class="form-group">
      <label for="exampleFormControlInput1">Nombre</label>
      <input readonly type="text" class="form-control" id="nomEdi">
 	 </div>
 	 <div class="form-group">
  	 	<label for="inputEmail4">Cupo</label>
     	<input readonly type="text" class="form-control" id="cupos">
  	 </div>
	 <div class="row">
      <div class="col">
      	<label for="exampleFormControlFile1">Fecha inicio</label>
        <input readonly type="text" class="form-control" id="fIni" name="fIni">
      </div>
      <div class="col">
      	<label for="exampleFormControlFile1">Fecha fin</label>
        <input readonly type="text" class="form-control" id="fFin" name="fFin">
      </div>
  	 </div>
  	 <div class="form-group">
      	<label for="exampleFormControlFile1">Fecha de Publicación</label>
        <input readonly type="text" class="form-control" id="fPubli" name="fPubli">
      </div>
      
      <div class=row>
	 <div class="col form-group">
	  <label for="ediciones">Estudiantes</label>
	  <select class="form-control" id="listEstu" name="curso"></select>
	 </div>
	  <div class="col form-group">
        <label for="ediciones">Estado</label>
   	    <select class="form-control" id="listEstado" name="edi">
   	    <option >Aceptado</option>
   	    	<option >Rechazado</option>
   	    </select>
   	    	
  	  </div>  
	 </div>
	 <input type="button" id="modificar" value="Modificar Estado">
	 <br>
	 <br>
  	</form>
  	<div id="wrapper">
  	<table id="tabla"></table>
  	</div>
  	<div class="form-group">
	  <p id="p1"></p>
	  </div>
</div>	
	<script type="text/javascript">
	$(document).ready(function() {
         console.log("hola4");
    	 $.ajax({
    		  method: "GET",
    		  url: "http://localhost:8080/edextweb/ConsultaEdicion"
    		  
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

	})
</script> 
<script type="text/javascript">
	   $('select#dropdownlist').on('change',function(){
		   var listBox = document.getElementById("listacursos");
		   listBox.options.length = 0;
     	    	var valor = $(this).val();
        	   $.ajax({
          		  method: "GET",
          		  url: "http://localhost:8080/edextweb/ConsultaEdicion",
          		  data: { Cusuario:"Cdatos", usr:valor }
          		}).done(function(data) {
          						document.getElementById("listacursos").innerHTML += "<option selected=\"true\" value=\"\" disabled>Seleccionar Curso</option>";
        	            		for(var i in data)
        	            		{ 
        	                		document.getElementById("listacursos").innerHTML += "<option value='"+data[i]+"'>"+data[i]+"</option>"; 
        	           			 }
          		}).fail(function() {
          			 console.log("Algo salió mal");
          		}).always(function() {
          		  console.log("Siempre se ejecuta")
          		});
	   });
</script> 
<script type="text/javascript">
	   $('select#listacursos').on('change',function(){
		   var listBox = document.getElementById("ediciones");
		   listBox.options.length = 0;
     	    	var valor = $(this).val();
        	   $.ajax({
          		  method: "GET",
          		  url: "http://localhost:8080/edextweb/ConsultaEdicion",
          		  data: { Cusuario:"edic", usr:valor }
          		}).done(function(data) {
          						document.getElementById("ediciones").innerHTML += "<option selected=\"true\" value=\"\" disabled>Seleccionar Edición</option>";
        	            		for(var i in data)
        	            		{ 
            	            		
        	                		document.getElementById("ediciones").innerHTML += "<option value='"+data[i]+"'>"+data[i]+"</option>"; 
        	           			 }
          		}).fail(function() {
          			 console.log("Algo salió mal");
          		}).always(function() {
          		  console.log("Siempre se ejecuta")
          		});
	   });
</script> 
<script type="text/javascript">
	$('select#ediciones').on('change',function(){
	     	    	var valor = $(this).val();
	     	    	console.log(valor);
	        	   $.ajax({
	          		  method: "GET",
	          		  url: "http://localhost:8080/edextweb/ConsultaEdicion",
	          		  data: { Cusuario:"Edidatos", usr:valor }
	          		}).done(function(data) {
			          			$("#nomEdi").val(data.nombre);
			                    $("#cupos").val(data.cupo);
			                    $("#fIni").val(data.fInicio);
			                    $("#fFin").val(data.fFin);
			                    $("#fPubli").val(data.fPublicacion);
	          	    }).fail(function() {
	          			 console.log("Algo salió mal");
	          		}).always(function() {
	          		  console.log("Siempre se ejecuta")
	          		});
		   });
</script>

<script type="text/javascript">
	   $('select#ediciones').on('change',function(){
		   var listBox = document.getElementById("listEstu");
		   listBox.options.length = 0;
     	    	var valor = $(this).val();
        	   $.ajax({
          		  method: "GET",
          		  url: "http://localhost:8080/edextweb/SeleccionarEstudiante",
          		  data: { Cconsulta:"Cdatos", edicion:valor }
          		}).done(function(data) {
              		
                    
          			
							
          			

          			
          			          	              			
        	            		
          			//var tabla=document.getElementsByTagName("table");
          			
          		document.getElementById('wrapper').removeChild(document.querySelector('table'));

          			

          			var table = document.createElement("table");
          			
          			for(var i in data)
            		{ 
          			    var tr = document.createElement('tr');   

          			    var td1 = document.createElement('td');
          			    var td2 = document.createElement('td');

          			    var text1 = document.createTextNode(data[i][0]+" 		");
          			    var text2 = document.createTextNode(data[i][1]+"  		");
          			  	
						
          			    td1.appendChild(text1);
          			    td2.appendChild(text2);
          			    tr.appendChild(td1);
          			    tr.appendChild(td2);

          			    table.appendChild(tr);
          			  document.getElementById("listEstu").innerHTML += "<option value='"+data[i][0]+"'>"+data[i][0]+"</option>";
          			}

          			document.getElementById('wrapper').appendChild(table);
          			//document.body.appendChild(table);
        	            			/*  body.appendChild(tabla);
        	            			console.log(data[i][0]);
        	            			console.log(data[i][1]);
            	            		console.log(typeof(i));
            	            		
        	                		document.getElementById("listEstu").innerHTML += "<option value='"+data[i][0]+"'>"+data[i][0]+"</option>";
        	                		document.getElementById("listEstado").innerHTML += "<option value='"+data[i][1]+"'>"+data[i][1]+"</option>";
        	                	
        	                		*/
        	                	   
        	           			// }
        	            		
          		}).fail(function() {
          			 console.log("Algo salió mal");
          		}).always(function() {
          		  console.log("Siempre se ejecuta")
          		});
	   });
        	   
</script> 
<script type="text/javascript">
$("#modificar").click(function(){
	
	var estudiante=$('select#listEstu').val();
	var estado=$('select#listEstado').val();
	var ediciones=$('select#ediciones').val();

	$.ajax({
		  method: "POST",
		  url: "http://localhost:8080/edextweb/SeleccionarEstudiante",
		  data: { Cestu:estudiante, Cestado:estado, Cedicion:ediciones }
		}).done(function(data) {
			 document.getElementById("p1").innerHTML +="<p>\"Se modificó correctamente el Estado\"</p>"		
	    }).fail(function() {
			 console.log("Algo salió mal");
		}).always(function() {
		  console.log("Siempre se ejecuta")
		});
})
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