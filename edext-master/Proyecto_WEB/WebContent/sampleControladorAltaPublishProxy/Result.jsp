<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorAltaPublishProxyid" scope="session" class="Publicaciones.ControladorAltaPublishProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorAltaPublishProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleControladorAltaPublishProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleControladorAltaPublishProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        Publicaciones.ControladorAltaPublish getControladorAltaPublish10mtemp = sampleControladorAltaPublishProxyid.getControladorAltaPublish();
if(getControladorAltaPublish10mtemp == null){
%>
<%=getControladorAltaPublish10mtemp %>
<%
}else{
        if(getControladorAltaPublish10mtemp!= null){
        String tempreturnp11 = getControladorAltaPublish10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg028");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        Publicaciones.DtEdicion seleccionarCurso13mtemp = sampleControladorAltaPublishProxyid.seleccionarCurso(arg0_1idTemp);
if(seleccionarCurso13mtemp == null){
%>
<%=seleccionarCurso13mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fInicio:</TD>
<TD>
<%
if(seleccionarCurso13mtemp != null){
java.util.Calendar typefInicio16 = seleccionarCurso13mtemp.getFInicio();
        java.text.DateFormat dateFormatfInicio16 = java.text.DateFormat.getDateInstance();
        java.util.Date datefInicio16 = typefInicio16.getTime();
        String tempResultfInicio16 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfInicio16.format(datefInicio16));
        %>
        <%= tempResultfInicio16 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fPublicacion:</TD>
<TD>
<%
if(seleccionarCurso13mtemp != null){
java.util.Calendar typefPublicacion18 = seleccionarCurso13mtemp.getFPublicacion();
        java.text.DateFormat dateFormatfPublicacion18 = java.text.DateFormat.getDateInstance();
        java.util.Date datefPublicacion18 = typefPublicacion18.getTime();
        String tempResultfPublicacion18 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfPublicacion18.format(datefPublicacion18));
        %>
        <%= tempResultfPublicacion18 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cupo:</TD>
<TD>
<%
if(seleccionarCurso13mtemp != null){
java.lang.Integer typecupo20 = seleccionarCurso13mtemp.getCupo();
        String tempResultcupo20 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecupo20));
        %>
        <%= tempResultcupo20 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fFin:</TD>
<TD>
<%
if(seleccionarCurso13mtemp != null){
java.util.Calendar typefFin22 = seleccionarCurso13mtemp.getFFin();
        java.text.DateFormat dateFormatfFin22 = java.text.DateFormat.getDateInstance();
        java.util.Date datefFin22 = typefFin22.getTime();
        String tempResultfFin22 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfFin22.format(datefFin22));
        %>
        <%= tempResultfFin22 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">foto:</TD>
<TD>
<%
if(seleccionarCurso13mtemp != null){
java.lang.String typefoto24 = seleccionarCurso13mtemp.getFoto();
        String tempResultfoto24 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefoto24));
        %>
        <%= tempResultfoto24 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(seleccionarCurso13mtemp != null){
java.lang.String typenombre26 = seleccionarCurso13mtemp.getNombre();
        String tempResultnombre26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre26));
        %>
        <%= tempResultnombre26 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 30:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg033");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        java.lang.String[] listarCursos30mtemp = sampleControladorAltaPublishProxyid.listarCursos(arg0_2idTemp);
if(listarCursos30mtemp == null){
%>
<%=listarCursos30mtemp %>
<%
}else{
        String tempreturnp31 = null;
        if(listarCursos30mtemp != null){
        java.util.List listreturnp31= java.util.Arrays.asList(listarCursos30mtemp);
        tempreturnp31 = listreturnp31.toString();
        }
        %>
        <%=tempreturnp31%>
        <%
}
break;
case 35:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg038");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        java.lang.String[] selectInstituto35mtemp = sampleControladorAltaPublishProxyid.selectInstituto(arg0_3idTemp);
if(selectInstituto35mtemp == null){
%>
<%=selectInstituto35mtemp %>
<%
}else{
        String tempreturnp36 = null;
        if(selectInstituto35mtemp != null){
        java.util.List listreturnp36= java.util.Arrays.asList(selectInstituto35mtemp);
        tempreturnp36 = listreturnp36.toString();
        }
        %>
        <%=tempreturnp36%>
        <%
}
break;
case 40:
        gotMethod = true;
        String email_5id=  request.getParameter("email45");
            java.lang.String email_5idTemp = null;
        if(!email_5id.equals("")){
         email_5idTemp  = email_5id;
        }
        String fNac_6id=  request.getParameter("fNac47");
            java.util.Calendar fNac_6idTemp = null;
        if(!fNac_6id.equals("")){
        java.text.DateFormat dateFormatfNac47 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfNac47  = dateFormatfNac47.parse(fNac_6id);
         fNac_6idTemp = new java.util.GregorianCalendar();
        fNac_6idTemp.setTime(dateTempfNac47);
        }
        String pass_7id=  request.getParameter("pass49");
            java.lang.String pass_7idTemp = null;
        if(!pass_7id.equals("")){
         pass_7idTemp  = pass_7id;
        }
        String foto_8id=  request.getParameter("foto51");
            java.lang.String foto_8idTemp = null;
        if(!foto_8id.equals("")){
         foto_8idTemp  = foto_8id;
        }
        String apellido_9id=  request.getParameter("apellido53");
            java.lang.String apellido_9idTemp = null;
        if(!apellido_9id.equals("")){
         apellido_9idTemp  = apellido_9id;
        }
        String nombre_10id=  request.getParameter("nombre55");
            java.lang.String nombre_10idTemp = null;
        if(!nombre_10id.equals("")){
         nombre_10idTemp  = nombre_10id;
        }
        String nickName_11id=  request.getParameter("nickName57");
            java.lang.String nickName_11idTemp = null;
        if(!nickName_11id.equals("")){
         nickName_11idTemp  = nickName_11id;
        }
        %>
        <jsp:useBean id="Publicaciones1DtUsuario_4id" scope="session" class="Publicaciones.DtUsuario" />
        <%
        Publicaciones1DtUsuario_4id.setEmail(email_5idTemp);
        Publicaciones1DtUsuario_4id.setFNac(fNac_6idTemp);
        Publicaciones1DtUsuario_4id.setPass(pass_7idTemp);
        Publicaciones1DtUsuario_4id.setFoto(foto_8idTemp);
        Publicaciones1DtUsuario_4id.setApellido(apellido_9idTemp);
        Publicaciones1DtUsuario_4id.setNombre(nombre_10idTemp);
        Publicaciones1DtUsuario_4id.setNickName(nickName_11idTemp);
        boolean registroUsuario40mtemp = sampleControladorAltaPublishProxyid.registroUsuario(Publicaciones1DtUsuario_4id);
        String tempResultreturnp41 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(registroUsuario40mtemp));
        %>
        <%= tempResultreturnp41 %>
        <%
break;
case 59:
        gotMethod = true;
        String descripcion_13id=  request.getParameter("descripcion64");
            java.lang.String descripcion_13idTemp = null;
        if(!descripcion_13id.equals("")){
         descripcion_13idTemp  = descripcion_13id;
        }
        String foto_14id=  request.getParameter("foto66");
            java.lang.String foto_14idTemp = null;
        if(!foto_14id.equals("")){
         foto_14idTemp  = foto_14id;
        }
        String creditos_15id=  request.getParameter("creditos68");
            java.lang.Integer creditos_15idTemp = null;
        if(!creditos_15id.equals("")){
         creditos_15idTemp  = java.lang.Integer.valueOf(creditos_15id);
        }
        String cantHoras_16id=  request.getParameter("cantHoras70");
            java.lang.Integer cantHoras_16idTemp = null;
        if(!cantHoras_16id.equals("")){
         cantHoras_16idTemp  = java.lang.Integer.valueOf(cantHoras_16id);
        }
        String fechaReg_17id=  request.getParameter("fechaReg72");
            java.util.Calendar fechaReg_17idTemp = null;
        if(!fechaReg_17id.equals("")){
        java.text.DateFormat dateFormatfechaReg72 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfechaReg72  = dateFormatfechaReg72.parse(fechaReg_17id);
         fechaReg_17idTemp = new java.util.GregorianCalendar();
        fechaReg_17idTemp.setTime(dateTempfechaReg72);
        }
        String uRL_18id=  request.getParameter("uRL74");
            java.lang.String uRL_18idTemp = null;
        if(!uRL_18id.equals("")){
         uRL_18idTemp  = uRL_18id;
        }
        String duracion_19id=  request.getParameter("duracion76");
            java.lang.Integer duracion_19idTemp = null;
        if(!duracion_19id.equals("")){
         duracion_19idTemp  = java.lang.Integer.valueOf(duracion_19id);
        }
        String nombre_20id=  request.getParameter("nombre78");
            java.lang.String nombre_20idTemp = null;
        if(!nombre_20id.equals("")){
         nombre_20idTemp  = nombre_20id;
        }
        %>
        <jsp:useBean id="Publicaciones1DtCurso_12id" scope="session" class="Publicaciones.DtCurso" />
        <%
        Publicaciones1DtCurso_12id.setDescripcion(descripcion_13idTemp);
        Publicaciones1DtCurso_12id.setFoto(foto_14idTemp);
        Publicaciones1DtCurso_12id.setCreditos(creditos_15idTemp);
        Publicaciones1DtCurso_12id.setCantHoras(cantHoras_16idTemp);
        Publicaciones1DtCurso_12id.setFechaReg(fechaReg_17idTemp);
        Publicaciones1DtCurso_12id.setURL(uRL_18idTemp);
        Publicaciones1DtCurso_12id.setDuracion(duracion_19idTemp);
        Publicaciones1DtCurso_12id.setNombre(nombre_20idTemp);
        String arg1_21id=  request.getParameter("arg180");
            java.lang.String arg1_21idTemp = null;
        if(!arg1_21id.equals("")){
         arg1_21idTemp  = arg1_21id;
        }
        boolean registroCurso59mtemp = sampleControladorAltaPublishProxyid.registroCurso(Publicaciones1DtCurso_12id,arg1_21idTemp);
        String tempResultreturnp60 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(registroCurso59mtemp));
        %>
        <%= tempResultreturnp60 %>
        <%
break;
case 82:
        gotMethod = true;
        %>
        <jsp:useBean id="Publicaciones1ArrayList_22id" scope="session" class="Publicaciones.ArrayList" />
        <%
        sampleControladorAltaPublishProxyid.confirmarCurso(Publicaciones1ArrayList_22id);
break;
case 87:
        gotMethod = true;
        sampleControladorAltaPublishProxyid.confirmarEdicion();
break;
case 90:
        gotMethod = true;
        sampleControladorAltaPublishProxyid.cancelar();
break;
case 93:
        gotMethod = true;
        String arg0_23id=  request.getParameter("arg096");
            java.lang.String arg0_23idTemp = null;
        if(!arg0_23id.equals("")){
         arg0_23idTemp  = arg0_23id;
        }
        String arg1_24id=  request.getParameter("arg198");
            java.lang.String arg1_24idTemp = null;
        if(!arg1_24id.equals("")){
         arg1_24idTemp  = arg1_24id;
        }
        sampleControladorAltaPublishProxyid.agregarPrograma(arg0_23idTemp,arg1_24idTemp);
break;
case 100:
        gotMethod = true;
        String arg0_25id=  request.getParameter("arg0103");
            java.lang.String arg0_25idTemp = null;
        if(!arg0_25id.equals("")){
         arg0_25idTemp  = arg0_25id;
        }
        String fInicio_27id=  request.getParameter("fInicio107");
            java.util.Calendar fInicio_27idTemp = null;
        if(!fInicio_27id.equals("")){
        java.text.DateFormat dateFormatfInicio107 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfInicio107  = dateFormatfInicio107.parse(fInicio_27id);
         fInicio_27idTemp = new java.util.GregorianCalendar();
        fInicio_27idTemp.setTime(dateTempfInicio107);
        }
        String fPublicacion_28id=  request.getParameter("fPublicacion109");
            java.util.Calendar fPublicacion_28idTemp = null;
        if(!fPublicacion_28id.equals("")){
        java.text.DateFormat dateFormatfPublicacion109 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfPublicacion109  = dateFormatfPublicacion109.parse(fPublicacion_28id);
         fPublicacion_28idTemp = new java.util.GregorianCalendar();
        fPublicacion_28idTemp.setTime(dateTempfPublicacion109);
        }
        String cupo_29id=  request.getParameter("cupo111");
            java.lang.Integer cupo_29idTemp = null;
        if(!cupo_29id.equals("")){
         cupo_29idTemp  = java.lang.Integer.valueOf(cupo_29id);
        }
        String fFin_30id=  request.getParameter("fFin113");
            java.util.Calendar fFin_30idTemp = null;
        if(!fFin_30id.equals("")){
        java.text.DateFormat dateFormatfFin113 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfFin113  = dateFormatfFin113.parse(fFin_30id);
         fFin_30idTemp = new java.util.GregorianCalendar();
        fFin_30idTemp.setTime(dateTempfFin113);
        }
        String foto_31id=  request.getParameter("foto115");
            java.lang.String foto_31idTemp = null;
        if(!foto_31id.equals("")){
         foto_31idTemp  = foto_31id;
        }
        String nombre_32id=  request.getParameter("nombre117");
            java.lang.String nombre_32idTemp = null;
        if(!nombre_32id.equals("")){
         nombre_32idTemp  = nombre_32id;
        }
        %>
        <jsp:useBean id="Publicaciones1DtEdicion_26id" scope="session" class="Publicaciones.DtEdicion" />
        <%
        Publicaciones1DtEdicion_26id.setFInicio(fInicio_27idTemp);
        Publicaciones1DtEdicion_26id.setFPublicacion(fPublicacion_28idTemp);
        Publicaciones1DtEdicion_26id.setCupo(cupo_29idTemp);
        Publicaciones1DtEdicion_26id.setFFin(fFin_30idTemp);
        Publicaciones1DtEdicion_26id.setFoto(foto_31idTemp);
        Publicaciones1DtEdicion_26id.setNombre(nombre_32idTemp);
        boolean seleccionarCurso2100mtemp = sampleControladorAltaPublishProxyid.seleccionarCurso2(arg0_25idTemp,Publicaciones1DtEdicion_26id);
        String tempResultreturnp101 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(seleccionarCurso2100mtemp));
        %>
        <%= tempResultreturnp101 %>
        <%
break;
case 119:
        gotMethod = true;
        String arg0_33id=  request.getParameter("arg0122");
            java.lang.String arg0_33idTemp = null;
        if(!arg0_33id.equals("")){
         arg0_33idTemp  = arg0_33id;
        }
        String arg1_34id=  request.getParameter("arg1124");
            java.util.Calendar arg1_34idTemp = null;
        if(!arg1_34id.equals("")){
        java.text.DateFormat dateFormatarg1124 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg1124  = dateFormatarg1124.parse(arg1_34id);
         arg1_34idTemp = new java.util.GregorianCalendar();
        arg1_34idTemp.setTime(dateTemparg1124);
        }
        boolean seleccionarEstudiante119mtemp = sampleControladorAltaPublishProxyid.seleccionarEstudiante(arg0_33idTemp,arg1_34idTemp);
        String tempResultreturnp120 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(seleccionarEstudiante119mtemp));
        %>
        <%= tempResultreturnp120 %>
        <%
break;
case 126:
        gotMethod = true;
        String email_37id=  request.getParameter("email133");
            java.lang.String email_37idTemp = null;
        if(!email_37id.equals("")){
         email_37idTemp  = email_37id;
        }
        String fNac_38id=  request.getParameter("fNac135");
            java.util.Calendar fNac_38idTemp = null;
        if(!fNac_38id.equals("")){
        java.text.DateFormat dateFormatfNac135 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfNac135  = dateFormatfNac135.parse(fNac_38id);
         fNac_38idTemp = new java.util.GregorianCalendar();
        fNac_38idTemp.setTime(dateTempfNac135);
        }
        String pass_39id=  request.getParameter("pass137");
            java.lang.String pass_39idTemp = null;
        if(!pass_39id.equals("")){
         pass_39idTemp  = pass_39id;
        }
        String foto_40id=  request.getParameter("foto139");
            java.lang.String foto_40idTemp = null;
        if(!foto_40id.equals("")){
         foto_40idTemp  = foto_40id;
        }
        String apellido_41id=  request.getParameter("apellido141");
            java.lang.String apellido_41idTemp = null;
        if(!apellido_41id.equals("")){
         apellido_41idTemp  = apellido_41id;
        }
        String nombre_42id=  request.getParameter("nombre143");
            java.lang.String nombre_42idTemp = null;
        if(!nombre_42id.equals("")){
         nombre_42idTemp  = nombre_42id;
        }
        String nickName_43id=  request.getParameter("nickName145");
            java.lang.String nickName_43idTemp = null;
        if(!nickName_43id.equals("")){
         nickName_43idTemp  = nickName_43id;
        }
        %>
        <jsp:useBean id="Publicaciones1DtUsuario_36id" scope="session" class="Publicaciones.DtUsuario" />
        <%
        Publicaciones1DtUsuario_36id.setEmail(email_37idTemp);
        Publicaciones1DtUsuario_36id.setFNac(fNac_38idTemp);
        Publicaciones1DtUsuario_36id.setPass(pass_39idTemp);
        Publicaciones1DtUsuario_36id.setFoto(foto_40idTemp);
        Publicaciones1DtUsuario_36id.setApellido(apellido_41idTemp);
        Publicaciones1DtUsuario_36id.setNombre(nombre_42idTemp);
        Publicaciones1DtUsuario_36id.setNickName(nickName_43idTemp);
        %>
        <jsp:useBean id="Publicaciones1DtEstudiante_35id" scope="session" class="Publicaciones.DtEstudiante" />
        <%
        Publicaciones1DtEstudiante_35id.setUsuario(Publicaciones1DtUsuario_36id);
        boolean registroUsuarioEst126mtemp = sampleControladorAltaPublishProxyid.registroUsuarioEst(Publicaciones1DtEstudiante_35id);
        String tempResultreturnp127 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(registroUsuarioEst126mtemp));
        %>
        <%= tempResultreturnp127 %>
        <%
break;
case 147:
        gotMethod = true;
        String arg0_44id=  request.getParameter("arg0150");
            java.lang.String arg0_44idTemp = null;
        if(!arg0_44id.equals("")){
         arg0_44idTemp  = arg0_44id;
        }
        boolean registroCategoria147mtemp = sampleControladorAltaPublishProxyid.registroCategoria(arg0_44idTemp);
        String tempResultreturnp148 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(registroCategoria147mtemp));
        %>
        <%= tempResultreturnp148 %>
        <%
break;
case 152:
        gotMethod = true;
        String instituto_46id=  request.getParameter("instituto157");
            java.lang.String instituto_46idTemp = null;
        if(!instituto_46id.equals("")){
         instituto_46idTemp  = instituto_46id;
        }
        %>
        <jsp:useBean id="Publicaciones1DtDocente_45id" scope="session" class="Publicaciones.DtDocente" />
        <%
        Publicaciones1DtDocente_45id.setInstituto(instituto_46idTemp);
        boolean registroUsuarioDoc152mtemp = sampleControladorAltaPublishProxyid.registroUsuarioDoc(Publicaciones1DtDocente_45id);
        String tempResultreturnp153 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(registroUsuarioDoc152mtemp));
        %>
        <%= tempResultreturnp153 %>
        <%
break;
case 159:
        gotMethod = true;
        String arg0_47id=  request.getParameter("arg0162");
            java.lang.String arg0_47idTemp = null;
        if(!arg0_47id.equals("")){
         arg0_47idTemp  = arg0_47id;
        }
        boolean registroInstituto159mtemp = sampleControladorAltaPublishProxyid.registroInstituto(arg0_47idTemp);
        String tempResultreturnp160 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(registroInstituto159mtemp));
        %>
        <%= tempResultreturnp160 %>
        <%
break;
case 164:
        gotMethod = true;
        String fInicio_49id=  request.getParameter("fInicio169");
            java.util.Calendar fInicio_49idTemp = null;
        if(!fInicio_49id.equals("")){
        java.text.DateFormat dateFormatfInicio169 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfInicio169  = dateFormatfInicio169.parse(fInicio_49id);
         fInicio_49idTemp = new java.util.GregorianCalendar();
        fInicio_49idTemp.setTime(dateTempfInicio169);
        }
        String descripcion_50id=  request.getParameter("descripcion171");
            java.lang.String descripcion_50idTemp = null;
        if(!descripcion_50id.equals("")){
         descripcion_50idTemp  = descripcion_50id;
        }
        String fFin_51id=  request.getParameter("fFin173");
            java.util.Calendar fFin_51idTemp = null;
        if(!fFin_51id.equals("")){
        java.text.DateFormat dateFormatfFin173 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfFin173  = dateFormatfFin173.parse(fFin_51id);
         fFin_51idTemp = new java.util.GregorianCalendar();
        fFin_51idTemp.setTime(dateTempfFin173);
        }
        String foto_52id=  request.getParameter("foto175");
            java.lang.String foto_52idTemp = null;
        if(!foto_52id.equals("")){
         foto_52idTemp  = foto_52id;
        }
        String nombre_53id=  request.getParameter("nombre177");
            java.lang.String nombre_53idTemp = null;
        if(!nombre_53id.equals("")){
         nombre_53idTemp  = nombre_53id;
        }
        %>
        <jsp:useBean id="Publicaciones1DtPrograma_48id" scope="session" class="Publicaciones.DtPrograma" />
        <%
        Publicaciones1DtPrograma_48id.setFInicio(fInicio_49idTemp);
        Publicaciones1DtPrograma_48id.setDescripcion(descripcion_50idTemp);
        Publicaciones1DtPrograma_48id.setFFin(fFin_51idTemp);
        Publicaciones1DtPrograma_48id.setFoto(foto_52idTemp);
        Publicaciones1DtPrograma_48id.setNombre(nombre_53idTemp);
        sampleControladorAltaPublishProxyid.registrarPrograma(Publicaciones1DtPrograma_48id);
break;
case 179:
        gotMethod = true;
        String arg0_54id=  request.getParameter("arg0182");
            java.lang.String arg0_54idTemp = null;
        if(!arg0_54id.equals("")){
         arg0_54idTemp  = arg0_54id;
        }
        String arg1_55id=  request.getParameter("arg1184");
            java.lang.String arg1_55idTemp = null;
        if(!arg1_55id.equals("")){
         arg1_55idTemp  = arg1_55id;
        }
        String arg2_56id=  request.getParameter("arg2186");
            java.util.Calendar arg2_56idTemp = null;
        if(!arg2_56id.equals("")){
        java.text.DateFormat dateFormatarg2186 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2186  = dateFormatarg2186.parse(arg2_56id);
         arg2_56idTemp = new java.util.GregorianCalendar();
        arg2_56idTemp.setTime(dateTemparg2186);
        }
        String arg3_57id=  request.getParameter("arg3188");
            java.lang.String arg3_57idTemp = null;
        if(!arg3_57id.equals("")){
         arg3_57idTemp  = arg3_57id;
        }
        sampleControladorAltaPublishProxyid.registrarEstEdicion(arg0_54idTemp,arg1_55idTemp,arg2_56idTemp,arg3_57idTemp);
break;
case 190:
        gotMethod = true;
        String arg0_58id=  request.getParameter("arg0193");
            java.lang.String arg0_58idTemp = null;
        if(!arg0_58id.equals("")){
         arg0_58idTemp  = arg0_58id;
        }
        String arg1_59id=  request.getParameter("arg1195");
            java.lang.String arg1_59idTemp = null;
        if(!arg1_59id.equals("")){
         arg1_59idTemp  = arg1_59id;
        }
        sampleControladorAltaPublishProxyid.agregarCategoriaCurso(arg0_58idTemp,arg1_59idTemp);
break;
case 197:
        gotMethod = true;
        String arg0_60id=  request.getParameter("arg0200");
            java.lang.String arg0_60idTemp = null;
        if(!arg0_60id.equals("")){
         arg0_60idTemp  = arg0_60id;
        }
        String arg1_61id=  request.getParameter("arg1202");
            java.lang.String arg1_61idTemp = null;
        if(!arg1_61id.equals("")){
         arg1_61idTemp  = arg1_61id;
        }
        sampleControladorAltaPublishProxyid.agregarDocentesAedicion(arg0_60idTemp,arg1_61idTemp);
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>