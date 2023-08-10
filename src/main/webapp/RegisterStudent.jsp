<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link href="resource/assets/css/style2.css" rel="stylesheet">

<title>Student Registration</title>

</head>

<body>


	<section>

		<div class="form-box">

			<div class="form-value">

				<form action="studentR" method="post">

					

					<div class="inputbox">

						<input type="text" name="user_name" required> <label
							for="">Student Username</label>

					</div>

					<div class="inputbox">

						<ion-icon name="lock-closed-outline"></ion-icon>

						<input type="text" name="pass1" required> <label for="">Password</label>

					</div>
					<div class="inputbox">



						<input type="text" name="sid" required> <label for="">Student
							Id</label>

					</div>
					<div class="inputbox">



						<input type="text" name="cid" required> <label for="">Course
							Id</label>

					</div>
					<div class="inputbox">



						<input type="text" name="pname" required> <label for="">Student
							Name</label>

					</div>
					<div class="inputbox">



						<input type="text" name="exp" required> <label for="">Email
						</label>

					</div>




					<input class="login" type="submit" value="Register">

				</form>



				<!--<button class="login"><a href="Login.html">Log in</a></button>-->



			<!-- 	<div class="register">

					<a href="ProfessorAdded.jsp">Register</a>

				</div>
 -->
				</form>

			</div>

		</div>

	</section>

	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>

	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

	<%
	String cname = "";
	int cid = 0;
	try {
		session = request.getSession();
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/crs";

		String user = "root";

		String pass = "root";

		Connection con = DriverManager.getConnection(url, user, pass);

		PreparedStatement prep = con.prepareStatement("Select * from course");

		ResultSet r3 = prep.executeQuery();
		while (r3.next()) {
			cid = r3.getInt(1);
			cname = r3.getString(2);
			out.println("<b>Course Available</b> : " + cname + "<br><br>");
			out.println("<b>Course Id</b> : " + cid + "<br><br>");
		}

	} catch (Exception e) {

	}
	%>


</body>
</html>