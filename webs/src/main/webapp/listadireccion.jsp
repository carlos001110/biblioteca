<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="es.ascender.biblioteca.negocio.Direccion" %>
<%@ page import="jdbc.DireccionRepositoryJdbc" %>
<%@ page import="repositories.DireccionRepositories" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Direcciones</title>
</head>
<body>

<%
    // Usar el repositorio para obtener las direcciones
    DireccionRepositories repo = new DireccionRepositoryJdbc();
    List<Direccion> lista = repo.buscartodos();

    // Verificar si hay parámetro de orden
    if (request.getParameter("orden") != null) {
        out.println("Ordenado por: " + request.getParameter("orden"));
        lista = repo.buscarTodosOrdenados(request.getParameter("orden"));
    } else {
        out.println("No hay orden");
        lista = repo.buscartodos();
    }
%>

<table>
<thead>
    <tr>
        <th><a href="?orden=dni">DNI</a></th>
        <th><a href="?orden=calle">Calle</a></th>
        <th><a href="?orden=numero">Número</a></th>
        <th><a href="?orden=codigopostal">Código Postal</a></th>
        <th>Borrar</th>
    </tr>
</thead>
<tbody>
    <% for (Direccion d : lista) { %>
        <tr>
            <td><%= d.getDni() %></td>
            <td><%= d.getCalle() %></td>
            <td><%= d.getNumero() %></td>
            <td><%= d.getCodigopostal() %></td>
<td><a href="borrardireccionjdbc.jsp?dni=<%= d.getDni() %>&calle=<%= d.getCalle() %>&numero=<%= d.getNumero() %>">Borrar</a></td>
        </tr>
    <% } %>
</tbody>
</table>

<a href="insertardireccion.jsp">Insertar nueva dirección</a>  
</body>
</html>
