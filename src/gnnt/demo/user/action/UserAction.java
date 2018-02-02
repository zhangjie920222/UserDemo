package gnnt.demo.user.action;

import gnnt.demo.user.model.Page;
import gnnt.demo.user.model.User;
import gnnt.demo.user.service.impl.UserServiceImpl;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// 获取方法名字
        String servletPath = request.getServletPath();//xxx.do
        // 去掉斜杠和.do
        String methodName = servletPath.substring(1, servletPath.length() - 3);
        try {
            // 利用反射获取方法
            Method method = getClass().getDeclaredMethod(methodName,HttpServletRequest.class, HttpServletResponse.class);
            // 执行相应的方法
            method.invoke(this, request, response);
        } catch (Exception e) {
           e.printStackTrace();
        }
	}
    //list员工
    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	    //默认分页
    	    int pagesize=6;
    	    int pagenum=1;
			String pagesizestr = request.getParameter("pagesize");
			String pagenumstr = request.getParameter("pagenum");
			if(pagesizestr!=null&&!"".equals(pagesizestr)){
				 pagesize =Integer.parseInt(pagesizestr);
			}
			if(pagenumstr !=null&&!"".equals(pagenumstr)){
				 pagenum = Integer.parseInt(pagenumstr);
			}
            String username = request.getParameter("username");          
            String gender = request.getParameter("gender");          
            String interest = request.getParameter("interest");            
            String departnostr = request.getParameter("departno");
            int departno=0;
            if(departnostr !=null&&!"".equals(departnostr)){
            	 departno = Integer.parseInt(departnostr);
            }          
            String fromtime = request.getParameter("time1");
            String totime = request.getParameter("time2");           
            UserServiceImpl userServiceImppl = new UserServiceImpl();
            int totalPageSize = userServiceImppl.totalNum(username, gender, interest, departno, fromtime, totime, pagenum, pagesize);
            List<User> list = userServiceImppl.listUser(username, gender, interest, departno, fromtime, totime, pagenum, pagesize);			
			Page page = new Page();
			page.setUsername(username);
			if(gender!=null&&!"".equals(gender)){
				page.setGender(gender);
            }else{
            	page.setGender("");
            }
			
			page.setInterest(interest);
			page.setDepartno(departno);
			page.setFromtime(fromtime);
			page.setTotime(totime);
			page.setPageNum(pagenum);
			page.setPageSize(pagesize);
			page.setTotalPageSize(totalPageSize);
			int totalPageNum = 0;
			if(totalPageSize%pagesize==0){
				totalPageNum=totalPageSize/pagesize;
			}else{				
				totalPageNum=totalPageSize/pagesize+1;
			}
			page.setTotalPageNum(totalPageNum);
			page.setUsers(list);		
			request.setAttribute("pageinfo", page);
			request.getRequestDispatcher("/jsp/listUser.jsp").forward(request, response);
		
    }
    //到修改员工页面
    private void toModifyUser(HttpServletRequest request, HttpServletResponse response) {
        try {
        	String userids = request.getParameter("userid");
        	int userid = Integer.parseInt(userids);
        	UserServiceImpl userServiceImppl = new UserServiceImpl();
        	User user = userServiceImppl.findByid(userid);
        	String interest = user.getInterest();
        	String[] interests = interest.split(",");
        	List<String> list = new ArrayList<String>();
        	for(String str:interests){
        		list.add(str);
        	}
        	request.setAttribute("user", user);
        	request.setAttribute("interests", list);
			request.getRequestDispatcher("/jsp/modifyUser.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
    //修改员工
    private void modifyUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
    	
  		String struserid = request.getParameter("userid");
  		int userid = Integer.parseInt(struserid);
  		String username = request.getParameter("username");
  		String gender = request.getParameter("gender");
  		String[] str = request.getParameterValues("interest");
  		String intime = request.getParameter("intime");
  		String sdepartNo = request.getParameter("departNo");
  		int departno = Integer.parseInt(sdepartNo);
  		String interests ="";
  		for(String s:str){
  			interests +=s+",";
  		}
  		interests = interests.substring(0,interests.length()-1);
  		UserServiceImpl userServiceImppl = new UserServiceImpl();
		int n = userServiceImppl.modifyUser(userid, username, gender, interests, departno, intime);
		String isSuccess="";
		if(n>0){
			isSuccess="yes";
		}else{
			isSuccess="no";
		}	      		  
  		request.setAttribute("isSuccess", isSuccess);
  		request.getRequestDispatcher("/jsp/modifyUser.jsp").forward(request, response);	

    }
    //添加员工
    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {       	
       
		String username = request.getParameter("username");
		String gender = request.getParameter("gender");
		String[] str = request.getParameterValues("interest");
		String intime = request.getParameter("intime");		
		String departNostr = request.getParameter("departNo");		
		int departno=Integer.parseInt(departNostr);
		String interests ="";
		for(String s:str){
			interests +=s+",";
		}
		interests = interests.substring(0,interests.length()-1);
    	UserServiceImpl userServiceImppl = new UserServiceImpl();
		int n = userServiceImppl.addUser(username, gender, interests, departno, intime);
		String isSuccess="";
		if(n>0){
			isSuccess="yes";
		}else{
			isSuccess="no";
		}
		request.setAttribute("isSuccess",isSuccess);
		request.getRequestDispatcher("/jsp/addUser.jsp").forward(request, response);
	
    }
    //删除员工
    private void delUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String suserid = request.getParameter("userid");
        int userid = Integer.parseInt(suserid);
    	UserServiceImpl userServiceImppl = new UserServiceImpl();
		int n = userServiceImppl.delUser(userid);
		String isSuccess="";
		if(n>0){
			isSuccess="yes";
		}else{
			isSuccess="no";
		}
        request.setAttribute("isSuccess",isSuccess);
    	request.getRequestDispatcher("/jsp/modifyUser.jsp").forward(request, response);

    }
    
}
