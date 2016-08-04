package libManager.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import libManager.bean.BookBean;

public  class BookDAO {
	Connection con;
	Statement stmt;
	ResultSet rs;
	public BookDAO(){
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
	public BookBean getBookDetails(int b_id){
		BookBean ibb=null;
		try {
			rs=stmt.executeQuery("select * from books where b_id="+b_id);
			ibb=new BookBean();
			while(rs.next())  {
				ibb.setbId(rs.getInt(1));
				ibb.setbName(rs.getString(2));
				ibb.setAuthorName(rs.getString(3));
				ibb.setAvalDate(rs.getDate(4));
				System.out.println(ibb.getbId()+"  "+ibb.getbName()+"  "+ibb.getAuthorName()+" "+ibb.getAvalDate());
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return ibb;  
		}
	
	}