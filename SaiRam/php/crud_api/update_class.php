<?php
include 'connection.php';

$id = $_POST['id'];
//$profilename = $_POST['name'];
//$email = $_POST['time'];
//$imagepath = $_POST['photo'];

$uid = $_POST['name'];
$name = $_POST['time'];
$address = $_POST['photo'];


//$query = mysqli_query($con, "UPDATE profile SET  name = '$profilename', time = '$email', photo = '$imagepath' WHERE id = '$id' ");
$query = mysqli_query($con, "UPDATE profile SET  name = '$uid', time = '$name', photo = '$address' WHERE id = '$id' ");

if($query){
  $response['success'] = 'true';
  $response['message'] = 'Data Updated Successfully';
}else{
  $response['success'] = 'false';
  $response['message'] = 'Data Updation Failed';
}

echo json_encode($response);
?>
