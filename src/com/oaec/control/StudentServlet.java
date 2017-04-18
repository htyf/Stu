package com.oaec.control;

/**
 * javaScript ---- Ajax ------Jquery ----
 *                                      easyUI
 *                                      EXTjs
 *                                      FreeMark
 */


import java.io.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oaec.model.Student;
import com.oaec.service.StudentService;
import com.oaec.utils.UuidUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String oper = request.getParameter("action");
		Student s = new Student();
		if ("add".equals(oper)) {
			add(request, response);
		}else if("del".equals(oper)){
			del(request, response);
		}else if("findOneStuForId".equals(oper)){
			findOneStuForId(request, response);
		}else if("update".equalsIgnoreCase(oper)){
			update(request, response);
		}else {
			findStuList(request, response);
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String userAge = request.getParameter("userage");
		String userSex = request.getParameter("userSex");
		
		try {
			PrintWriter out = response.getWriter();
			out.write("chengg ");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*try {
			userSex = new String(userSex.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}*/
		String userPhone = request.getParameter("userPhone");
		String id = UuidUtil.getUuid();
		Student stu = new Student(id,userName,Integer.parseInt(userAge),userSex.charAt(0),userPhone);
		StudentService stuservice = new StudentService();
		int num = stuservice.add(stu);
		request.setAttribute("tips", num>0?"添加成功":"添加失败");
		try {
			request.getRequestDispatcher("message.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void findStuList(HttpServletRequest request,
			HttpServletResponse response) {
		//可能性：
		// 可能性一: 直接访问后台  
		// 可能性二: 前端页面访问后台
		String nowPage = request.getParameter("page");
		int page = nowPage==null?0:Integer.parseInt(nowPage); //当前页 3
		int pageRow =Integer.parseInt((String)this.getServletContext().getAttribute("pageRow"));
		StudentService stuservice = new StudentService();
		List list = stuservice.getStudentList(page,pageRow);
		String s = JSON.toJSONString(list);
		try {
			response.getWriter().write(s);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	request.setAttribute("stuList", list.get(0));
	//	int num = (int)list.get(1);
	//	request.setAttribute("pageNum", num%pageRow==0?num/pageRow:num/pageRow+1);
	//	request.setAttribute("page", page+1);
		/*
		 * request.getParameter(""); setAttribute(""); request.getAttribute("");
		 * 的用法
		[{"sage":12,"sid":"ed9ca998bf8e448cb862cc2b9ad01e10","sname":"王五","sphone":"1888888888888","ssex":"男"},
		{"sage":12,"sid":"f9d20225f7a74da480690474065f0601","sname":"窝窝头3","sphone":"12222222333","ssex":"女"},
		{"sage":21,"sid":"3756201f759e488c9f04da84c098e2ac","sname":"窝窝头4","sphone":"12222222333","ssex":"女"},
		{"sage":21,"sid":"1782ef8e38264807a89a94191c868bb9","sname":"窝窝头5","sphone":"12222222333","ssex":"女"},
		{"sage":54,"sid":"be7b8cf33ba34b838cb8f33bfe3c0657","sname":"赵七","sphone":"1888888888888","ssex":"女"}]

		 * 
		 */
		// 转发和重定向的区别？
		/*
		try {
			String s = JSON.toJSONString(list.get(0));
			response.getWriter().write(s);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		*/
		/*
		try {
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}// 转发
			// response.sendRedirect("index.jsp");//重定向
			 * */
			 
	}

	public void del(HttpServletRequest request, HttpServletResponse response) {
		String ids = request.getParameter("id");
		String[] id = ids.split(",");
		StudentService stuservice = new StudentService();
		int num = stuservice.del(id);
		request.setAttribute("tips", num>0?"删除成功":"删除失败");
		/*try {
			PrintWriter pw = response.getWriter();
			pw.write("OK");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			request.getRequestDispatcher("message.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void findOneStuForId(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("ids");
		StudentService stuse = new StudentService();
		Student stu = stuse.findOneStuForId(id);
		request.setAttribute("stu", stu);
		try {
			request.getRequestDispatcher("update.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private void update(HttpServletRequest request,
			HttpServletResponse response){
		String id = request.getParameter("id");
		String userName = request.getParameter("name");
		String userAge = request.getParameter("age");
		String userSex = request.getParameter("sex");
		String userPhone = request.getParameter("phone");
		Student stu = new Student(id,userName,Integer.parseInt(userAge),userSex.charAt(0),userPhone);
		
		StudentService stuservice = new StudentService();
		int num = stuservice.update(stu);
		request.setAttribute("tips", num>0?"修改成功":"修改失败");
		try {
			request.getRequestDispatcher("message.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
