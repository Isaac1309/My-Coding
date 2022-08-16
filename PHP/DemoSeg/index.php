<?php
include('conxion.php');
session_start();
//verifica session con usuario autentificado
if(isset($_SESSION["id_usuario"]));
{
header("location:index1.php");

}

if(!empty($_POST))
{
    $usuario = htmlspecialchars($_POST['usuario']);
    $password = htmlspecialchars($_POST['password']);
    $error = '';
//Para encriptar contraseñas se usa shal
    $shal_pass = shal($password);
    $sql = "SELECT id_usuario, idtipou FORM usuarios WHERE usuario = '$usuario' AND password ='$shal_pass'";

    $result = $conexion->query($sql);
    $rows = $result->num_rows;

    if(rows>0){
        $row=$result->fetch_assoc();
        $_SESSION['id_usuario'] = $row['id_usuario'];
        $_SESSION['tipo_usuario'] = $row ['idtipou'];

        header("location: index1.php");
    }else{
        $error="El Nombre o Contraseña Son Incorrectos";
    }
}

?>

<html>
    <head>
        <title>Login</title>

        <style type = "text/css">
        *{
            margin: 0px;
            padding: opx;
        }
        body{
            background: url(fondo3.jpg);
            background-size: 100vw 100vh;
            background-attachment: fixed;
        }
        form{
            background: #E3F6CE;
            width: 350px;
            border: 5px solid #31B404;
            margin: 130px auto;
        }
        form h1{
            text-align: center;
            color: #31B404;
            font-weight: normal;
            margin: 30px 0px;
        }
        form input{
            width: 280px;
            height: 35px;
            margin: 10px 30px;
            padding: 0px 10px;
            text-align: center;
        }
        </style>
    </head>
        <body>
            <form action = "<php htmlspecialchars ($_SERVER['PHP_SELF']); ?>" method= "POST">
            <h1> Inicia Sesión </h1>

            <!--Solo que acepte caracteres que le indique con el pattern -->
            <input type = "text" id="usuario" name="usuario" placeholder = "Usuario" required pattern = "[A-Za-z0-9][1,15]"></div>
            <br/>

            <input type = "password" id="password" name = "password" placeholder = "Password" required pattern = "[A-Za-z0-9][1,15]"></div>
            <br/>

            <div><input type= "submit" name = "login" valuer="Entrar"></div>
            <br/>       

            <div style = "font-size:16px; color:#cc0000;"><?php echo isset ($error) ? utf8_decode($error) : '' ; ?> </div>
            </form>

        </body>

</html>