package com.digit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.model.ProfessorApp;
@WebServlet("/removeProfessor")
public class removeProfessorC extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pid = Integer.parseInt(req.getParameter("pid"));
		ProfessorApp p = new ProfessorApp();
		p.setPid(pid);
		boolean b = p.RemoveProfessor();
		if(b) {
			
			resp.sendRedirect("/CourseManagementMVCProject/removeProfessorSuccess.jsp");
		}
		else {
			resp.sendRedirect("/CourseManagementMVCProject/ManageControl.jsp");
		}
	}

}
