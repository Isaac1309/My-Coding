<?php
include('conexion.php');
    session_start();
if(isset($_SESSION["id_usuario"])){
    header("location: index.php");
}
    if(!empty($_POST)){
        $usuario = htmlspecialchars($_POST['usuario']);
        $password = htmlspecialchars($_POST['password']);
        $error = '';
        $sha1_pass = sha1($password);
        $sql="SELECT id_usuario, idtipou FROM usuarios WHERE usuario = '$usuario' AND password = '$sha1_pass'";
        $result=$conexion->query($sql);
        $rows=$result->num_rows;
        if($rows>0){
            $row=$result->fetch_assoc();
            $_SESSION['id_usuario']=$row['id_usuario'];
            $_SESSION['tipo_usuario']=$row['idtipou'];
            header("location: index.php");
        }else{
            $error="El nombre o contraseña son incorrectos";
        }
    }
?>
<html>
    <head>
        <title>Login</title>
        <style type="text/css">
            *{
                margin: 0px;
                padding: 0px;
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
                font-size: 40pt;
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
        <form action="<?php htmlspecialchars($_SERVER['PHP_SELF']);?>" method="POST">
            <h1>Inicia Sesion</h1>
                <input type="text" id="usuario" name="usuario" placeholder="Usuario" required pattern="[A-Za-z0-9]{1,15}"></input>
                <br/>
                <input type="password" id="password" name="password" placeholder="Password" required pattern="[A-Za-z0-9]{1,15}"></input>
                <br/>
                <div><input type="submit" name="login" value="Entrar"></input></div>
                <br/>
                <div style="font-size: 16px; color:#cc0000;"><?php echo isset($error) ? utf8_decode($error):''; ?></div>
        </form>
    </body>
</html>