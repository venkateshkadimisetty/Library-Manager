package libManager.srv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import libManager.bean.MemberBean;
import libManager.dao.MemDAO;

import com.google.gson.Gson;

public class MemSrv extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/json");
		PrintWriter pw=res.getWriter();
		Gson gs=new Gson();
		/*IssueBookBean ibb=new IssueBookBean();
		pw.write(gs.toJson(ibb));*/
		//getting book details
		int mem_id=Integer.parseInt(req.getParameter("memId"));
		MemDAO md=new MemDAO();
		MemberBean b1=md.getMemDetails(mem_id);
		pw.write(gs.toJson(b1));
	}

}
