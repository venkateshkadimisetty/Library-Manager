package libManager.srv;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import libManager.bean.AddBookBean;
import libManager.dao.AddBookDAO;

import org.json.JSONObject;

public class AddBookSrv extends HttpServlet {

	private static final long serialVersionUID = 1L;

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	 BufferedReader br = req.getReader();
	    String str = null;
	    String str1="";
	    while ((str = br.readLine()) != null) {
	        str1=str1+""+str;
	    }
	    System.out.println(str1);
	    JSONObject jobj=new JSONObject(str1);
	    JSONObject model=jobj.getJSONObject("mod");
	    AddBookBean abb=new AddBookBean();
	    abb.setbId(model.getString("bid"));
	    abb.setbName(model.getString("bname"));
	    abb.setbAuthor(model.getString("bauthor"));
	    abb.setbDate(model.getString("bdate").substring(0, 10));
	    AddBookDAO abd=new AddBookDAO();
	    abd.addBook(abb);
	}
}
