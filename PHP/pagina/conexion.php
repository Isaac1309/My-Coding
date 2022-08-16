<?php
$host = "localhost";
$user = "root";
$password = "";
$database = "proyecto";

try {
	$conexion = mysqli_connect($host, $user, $password, $database);
	//echo "Conectado" ;
	//echo "";
} catch (Exception $e) {
	echo "Error";
	
}

?>