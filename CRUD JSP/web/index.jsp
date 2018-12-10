
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

        <title>CRUD en JSP</title>

    </head>
    <body>
        <%
            //Conectando a la Base de Datos
            Connection con;
            String url = "jdbc:mysql://localhost:3306/registro";
            String Driver = "com.mysql.jdbc.Driver";
            String user = "root";
            String clave = "";
            Class.forName(Driver);
            con = DriverManager.getConnection(url, user, clave);
            //Empezamos Listado los Datos de la Tabla Usuario
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("select * from usuario");
            rs = ps.executeQuery();
            //Creamos la Tabla
        %>
        <div class="container">
            <h1>CRUD en JSP</h1>
            <hr>
            <a class="btn btn-success btn-lg"href="Agregar.jsp">Nuevo Registro</a>
            <br>
            <br>
            <table class="table table-bordered">
                <tr>
                    <th class="text-center">ID</th>
                    <th class="text-center">DNI</th>
                    <th >Nombre</th>
                    <th class="text-center">Acciones</th>
                </tr>
                <%
                    while (rs.next()) {

                %>
                <tr>
                    <td class="text-center"><%= rs.getInt("Id")%></td>
                    <td class="text-center"><%= rs.getString("DNI")%></td>
                    <td><%= rs.getString("Nombres")%></td>
                    <td class="text-center">
                        <a  href="Editar.jsp?id=<%= rs.getInt("Id")%>"class="btn-warning btn-sm">Editar</a>
                        <a  href="Eliminar.jsp?id=<%= rs.getInt("Id")%>"class="btn-danger btn-sm">Eliminar</a>
                    </td>

                    <%}%>

            </table>


        </div> 
    </body>
</html>
