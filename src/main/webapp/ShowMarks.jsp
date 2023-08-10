

<%@page import="java.sql.Connection"%>

<%@page import="java.sql.DriverManager"%>

<%@page import="java.sql.PreparedStatement"%>

<%@page import="java.sql.ResultSet"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="Keywords" content="html, css, html tables, table">
    <meta name="Description" content="html table">
<title>Insert title here</title>
<link rel="stylesheet" href="resource/assets/css/markscard.css">
<body>
</head>


        <%
        int sid=0;
        int cid = 0;

        String pname = "";

        int Assesment1_Score = 0;

        int Assesment2_Score = 0;

        int Practical_Score = 0;

        int Final_Score = 0;

        String Grade = "";

        String cname = "";

        String sname = "";


        try {

            session = request.getSession();

            Class.forName("com.mysql.cj.jdbc.Driver");

 

            String url = "jdbc:mysql://localhost:3306/crs";

 

            String user = "root";

 

            String pass = "root";

 

            Connection con = DriverManager.getConnection(url, user, pass);

 

            sid = (int) session.getAttribute("sid");

 

           /*  int cid = 0;

            String pname = "";

            int Assesment1_Score = 0;

            int Assesment2_Score = 0;

            int Practical_Score = 0;

            int Final_Score = 0;

            String Grade = "";

            String cname = "";

            String sname = "";
 */
            PreparedStatement prep = con.prepareStatement("Select * from grade where sid=?");

            prep.setInt(1, sid);

            ResultSet r = prep.executeQuery();

            if (r.next()) {

                Assesment1_Score = r.getInt(2);

                Assesment2_Score = r.getInt(3);

                Practical_Score = r.getInt(4);

                Final_Score = r.getInt(5);

                Grade = r.getString(6);

 

            }

            PreparedStatement prep1 = con.prepareStatement("Select * from student where sid=?");

            prep1.setInt(1, sid);

            ResultSet r1 = prep1.executeQuery();

            if (r1.next()) {

 

                cid = r1.getInt(2);

                sname = r1.getString(3);

            }

            PreparedStatement prep2 = con.prepareStatement("Select * from professors where cid=?");

            prep2.setInt(1, cid);

            ResultSet r2 = prep2.executeQuery();

            if (r2.next()) {

                pname = r2.getString(3);

            }

            PreparedStatement prep3 = con.prepareStatement("Select * from course where cid=?");

            prep3.setInt(1, cid);

            ResultSet r3 = prep3.executeQuery();

            if (r3.next()) {

                cname = r3.getString(2);

            }

        

           out.println("<b>Student Id</b> : " + sid + "<br><br>");

            out.println("<b>Student Name</b> : " + sname + "<br><br>");

            out.println("<b>Professor Assigned</b> : " + pname + "<br><br>");

            out.println("<b>Course Assigned</b> : " + cname + "<br><br>");

            out.println("<b>First Assesment Score</b> : " + Assesment1_Score + "<br><br>");

            out.println("<b>Second Assesment Score</b> : " + Assesment2_Score + "<br><br>");

            out.println("<b>Practical Marks</b> : " + Practical_Score + "<br><br>");

            out.println("<b>Final Score</b> : " + Final_Score + "<br><br>");

            out.println("<b>Grade Obtained by course</b> : " + Grade + "<br><br>");   
  

            

            

          
 

        } catch (Exception e) {

            e.printStackTrace();

        }%>
<div class="container">
      <h2 align="center">Report Card</h2><br><br>
      <table>
        <thead>
          <tr>
            <th>Student Id</th>
            <th>Student Name</th>
           <!--  <th>Professor Assigned</th>
            <th>Course Assigned</th> -->
            <th>Test1_Score</th>
            <th>Test2_Score</th>
            <th>Practical_Score</th>
            
          <tr>  
        </thead>
        <tbody>
          <tr>
            <td><%out.println(sid);%></td>
            <td><%out.println(sname);%></td>
           <%--  <td><%out.println(pname);%></td>
            <td><%out.println(cname);%></td> --%>
            <td><%out.println(Assesment1_Score);%></td>
            <td><%out.println(Assesment1_Score);%></td>
            <td><%out.println(Practical_Score);%></td>
            
          </tr>
          
        </tbody>
    
        <tfoot>
          <tr>
            <td colspan=3>Maximum Marks:  <%out.println("100");%></td>
            <td colspan=3>Marks Obtained: <%out.println(Final_Score);%></td>
            <td colspan=2>Grade: <%out.println(Grade);%></td>
          </tr>
        </tfoot> 
      </table>
      <br><br>
      <a href="Logout">Logout</a>
      <span style="margin: 0 285px"> </span>
<a href="Menu.jsp">Back To Menu</a>
    </div>

</body>

</html>