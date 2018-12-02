<%-- 
    Document   : gatepass.jsp
    Created on : Nov 28, 2018, 1:24:19 AM
    Author     : ARJIT PATHAK
--%>


<%@ page import ="java.sql.*" %>
<% 
    String name = request.getParameter("name");
    String datein = request.getParameter("sdate");
    String dateout = request.getParameter("edate");
    String reason = request.getParameter("reason");
    
    
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project",
            "root", "");
    PreparedStatement ps = con.prepareStatement("insert into gatepass(name,datein,dateout,comment) values (?,?,?,?)");
    ps.setString(1,name);
    ps.setString(2,datein);
    ps.setString(3,dateout);
    ps.setString(4,reason);
    int i = ps.executeUpdate();
    if(i>0){
        out.println("GatePass Created successfully");
        response.sendRedirect("about.html");
    }
    else{
        response.sendRedirect("gate.html");
    }
    
%>
