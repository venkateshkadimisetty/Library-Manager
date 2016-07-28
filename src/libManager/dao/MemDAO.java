package libManager.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import libManager.bean.MemberBean;
public class MemDAO {
	Connection con;
	Statement stmt;
	ResultSet rs;
	public MemDAO(){
		try{  
			/*Class.forName("com.mysql.jdbc.Driver");    
			con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/test","test",""); */
			con=DAO.getConnection(); 
			System.out.println(con); 
			stmt=con.createStatement();  
			}catch(Exception e)
				{ 
					System.out.println(e);
				}  
			  
			}
	public MemberBean getMemDetails(int mem_id){
		MemberBean mb=null;
		try {
			rs=stmt.executeQuery("select * from members where s_id="+mem_id);
			mb=new MemberBean();
			while(rs.next())  {
				mb.sId=rs.getInt(1);
				mb.sName=rs.getString(2);
				mb.booksLimit=rs.getInt(3);
				mb.noOfBooks=rs.getInt(4);
				mb.totalFine=rs.getInt(5);
				mb.issueDate=rs.getDate(6);
				mb.mobileNo=rs.getString(7);
				mb.emailId=rs.getString(8);
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return mb;  
		}

}
