package gnnt.demo.user.service;

import gnnt.demo.user.model.User;

import java.util.List;

public interface UserService {
	public List<User> listUser(String username,String gender,String interest,int departno,String fromtime,String totime,int pagenum,int pagesize);
	public int addUser(String username,String gender,String interest,int departno,String intime);
	public int delUser(int userid);
	public int modifyUser(int userid,String username,String gender,String interest,int departno,String intime);
	public int totalNum(String username,String gender,String interest,int departno,String fromtime,String totime,int pagenum,int pagesize);
    public User findByid(int userid);
}
