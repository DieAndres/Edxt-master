<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
<%@page import="Interface.*,java.util.List,java.util.ArrayList,com.google.gson.Gson,Logica.Manejador,Logica.Curso,Logica.Estudiante,Logica.Usuario"%>
     
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>AltaUsuarioCont</title>
<%-- 	<jsp:include page="WEB-INF/header.jsp" > --%>
<%--     <jsp:param name="title" value="altaUsuarioCont"/> --%>
<%-- 	</jsp:include> --%>
 	<link rel="stylesheet" 
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
 	crossorigin="anonymous" /> 
	<style>#page {margin:200px auto;width: 75%; color: white;opacity: 0.7;}</style>
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
	
	<%
		String nickname = request.getParameter("A_nick");
		String nombre = request.getParameter("A_nombre");
		String apellido = request.getParameter("A_apellido");
		String password = request.getParameter("A_pass");
		String cPassword = request.getParameter("A_confPass");
		String email = request.getParameter("A_email");
		String fnac = request.getParameter("A_fnac");
		String tipoU = request.getParameter("A_tipoUsuario");
		String foto = request.getParameter("A_foto");
		
	%>
	
 	<form action="AltaUsuario" method="post" ">
 	
		<input type="hidden" name="A_nick" value="<%=nickname%>">
		<input type="hidden" name="A_nombre" value="<%=nombre%>">
		<input type="hidden" name="A_apellido" value="<%=apellido%>">
		<input type="hidden" name="A_pass" value="<%=password%>">
		<input type="hidden" name="A_confPass" value="<%=cPassword%>">
		<input type="hidden" name="A_email" value="<%=email%>">
		<input type="hidden" name="A_fnac" value="<%=fnac%>">
		<input type="hidden" name="A_tipoUsuario" value="<%=tipoU%>">
		<input type="hidden" name="A_fot" value="<%=foto%>">
		
 		
 <div id="page">		
 		<h4>Agregar Datos</h4>
 		<p class="lead">
 			 Continuemos con el alta de la clase <%=nombre%> de ID <%=nickname%>
		</p>
 		<%if (tipoU.equals("Docente")){%>
		
		<div class="form-group">
  		<label for="exampleInputInstituto">Instituto</label>
  		<select  class="form-control" id="exampleInputInstituto" name="A_Instituto">
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
		
 		<%}else if (tipoU.equals("Estudiante")){ %>
 		<%}%>
 		     
	  <button type="submit" class="btn btn-primary" id="agregar">ACEPTAR</button>
	</form>

</div>
<script type="text/javascript">
document.getElementById("botonBuscar").addEventListener('click',function ()
		{var buscar=document.getElementById("barraBuscar").value;
		console.log(buscar);
		localStorage.setItem("consulta", buscar);
		window.location = 'busqueda.jsp';
		   }  );
</script>

<%@include file="WEB-INF/footer.jsp" %>
</body>
</html>