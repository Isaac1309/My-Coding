<?php

    include("db.php");

    if(isset($_GET['id'])){

        $id = $_GET['id'];

        $query = "DELETE FROM usuarios WHERE id = $id;";
        $result = mysqli_query($conn,$query);

        if(!$result){
            die("Fallo al eliminar");

        }else{
            $_SESSION['mensaje'] = "Usuario Eliminado";
            $_SESSION['color'] = "danger";

            //header("Location: index.php");
            include('mensajes.php');
            include('refresh_user.php');
        }


    }else{
        echo "id incorrecto";
    }


?>



