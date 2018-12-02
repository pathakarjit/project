package login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static javax.ws.rs.core.Response.status;
import static javax.ws.rs.core.Response.status;

/**
 *
 * @author ARJIT PATHAK
 */
public class validate {
  
public static boolean check(String name,String pass){  
boolean status=false;  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");  
      
PreparedStatement ps=con.prepareStatement(  
"select * from stu where email=? and pass=?");  
ps.setString(1,name);  
ps.setString(2,pass);  
      
ResultSet  rs=ps.executeQuery();  
if(rs.next())
{
    String a=rs.getString("email");
    String a1=rs.getString("pass");
  if(a.equals(name)&& a1.equals(pass))
  {
     // System.out.println("helloworld");
      return true;
  }
  return false;
}

//status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
 
return false; 
}
public static boolean check1(String name,String pass,String pass1){  
boolean status=false;  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");  
      
PreparedStatement ps=con.prepareStatement(  
"INSERT INTO stu"
		+ "(email,pass,pass1) VALUES"
		+ "(?,?,?)");
ps.setString(1,name);  
ps.setString(2,pass); 
ps.setString(3,pass1); 
      
int  rs=ps.executeUpdate();  
if(rs>0)
{
   return true;
}

//status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
 
return false; 
}
public static void main(String args[])
{
 //validate.check1("abcd","1234","123");   
  validate.check("abc","123");
}
}
