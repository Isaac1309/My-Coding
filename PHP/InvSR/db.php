<?php
 session_start();
 $conn = mysqli_connect('localhost','root','','proyectoinv');
    if(isset($conn)){
        //echo "<script> console.log('Conectado a BD'); </script>";
    }else{
        //echo "<script> console.log('Sin conexion a BD'); <script>";
    }
?>