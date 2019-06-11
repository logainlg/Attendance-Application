<?php
//host
$host = "localhost";
//user name
$username = "id9425305_fnb";
//database password
$pwd = "foodninja";
//database name.
$db = "id9425305_foodninjaweb";

$con=mysqli_connect($host,$username,$pwd,$db) or die("Unable to Connect");

if(mysqli_connect_error($con))
{
	echo "Failed to connect";
}

$query=mysqli_query($con,"SELECT * FROM profile");

if($query)
{
while($row=mysqli_fetch_array($query))
	{
	$flag[]=$row;
	}
print(json_encode($flag));
}
mysqli_close($con);
?>


