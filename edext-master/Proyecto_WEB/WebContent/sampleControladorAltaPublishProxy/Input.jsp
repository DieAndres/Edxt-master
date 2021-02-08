<%@page contentType="text/html;charset=UTF-8"%>
<HTML>
<HEAD>
<TITLE>Inputs</TITLE>
</HEAD>
<BODY>
<H1>Inputs</H1>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

boolean valid = true;

if(methodID != -1) methodID = Integer.parseInt(method);
switch (methodID){ 
case 2:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 5:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">endpoint:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="endpoint8" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 10:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 13:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg0:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg028" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 30:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg0:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg033" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 35:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg0:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg038" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 40:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">arg0:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">email:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="email45" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fNac:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="fNac47" SIZE=20></TD>
<%
java.text.DateFormat dateFormatfNac47 = java.text.DateFormat.getDateInstance();
java.util.GregorianCalendar gcExampfNac47  = new java.util.GregorianCalendar();
java.util.Date datefNac47 = gcExampfNac47.getTime();
String tempResultfNac47 = dateFormatfNac47.format(datefNac47);
%>
<TD ALIGN="left">
</TR>
<TR>
<TD> </TD>
<TD ALIGN="left"> eg. <%= tempResultfNac47 %> </TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">pass:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="pass49" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">foto:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="foto51" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="apellido53" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="nombre55" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nickName:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="nickName57" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 59:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">arg0:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="descripcion64" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">foto:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="foto66" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">creditos:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="creditos68" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantHoras:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="cantHoras70" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaReg:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="fechaReg72" SIZE=20></TD>
<%
java.text.DateFormat dateFormatfechaReg72 = java.text.DateFormat.getDateInstance();
java.util.GregorianCalendar gcExampfechaReg72  = new java.util.GregorianCalendar();
java.util.Date datefechaReg72 = gcExampfechaReg72.getTime();
String tempResultfechaReg72 = dateFormatfechaReg72.format(datefechaReg72);
%>
<TD ALIGN="left">
</TR>
<TR>
<TD> </TD>
<TD ALIGN="left"> eg. <%= tempResultfechaReg72 %> </TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">uRL:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="uRL74" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="duracion76" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="nombre78" SIZE=20></TD>
</TR>
</TABLE>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg1:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg180" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 82:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg0:</TD>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 87:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 90:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 93:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg0:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg096" SIZE=20></TD>
</TR>
</TABLE>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg1:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg198" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 100:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg0:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg0103" SIZE=20></TD>
</TR>
</TABLE>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">arg1:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fInicio:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="fInicio107" SIZE=20></TD>
<%
java.text.DateFormat dateFormatfInicio107 = java.text.DateFormat.getDateInstance();
java.util.GregorianCalendar gcExampfInicio107  = new java.util.GregorianCalendar();
java.util.Date datefInicio107 = gcExampfInicio107.getTime();
String tempResultfInicio107 = dateFormatfInicio107.format(datefInicio107);
%>
<TD ALIGN="left">
</TR>
<TR>
<TD> </TD>
<TD ALIGN="left"> eg. <%= tempResultfInicio107 %> </TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fPublicacion:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="fPublicacion109" SIZE=20></TD>
<%
java.text.DateFormat dateFormatfPublicacion109 = java.text.DateFormat.getDateInstance();
java.util.GregorianCalendar gcExampfPublicacion109  = new java.util.GregorianCalendar();
java.util.Date datefPublicacion109 = gcExampfPublicacion109.getTime();
String tempResultfPublicacion109 = dateFormatfPublicacion109.format(datefPublicacion109);
%>
<TD ALIGN="left">
</TR>
<TR>
<TD> </TD>
<TD ALIGN="left"> eg. <%= tempResultfPublicacion109 %> </TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cupo:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="cupo111" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fFin:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="fFin113" SIZE=20></TD>
<%
java.text.DateFormat dateFormatfFin113 = java.text.DateFormat.getDateInstance();
java.util.GregorianCalendar gcExampfFin113  = new java.util.GregorianCalendar();
java.util.Date datefFin113 = gcExampfFin113.getTime();
String tempResultfFin113 = dateFormatfFin113.format(datefFin113);
%>
<TD ALIGN="left">
</TR>
<TR>
<TD> </TD>
<TD ALIGN="left"> eg. <%= tempResultfFin113 %> </TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">foto:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="foto115" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="nombre117" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 119:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg0:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg0122" SIZE=20></TD>
</TR>
</TABLE>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg1:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg1124" SIZE=20></TD>
<%
java.text.DateFormat dateFormatarg1124 = java.text.DateFormat.getDateInstance();
java.util.GregorianCalendar gcExamparg1124  = new java.util.GregorianCalendar();
java.util.Date datearg1124 = gcExamparg1124.getTime();
String tempResultarg1124 = dateFormatarg1124.format(datearg1124);
%>
<TD ALIGN="left">
</TR>
<TR>
<TD> </TD>
<TD ALIGN="left"> eg. <%= tempResultarg1124 %> </TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 126:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">arg0:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">usuario:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">email:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="email133" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fNac:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="fNac135" SIZE=20></TD>
<%
java.text.DateFormat dateFormatfNac135 = java.text.DateFormat.getDateInstance();
java.util.GregorianCalendar gcExampfNac135  = new java.util.GregorianCalendar();
java.util.Date datefNac135 = gcExampfNac135.getTime();
String tempResultfNac135 = dateFormatfNac135.format(datefNac135);
%>
<TD ALIGN="left">
</TR>
<TR>
<TD> </TD>
<TD ALIGN="left"> eg. <%= tempResultfNac135 %> </TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">pass:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="pass137" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">foto:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="foto139" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">apellido:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="apellido141" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">nombre:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="nombre143" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">nickName:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="nickName145" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 147:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg0:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg0150" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 152:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">arg0:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">instituto:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="instituto157" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 159:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg0:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg0162" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 164:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">arg0:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fInicio:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="fInicio169" SIZE=20></TD>
<%
java.text.DateFormat dateFormatfInicio169 = java.text.DateFormat.getDateInstance();
java.util.GregorianCalendar gcExampfInicio169  = new java.util.GregorianCalendar();
java.util.Date datefInicio169 = gcExampfInicio169.getTime();
String tempResultfInicio169 = dateFormatfInicio169.format(datefInicio169);
%>
<TD ALIGN="left">
</TR>
<TR>
<TD> </TD>
<TD ALIGN="left"> eg. <%= tempResultfInicio169 %> </TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="descripcion171" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fFin:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="fFin173" SIZE=20></TD>
<%
java.text.DateFormat dateFormatfFin173 = java.text.DateFormat.getDateInstance();
java.util.GregorianCalendar gcExampfFin173  = new java.util.GregorianCalendar();
java.util.Date datefFin173 = gcExampfFin173.getTime();
String tempResultfFin173 = dateFormatfFin173.format(datefFin173);
%>
<TD ALIGN="left">
</TR>
<TR>
<TD> </TD>
<TD ALIGN="left"> eg. <%= tempResultfFin173 %> </TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">foto:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="foto175" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="nombre177" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 179:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg0:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg0182" SIZE=20></TD>
</TR>
</TABLE>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg1:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg1184" SIZE=20></TD>
</TR>
</TABLE>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg2:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg2186" SIZE=20></TD>
<%
java.text.DateFormat dateFormatarg2186 = java.text.DateFormat.getDateInstance();
java.util.GregorianCalendar gcExamparg2186  = new java.util.GregorianCalendar();
java.util.Date datearg2186 = gcExamparg2186.getTime();
String tempResultarg2186 = dateFormatarg2186.format(datearg2186);
%>
<TD ALIGN="left">
</TR>
<TR>
<TD> </TD>
<TD ALIGN="left"> eg. <%= tempResultarg2186 %> </TD>
</TR>
</TABLE>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg3:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg3188" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 190:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg0:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg0193" SIZE=20></TD>
</TR>
</TABLE>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg1:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg1195" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 197:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg0:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg0200" SIZE=20></TD>
</TR>
</TABLE>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">arg1:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="arg1202" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 1111111111:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">URLString:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="url1111111111" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 1111111112:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=org.eclipse.jst.ws.util.JspUtils.markup(method)%>">
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
}
if (valid) {
%>
Select a method to test.
<%
}
%>

</BODY>
</HTML>
