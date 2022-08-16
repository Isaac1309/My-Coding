<?php

 //biblioteca de conexión
 /*
   
    primer parametro = direccion a en donde se encuentra la base de datos
    segundo parametro = usuario en nuestro servidor.
    tercer parametro = contraseña de usuario.
    cuarto parametro = nombre de base de datos.

 */

 session_start();

 $conn = mysqli_connect('localhost','root','123','php_crud');

    if(isset($conn)){
        //echo "<script> console.log('Conectado a BD'); </script>";
    }else{
        //echo "<script> console.log('Sin conexion a BD'); <script>";
    }



?>