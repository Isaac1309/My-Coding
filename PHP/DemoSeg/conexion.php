<?php
$host = "localhost";
$user = "root";
$password = "";
$database="proyecto";

try{
    $conexion=mysqli_connect($host, $user, $password, $database);
    echo "conectado";


}catch(Exception $e){
    echo ("error");

}
?>