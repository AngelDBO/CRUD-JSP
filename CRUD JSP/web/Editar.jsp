<%-- 
    Document   : Editar
    Created on : 9/12/2018, 02:18:39 PM
    Author     : AngelDanielBedoyaOrt
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <title>JSP Page</title>
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
            //Empezamos Listado los Datos de la Tabla Usuario fila secleccionada
            PreparedStatement ps;
            ResultSet rs;
            int id = Integer.parseInt(request.getParameter("id"));
            ps = con.prepareStatement("select * from usuario where Id=" + id);
            rs = ps.executeQuery();
            while (rs.next()) {

        %>
        <div class="container">
            <h1>Editar Registro</h1>
            <hr>
            <form action="" method="post" class="form-control" style="width: 500px; height: 400px">

                ID:
                <input type="text" readonly="" class="form-control" value="<%= rs.getInt("Id")%>"/>

                Nombres:
                <input type="text" name="txtNom" class="form-control" value="<%= rs.getString("Nombres")%>"/><br>

                DNI:
                <input type="text" name="txtDNI" class="form-control" value="<%= rs.getString("DNI")%>"/>
                <br>
                <input type="submit" value="Guardar" class="btn btn-primary btn-lg"/>
                <a href="index.jsp">Regresar</a>
            </form>
            <%}%>
        </div>
    </body>
</html>

<%String dni, nom;
       nom=request.getParameter("txtNom");
       dni=request.getParameter("txtDNI");      
       if(dni!=null && nom!=null){
           ps=con.prepareStatement("update usuario set DNI='"+dni+"',Nombres='"+nom+"'where Id="+id);
           ps.executeUpdate();
           //JOptionPane.showMessageDialog(null,"Se Agrego Correctamete");           
           response.sendRedirect("index.jsp");
           
       }
       
       
%>
