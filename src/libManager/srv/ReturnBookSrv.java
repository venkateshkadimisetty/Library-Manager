package libManager.srv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import libManager.bean.ReturnBookBean;
import libManager.dao.ReturnBookDAO;

import com.google.gson.Gson;

public class ReturnBookSrv extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/json");
		PrintWriter pw=res.getWriter();
		Gson gs=new Gson();
		/*IssueBookBean ibb=new IssueBookBean();
		pw.write(gs.toJson(ibb));*/
		//getting book details
		int bookId=Integer.parseInt(req.getParameter("bookId"));
		ReturnBookDAO rbd=new ReturnBookDAO();
		ReturnBookBean b1=rbd.getBookLendDetails(bookId);
		pw.write(gs.toJson(b1));
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BufferedReader br = req.getReader();
	    String str = null;
	    String str1="";
	    while ((str = br.readLine()) != null) {
	        /*sb.append(str);*/
	        str1=str1+""+str;
	    }
	    System.out.println(str1);
	    /*System.out.println(sb);*/
	    JSONObject jobj=new JSONObject(str1);
	    JSONObject model=jobj.getJSONObject("mod");
	    
	    ReturnBookBean rbb=new ReturnBookBean();
	    rbb.setsId(model.getInt("memId"));
	    rbb.setbId(Integer.parseInt(model.getString("bookId")));
	    rbb.setSubDate(model.getString("submissionDate").substring(0, 10));
	    rbb.setIssueDate(model.getString("issueDate").substring(0, 10));
	    rbb.setDueDate(model.getString("dueDate").substring(0, 10));
	    rbb.setFine(model.getInt("fine"));
	    ReturnBookDAO rbd=new ReturnBookDAO();
		int res=rbd.deleteBookLendDetails(rbb);
	    
	}
}
