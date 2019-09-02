<html>
<head>
	<title>Log In</title>
		<link href="login1.css" rel="stylesheet" type="text/css">
</head>
<body>
	<?php
		if(isset($_POST['submit']))
		{
			$username=$_POST['user'];
			$password=$_POST['pass'];

			$dbhost='localhost';
			$dbuser='root';
			$dbpass='';
			$dbname='user';

			$conn=mysqli_connect($dbhost,$dbuser,$dbpass,$dbname);

			if(!$conn)
			{
				die("Connection Failed : ".mysqli_error());
			}
			
			$sql="SELECT * FROM student";
			$retval=mysqli_query($conn,$sql);
			while($row=mysqli_fetch_array($retval))
			{
				$username1=$row[1];
				$password1=$row[3];
				if($username1==$username && $password1==$password)
				{
					header('location:confirmation.php');
				}
			}
			
			mysqli_close($conn);
		}
	?>
	<div class="loginbox">
		<h2>Login Here</h2>
		<form name="myform" action="Login.php" method="post">
			<p>Username</p>
			<input type="text" name="user" placeholder="Enter Username" size="35" required="required">
			<p>Password</p>
			<input type="Password" name="pass" placeholder="Enter Password" required="required"><br>
			<input type="submit" name="submit" value="Login"><br>
		</form>
	</div>
	<div class="container">
		<h1 class="head">Easy<br>Online<br>Learning</h1>
	</div>
</body>
</html>
