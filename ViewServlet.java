import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>Add New Student</a>");  
        out.println("<h1>Student List</h1>");  
          
        List<User> list=StuDao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th>"
        		+ "<th>First Name</th>"
        		+ "<th>Last Name</th>"
        		+ "<th>Dateofbirth</th>"
        		+ "<th>Username</th>"
        		+ "<th>Password</th>"
        		+ "<th>Email</th>"
        		+ "<th>Edit</th>"
        		+ "<th>Delete</th></tr>");  
        for(User e:list){  
         out.print("<tr><td>"+e.getId()+"</td>"
         		+ "<td>"+e.getFirstname()+"</td>"
         		+ "<td>"+e.getLastname()+"</td>"
         		+ "<td>"+e.getDateofbirth()+"</td>"
         		+ "<td>"+e.getUsername()+"</td>"
         		+ "<td>"+e.getPassword()+"</td>"
                 +"<td>"+e.getEmail()+"</td>"
                 +"<td><a href='EditServlet?id="+e.getId()+"'>edit</a></td>"  
                 +"<td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  