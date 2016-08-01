package libManager.factory;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFactory {
	
	public static java.util.Date stringToUtilDate(String str){
		str=str.substring(0, 10);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate=null;
		try {
			utilDate = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return utilDate;
	}
	
	public static java.sql.Date utilToSqlDate(java.util.Date ud){
		java.sql.Date sqlDate=new java.sql.Date(ud.getTime());
		return sqlDate;
	}
	
	public static java.sql.Date stringToSqlDate(String str){
		str=str.substring(0, 10);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date sqlDate=null;
		try {
			sqlDate = new java.sql.Date(sdf.parse(str).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;
	}
	
	public static java.util.Date sqlToUtilDate(java.sql.Date sqlDate){
		java.util.Date utilDate=new java.util.Date(sqlDate.getTime());
		return utilDate;
	}

}
