package com.digit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.model.ProfessorApp;

@WebServlet("/professorR")
public class RegisterProfessor extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String user_name = req.getParameter("user_name");
		String pass1 = req.getParameter("pass1");
		int pid = Integer.parseInt(req.getParameter("pid"));
		int exp = Integer.parseInt(req.getParameter("exp"));
		String pname = req.getParameter("pname");
		  int cid = Integer.parseInt(req.getParameter("cid"));
		  ProfessorApp p = new ProfessorApp();
		 p.setUser_name(user_name);
		 p.setPass1(pass1);
		 p.setPid(pid);
		 p.setExp(exp);
		 p.setCourse_id(cid);
		 p.setPname(pname);
		  HttpSession session =req.getSession();
		  session.setAttribute("pname", p.getPname());
		  session.setAttribute("pid", p.getPid());
		  session.setAttribute("exp",p.getExp());
		  session.setAttribute("cid", p.getCourse_id());
		  boolean b = p.professorRegister();
		  if(b) {
			  resp.sendRedirect("/CourseManagementMVCProject/ProfessorAdded.jsp");
		  }
		  else {
			  resp.sendRedirect("/CourseManagementMVCProject/ProfessorAddingFail.jsp");
		  }
	}

}
