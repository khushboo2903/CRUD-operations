import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String fname=request.getParameter("fname"); 
        String lname=request.getParameter("lname");
        String dob=request.getParameter("dob"); 
        String uname=request.getParameter("uname"); 
        String pwd=request.getParameter("pwd");  
        String mail=request.getParameter("mail");  
       
          
        User e=new User(); 
        e.setId(id); 
        e.setFirstname(fname);  
        e.setLastname(lname);  
        e.setDateofbirth(dob);
        e.setUsername(uname);
        e.setPassword(pwd);  
        e.setEmail(mail);  
       
          
        int status=StuDao.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}  