<%-- 
    Document   : holileave
    Created on : Nov 28, 2018, 1:35:04 AM
    Author     : ARJIT PATHAK
--%>

<%@ page import ="java.sql.*" %>
<% 
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
        request.getRequestDispatcher("/gatepass.jsp").forward(request,response);
    }
    else{
        response.sendRedirect("holyday.html");
    }
    
%>
