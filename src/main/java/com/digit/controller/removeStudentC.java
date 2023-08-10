package com.digit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.model.StudentApp;
@WebServlet("/removeStudent")
public class removeStudentC extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int sid = Integer.parseInt(req.getParameter("sid"));
		 StudentApp s = new StudentApp();
		 s.setSid(sid);
		 boolean b =s.RemoveStudent();
		 if(b) {
			 resp.sendRedirect("/CourseManagementMVCProject/removeStudentsuccess.jsp");
		 }
		 else {
			 
		 }
	}

}
