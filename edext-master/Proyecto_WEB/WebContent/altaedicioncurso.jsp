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
		 <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css"/>
		
<meta charset="ISO-8859-1">
<!--------------------->
<style>#page {margin:200px auto;width: 75%; color: white;opacity: 0.7;}</style>
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
<title>Alta Edicion Curso</title>
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
	<form id="formulario">
  <div class="form-group">
  <div class="form-group">
    <label for="exampleFormControlSelect2">Instituto</label>
    <select class="form-control" id="institutos" name="Instituto">
    <option selected="true" value="" disabled>Seleccionar Instituto</option>
 	
 	<%
 	Fabrica fabrica= Fabrica.getInstancia();
 	Manejador m = Manejador.getInstancia();
	IConsulta icon=fabrica.getIConsulta();
	List<String> list = new ArrayList<>();
	list=icon.listarInstituto();
	for(String s :list){
	    %><option value="<%=s%>" ><%=s%></option>	<%
	}
	%>
    </select>
  </div>
<!--   <input type="button" value="consulta" id="enviar"  onclick="myFunction()"> -->
  <div class="form-group">
   	 <label for="exampleFormControlSelect2">Cursos</label>
   	 	<select  class="form-control" id="cursos" name="cursos">
<!--    	 	<input type="text"  id="valor" name="seleIns"> -->
   	 	<script type="text/javascript">
   		 $('select#institutos').on('change',function(){
        	 $('#cursos').empty();
        	 $('#docentes').empty();
     	    	var valor = $(this).val();   	    	
        	   $.ajax({
          		  method: "GET",
          		  url: "http://localhost:8080/edextweb/ListarCursos",
          		  data: {inst: valor}
          		  
          		}).done(function(data) {
          			document.getElementById("cursos").innerHTML += "<option selected=\"true\" value=\"\" disabled>Seleccionar Curso</option>";
        	            		for(var i in data)
        	            		{ 
        	                		document.getElementById("cursos").innerHTML += "<option value='"+data[i]+"'>"+data[i]+"</option>"; 
        	           			 }
          		}).fail(function() {
          			 console.log("Algo salió mal");
          		}).always(function() {
          		  console.log("Siempre se ejecuta")
          		});
         		
        	   
        	   $.ajax({
          		  method: "POST",
          		  url: "http://localhost:8080/edextweb/ListarCursos",
          		  data: {instD: valor}
         		  
          		}).done(function(data) {
          			
        	            		for(var i in data)
        	            		{ 
        	                		document.getElementById("docentes").innerHTML += "<option value='"+data[i]+"'>"+data[i]+"</option>"; 
        	           			 }
          		}).fail(function() {
          			 console.log("Algo salió mal");
          		}).always(function() {
          		  console.log("Siempre se ejecuta")
          		});
        	  
        	});
   		 
	  </script>
   	  
    	</select>
  </div>
  <div class="form-group">
	    <label for="exampleInputEmail1">Nombre de Edicion</label>
	    <input type="text" class="form-control" id="exampleInputNombre" aria-describedby="emailHelp" name="A_Edicion">
	  </div>
	  <div>
	   <label for="exampleInputEmail1">Fecha Inicio</label>
	  <input type="text" id="datepicker" width="276"  name="A_fini"/>
	  <script>
        $('#datepicker').datepicker({
            uiLibrary: 'bootstrap4'
        });
     </script>
	  </div>
	  
	  <div>
	   <label for="exampleInputEmail1">Fecha Fin</label>
	  <input type="text" id="datepicker2" width="276"  name="A_ffin"/>
	  <script>
        $('#datepicker2').datepicker({
            uiLibrary: 'bootstrap4'
        });
     </script>
	  </div>
	  
	  <div class="form-group">
	    <label for="exampleInputEmail1">Cupo</label>
	    <input type="text" class="form-control" id="exampleInputNombre" aria-describedby="emailHelp" name="A_cupo">
	  </div>
  	<div class="form-group">
   	 <label for="exampleFormControlSelect2">Docentes</label>
   	 	<select class="form-control" id="docentes" multiple="multiple" name="docentes">

    	</select>
    	<script type="text/javascript">
    	
    	</script>
    </div>
    
   <div class="w-50 mt-3">
    	<label for="exampleFormControlFile1">Foto</label>
    	<input type="file" class="form-control-file" id="exampleFormControlFile1" name="imgProg">
    	<input type="hidden"  id="valor" name="A_foto">
    </div>
	<div class="form-group">
	  <p id="p1"></p>
	  </div> 
	  <script type="text/javascript">
	  $("#exampleFormControlFile1").on("change",function(){

		    var filePath=$('#exampleFormControlFile1').val(); 
		 
		  console.log(filePath);
      
		   document.getElementById('valor').value=filePath;
	
		
	  });

		
	  </script>
	  <br> 
	  
	  <input type="button" class="btn btn-primary" value="enviar" id="enviar">
<!--   <button type="submit" class="btn btn-primary">Alta Edicion</button> -->

</form>
</div>
<script type="text/javascript">

$('#enviar').click(function(){
	
	
    var url = "http://localhost:8080/edextweb/AltaEdicionCurso";
    $.ajax({                        
       type: "POST",                 
       url: url,                     
       data: $("#formulario").serialize(),
       success: function(data)             
       {
    	document.getElementById("p1").innerHTML +="<p>\"Se ingresó correctamente la edición\"</p>"	
       console.log("funciono")              
       }
   });
    
});
</script>
<script type="text/javascript">
	/*$(document).ready(function() {
         console.log("hola1");
         $('select#institutos').on('change',function(){
        	 $('#cursos').empty();
     	    	var valor = $(this).val();
        	    console.log(valor);
        	    $.ajax({
          		  method: "GET",
          		  url: "http://localhost:8080/edextweb/ListarCursos",
          		  data: {inst: valor}
 
          		  
          		}).done(function(data) {
        	            		for(var i in data)
        	            		{ 
        	                		document.getElementById("cursos").innerHTML += "<option value='"+data[i]+"'>"+data[i]+"</option>"; 
        	           			 }
          		}).fail(function() {
          			 console.log("Algo salió mal");
          		}).always(function() {
          		  console.log("Siempre se ejecuta")
          		});
        	    
        	});

         
    	 
	})*/
</script>
<%@include file="WEB-INF/footer.jsp" %>
<script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
</body>
</html>