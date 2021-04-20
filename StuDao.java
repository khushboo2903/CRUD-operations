import java.util.*;  
import java.sql.*;  
  
public class StuDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","1234");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(User e){  
        int status=0;  
        try{  
            Connection con=StuDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into student(fname,lname,dob,uname,pwd,mail,) values (?,?,?,?,?,?)");  
            ps.setString(1,e.getFirstname()); 
            ps.setString(2,e.getLastname());  
            ps.setString(3,e.getDateofbirth());  
            ps.setString(4,e.getUsername());
            ps.setString(5,e.getPassword());  
            ps.setString(6,e.getEmail());  
              
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(User e){  
        int status=0;  
        try{  
            Connection con=StuDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update student set fname=?,lname=?,dob=?,uname=?,pwd=?,mail=? where id=?");  
            ps.setInt(1,e.getId());  
            ps.setString(2,e.getFirstname()); 
            ps.setString(3,e.getLastname());  
            ps.setString(4,e.getDateofbirth());  
            ps.setString(5,e.getUsername());
            ps.setString(6,e.getPassword());  
            ps.setString(7,e.getEmail());  
             
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=StuDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from student where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static User getEmployeeById(int id){  
        User e=new User();  
          
        try{  
            Connection con=StuDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from student where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setFirstname(rs.getString(2));  
                e.setLastname(rs.getString(3)); 
                e.setDateofbirth(rs.getString(4));  
                e.setUsername(rs.getString(5));  
                e.setPassword(rs.getString(6));  
                e.setEmail(rs.getString(7));  
                 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<User> getAllEmployees(){  
        List<User> list=new ArrayList<User>();  
          
        try{  
            Connection con=StuDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from student");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	User e=new User();  
                e.setId(rs.getInt(1));  
                e.setFirstname(rs.getString(2));  
                e.setLastname(rs.getString(3));  
                e.setDateofbirth(rs.getString(4));  
                e.setUsername(rs.getString(5)); 
                e.setPassword(rs.getString(6));  
                e.setEmail(rs.getString(7));  
                 
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  