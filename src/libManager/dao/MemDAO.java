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
				mb.setsId(rs.getInt(1));
				mb.setsName(rs.getString(2));
				mb.setBooksLimit(rs.getInt(3));
				mb.setNoOfBooks(rs.getInt(4));
				mb.setTotalFine(rs.getInt(5));
				mb.setIssueDate(rs.getDate(6));
				mb.setMobileNo(rs.getString(7));
				mb.setEmailId(rs.getString(8));
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return mb;  
		}

}
