package com.digit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.model.ProfessorApp;
import com.digit.model.StudentApp;
@WebServlet("/LoginProfessor")
public class ProfessorLoginController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_name = req.getParameter("user_name");
		String pass1 = req.getParameter("pass1");
		int pid = Integer.parseInt(req.getParameter("pid"));
	   ProfessorApp p = new ProfessorApp();
		p.setUser_name(user_name);
		p.setPass1(pass1);
		p.setPid(pid);
		HttpSession session = req.getSession();
		 session.setAttribute("pid", p.getPid());
	    boolean b = p.ProfessorLogin();
	    if(b) {
	    	resp.sendRedirect("/CourseManagementMVCProject/Menu.jsp");
	    }
	    else {
	    	resp.sendRedirect("/CourseManagementMVCProject/ProfessorLoginFail.jsp");
	    	
	}

}
}
