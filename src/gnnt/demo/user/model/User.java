package gnnt.demo.user.model;

public class User {
	
	private int userId;
	private String userName;
	private String gender;
	private String interest;//��Ȥ����
	private String intime;//��ְʱ��
	private Integer departno;//���ű��
	private String departname;//��������
	
	
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
