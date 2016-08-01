package libManager.srv;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import libManager.bean.IssueBookBean;
import libManager.dao.IssueDAO;

import org.json.JSONObject;

public class IssueSrv extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res)
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
    
    IssueBookBean ibb=new IssueBookBean();
    ibb.setMemId(model.getString("memId"));
    ibb.setBookId(model.getString("bookId"));
    ibb.setIssueDate(model.getString("issueDate").substring(0, 10));
    ibb.setDueDate(model.getString("dueDate").substring(0, 10));
    IssueDAO id=new IssueDAO();
    int result=id.insertDB(ibb);
    
/*       
    System.out.println(jobj);
    JSONObject jObj = new JSONObject(sb.toString());
    String name = jObj.getString("name");
*/
    res.setContentType("text/plain");
    res.setCharacterEncoding("UTF-8");
    res.getWriter().write("No of records updated :  "+result);
	}
}
