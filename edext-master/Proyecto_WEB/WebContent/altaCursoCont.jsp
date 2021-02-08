<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="WEB-INF/header.jsp" >
    <jsp:param name="title" value="altaCursoCont"/>
	</jsp:include>
<meta charset="ISO-8859-1">
<style>#page {margin:200px auto;width: 75%; color: white;opacity: 0.7;}</style> 
<!-- -----------Search Bar---------------- -->
 <style>.topnav input[type=text] {padding: 5px;margin-top: 8px;font-size: 15px;border: none;float: top;}</style>
<style>.topnav .search-container button {float: right;padding: 5px 9px;margin-top: 8px;margin-right: 16px;background: #ddd;font-size: 13px;border: none;cursor: pointer;}}</style>
  <style> .topnav .search-container {float: right;} </style>
  <!-- --------------------------------------- -->   
<title>Alta Curso Continuacion</title>
</head>
<body background="https://us.123rf.com/450wm/yamabikay/yamabikay1705/yamabikay170500120/78105857-textura-de-cuero-verde-oscuro-en-macro-fondo-cuadrado-transparente-listo-para-el-azulejo-foto-de-alt.jpg?ver=6">

<h1>Ingresar Previas</h1>

<div id="page">
<form action="AltaCurso" method="post">

<select name="provincia" id="provincia" onchange="ShowSelected()"></select>
	    <script type="text/javascript">
	        function cargar_provincias()
	        {
	            var array = ["Cantabria", "Asturias", "Galicia", "Andalucia", "Extremadura"];
	            for(var i in array)
	            { 
	                document.getElementById("provincia").innerHTML += "<option value='"+array[i]+"'>"+array[i]+"</option>"; 
	            }
	    }
	    cargar_provincias();


	    
	 </script>
	 <script type="text/javascript">

	 var array=[];
	 
	function ShowSelected()
	{
	
	/* Para obtener el valor */
	var cod = document.getElementById("provincia").value;
	array.push(cod);
	console.log(array);
	}
	 </script>
	
	
	
	
<div class="form-group">
	    <label for="exampleInputInstituto">Guardar</label>
	    <input type="submit" value="submit">
	  </div>

	</form>
</div>
<%@include file="WEB-INF/footer.jsp" %>
</body>
</html>