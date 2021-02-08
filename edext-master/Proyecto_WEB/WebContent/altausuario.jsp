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
	  <br> </br>
	  
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
	  
	 <div class="w-50 mt-3">
    	<label for="exampleFormControlFile1">Foto</label>
    	<input class="form-control" type="file" class="form-control-file" id="exampleFormControlFile1" name="imgProg">
    </div>
	  
    <script>
        $('#datepicker').datepicker({
            uiLibrary: 'bootstrap4'
        });
     </script>
  
     </div>
	  <button type="submit" class="btn btn-primary" id="aceptar" >Submit</button>
<!-- 	  <input type="button" value="consulta2" id="enviar" onclick="getFilePath()"> -->
<!-- 	  <input type="text"  id="valor" name="A_foto"> -->
	  <script type="text/javascript">
	/* function getFilePath(){ 

		 var file    = document.querySelector('input[type=file]').files[0];
		  var reader  = new FileReader();

		  reader.onloadend = function () {
		    preview.src = reader.result;
		    console.log(preview.src)
		  }

		  if (file) {
		    reader.readAsDataURL(file);
		  } else {
		    preview.src = "";
		  }
		  
		  var input = document.getElementById("exampleFormControlFile1");
		  console.log(input.files[0].mozFullPath);
		 /var fReader = new FileReader();
		  fReader.readAsDataURL(input.files[0]);
		  fReader.onloadend = function(event){
		      var img = document.getElementById("yourImgTag");
		      img.src = event.target.result;
		  }

		     var filePath=$('#exampleFormControlFile1').val(); 
		  //var file = document.getElementById('exampleFormControlFile1').files[0].path;
 
		  
      
		     //console.log(fReader.readAsDataURL(input.files[0]));
		   console.log(filePath);
		     document.getElementById('valor').val()=filePath;
		} */
		const fileSelector = document.getElementById('exampleFormControlFile1');
		  fileSelector.addEventListener('change', (event) => {
		    const fileList = event.target.files;
		    console.log(fileList);
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
	</form>
	
</div>	
	
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
</body>
</html>