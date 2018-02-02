package gnnt.demo.user.dao;

import gnnt.demo.user.model.User;

import java.util.List;

public interface UserDao {
	
	public List<User> listUser(String username,String gender,String interest,int departno,String fromtime,String totime,int pagenum,int pagesize);
	public int addUser(User user);
	public int modifyUser(User user);
	public int delUser(int userId);
	public int findTotalNum(String username,String gender,String interest,int departno,String fromtime,String totime);
    public User findByid(int userid);
}
