package com.digit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProfessorApp {
	int pid;
	String pname;
	int exp;
	static String user_name;
	static String pass1;
	private static PreparedStatement pstmt;
	int course_id;
	private Connection con;
	private Statement stmt;
	private ResultSet resultset;

	/**
	 * @return the pid
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * @return the exp
	 */
	public int getExp() {
		return exp;
	}

	/**
	 * @param exp the exp to set
	 */
	public void setExp(int exp) {
		this.exp = exp;
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

	/**
	 * @return the course_id
	 */
	public int getCourse_id() {
		return course_id;
	}

	/**
	 * @param course_id the course_id to set
	 */
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public ProfessorApp() {
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

	public boolean professorRegister() {
		String sql = "insert into users values(?,?)";

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, getUser_name());

			pstmt.setString(2, getPass1());
			

			int x = pstmt.executeUpdate();

			if (x > 0) {

				String sql1 = "insert into prequest values(?,?,?)";

				try {

					pstmt = con.prepareStatement(sql1);

					pstmt.setString(1, getUser_name());

					pstmt.setString(2, getPass1());
					pstmt.setInt(3, getPid());


					int y = pstmt.executeUpdate();

					if (y > 0) {

						String sql2 = "insert into professors values(?,?,?,?)";
						pstmt = con.prepareStatement(sql2);
						pstmt.setInt(1, getPid());
						pstmt.setInt(2, getCourse_id());
						pstmt.setString(3, getPname());
						pstmt.setInt(4, getExp());

						x = pstmt.executeUpdate();
						if (x > 0) {
							return true;
						} else {
							return false;
						}

					}

				}

				catch (SQLException e) {

					// TODO Auto-generated catch block

					e.printStackTrace();

				}

			}

		}

		catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		return false;
	}

	public boolean RemoveProfessor() {
		try {

			String sql = "delete from professors where pid=?";
			pstmt = con.prepareStatement(sql);
			// Scanner sc = new Scanner(System.in);
			// System.out.println("How many professor do you want to remove");
			// n = sc.nextInt();
			// for (int i = 0; i < n; i++) {
			// System.out.println("enter professor id to be removed");
			pstmt.setInt(1, getPid());
			int x = pstmt.executeUpdate();
			if (x > 0) {

				return true;

			} else {
				return false;
			}

			// }

		} catch (Exception e) {
// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return false;
	}
	public boolean ProfessorLogin() {
		try {

			String sql = "select * from prequest";

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

}
