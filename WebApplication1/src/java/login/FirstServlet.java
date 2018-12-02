package login;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
 
public class FirstServlet extends HttpServlet {  
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("name");  
    String p=request.getParameter("pass");  
       
     // validate obj = new validate();
    if(validate.check(n,p))
    {
        RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");  
        rd.forward(request,response);  
    }  
    else{  
       // out.print("Sorry username or password error");  
        RequestDispatcher rd=request.getRequestDispatcher("holyday.html");  
        rd.include(request,response);  
    }  
          
    out.close();  
    }  
}  
