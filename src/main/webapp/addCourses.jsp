<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en">

<head>

	 <link href="resource/assets/css/style2.css" rel="stylesheet">

	<title>Adding Course</title>

</head>

<body>

	<section>

		<div class="form-box">

			<div class="form-value">

				<form action="addCourses" method="post">

					<h2>Add</h2>

					<div class="inputbox">

						<input type="text" name="cid" required>

						<label for="">Course ID</label>

					</div>

					<div class="inputbox">

						

						<input type="text" name="cname" required>

						<label for="">Course Name</label>

					</div>
					<div class="inputbox">

						
						<input type="text" name="fees" required>

						<label for="">Fees of the course</label>

					</div>
					<div class="inputbox">

						
						<input type="text" name="dur_months" required>

						<label for="">Duration of the course</label>

					</div>
					



					<input class="login" type="submit" value="Add Course">

				</form>



				<!--<button class="login"><a href="Login.html">Log in</a></button>-->

				

					
				</form>

			</div>

		</div>

	</section>

	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>

	<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>



</html>