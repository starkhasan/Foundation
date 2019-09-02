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
			
			$sql="SELECT * FROM login";
			$retval=mysqli_query($conn,$sql);
			$row=mysqli_fetch_array($retval);
			$username1=$row['username'];
			$password1=$row['password'];

			if($username1==$username && $password1==$password)
			{
				header('location:sublime.html');
			}
			else
			{
				
			}
			
			mysqli_close($conn);

		}
	?>