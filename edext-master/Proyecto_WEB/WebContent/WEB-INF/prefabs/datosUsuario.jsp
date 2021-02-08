	 <jsp:include page="text.jsp"><jsp:param name="lab" value="Nickname"/><jsp:param name="var" value="A_nick"/>
	 <jsp:param name="block" value="${param.view}"/>
	 </jsp:include>
	  
	  <jsp:include page="text.jsp"><jsp:param name="lab" value="Nombre"/><jsp:param name="var" value="A_nombre"/>
	  <jsp:param name="block" value="${param.view}"/>
	  </jsp:include>
	  
	  <jsp:include page="text.jsp"><jsp:param name="lab" value="Apellido"/><jsp:param name="var" value="A_apellido"/>
	  <jsp:param name="block" value="${param.view}"/>
	  </jsp:include>
	  
	  <jsp:include page="pass.jsp"><jsp:param name="lab" value="Password"/><jsp:param name="var" value="A_pass"/>
	  <jsp:param name="block" value="${param.view}"/>
	  </jsp:include>
	  
	  <jsp:include page="pass.jsp"><jsp:param name="lab" value="Confirmacion de Password"/><jsp:param name="var" value="A_confPass"/>
	  <jsp:param name="block" value="${param.view}"/>
	  </jsp:include>
	  
	  <jsp:include page="email.jsp"><jsp:param name="lab" value="Email"/><jsp:param name="var" value="A_email"/>
	  <jsp:param name="block" value="${param.view}"/>
	  </jsp:include>

	  <jsp:include page="fecha.jsp"><jsp:param name="lab" value="Fecha de Nacimiento"/><jsp:param name="var" value="A_fnac"/>
	  <jsp:param name="block" value="${param.view}"/>
	  </jsp:include>
	  
	  <jsp:include page="tipoUsuario.jsp"><jsp:param name="lab" value="Indique el Tipo de usuario"/>
	  <jsp:param name="block" value="${param.view}"/>
	  </jsp:include>