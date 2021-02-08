<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Inicio</title>
<style>
		html{
		    font-size: 62.5%; /*Reset para Rems*/
		    box-sizing: border-box;
		}
		*,*::before, *::after{
		    box-sizing: inherit;
		}
		body{
			font-family:'Open Sans', sans-serif;
			background:url(https://png.pngtree.com/thumb_back/fw800/background/20190828/pngtree-top-view-background-of-desktop-with-electronic-devices-and-laptop-image_307721.jpg);
		    font-size: 1.6rem;
		    background-position: center center;
		    background-repeat: no-repeat;
		    background-attachment: fixed;
		    background-size: cover;  
		}
		 .centrado{
		          
		        text-align:center;
		         
		        float:left;
		        
		        -webkit-box-shadow: 2px 0px 22px -1px rgba(0,0,0,0.75);
				-moz-box-shadow: 2px 0px 22px -1px rgba(0,0,0,0.75);
				box-shadow: 2px 0px 22px -1px rgba(0,0,0,0.75);  
		
		        position: absolute;
				/*nos posicionamos en el centro del navegador*/
				top:60%;
				left:20%;
				/*determinamos una anchura*/
				width:350px;
				/*indicamos que el margen izquierdo, es la mitad de la anchura*/
				margin-left:-200px;
				/*determinamos una altura*/
				height:200px;
				/*indicamos que el margen superior, es la mitad de la altura*/
				margin-top:-150px;
			
				padding:10px;
		     }    
		
</style>
</head>
<body>
	<div class="centrado">
		<form action="CrearSesion" method="get">
		<h1>LOGIN</h1>
		  <div >
		  
		    <label for="exampleInputEmail1">Nickname</label>
		    <input type="text"  id="exampleInputtext" name="nickname" >
		   
		  </div>
		  
		  <div >
		    <label for="exampleInputPassword1">Password</label>
		    <input type="password" id="exampleInputPassword1" name="pass" >
		  </div>
		  
		  <button type="submit" class="btn btn-dark">ACEPTAR</button>
		  <button type="button" onclick="window.location.href='index.jsp'" class="btn btn-dark">CANCELAR</button>
		  <button type="button" onclick="window.location.href='altausuario.jsp'" class="btn btn-dark">REGISTRARSE</button>
		</form>
	</div>
</body>

</html>