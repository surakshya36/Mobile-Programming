<?php
header("Content-Type: application/json");
include "db.php";

// Get data from POST request
$data = json_decode(file_get_contents("php://input"), true);
$id = $data['id'] ?? null;
$name = $data['name'] ?? null;
$roll = $data['roll'] ?? null;

// Validate input
if (!$id || !$name || !$roll) {
    echo json_encode(["status" => "error", "message" => "Missing parameters"]);
    exit;
}

// Prevent SQL injection
$id = mysqli_real_escape_string($conn, $id);
$name = mysqli_real_escape_string($conn, $name);
$roll = mysqli_real_escape_string($conn, $roll);

// Update query
$sql = "UPDATE students SET name='$name', roll='$roll' WHERE id='$id'";

if (mysqli_query($conn, $sql)) {
    echo json_encode(["status" => "success", "message" => "Student updated"]);
} else {
    echo json_encode(["status" => "error", "message" => "Update failed: " . mysqli_error($conn)]);
}

mysqli_close($conn);
?>