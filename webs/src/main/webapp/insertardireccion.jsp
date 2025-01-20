<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="es.ascender.biblioteca.negocio.Direccion" %>
    <%@ page import="jdbc.DireccionRepositoryJdbc" %>
    <%@ page import="repositories.DireccionRepositories" %>
    <%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String dni = request.getParameter("dni");
String calle = request.getParameter("calle");
String numeroStr = request.getParameter("numero");
String codigopostalStr = request.getParameter("codigopostal");


int numero = Integer.parseInt(numeroStr);
int codigopostal = Integer.parseInt(codigopostalStr);

Direccion d=new Direccion(dni,calle,numero,codigopostal);
DireccionRepositories repo=new DireccionRepositoryJdbc();
repo.insertar(d);
response.sendRedirect("listadireccion.jsp");

%>
</body>
</html>