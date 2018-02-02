package gnnt.demo.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gnnt.demo.user.dao.UserDao;
import gnnt.demo.user.model.User;
import gnnt.demo.user.util.DBUtil;

public class UserDaoImpl implements UserDao{
	//list员工
	@Override
	public List<User> listUser(String username, String gender, String interest,
			int departno, String fromtime, String totime, int pagenum,
			int pagesize) {
		Connection conn =null;
		List<User> list = new ArrayList<User>();
		int rn1=1;
		int rn2=6;
		String likes="";
		try {
			    conn=DBUtil.getConnection();
			    if(pagenum!=0){
			    	 rn1 = (pagenum-1)*pagesize+1;
			    }
			    if(pagesize!=0){
			        rn2 = rn1+pagesize;
			    }
	            
	            String search="where 1=1";	           
	            if(username!=null&&!"".equals(username)){
	            	search +="and ZU.USERNAME like ?";
	            }	        
	            if(gender!=null&&!"".equals(gender)){
	            	search += "and ZU.GENDER=?";
	            }	         
	            if(interest!=null&&!"".equals(interest)){
		        	 String interests[] = interest.split(",");	        	
		             for(int i=0; i<interests.length;i++){	            	 
		            	 likes +="%"+interests[i];
		             }
		             likes +="%";
		         	 search += "and ZU.INTEREST like ?";
		         }	           
	            if(departno>0){            	
	            	search += "and ZU.DEPARTNO=?";
	            }	           
	            if(fromtime!=null&&!"".equals(fromtime)){
	            	search += "and INTIME >= to_date(?,'yyyy-mm-dd')";
	            }
	            if(totime!=null&&!"".equals(totime)){
	            	search += "and INTIME <= to_date(?,'yyyy-mm-dd')";
	            }			
				String sql="SELECT * FROM (SELECT A.*, ROWNUM RN FROM (SELECT * FROM ZHANGJ_USER ZU inner join ZHANGJ_DEPART ZD ON ZU.DEPARTNO=ZD.DEPARTNO "+search+") A WHERE ROWNUM < ?) WHERE RN >= ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                int i=1;
                if(username!=null&&!"".equals(username)){
	            	ps.setString(i++, username);
	            }	        
	            if(gender!=null&&!"".equals(gender)){
	            	ps.setString(i++, gender);
	            }	         
	            if(interest!=null&&!"".equals(interest)){
	            	ps.setString(i++, likes);
	            }	          
	            if(departno>0){            	
	            	ps.setInt(i++, departno);
	            }	           
	            if(fromtime!=null&&!"".equals(fromtime)){
	            	ps.setString(i++, fromtime);
	            }
	            if(totime!=null&&!"".equals(totime)){
	            	ps.setString(i++, totime);
	            }		
			    ps.setInt(i++, rn2);
			    ps.setInt(i++, rn1);
			    ResultSet rs = ps.executeQuery();
			    while(rs.next()){
				User user = new User();
				user.setUserName(rs.getString("username"));
				user.setGender(rs.getString("gender"));
				user.setInterest(rs.getString("interest"));
				user.setDepartname( rs.getString("departname"));
				user.setIntime(rs.getString("intime").substring(0,11));
				user.setUserId(rs.getInt("userid"));
				list.add(user);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	//添加员工
	@Override
	public int addUser(User user) {
		Connection conn =null;
		int n =0;
		try {
			conn=DBUtil.getConnection();
			String sql = "insert into ZHANGJ_USER(USERNAME,GENDER,INTEREST,INTIME,DEPARTNO) values(?,?,?,to_date(?, 'yyyy-mm-dd'),?)";
			PreparedStatement ps = conn.prepareStatement(sql);	
			String username=user.getUserName();
			String gender = user.getGender();
			String interest = user.getInterest();
			String intime = user.getIntime();
			int departno = user.getDepartno();
			ps.setString(1, username);
			ps.setString(2, gender);
			ps.setString(3, interest);
			ps.setString(4, intime );
			ps.setInt(5, departno);			
			n = ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n;
	}
	//修改员工
	@Override
	public int modifyUser(User user) {
		Connection conn =null;
		int n =0;
		try {
			conn=DBUtil.getConnection();
			String sql = "update zhangj_user set username=?,gender=?,interest=?,departno=?,intime=to_date(?, 'yyyy-mm-dd') where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getGender());
			ps.setString(3, user.getInterest());
			ps.setInt(4, user.getDepartno());
			ps.setString(5, user.getIntime());
			ps.setInt(6, user.getUserId());			
			n = ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n;
	}
	//删除员工
	@Override
	public int delUser(int userId) {
		Connection conn =null;
		int n =0;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from zhangj_user where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setInt(1, userId);					
			n = ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n;
	}
	//查询总页数
	@Override
	public int findTotalNum(String username, String gender,
			String interest, int departno, String fromtime, String totime) {
		Connection conn =null;
		int n =0;
		String likes="";
		try {
			conn=DBUtil.getConnection();
			 String search="where 1=1";    
	         if(username!=null&&!"".equals(username)){
	         	search +="and ZU.USERNAME = ?";
	         }	     
	         if(gender!=null&&!"".equals(gender)){
	         	search += "and ZU.GENDER=?";
	         }	      
	         if(interest!=null&&!"".equals(interest)){
	        	 String interests[] = interest.split(",");	        	
	             for(int i=0; i<interests.length;i++){	            	 
	            	 likes +="%"+interests[i];
	             }
	             likes +="%";
	         	 search += "and ZU.INTEREST like ?";
	         }	       
	         if(departno>0){ 
	         	search += "and ZU.DEPARTNO=?";
	         }	        
	         if(fromtime!=null&&!"".equals(fromtime)){
	         	search += "and INTIME > to_date(?,'yyyy-mm-dd')";
	         }
	         if(totime!=null&&!"".equals(totime)){
	        	 search += "and INTIME < to_date(?,'yyyy-mm-dd')";
	         }			
			 String sql="SELECT COUNT(*) FROM ZHANGJ_USER ZU "+search+"";			 
			 PreparedStatement ps = conn.prepareStatement(sql);	
			 int i=1;
			 if(username!=null&&!"".equals(username)){
	         	ps.setString(i++, username);
	         }	     
	         if(gender!=null&&!"".equals(gender)){
	        	 ps.setString(i++, gender);
	         }	      
	         if(interest!=null&&!"".equals(interest)){
	        	 ps.setString(i++, likes);
	         }	       
	         if(departno>0){ 
	        	 ps.setInt(i++, departno);
	         }	        
	         if(fromtime!=null&&!"".equals(fromtime)){
	        	 ps.setString(i++, fromtime);
	         }
	         if(totime!=null&&!"".equals(totime)){
	        	 ps.setString(i++, totime);
	         }		
			 ResultSet rs  = ps.executeQuery();
			 while(rs.next()){
		   	   String	n1 = rs.getString(1);
			   n=Integer.parseInt(n1);			
			 }
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n;
	}
	//根据id查询员工
	@Override
	public User findByid(int userid) {
		Connection conn =null;
		User user = new User();
		try {
			conn=DBUtil.getConnection();
			String sql="select * from zhangj_user where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setInt(1, userid);					
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user.setUserName(rs.getString("username"));
				user.setUserId(rs.getInt("userid"));
				user.setGender(rs.getString("gender"));
				user.setIntime(rs.getString("intime").substring(0,11));
				user.setDepartno(rs.getInt("departno"));
				user.setInterest(rs.getString("interest"));
			}
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

}
