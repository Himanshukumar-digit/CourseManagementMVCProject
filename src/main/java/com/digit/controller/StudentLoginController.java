package com.digit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.model.StudentApp;
@WebServlet("/LoginStudent")
public class StudentLoginController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_name = req.getParameter("user_name");
		String pass1 = req.getParameter("pass1");
		StudentApp s = new StudentApp();
		s.setUser_name(user_name);
		s.setPass1(pass1);
		HttpSession session = req.getSession();
		
	    boolean b = s.loginStudent();
	    
	    if(b) {
	    	resp.sendRedirect("/CourseManagementMVCProject/Menu.jsp");
	    }
	    else {
	    	resp.sendRedirect("/CourseManagementMVCProject/StudentLoginFail.jsp");
	    	
	    }
	}

}
