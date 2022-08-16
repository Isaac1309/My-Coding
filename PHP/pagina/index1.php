<?php
include('conexion.php');


session_start();
  

  if (!isset($_SESSION["id_usuario"])) 
  {
    header("location: index1.php");
  }

?>



<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Base de Datos</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/dataTables.bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style type="text/css">
      
      body{
        background: url(fondo3.jpg);
        background-size: 100vw 100vh;
        background-attachment: fixed;
      }
      a{
        color: #000;
        padding: 5px 5px;
      }
      a:active{
        background: #2EFE64;
      }

      nav.menu{
        margin: 0;
        padding: 0;
      }
      nav.menu li{
        display: block;
        float: left;
        padding: 0 10px;
      }

    </style>


  </head>
  <body>

    <section>
      <nav class="menu">
        <menu>
          <?php if($_SESSION['tipo_usuario']==1) { ?>

          <li><a href="agregarusuarios.php">Registrar Empleado</a><br /><br /></li>
      
          <?php } ?>
          <li><a href="agregar.php">Agregar Producto</a><br /><br /></li>
          <li><a href="ubicacion.php">Ubicacion</a> </li>
          <li><a href="salir.php">Cerrar Sesi&oacute;n</a><br /><br /></li>
        </menu>
      </nav>

      <p><br/></p>
      <div class="container">
        
        <h1>Productos</h1>

        <table class="table table-striped table-bordered table-hover" id="mydata">
          <thead>
            <tr>
              <th>ID</th>
              <th>Nombre</th>
              <th>Caracteristicas</th>
              <th>Cantidad</th>
              <th>Cambios</th>
            </tr>
          </thead>
          <tfoot>
            <tr>
              <th>ID</th>
              <th>Nombre</th>
              <th>Caracteristicas</th>
              <th>Cantidad</th>
              <th>Cambios</th>
            </tr>
          </tfoot>
          <tbody>

          <?php
            $sql="SELECT * FROM productos";
            $query=mysqli_query($conexion, $sql);
            //para obtener un numero de filas
              if (mysqli_num_rows($query)>0)
              {

                while ($row=mysqli_fetch_object($query))
              {
        
          ?>
              <tr>
                <td> <?php echo $row->id_producto; ?></td>
                <td> <?php echo $row->nombre; ?></td>
                <td> <?php echo $row->caracteristicas; ?></td>
                <td> <?php echo $row->cantidad; ?></td>
                <td>
                  <a href="agregar.php?edited=1&id_producto=<?php echo $row->id_producto; ?>">Editar</a> |
                  <a href="agregar.php?deleted=1&id_producto=<?php echo $row->id_producto; ?>">Eliminar</a>
                </td>

              </tr>
          <?php
              }
             }
          ?>
            
          </tbody>

        </table>

      </div>

      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="js/jquery.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="js/bootstrap.min.js"></script>
      <script src="js/jquery.dataTables.min.js"></script>
      <script src="js/dataTables.bootstrap.min.js"></script>
      <script>
      	$('#mydata').dataTable();
      </script>
    </section>
  </body>
</html>