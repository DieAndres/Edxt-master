<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "Interface.*,java.util.List,java.util.ArrayList,com.google.gson.Gson,Logica.Manejador,Logica.Curso"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="WEB-INF/header.jsp" >
    <jsp:param name="title" value="altaCurso"/>
	</jsp:include>
	<meta charset="ISO-8859-1">
	<title>Alta Curso</title>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
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
<!-- FORMULARIO -->
<div id="page">
	<form  method="post" id="formulario">  
<div class="form-group">
  <label for="exampleFormControlSelect2">Instituto</label>
  	<select  class="form-control" id="institutos" name="Instituto">
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
	  <div class="form-group">
	    <label for="exampleInputInstituto">Nombre del Curso</label>
	    <input class="form-control" type="text" name="NomCurso">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputInstituto">Descripcion del curso</label>
	    <input class="form-control" type="text" name="DescCurso">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputInstituto">Duración</label>
	    <input class="form-control" type="text" name="Duracion">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputInstituto">Cantidad de horas</label>
	    <input class="form-control" type="text" name="CantHoras">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputInstituto">Cantidad de Creditos</label>
	    <input class="form-control" type="text" name="CantCred">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputInstituto">URL Asociada</label>
	    <input class="form-control" type="text" name="URLAsoc">
	  </div>
	  <div class="form-group">
	  <label for="exampleFormControlFile1">Categorias</label>
	    <select class="form-control" id="categorias" multiple="multiple" name="categorias">
	
 	<%
	List<String> listCat = new ArrayList<>();
	listCat=icon.listarCategorias();
	for(String s :listCat){
	    %><option value="<%=s%>" ><%=s%></option>	<%
	}
	%>

    
	 
	  </select>
	  </div>
	  <div class="w-50 mt-3">
    	<label for="exampleFormControlFile1">Foto</label>
    	<input class="form-control" type="file" class="form-control-file" id="exampleFormControlFile1" name="imgProg">
    	<input type="hidden"  id="valor" name="A_foto">
    </div>
	  
	  <script type="text/javascript">
	  $("#exampleFormControlFile1").on("change",function(){

		    var filePath=$('#exampleFormControlFile1').val(); 		
		  console.log(filePath);
		   document.getElementById('valor').value=filePath;	
	  });

		
	  </script>
	  <label for="exampleFormControlFile1">Previas</label>
	  <select class="form-control" id="previas" multiple="multiple" name="previas">
	 

 	<%
 	
	List<String> listC = new ArrayList<>();
	listC=icon.listarCurso();
	for(String s :listC){
	    %><option value="<%=s%>" ><%=s%></option>	<%
	}
	%>
	 
	  </select>
	  
	  <div class="form-group">
	  <label for="exampleInputEmail1">Fecha</label>
	  <input class="form-control" type="text" id="datepicker" width="276"  name="A_fnac"/>
 
	  
	 <script>
        $('#datepicker').datepicker({
            uiLibrary: 'bootstrap4'
        });
     </script> 
 
     </div>
	  <div class="form-group">	    
	   
	  </div>
	  <div class="form-group">
	   <input type="button" value="guardar" id="enviar">
	
	  </div>
	  <div class="form-group">
	  <p id="p1"></p>
	  </div>
	</form>
</div>	
	<script type="text/javascript">
    
</script>

<script type="text/javascript">
document.getElementById("botonBuscar").addEventListener('click',function ()
		{var buscar=document.getElementById("barraBuscar").value;
		console.log(buscar);
		localStorage.setItem("consulta", buscar);
		window.location = 'busqueda.jsp';
		   }  );
</script>


	<script type="text/javascript">
	/*$(document).ready(function() {
     
         
    	 $.ajax({
    		  method: "GET",
    		  url: "http://localhost:8080/edextweb/AltaCurso"
    		  
    		}).done(function(data) {
    		 	
    		 	 function cargar_provincias()
  	        	{
  	           			
  	            		for(var i in data)
  	            		{ 
  	                		document.getElementById("previas").innerHTML += "<option value='"+data[i]+"'>"+data[i]+"</option>"; 
  	           			 }
  	    		}
  	    		cargar_provincias();// imprimimos la respuesta
    		}).fail(function() {
    			 console.log("Algo salió mal");
    		}).always(function() {
    		  console.log("Siempre se ejecuta")
    		});
	})

	*/
</script>
<script type="text/javascript">

$('#enviar').click(function(){
	
	document.getElementById("p1").innerHTML="";
    var url = "http://localhost:8080/edextweb/ConsultaPrevias";
    $.ajax({                        
       type: "POST",                 
       url: url,                     
       data: $("#formulario").serialize(),
       success: function(data)  {
    	  console.log(data);
    	  if(data=="Incorrecto"){
    		  document.getElementById("p1").innerHTML +="<p>\"El curso ya existe\"</p>"
        	  }
    	  else{
           document.getElementById("p1").innerHTML +="<p>\"Se agregó correctamente el Curso\"</p>"
               console.log("funciono")
    	  }
               }

	 });
    
    /*
    var selected=[];
    var i=0;
    
    	$('#previas :selected').each(function(){
    		selected[i++]=$(this).text();
    		})
    		$.ajax({
    			url:"http://localhost:8080/edextweb/ConsultaPrevias",
    			type:"POST",
    			dataType:"json",
    			data: {json:selected},
    success:function(data){
    // codes....
    },

    });
    		console.log(selected);
    */
});


</script>

	  <script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>

<%@include file="WEB-INF/footer.jsp" %>
<script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
</body>
</html>