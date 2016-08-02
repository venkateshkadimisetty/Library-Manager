package libManager.srv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import libManager.bean.BookBean;
import libManager.dao.BookDAO;

import com.google.gson.Gson;

public class BookSrv extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/json");
		PrintWriter pw=res.getWriter();
		Gson gs=new Gson();
		/*IssueBookBean ibb=new IssueBookBean();
		pw.write(gs.toJson(ibb));*/
		//getting book details
		int bookId=Integer.parseInt(req.getParameter("bookId"));
		BookDAO bd=new BookDAO();
		BookBean b1=bd.getBookDetails(bookId);
		pw.write(gs.toJson(b1));
	}

}
