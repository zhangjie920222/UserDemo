package gnnt.demo.user.service.impl;

import java.util.List;

import gnnt.demo.user.dao.impl.UserDaoImpl;
import gnnt.demo.user.model.User;
import gnnt.demo.user.service.UserService;
public class UserServiceImpl implements UserService{
    //listԱ��
	@Override
	public List<User> listUser(String username, String gender, String interest,
			int departno,String fromtime, String totime,int pagenum,int pagesize) {       
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			List<User> list = userDaoImpl.listUser(username, gender, interest, departno, fromtime, totime, pagenum, pagesize);
		    return list;
	}
	//���Ա��
	@Override
	public int addUser(String username, String gender, String interest,
			int departno, String intime) {
		User user = new User();
	    user.setUserName(username);
	    user.setGender(gender);
	    user.setInterest(interest);
	    user.setDepartno(departno);
	    user.setIntime(intime);
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		int n = userDaoImpl.addUser(user);
		return n;
	}
	//ɾ��Ա��
	@Override
	public int delUser(int userid) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		int n = userDaoImpl.delUser(userid);
		return n;
	}
	//�޸�Ա��
	@Override
	public int modifyUser(int userid,String username, String gender, String interest,
			int departno, String intime) {
		User user = new User();
	    user.setUserName(username);
	    user.setGender(gender);
	    user.setInterest(interest);
	    user.setDepartno(departno);
	    user.setIntime(intime);
	    user.setUserId(userid);
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		int n = userDaoImpl.modifyUser(user);
		return n;
	}
	//��ѯ��ҳ��
	@Override
	public int totalNum(String username, String gender, String interest,
			int departno, String fromtime, String totime, int pagenum,
			int pagesize) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		int totalNum = userDaoImpl.findTotalNum(username, gender, interest, departno, fromtime, totime);
		return totalNum;
	}
	//����id��ѯԱ��
	@Override
	public User findByid(int userid) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.findByid(userid);
		return user;
	}

}
