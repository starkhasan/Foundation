<html>
<head>
	<title>Registration</title>
		<link href="registration.css" rel="stylesheet" type="text/css">
</head>
<body>
	<?php
		if(isset($_POST['submit']))
		{
			$name=$_POST['stuname'];
			$admission=$_POST['adnum'];
			$department=$_POST['department'];
			$password=$_POST['passw'];

			$dbhost='localhost';
			$dbuser='root';
			$dbpass='';
			$dbname='user';

			$conn=mysqli_connect($dbhost,$dbuser,$dbpass,$dbname);

			if(!$conn)
			{
				die("Connection Failed : ".mysqli_error());
			}
			
			$sql="INSERT INTO student (stu_Name,Admission_No,Department,Password) VALUES ('$name','$admission','$department','$password')";
			$retval=mysqli_query($conn,$sql);
			if(!$retval)
			{
				die('Could not Enter Data : ' . mysqli_error());
			}
			header('location:Login.php');
			mysqli_close($conn);

		}
	?>
	<div class="loginbox">
		<h2>Student Registration</h2>
		<form name="myform" action="New_user.php" method="post">
			<p>Name</p>
			<input type="text" name="stuname" placeholder="Enter Your Name" size="35" required="required">
			<p>Admission Number</p>
			<input type="text" name="adnum" placeholder="Enter Admission Number" size="35" required="required">
			<label>Department</label>
			<select name="department">
				<option value="Computer Science and Engineering">Computer Science and Engineering</option>
				<option value="Information and Technology">Information and Technology</option>
				<option value="Mechnical Engineering">Mechnical Engineering</option>
			</select>
			<p>Password</p>
			<input type="Password" name="passw" placeholder="Enter Password" required="required"><br>
			<input type="submit" name="submit" value="Login"><br>
		</form>
		<a style="text-decoration:none" href="Login.php">Already Registered</a><br>
	</div>
	<div class="container">
		<h1 class="head">Easy<br>Online<br>Learning</h1>
	</div>
</body>
</html>
