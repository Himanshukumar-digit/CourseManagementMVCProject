<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

	 <link href="resource/assets/css/style2.css" rel="stylesheet">

	<title>Professor Login</title>

</head>

<body>

	<section>

		<div class="form-box">

			<div class="form-value">

				<form action="Grading" method="post">

				

					<div class="inputbox">

						<input type="text" name="sid" required>

						<label for="">Enter Student Id</label>

					</div>

					<div class="inputbox">

						

						<input type="text" name="Assesment1_Score" required>

						<label for="">Enter Term 1 Marks</label>

					</div>
					<div class="inputbox">

						

						<input type="text" name="Assesment2_Score" required>

						<label for=""> Enter Term 2 Marks</label>

					</div>
					<div class="inputbox">

						

						<input type="text" name="Practical_Score" required>

						<label for=""> Enter Practical</label>

					</div>
					<div class="inputbox">

						

						<input type="text" name="Final_Score" required>

						<label for=""> Enter Practical</label>

					</div>
					<div class="inputbox">

						

						<input type="text" name="Grade" required>

						<label for=""> Grade</label>

					</div>

					



					<input class="login" type="submit" value="Grade Student">

				</form>



				<!--<button class="login"><a href="Login.html">Log in</a></button>-->

				

					<!-- <div class="register">

						<p>Don't have a account / <a href="RegisterProfessor.jsp">Register</a></p>
 -->
					</div>

				</form>

			</div>

		</div>

	</section>

	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>

	<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>


<%
	int pid=0;
	String cname="";
	int sid=0;
	int cid=0;
	String sname="";
	try{
	session=request.getSession();
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/crs";

    String user = "root";

    String pass = "root";

    Connection con = DriverManager.getConnection(url, user,pass);
    PreparedStatement prep2= con.prepareStatement("Select * from professor where pid=?");
	prep2.setInt(1, pid);
    ResultSet r2 = prep2.executeQuery();
    if(r2.next()){

 	 cid=r2.getInt(2);
    }
    PreparedStatement prep3 = con.prepareStatement("Select * from course where cid=?");
	prep3.setInt(1, cid);
    ResultSet r3 = prep3.executeQuery();
    if(r3.next()){
 	 cname=r3.getString(2);
    }
    out.println("<b>Course Id</b> : "+cid+"<br><br>");
    out.println("<b>Course Assigned</b> : "+cname+"<br><br>");
    PreparedStatement prep1 = con.prepareStatement("Select * from student where c_id=?");
  	prep1.setInt(1, cid);
      ResultSet r1 = prep1.executeQuery();
      while(r1.next()){
    	
   	  sid=r1.getInt(1);
   	  sname=r1.getString(3);
   	out.println("<hr>");
   	  out.println("<b>Student Id</b> : "+sid+"<br><br>");
      out.println("<b>Student Name</b> : "+sname+"<br><br>");
      
      }
    
   
  
   
     
}
catch(Exception e){
e.printStackTrace();
}
	
	
	%>
	
</body>
</html>