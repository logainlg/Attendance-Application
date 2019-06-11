<?php
if($_SERVER['REQUEST_METHOD']=='POST'){

include 'DatabaseConfig.php';

 $con = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);
 
 
 $id = $_POST['id'];
 $F_name = $_POST['f_name'];
 $L_name = $_POST['L_name'];
 $email = $_POST['email'];
 $password = $_POST['password'];

$Sql_Query = "UPDATE UserLoginTable SET first_name = '$F_name', last_name = '$L_name', user_email = '$email' , user_password = '$password' WHERE id = $id";


 if(mysqli_query($con,$Sql_Query))
{
 echo 'Record Updated Successfully';
}
else
{
 echo 'Something went wrong';
 }
 }
 mysqli_close($con);
?>