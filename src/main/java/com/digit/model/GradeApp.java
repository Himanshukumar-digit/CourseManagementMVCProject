package com.digit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class GradeApp {
	int sid;
	int Assesment1_Score;
	int Assesment2_Score;
	int Practical_Score;
	int Final_Score;
	String Grade;
	private Connection con;
	private PreparedStatement pstmt;
	
	public GradeApp() {
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
	  public boolean grade() {

	        this.setFinal_Score((Practical_Score+Assesment1_Score+Assesment2_Score)/3);

	        if(Final_Score>=90) {

	            this.setGrade("O");

	        }

	        else if(Final_Score<90 && Final_Score>=70){

	            this.setGrade("E");

	        }

	        else if(Final_Score<70 && Final_Score>=50) {

	            this.setGrade("A");

	        }

	        else {

	            this.setGrade("F");

	        }

	        try {

	            String sql="insert into Grade values(?,?,?,?,?,?)";

	            pstmt=con.prepareStatement(sql);

	            pstmt.setInt(1, getSid());

	            pstmt.setInt(2,getAssesment1_Score());

	            pstmt.setInt(3, getAssesment1_Score());

	            pstmt.setInt(4, getPractical_Score());

	            pstmt.setInt(5, getFinal_Score());

	            pstmt.setString(6, getGrade());

	            int x=pstmt.executeUpdate();

	            if(x>0) {

	                return true;

	            }

	        }

	        catch(Exception e){

	            e.printStackTrace();

	        }

	        

	        return false;

	    }
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
	 * @return the assesment1_Score
	 */
	public int getAssesment1_Score() {
		return Assesment1_Score;
	}
	/**
	 * @param assesment1_Score the assesment1_Score to set
	 */
	public void setAssesment1_Score(int assesment1_Score) {
		Assesment1_Score = assesment1_Score;
	}
	/**
	 * @return the assesment2_Score
	 */
	public int getAssesment2_Score() {
		return Assesment2_Score;
	}
	/**
	 * @param assesment2_Score the assesment2_Score to set
	 */
	public void setAssesment2_Score(int assesment2_Score) {
		Assesment2_Score = assesment2_Score;
	}
	/**
	 * @return the practical_Score
	 */
	public int getPractical_Score() {
		return Practical_Score;
	}
	/**
	 * @param practical_Score the practical_Score to set
	 */
	public void setPractical_Score(int practical_Score) {
		Practical_Score = practical_Score;
	}
	/**
	 * @return the final_Score
	 */
	public int getFinal_Score() {
		return Final_Score;
	}
	/**
	 * @param final_Score the final_Score to set
	 */
	public void setFinal_Score(int final_Score) {
		Final_Score = final_Score;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return Grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		Grade = grade;
	}
	
	
	

}
