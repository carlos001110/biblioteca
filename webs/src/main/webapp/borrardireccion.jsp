<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="es.ascender.biblioteca.negocio.Direccion" %>
<%@ page import="jdbc.DireccionRepositoryJdbc" %>
<%@ page import="repositories.DireccionRepositories" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Borrar Dirección</title>
</head>
<body>

<% 
    // Recoger los parámetros del formulario
    String dni = request.getParameter("dni");
    String calle = request.getParameter("calle");
    String numeroStr = request.getParameter("numero");

    // Convertir los valores numéricos a enteros
    int numero = Integer.parseInt(numeroStr);

    // Crear un objeto Direccion con los tres valores de la clave primaria
    Direccion d = new Direccion(dni, calle, numero);

    // Usar la implementación concreta DireccionRepositoryJdbc
    DireccionRepositories repo = new DireccionRepositoryJdbc();

    // Llamar al método para borrar la dirección de la base de datos
    repo.borrar(d);

    // Redirigir a otra página (listadireccion.jsp) después de borrar
    response.sendRedirect("listadireccion.jsp");
%>

</body>
</html>
