<?php
include "db.php";

$id = $_POST['id'] ?? null;

if ($id) {
    $stmt = $conn->prepare("DELETE FROM students WHERE id = ?");
    $stmt->bind_param("i", $id);

    if ($stmt->execute()) {
        echo "Deleted";
    } else {
        echo "Error";
    }

    $stmt->close();
} else {
    echo "Invalid ID";
}
$conn->close();
?>
