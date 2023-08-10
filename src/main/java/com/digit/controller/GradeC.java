package com.digit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.model.GradeApp;

@WebServlet("/Grading")
public class GradeC extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int sid = Integer.parseInt(req.getParameter("sid"));
		int Assesment1_Score = Integer.parseInt(req.getParameter("Assesment1_Score"));
		int Assesment2_Score = Integer.parseInt(req.getParameter("Assesment2_Score"));
		int Practical_Score = Integer.parseInt(req.getParameter("Practical_Score"));
		
		GradeApp g = new GradeApp();
		g.setAssesment1_Score(Assesment1_Score);
		g.setSid(sid);
		g.setAssesment2_Score(Assesment2_Score);
		g.setPractical_Score(Practical_Score);
		
		HttpSession session = req.getSession();
		session.setAttribute("sid", g.getSid());
		boolean b = g.grade();
		if(b) {
			resp.sendRedirect("/CourseManagementMVCProject/GradedSuccessfully.jsp");
		}
		else {
			resp.sendRedirect("/CourseManagementMVCProject/GradingFail.jsp");
		}

	}

}
