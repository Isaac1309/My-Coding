<?php

    include("db.php");



        $nombre = $_POST['nombre'];
        $correo = $_POST['correo'];
        $cv = $_POST['cv'];

        $query = "INSERT INTO usuarios(nombre,correo,cv) VALUES('$nombre','$correo','$cv')";
        $result = mysqli_query($conn,$query);
        
        if(!$result){
            echo 0;
            die("Error en Query");
        }else{
            
            $_SESSION['mensaje'] = "Usuario Guardado";
            $_SESSION['color'] = "success";


            //header("Location: index.php");
            include('mensajes.php');
            include('refresh_user.php');
        
        }
        

        
    





?>