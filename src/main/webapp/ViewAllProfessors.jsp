<%@page import="java.sql.ResultSet"%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>

<%@page import="java.sql.Connection"%>

<%@page import="java.sql.DriverManager"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Insert title here</title>

</head>

<body>

	<%
	session = request.getSession();

	Class.forName("com.mysql.cj.jdbc.Driver");

	String url = "jdbc:mysql://localhost:3306/crs";

	String user = "root";

	String pwd = "root";

	Connection con = DriverManager.getConnection(url, user, pwd);

	String sql = "select * from professors";

	Statement stmt = con.createStatement();
	ResultSet res5 = stmt.executeQuery(sql);

	while (res5.next() == true) {

		out.println("<br> Professor Id:-" + res5.getInt(1));

		out.println("<br> Course Id:- " + res5.getInt(2));

		out.println("<br> Professor Name:-" + res5.getString(3));

		out.println("<br> Professor Experience:-" + res5.getInt(4));
	}
	%>

</body>

</html>