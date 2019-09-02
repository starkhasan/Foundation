<html>
<head>
	<title>Confirmation</title>
		<link href="login1.css" rel="stylesheet" type="text/css">
</head>
<body>
	<?php
		if(isset($_POST['submit']))
		{
			$department1=$_POST['department'];
			$year1=$_POST['year'];

			if($department1=="Computer Science and Engineering" && $year1=="First")
			{
				header('location:computer_science_1st.html');
			}
			else if($department1=="Computer Science and Engineering" && $year1=="Second")
			{
				header('location:computer_science_2nd_3rd_datastru.html');
			}
			else if($department1=="Computer Science and Engineering" && $year1=="Third")
			{
				header('location:computer_science_3rd_6th_se.html');
			}
			else if($department1=="Computer Science and Engineering" && $year1=="Forth")
			{
				header('location:computer_science_4th_7th_ai.html');
			}
			else if($department1=="Information and Technology" && $year1=="First")
			{
				header('location:computer_science_1st.html');
			}
			else if($department1=="Information and Technology" && $year1=="Second")
			{
				header('location:computer_science_2nd_3rd_datastru.html');
			}
			else if($department1=="Information and Technology" && $year1=="Third")
			{
				header('location:computer_science_3rd_6th_se.html');
			}
			else if($department1=="Information and Technology" && $year1=="Forth")
			{
				header('location:computer_science_4th_7th_ai.html');
			}
			else if($department1=="Mechnical Engineering" && $year1=="Forth")
			{
				header('location:mech_engg_4th_7th_automob.html');
			}
			else if($department1=="Mechnical Engineering" && $year1=="Third")
			{
				header('location:mech_engg_3rd_5th_md1.html');
			}
			else if($department1=="Mechnical Engineering" && $year1=="Second")
			{
				header('location:mech_engg_2nd_3rd_fm.html');
			}

		}
	?>
	<div class="loginbox">
		<h2>Academic Details</h2>
		<form name="myform1" action="confirmation.php"  method="post">
			<label>Department</label>
			<select name="department">
				<option value="Computer Science and Engineering">Computer Science and Engineering</option>
				<option value="Information and Technology">Information and Technology</option>
				<option value="Mechnical Engineering">Mechnical Engineering</option>
			</select>
			<label>Year</label>
			<select name="year">
				<option value="First">First</option>
				<option value="Second">Second</option>
				<option value="Third">Third</option>
				<option value="Forth">Fourth</option>
			</select><br>
			<input type="submit" name="submit" value="Submit">
		</form>
	</div>
	<div class="container">
		<h1 class="head">Easy<br>Online<br>Learning</h1>
	</div>
</body>
</html>
