package login;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

  
 
public class reg extends HttpServlet {  
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    try (PrintWriter out = response.getWriter()) {
        String n=request.getParameter("email");
        String p=request.getParameter("psw");
        String s=request.getParameter("psw1");
        
        // validate obj = new vlidate();
        
        if(validate.check1(n,p,s))
        {
            out.println("sucessfully register");
            
        }
        else
        {
            out.println("unsucessfully register");
        }
    }
    }  
}  
