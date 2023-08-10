package com.digit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.model.CourseApp;
@WebServlet("/admin")
public class AdminC extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

        String user_name=req.getParameter("user_name");

        String pass=req.getParameter("pass");

                CourseApp c=new CourseApp();

                c.setUser_name(user_name);

                c.setPass(pass);

                boolean b=c.admin();

                if(b==true) {

                    resp.sendRedirect("/CourseManagementMVCProject/Menu.jsp");

                    

                }
		
		
	}

}
