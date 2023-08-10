package com.digit.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;





public class CourseApp {
	public static PreparedStatement pstmt;
	/**
	 * @return the user_name
	 */

	int cid;
	String cname;
	int fees;
	int dur_months;
	static String user_name;
	static String pass;
	private static Connection con;
	private static ResultSet res;

	public CourseApp() {
		// Store the database connection code.
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

	public static boolean login() {
		try {
			// TODO Auto-generated method stub
			// Scanner sc = new Scanner(System.in);
			// System.out.println("Enter the user_name:");
			// user_name=sc.next();  
			// System.out.println("Enter the password:");
			// pass=sc.next();
			String sql = "select * from users where user_name=? and password=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, user_name);

			pstmt.setString(2, pass);
			res = pstmt.executeQuery();
			if (user_name.equals("admin") && pass.equals("admin")) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean admin() {
		// int temp = 0;

		// System.out.println("Admin Login");

		// while (true) {

		// temp++;

		boolean b = login();

		if (b == true) {
//
			// System.out.println("Login Successful...\n");

			// System.out.println("------------------------------------");

			// manage();

			return true;

		}

		else {

			return false;
		}
	}
		public boolean addCourse(){
			try {
				/*int x;
				Scanner sc = new Scanner(System.in);
				System.out.println("add course");

				System.out.println("How many course do you want");
				n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					System.out.println("course" + (i + 1));
					System.out.println("Enter the course id");
					int cid = sc.nextInt();
					System.out.println("Enter the course name");
					String cname = sc.next();
					System.out.println("Enter the fees");
					int fees = sc.nextInt();
					System.out.println("Enter the course duration");
					int dur_months = sc.nextInt();
					Courses c = new Courses(cid, cname, fees, dur_months);*/
					String sql = "insert into course values(?,?,?,?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, getCid());
					pstmt.setString(2,getCname());
					pstmt.setInt(3, getFees());
					pstmt.setInt(4, getDur_months());

					int x = pstmt.executeUpdate();
					if (x > 0) {
						//System.out.println("Course Added is :" + c.getCname());
						//System.out.println("----*----");
						this.setCid(getCid());
						this.setCname(getCname());
						this.setFees(getFees());
						this.setDur_months(dur_months);
						return true;

					}
					else {
						return false;
					}
				
			
		

			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean RemoveCourse() {
			try {

				String sql = "delete from course where cid=?";

				pstmt =con.prepareStatement(sql);
				

				//System.out.println("How many course do you want to remove");

			//	n = sc.nextInt();
//
				//for (int i = 0; i < n; i++) {

				//	System.out.println("enter course id to be removed");

					pstmt.setInt(1, getCid());
					//System.out.println(getCid());

					int x = pstmt.executeUpdate();

					if (x > 0) {
                           return true;
						//System.out.println((i + 1) + " Student removed");

					}
					else {
						return false;
					}

				//}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			return false;
		}

	

	/**
	 * @return the cid
	 */
	public int getCid() {
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}

	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * @return the fees
	 */
	public int getFees() {
		return fees;
	}

	/**
	 * @param fees the fees to set
	 */
	public void setFees(int fees) {
		this.fees = fees;
	}

	/**
	 * @return the dur_months
	 */
	public int getDur_months() {
		return dur_months;
	}

	/**
	 * @param dur_months the dur_months to set
	 */
	public void setDur_months(int dur_months) {
		this.dur_months = dur_months;
	}

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
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

}
