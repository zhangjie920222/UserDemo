package gnnt.demo.user.model;

public class User {
	
	private int userId;
	private String userName;
	private String gender;
	private String interest;//兴趣爱好
	private String intime;//入职时间
	private Integer departno;//部门编号
	private String departname;//部门名称
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	
	public String getDepartname() {
		return departname;
	}
	public void setDepartname(String departname) {
		this.departname = departname;
	}
	public Integer getDepartno() {
		return departno;
	}
	public void setDepartno(Integer departno) {
		this.departno = departno;
	}
	
	

	
}
