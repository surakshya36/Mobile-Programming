<?php
include "db.php";
$name = $_POST['name'];
$roll = $_POST['roll'];

$sql = "INSERT INTO students (name, roll) VALUES ('$name', '$roll')";
if (mysqli_query($conn, $sql)) {
    echo "Success";
} else {
    echo "Error";
}
?>
