package libManager.bean;

import java.util.Date;

public class BookBean {
private int bId;
private String bName;
private String authorName;
private Date avalDate;

public int getbId() {
	return bId;
}
public void setbId(int bId) {
	this.bId = bId;
}
public String getbName() {
	return bName;
}
public void setbName(String bName) {
	this.bName = bName;
}
public String getAuthorName() {
	return authorName;
}
public void setAuthorName(String authorName) {
	this.authorName = authorName;
}
public Date getAvalDate() {
	return avalDate;
}
public void setAvalDate(Date avalDate) {
	this.avalDate = avalDate;
}

}
