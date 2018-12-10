package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        <title>CRUD en JSP</title>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1>CRUD en JSP</h1>\n");
      out.write("            <hr>\n");
      out.write("            <a class=\"btn btn-success btn-lg\"href=\"Agregar.jsp\">Nuevo Registro</a>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <table class=\"table table-bordered\">\n");
      out.write("                <tr>\n");
      out.write("                    <th class=\"text-center\">ID</th>\n");
      out.write("                    <th class=\"text-center\">DNI</th>\n");
      out.write("                    <th >Nombre</th>\n");
      out.write("                    <th class=\"text-center\">Acciones</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    while (rs.next()) {

                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td class=\"text-center\">");
      out.print( rs.getInt("Id"));
      out.write("</td>\n");
      out.write("                    <td class=\"text-center\">");
      out.print( rs.getString("DNI"));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("Nombres"));
      out.write("</td>\n");
      out.write("                    <td class=\"text-center\">\n");
      out.write("                        <a  href=\"Editar.jsp?id=");
      out.print( rs.getInt("Id"));
      out.write("\"class=\"btn-warning btn-sm\">Editar</a>\n");
      out.write("                        <a  href=\"Eliminar.jsp?id=");
      out.print( rs.getInt("Id"));
      out.write("\"class=\"btn-danger btn-sm\">Eliminar</a>\n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div> \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
