package com.digit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.digit.model.StudentApp;
@WebServlet("/studentR")
public class RegisterStudent extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String user_name = req.getParameter("user_name");
	    String pass1 = req.getParameter("pass1");
	    int sid = Integer.parseInt(req.getParameter("sid"));
 	   int cid = Integer.parseInt(req.getParameter("cid"));
 	   String sname = req.getParameter("sname");
 	   String email = req.getParameter("email");
 	   StudentApp s = new StudentApp();
 	  s.setUser_name(user_name);
	    s.setPass1(pass1);
 	   s.setSid(sid);
 	   s.setSname(sname);
 	   s.setCourseid(cid);
 	   s.setEmail(email);
 	   HttpSession session =req.getSession();
 	   session.setAttribute("cid",s.getCourseid());
 	   session.setAttribute("sname",s.getSname());
 	   session.setAttribute("email",s.getEmail());
 	   session.setAttribute("sid",s.getSid());
 	   
	    boolean b = s.StudentRegister();
	    if(b) {
	    	resp.sendRedirect("/CourseManagementMVCProject/StudentAdded.jsp");
	    }
	    else {
	    	resp.sendRedirect("/CourseManagementMVCProject/StudentAddingFail.jsp");
	    	
	    }
	}

}
