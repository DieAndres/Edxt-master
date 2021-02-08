<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
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
	<h2>Consultar Curso</h2>
	<div class="dropdown" align="left">
		<label for="dropdownlist">Instituto</label>
	    <select id="dropdownlist" name="curso" class="form-control"> 
	    	<option selected="true" value="" disabled>Seleccionar Instituto</option>
	    </select>
	    <br/><br/>
	</div>
	<div class="list-group">
		<label for="listacursos">Curso</label>
	  <select id="listacursos" name="curso" class="form-control"></select>
	 </div>
	 <br/><br/>
<div id="consultaCr" style="display: none">
   <!--  <div class="form-group">
 	<label for="exampleFormControlInput1">Nombre</label>
    <input type="text" class="form-control" id="nomInsti" readonly>
  </div> -->
  <div class="form-group">
    <label for="exampleFormControlTextarea1">Descripcion</label>
    <textarea class="form-control" id="descInsti" rows="3" readonly></textarea>
  </div>
  <div class="row">
  <div class="col form-group">
  	<label for="inputEmail4">Créditos</label>
    <input type="text" class="form-control" id="creditos" readonly>
  </div>
  <div class="col form-group">
  	<label for="inputEmail4">Cantidad de Horas</label>
    <input type="text" class="form-control" id="canthoras" readonly>
  </div>
  <div class="col form-group">
  	<label for="inputEmail4">Duración</label>
    <input type="text" class="form-control" id="duracion" readonly>
  </div>
  </div>
  <div class="row">
  <div class="col form-group">
    <label for="previas">Previas</label>
    <select multiple class="form-control" id="previas" readonly></select>
  </div>
  <div class="col form-group">
    <label for="categorias">Categorias</label>
    <select multiple class="form-control" id="categorias" readonly></select>
  </div>
  </div>
  <div class="row">
  <div class="col form-group">
    <label for="ediciones">Ediciones del Curso</label>
    <select class="form-control" id="ediciones"></select>
  </div>
  <div class="col form-group">
    <label for="pform">Programas de Formación</label>
    <select class="form-control" id="pform"></select>
  </div>
  </div>
  </div>
<br/><br/>
<div id="consultaEd" style="display: none">
	<h6>Edición:  </h6>
	 <div class="form-group">
    	<label for="exampleFormControlInput1">Nombre</label>
    	<input type="text" class="form-control" id="nomEdi" readonly>
     </div>
 	 <div class="form-group">
  	 	<label for="inputEmail4">Cupo</label>
     	<input type="text" class="form-control" id="cupos" readonly>
  	 </div>
	 <div class="row">
      <div class="col">
      	<label for="exampleFormControlFile1">Fecha inicio</label>
        <input type="text" class="form-control" id="fIni" name="fIni" readonly>
      </div>
      <div class="col">
      	<label for="exampleFormControlFile1">Fecha fin</label>
        <input type="text" class="form-control" id="fFin" name="fFin" readonly>
      </div>
  	 </div>
  	 <div class="form-group">
      	<label for="exampleFormControlFile1">Fecha de Publicación</label>
        <input type="text" class="form-control" id="fPubli" name="fPubli" readonly>
      </div>
</div> 
<div id="consultaPr" style="display: none">
	<h6>Programa de Formación:  </h6>
	  <div class="form-group">
   		<label for="exampleFormControlInput1">Nombre</label>
    	<input type="text" class="form-control" id="nomProg" readonly>
      </div>
	  <div class="form-group">
	    <label for="exampleInputEmail1">Descripcion</label>
	    <input type="text" class="form-control" id="InputDescripcion" aria-describedby="emailHelp" name="D_apellido" readonly>
	  </div>
	  <div class="row">
	    <div class="col w-25 p-3">
	      <h6>Periodo de Vigencia:  </h6>
	    </div>
	    <div class="col">
	      <label for="exampleInputPassword1">Fecha Inicio</label>
	      <input type="text" class="form-control" id="InputInicio" name="F_Inicio" readonly>
	    </div>
	    <div class="col">
	      <label for="exampleInputPassword1">Fecha Fin</label>
	      <input type="text" class="form-control" id="InputFin" name="F_Fin" readonly>
	    </div>
	  </div>
	
</div>         
	</form>
</div>
<script type="text/javascript">
	$(document).ready(function() {
         console.log("hola4");
    	 $.ajax({
    		  method: "GET",
    		  url: "http://localhost:8080/edextweb/ConsultaCurso"
    		  
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
		   $("#consultaCr").hide();
		   $("#consultaEd").hide();
		   $("#consultaPr").hide();
		   var listBox = document.getElementById("listacursos");
		   listBox.options.length = 0;
     	    	var valor = $(this).val();
        	   $.ajax({
          		  method: "GET",
          		  url: "http://localhost:8080/edextweb/ConsultaCurso",
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
	     	    	var valor = $(this).val();
	     	    	console.log(valor);
	        	   $.ajax({
	          		  method: "GET",
	          		  url: "http://localhost:8080/edextweb/ConsultaCurso",
	          		  data: { Cusuario:"Cursodatos", usr:valor }
	          		}).done(function(data) {
			          			$("#nomInsti").val(data.nombre);
			                    $("#descInsti").val(data.descripcion);
			                    $("#creditos").val(data.creditos);
			                    $("#canthoras").val(data.cantHoras);
			                    $("#duracion").val(data.duracion);
	          		}).fail(function() {
	          			 console.log("Algo salió mal");
	          		}).always(function() {
	          		  console.log("Siempre se ejecuta")
	          		});
		   });
</script>
<script type="text/javascript">
	   $('select#listacursos').on('change',function(){
		   var listBox = document.getElementById("previas");
		   listBox.options.length = 0;
     	    	var valor = $(this).val();
        	   $.ajax({
          		  method: "GET",
          		  url: "http://localhost:8080/edextweb/ConsultaCurso",
          		  data: { Cusuario:"prev", usr:valor }
          		}).done(function(data) {
        	            		for(var i in data)
        	            		{ 
        	                		document.getElementById("previas").innerHTML += "<option value='"+data[i]+"'>"+data[i]+"</option>"; 
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
		   var listBox = document.getElementById("categorias");
		   listBox.options.length = 0;
     	    	var valor = $(this).val();
        	   $.ajax({
          		  method: "GET",
          		  url: "http://localhost:8080/edextweb/ConsultaCurso",
          		  data: { Cusuario:"cate", usr:valor }
          		}).done(function(data) {
        	            		for(var i in data)
        	            		{ 
        	                		document.getElementById("categorias").innerHTML += "<option value='"+data[i]+"'>"+data[i]+"</option>"; 
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
          		  url: "http://localhost:8080/edextweb/ConsultaCurso",
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
	   $('select#listacursos').on('change',function(){
		   $("#consultaCr").show();
		   $("#consultaEd").hide();
		   $("#consultaPr").hide();
		   var listBox = document.getElementById("pform");
		   listBox.options.length = 0;
     	    	var valor = $(this).val();
        	   $.ajax({
          		  method: "GET",
          		  url: "http://localhost:8080/edextweb/ConsultaCurso",
          		  data: { Cusuario:"prog", usr:valor }
          		}).done(function(data) {
          						document.getElementById("pform").innerHTML += "<option selected=\"true\" value=\"\" disabled>Seleccionar Programa</option>";
        	            		for(var i in data)
        	            		{ 
        	                		document.getElementById("pform").innerHTML += "<option value='"+data[i]+"'>"+data[i]+"</option>"; 
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
				   $("#consultaPr").hide();
		  		   $("#consultaEd").show();
	     	    	var valor = $(this).val();
	     	    	console.log(valor);
	        	   $.ajax({
	          		  method: "GET",
	          		  url: "http://localhost:8080/edextweb/ConsultaCurso",
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
	$('select#pform').on('change',function(){
				   $("#consultaEd").hide();
				   $("#consultaPr").show();
	     	    	var valor = $(this).val();
	     	    	console.log(valor);
	        	   $.ajax({
	          		  method: "GET",
	          		  url: "http://localhost:8080/edextweb/ConsultaCurso",
	          		  data: { Cusuario:"Progdatos", usr:valor }
	          		}).done(function(data) {
	          					$("#nomProg").val(data.nombre);
			          			$("#InputDescripcion").val(data.descripcion);
			                    $("#InputInicio").val(data.fInicio);
			                    $("#InputFin").val(data.fFin);         		
	          		}).fail(function() {
	          			 console.log("Algo salió mal");
	          		}).always(function() {
	          		  console.log("Siempre se ejecuta")
	          		});
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