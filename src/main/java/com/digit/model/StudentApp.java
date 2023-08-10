package com.digit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentApp {
	int sid;
	int courseid;
	String sname;
	String email;
	private Statement stmt;
	private ResultSet resultset;
	private static Connection con;
	static String user_name;
	static String pass1;
	private static PreparedStatement pstmt;

	/**
	 * @return the sid
	 */
	public int getSid() {
		return sid;
	}

	/**
	 * @param sid the sid to set
	 */
	public void setSid(int sid) {
		this.sid = sid;
	}

	/**
	 * @return the courseid
	 */
	public int getCourseid() {
		return courseid;
	}

	/**
	 * @param courseid the courseid to set
	 */
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}

	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return the pass1
	 */
	public String getPass1() {
		return pass1;
	}

	/**
	 * @param pass1 the pass1 to set
	 */
	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public StudentApp() {
		String url = "jdbc:mysql://localhost:3306/crs";

		String user = "root";

		String pwd = "root";

		// Database connection

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pwd);

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

	public boolean StudentRegister() {

		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * System.out.println("Kindly register yourself");
		 * 
		 * System.out.println("\nEnter user name");
		 * 
		 * user_name = sc.next();
		 * 
		 * System.out.println("Set password");
		 * 
		 * pass1 = sc.next();
		 */

		String sql = "insert into users values(?,?)";

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, getUser_name());

			pstmt.setString(2, getPass1());

			int x = pstmt.executeUpdate();

			if (x > 0) {

				String sql1 = "insert into srequest values(?,?)";

				try {

					pstmt = con.prepareStatement(sql1);

					pstmt.setString(1, getUser_name());

					pstmt.setString(2, getPass1());

					int y = pstmt.executeUpdate();

					if (y > 0) {

						String sql2 = "insert into student values(?,?,?,?)";
						pstmt = con.prepareStatement(sql2);
						pstmt.setInt(1, getSid());
						pstmt.setInt(2, getCourseid());
						pstmt.setString(3, getSname());
						pstmt.setString(4, getEmail());

						int x1 = pstmt.executeUpdate();
						if (x1 > 0) {
							/*
							 * System.out.println("Student Added is :" + s.getSname());
							 * System.out.println("----*----");
							 */
							return true;

						}

					}

				} catch (SQLException e) {

					// TODO Auto-generated catch block

					e.printStackTrace();

				}

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		return false;

	}

	public boolean RemoveStudent() {
		try {

			String sql = "delete from student where sid=?";
			Scanner sc = new Scanner(System.in);

			pstmt = con.prepareStatement(sql);

			System.out.println("How many student do you want to remove");

			// n = sc.nextInt();

			// for (int i = 0; i < n; i++) {

			// System.out.println("enter student id to be removed");

			pstmt.setInt(1, getSid());

			int x = pstmt.executeUpdate();

			if (x > 0) {

				// System.out.println((i + 1) + " Student removed");
				return true;

			}

			// }

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return false;
	}

	public boolean loginStudent() {
		try {

			String sql = "select * from srequest";

			stmt = con.createStatement();

			resultset = stmt.executeQuery(sql);

			while (resultset.next() == true) {

				if (user_name.equals(resultset.getString("user_name"))

						&& pass1.equals(resultset.getString("pass1"))) {

					return true;

				}

			}

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		return false;

	}
	public boolean showMarks() {
		PreparedStatement prep1;
		try {
			prep1 = con.prepareStatement("Select *from student where sid=?");
			prep1.setInt(1, sid);
	          ResultSet r1 = prep1.executeQuery();
	          if(r1.next()){
	        	
	       	  return true;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      	
          return false;
	}
}
