package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class holileave_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
 
    String name = request.getParameter("name");
    String snum = request.getParameter("smob");
    String fname = request.getParameter("fathername");
    String fnum = request.getParameter("parentmob");
    String datein = request.getParameter("sdate");
    String dateout = request.getParameter("edate");
    String address = request.getParameter("address");
    String reason = request.getParameter("reason");
    
    
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project",
            "root", "");
    PreparedStatement ps = con.prepareStatement("insert into leavepass(name,snum,fname,fnum,leavein,leaveout,address,reason) values (?,?,?,?,?,?,?,?)");
    ps.setString(1,name);
    ps.setString(2,snum);
    ps.setString(3,fname);
    ps.setString(4,fnum);
    ps.setString(5,datein);
    ps.setString(6,dateout);
    ps.setString(7,address);
    ps.setString(8,reason);
    
    int i = ps.executeUpdate();
    
    if(i>0){
        out.println("LeavePass Created successfully");
        response.sendRedirect("/about.html");
    }
    else{
        response.sendRedirect("holyday.html");
    }
    

      out.write('\n');
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
