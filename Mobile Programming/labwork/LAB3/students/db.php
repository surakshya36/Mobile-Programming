<?php
$host = "localhost";
$user = "root";
$password = "";
$db = "studentdb";

$conn = mysqli_connect($host, $user, $password, $db, 3307);
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
?>
