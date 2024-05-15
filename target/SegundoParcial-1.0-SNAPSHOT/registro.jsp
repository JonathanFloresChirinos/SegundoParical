<%@page import="com.emergentes.modelo.Seminario"%>
<%
    Seminario sem = (Seminario) request.getAttribute("part");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de Participantes</h1>
        <form action="MainServlet" method="post">
            <table>
                <input type="hidden" name="id" value="<%=sem.getId()%>">
                <tr>
                    <td>Nombres: </td>
                    <td><input type="text" name="nombres" value="<%=sem.getNombres()%>"></td>
                </tr>
                <tr>
                    <td>Apellidos: </td>
                    <td><input type="text" name="apellidos" value="<%=sem.getApellidos()%>"></td>
                </tr>
                <tr>
                    <td>Seminario</td>
                    <td><input type="text" name="seminario" value="<%=sem.getSeminario()%>"></td>
                </tr>
                <tr>
                    <td>Confirmado: </td>
                    <%if (sem.getConfirmado().equals("si")) {%>
                    <td>
                        <select name="confirmado">
                            <option value="si" selected>SI</option>
                            <option value="no">NO</option>
                        </select>
                    </td>
                    <%} else {%>
                    <td>
                        <select name="confirmado">
                            <option value="si" >SI</option>
                            <option value="no"selected>NO</option>
                        </select>
                    </td>
                    <%}%>
                </tr>
                <tr>
                    <td>Fecha de Inscripción: </td>
                    <td><input type="date" name="fecha" value="<%=sem.getFecha()%>"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Registrar"></td>
                </tr>
            </table>
        </form>

        <a href="url">Repositorio Remoto</a>
    </body>
</html>
