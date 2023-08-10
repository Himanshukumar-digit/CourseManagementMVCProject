package com.digit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.model.GradeApp;
import com.digit.model.StudentApp;
@WebServlet("/Sid")
public class ShowMarksC extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int sid = Integer.parseInt(req.getParameter("sid"));
		 StudentApp s = new StudentApp();
		 s.setSid(sid);
		 HttpSession session =req.getSession();
		 session.setAttribute("sid",s.getSid());
		 boolean b = s.showMarks();
		 if(b) {
			 resp.sendRedirect("/CourseManagementMVCProject/ShowMarks.jsp");
			 
		 }
		 else {
			
		 }
	}

}
