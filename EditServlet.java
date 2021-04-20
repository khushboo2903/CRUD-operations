import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Student</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
       User e=StuDao.getEmployeeById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>First Name:</td><td><input type='text' name='fname' value='"+e.getFirstname()+"'/></td></tr>");
        out.print("<tr><td></td>Last name<td><input type='text' name='lname' value='"+e.getLastname()+"'/></td></tr>");  
        out.print("<tr><td>Date of birth:</td><td><input type='text' name='dob' value='"+e.getDateofbirth()+"'/></td></tr>");
         
        out.print("<tr><td>User name:</td><td><input type='uname' name='uname' value='"+e.getUsername()+"'/></td></tr>");  
        out.print("<tr><td>Password:</td><td><input type='pwd' name='pwd' value='"+e.getPassword()+"'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='mail' name='mail' value='"+e.getEmail()+"'/></td></tr>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  