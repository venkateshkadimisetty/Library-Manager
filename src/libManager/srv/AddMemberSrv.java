package libManager.srv;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import libManager.bean.MemberBean;
import libManager.dao.AddMemberDAO;
import libManager.factory.DateFactory;

import org.json.JSONObject;

public class AddMemberSrv extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 BufferedReader br = req.getReader();
		    String str = null;
		    String str1="";
		    while ((str = br.readLine()) != null) {
		        /*sb.append(str);*/
		        str1=str1+""+str;
		    }
		    System.out.println(str1);
		    JSONObject jobj=new JSONObject(str1);
		    JSONObject model=jobj.getJSONObject("mod");
		   /* AddMemberBean amb=new AddMemberBean();
		    amb.setsName(model.getString("fname"));
		    amb.setsId(model.getString("sid"));
		    amb.setNoBooks(model.get("no_books").toString());
		    amb.setBookLimit(model.get("b_limit").toString());
		    amb.setMobileNo(model.getString("mobile"));
		    amb.setEmaiId(model.getString("email"));
		    amb.setFine(model.get("fine").toString());
		    amb.setIssueDate(model.getString("issueDate").substring(0, 10));*/
		    
		    MemberBean mb=new MemberBean();
		    mb.setsName(model.getString("fname"));
		    mb.setsId(Integer.parseInt(model.getString("sid")));
//		    mb.setNoOfBooks(Integer.parseInt(model.get("no_books").toString()));
		    mb.setNoOfBooks(model.getInt("no_books"));
		    mb.setBooksLimit((model.getInt("b_limit")));
		    mb.setMobileNo(model.getString("mobile"));
		    mb.setEmailId(model.getString("email"));
		    mb.setTotalFine(model.getInt("fine"));
		    mb.setIssueDate(DateFactory.stringToUtilDate(model.getString("issueDate")));
		    
		    AddMemberDAO amd=new AddMemberDAO();
		    amd.addMember(mb);
	}

}
