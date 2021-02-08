<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Interface.*,java.util.List,java.util.ArrayList,com.google.gson.Gson,Logica.Manejador,Logica.Curso,Logica.Estudiante,Logica.Usuario"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Bootstrap 4, from LayoutIt!</title>
    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   <!-- -----------Search Bar---------------- -->
 <style>.topnav input[type=text] {padding: 5px;margin-top: 8px;font-size: 15px;border: none;float: top;}</style>
<style>.topnav .search-container button {float: right;padding: 5px 9px;margin-top: 8px;margin-right: 16px;background: #ddd;font-size: 13px;border: none;cursor: pointer;}}</style>
  <style> .topnav .search-container {float: right;} </style>
  <!-- --------------------------------------- -->
 <script>
		function myFunction() {
		//alert("llegue aca");
		var nombre ='<%=request.getAttribute("usuario")%>';
		localStorage.setItem("Nombre", nombre);
		
		//alert(nombre);
		var tipo2 ='<%=request.getAttribute("tipo")%>';
		//alert(tipo2);
		//logica de la funcion 
			if (tipo2=="D"){
				//alert("entré al menu Docente");
				document.getElementById("p1").innerHTML +="	<div class=\"row navbar navbar-expand-sm bg-dark navbar-dark\">"+
					"	<div class=\"col\">"+
					"	<ul class=\"navbar-nav\">"+
					"	   <!-- Dropdown -->"+
					"	  <li class=\"nav-item dropdown\">"+
					"	      <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbardrop\" data-toggle=\"dropdown\">Usuarios</a>"+
					"	      <div class=\"dropdown-menu\">"+
					"	        <a class=\"dropdown-item\" href=\"consultaUsuario.jsp\">Consulta Usuario</a>"+
					"	        <a class=\"dropdown-item\" href=\"#\">Modificar Datos Usuario</a>"+
					"	      </div></li>"+
					"	      <!-- Dropdown -->"+
					"	    <li class=\"nav-item dropdown\">"+
					"	      <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbardrop\" data-toggle=\"dropdown\">Cursos</a>"+
					"	      <div class=\"dropdown-menu\">"+
					"	        <a class=\"dropdown-item\" href=\"altaCurso.jsp\">Alta de Curso</a>"+
					"	        <a class=\"dropdown-item\" href=\"consultaCurso.jsp\">Consulta de Curso</a>"+
					"	      </div></li>"+
					"	    <!-- Dropdown -->"+
					"	    <li class=\"nav-item dropdown\">"+
					"	      <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbardrop\" data-toggle=\"dropdown\">Edicion de Cursos</a>"+
					"	      <div class=\"dropdown-menu\">"+
					"	        <a class=\"dropdown-item\" href=\"altaedicioncurso.jsp\">Alta de Edicion de Curso</a>"+
					"	        <a class=\"dropdown-item\" href=\"consultaEdicion.jsp\">Consulta Edicion de Curso</a>"+
					"	        <a class=\"dropdown-item\" href=\"seleccionarEstudiantes.jsp\">Seleccionar Estudiantes para Edicion de Curso</a>"+
					"	        <a class=\"dropdown-item\" href=\"listarAceptados.jsp\">Listar Estudiantes aceptados para Edicion de Curso</a>"+
					"	      </div></li>"+
					"	      <!-- Dropdown -->"+
					"	    <li class=\"nav-item dropdown\">"+
					"	      <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbardrop\" data-toggle=\"dropdown\">Programa de Formacion</a>"+
					"	      <div class=\"dropdown-menu\">"+
					"	       <a class=\"dropdown-item\" href=\"altaprograma.jsp\">Crear Programa de Formacion</a>"+
					"	        <a class=\"dropdown-item\" href=\"#\">Agregar Curso a Programa de Formacion</a>"+
					"	        <a class=\"dropdown-item\" href=\"consultaProgFormacion.jsp\">Consulta Programa de Formacion</a>"+
					"	      </div></li>"+
					"	    <li class=\"nav-item\">"+
					"	      <a class=\"nav-link\" href=\"#\">Seguidores</a>"+
					"	    </li>"+
					"	    </ul></div>"+
					"	    <div class=\"col\">"+
					"			<ul class=\"nav justify-content-end\">"+
					"				<p class=\"text-white bg-dark\">Bienvenido Docente</p>"+
					"					<li class=\"nav-item\"><a id=\"cerrar\" class=\"nav-link\" href=\"Logout\">Cerrar Sesion</a></li>"+
					"			</ul>"+
					"		</div>"+
					"	    </div>"
									;
				
			}else if(tipo2=="E"){
					//alert("entré al menu Estudiante");
						document.getElementById("p1").innerHTML += "<div class=\"row navbar navbar-expand-sm bg-dark navbar-dark\">"+
						"<div class=\"col\">"+
						"<ul class=\"navbar-nav\">"+
						"  <!-- Dropdown -->"+
						"  <li class=\"nav-item dropdown\">"+
						"      <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbardrop\" data-toggle=\"dropdown\">Usuarios</a>"+
						"      <div class=\"dropdown-menu\">"+
						"        <a class=\"dropdown-item\" href=\"consultaUsuario.jsp\">Consulta Usuario</a>"+
						"        <a class=\"dropdown-item\" href=\"#\">Modificar Datos Usuario</a>"+
						"      </div></li>"+
						"    <!-- Dropdown -->"+
						"    <li class=\"nav-item dropdown\">"+
						"      <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbardrop\" data-toggle=\"dropdown\">Cursos</a>"+
						"      <div class=\"dropdown-menu\">"+
						"        <a class=\"dropdown-item\" href=\"consultaCurso.jsp\">Consulta Curso</a>"+
						"      </div></li>"+
						"      <!-- Dropdown -->"+
						"    <li class=\"nav-item dropdown\">"+
						"      <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbardrop\" data-toggle=\"dropdown\">Edicion de Cursos</a>"+
						"      <div class=\"dropdown-menu\">"+
						"        <a class=\"dropdown-item\" href=\"inscripcionEdicion.jsp\">Inscripcion a Edicion de Curso</a>"+
						"        <a class=\"dropdown-item\" href=\"consultaEdicion.jsp\">Consulta Edicion de Curso</a>"+
						"        <a class=\"dropdown-item\" href=\"#\">Resultado de inscripcion a Edicion de Curso</a>"+
						"      </div></li>"+
						"      <!-- Dropdown -->"+
						"    <li class=\"nav-item dropdown\">"+
						"      <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbardrop\" data-toggle=\"dropdown\">Programa de Formacion</a>"+
						"      <div class=\"dropdown-menu\">"+
						"        <a class=\"dropdown-item\" href=\"#\">Inscripcion a Programa de Formacion</a>"+
						"        <a class=\"dropdown-item\" href=\"consultaProgFormacion.jsp\">Consulta Programa de Formacion</a>"+
						"      </div></li>"+
						"      <li class=\"nav-item\">"+
						"      <a class=\"nav-link\" href=\"#\">Seguidores</a>"+
						"    </li>"+
						"      </ul></div>"+
						"		<div class=\"col\">"+
						"			<ul class=\"nav justify-content-end\">"+
						"				<p class=\"text-white bg-dark\">Bienvenido Estudiante</p>"+
						"					<li class=\"nav-item\"><a id=\"cerrar\" class=\"nav-link\" href=\"Logout\">Cerrar Sesion</a></li>"+
						"			</ul>"+
						"		</div>"+
						"	    </div>"
						;
			}else{
				//alert("va el menu visitante");
				document.getElementById("p1").innerHTML +="<div class=\"row mr-auto navbar-expand-sm bg-dark navbar-dark\">"+
				"		<div class=\"col\">"+
				"		  <nav class=\"navbar-nav\">"+
				"		    <li class=\"nav-item dropdown\">"+
				"		      <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbardrop\" data-toggle=\"dropdown\">Consultas</a>"+
				"		      <div class=\"dropdown-menu\">"+
				"		        <a class=\"dropdown-item\" href=\"consultaUsuario.jsp\">Consulta Usuario</a>"+
				"		        <a class=\"dropdown-item\" href=\"consultaCurso.jsp\">Consulta Curso</a>"+
				"		        <a class=\"dropdown-item\" href=\"consultaEdicion.jsp\">Consulta Edicion de Curso</a>"+
				"		        <a class=\"dropdown-item\" href=\"consultaProgFormacion.jsp\">Consulta Programa Formacion</a>"+
				"		      </div></li>"+
				"		     </nav>"+
				"		</div>"+
				"			<div class=\"col\">"+
				"				<ul class=\"nav justify-content-end\">"+
				"					<li class=\"nav-item\"><a class=\"nav-link\" href=\"#\"></a></li>"+
				"					<li class=\"nav-item\"><a class=\"nav-link\" href=\"altausuario.jsp\">Registrarse</a></li>"+
				"					<li class=\"nav-item\"><a class=\"nav-link\" href=\"Login.jsp\">Iniciar Sesion</a></li>"+
				"				</ul>"+
				"		</div>"+
				"		</div>"
				;
			}
		}
</script> 

  </head>
  <!-- body onload="myFunction()" background="https://image.freepik.com/vector-gratis/vector-fondo-triangulos-poligono-abstracto_2065-346.jpg"-->
  <body onload="myFunction()" background="https://us.123rf.com/450wm/yamabikay/yamabikay1705/yamabikay170500120/78105857-textura-de-cuero-verde-oscuro-en-macro-fondo-cuadrado-transparente-listo-para-el-azulejo-foto-de-alt.jpg?ver=6">
<!-- ------------------------------------------------------------- -->
<script type="text/javascript">
//var valor = document.getElementById("prueba").value;
//alert(valor);
</script> 


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
<p id="p1"></p>


<% 
// Fabrica fabrica= Fabrica.getInstancia();
// IConsulta icon = fabrica.getIConsulta();
// Manejador m = Manejador.getInstancia();
// Usuario user= new Usuario();
// user=null;
//String nickname = (String) request.getAttribute("usuario");
// System.out.println("el nickname que paso esss"+ nickname);
// user= m.buscarUsuario(nickname);
// //vemos el tipo del usuario
// 				String tipo="";
// 				List<Estudiante> est = new ArrayList<Estudiante>();
// 				est= m.getEstudiantes();	
// 				for(Estudiante e: est) {
					
// 					if(user.getNickname().equals(e.getNickname()) )
// 						tipo = "E";
// 					else {
// 						tipo = "D";
// 					}
// 				}
// %> 
<%
//out.print(request.getAttribute("nombre"));
//out.print(request.getAttribute("usuario"));
 //String usuario =  request.getAttribute("usuario").toString();
 // out.print(usuario);
%>

<input type="hidden" id= "AU" name="A_Usuario" value="<%=request.getAttribute("usuario")%>">
<input type="hidden" id= "AT" name="A_Tipo" value="<%=request.getAttribute("tipo")%>">

<%
Fabrica fabrica= Fabrica.getInstancia();
IConsulta icon = fabrica.getIConsulta();
Manejador m = Manejador.getInstancia();
Usuario user= new Usuario();
user=null;
%>




    <div class="container-fluid">
	
	<div class="row">
		<div class="col-md-12">
			<div class="carousel slide" id="carousel-522377">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-522377" class="active">
					</li>
					<li data-slide-to="1" data-target="#carousel-522377">
					</li>
					<li data-slide-to="2" data-target="#carousel-522377">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img class="d-block w-100" alt="Carousel Bootstrap First" src="https://www.muycomputerpro.com/wp-content/uploads/2020/01/programadores.jpg">
						<div class="carousel-caption">									
							<h1>
								mas de 2000 alumnos!! 
							</h1>
							<p>
								ya eligieron edeXT para continuar sus estudios academicos.
							</p>
						</div>
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" alt="Carousel Bootstrap Second" src="https://renovaliainmobiliaria.com/wp-content/uploads/2020/08/alquilar-piso-para-estudiantes.jpg">
						<div class="carousel-caption">
							<h1>
								Aprende a tu Ritmo
							</h1>
							<p>
								Puedes acceder a la plataforma las 24 horas del dia, los 365 dias del año.
							</p>
						</div>
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" alt="Carousel Bootstrap Third" src="https://www.beon.com/wp-content/uploads/2019/05/Foto-2-Visas-estudiantes.jpg">
						<div class="carousel-caption">
							<h1>
								Cursos de Programación 
							</h1>
							<p>
								Aprenda con edeXT cursos de programación en todos los lenguajes y en todos los niveles, y conviertase en un profesional,
								Desde crear pequeños Scripts hasta utilizar funciones complejas  en lenguajes avanzados de programación.
							</p>
						</div>
					</div>
				</div> <a class="carousel-control-prev" href="#carousel-522377" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a> <a class="carousel-control-next" href="#carousel-522377" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
document.getElementById("botonBuscar").addEventListener('click',function ()
		{var buscar=document.getElementById("barraBuscar").value;
		console.log(buscar);
		localStorage.setItem("consulta", buscar);
		window.location = 'busqueda.jsp';
		   }  );
</script>

<script>
    document.getElementById("cerrar").addEventListener('click',function (){
    	localStorage.removeItem('Nombre');
        }) 		  
    </script>


    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
    
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
<!-- %@include file="WEB-INF/footer.jsp" %-->
<script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
  </body>
</html>