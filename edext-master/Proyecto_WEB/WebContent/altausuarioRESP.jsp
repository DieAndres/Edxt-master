<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!--link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" /-->
    <jsp:include page="WEB-INF/header.jsp" >
    <jsp:param name="title" value="altausuario"/>
	</jsp:include>
<meta charset="ISO-8859-1">
<title>Alta Usuario</title>
</head>
<body>

<h1>la variable que paso va a ser3:</h1>>
<%

out.print(request.getAttribute("nombre"));
 
 out.print(request.getAttribute("usuario"));
 //String usuario =  request.getAttribute("usuario").toString();
 // out.print(usuario);
%>>

<!---------------------------------------------------   -->
<form action="altausuarioCont.jsp" method="post">
	  <div class="form-group">
	    <label for="exampleInputEmail1">Nickname</label>
	    <input type="text" class="form-control" id="exampleInputNick" aria-describedby="emailHelp" name="A_nick">
	    
	  </div>
	  <div class="form-group">
	    <label for="exampleInputEmail1">Nombre</label>
	    <input type="text" class="form-control" id="exampleInputNombre" aria-describedby="emailHelp" name="A_nombre">
	    
	  </div>
	  	  <div class="form-group">
	    <label for="exampleInputEmail1">Apellido</label>
	    <input type="text" class="form-control" id="exampleInputApellido" aria-describedby="emailHelp" name="A_apellido">
	    
	  </div>
	  
	  <div class="form-group">
	    <label for="exampleInputPassword1">Password</label>
	    <input type="password" class="form-control" id="exampleInputPassword1" name="A_pass">
	  </div>
	  
	  <div class="form-group">
	    <label for="exampleInputEmail1">Confirmacion de Password</label>
	    <input type="password" class="form-control" id="exampleInputConfPass" aria-describedby="emailHelp" name="A_confPass">
	    
	  </div>
	  <div class="form-group">
	    <label for="exampleInputEmail1">Email</label>
	    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="A_email">
	    
	  </div>
	  <div class="form-group">
	  <label for="exampleInputEmail1">Fecha Nacimiento</label>
	  <input type="text" id="datepicker" width="276"  name="A_fnac"/>
	  
	  <div class="input-group mb-3">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">Tipo de Usuario</label>
			</div>
			<select class="custom-select" id="inputGroupSelect01" name="A_tipoUsuario">
				<option selected>Indique el tipo de Usuario</option>
				<option value="Estudiante">Estudiante</option>
				<option value="Docente">Docente</option>
			</select>
		</div>
	  
	 
	  
    <script>
        $('#datepicker').datepicker({
            uiLibrary: 'bootstrap4'
        });
     </script>
  
     </div>
	  <button type="submit" class="btn btn-primary" id="aceptar">Submit</button>
	</form>
<!-- %
		String nickname = request.getParameter("A_nick");
		String nombre = request.getParameter("A_nombre");
		String apellido = request.getParameter("A_apellido");
		String password = request.getParameter("A_pass");
		String cPassword = request.getParameter("A_confPass");
		String email = request.getParameter("A_email");
		String fnac = request.getParameter("A_fnac");
		String tipoU = request.getParameter("A_tipoUsuario");
	%--> 
<%@include file="WEB-INF/footer.jsp" %>  
</body>
</html>