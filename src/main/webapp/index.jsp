<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Seminario"%>
<%
    ArrayList<Seminario> lista = (ArrayList<Seminario>) request.getAttribute("sem");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seminario</title>
    </head>
    <body>
        <fieldset align="center">
            <legend><b>SEGUNDO PARCIAL</b></legend>
            <p><b>Nombre:</b> Jonathan Flores Chirinos</p>
            <p><b>Carnet:</b> 10073709 LP</p>
        </fieldset>
        <h1 align="center">Registro Día del Internet</h1>
        <table border="1" cellspacing="0" align="center" readonly>
            <tr>
                <td><a href="MainServlet?op=nuevo">Nuevo registro</a></td>
            </tr>
            <tr>
                <th>Id</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Seminario</th>
                <th>Confirmado</th>
                <th>Fecha de Inscripción</th>
                <th></th>
                <th></th>
            </tr>
            <%
                for (Seminario item : lista) {
            %>
            <tr>
                <td align="center"><%=item.getId()%></td>
                <td align="center"><%=item.getNombres()%></td>
                <td align="center"><%=item.getApellidos()%></td>
                <td align="center"><%=item.getSeminario()%></td>
            <% if (item.getConfirmado().equals("si")) {%>
            <td align="center"><input type="checkbox" onclick="return false;" checked></td>
            <% } else {%>
            <td align="center"><input type="checkbox" onclick="return false;"></td>
            <% }%>
            <td align="center"><%=item.getFecha()%></td>
            <td align="center"><a href="MainServlet?op=editar&id=<%=item.getId()%>">Editar</a></td>
            <td align="center"><a href="MainServlet?op=eliminar&id=<%=item.getId()%>">Eliminar</a></td>
        </tr>
        <%
            }
        %>
    </table>

</body>
</html>
