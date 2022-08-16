<?php
    include("db.php");
        $nombre = $_POST['nombre'];
        $tAyuda = $_POST['tipo_ayuda'];
        $descripcion = $_POST['descripcion'];
        $query = "INSERT INTO usuarios(nombre,tipo_ayuda,descripcion)VALUES('$nombre','$tAyuda','$descripcion')";
        $result = mysqli_query($conn,$query);
        if(!$result){
            echo 0;
            die("Error en Query");
        }else{
            $_SESSION['mensaje'] = "Usuario Guardado";
            $_SESSION['color'] = "success";
            include('mensajes.php');
            include('refresh_user.php');
        }
?>