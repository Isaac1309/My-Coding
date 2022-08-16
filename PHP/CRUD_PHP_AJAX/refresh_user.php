<table class="table table-bordered table-dark">
    <thead>
        <tr>

            <th>Nombre</th>
            <th>Correo</th>
            <th>Curriculum</th>
            <th>Fecha de Creacion</th>
            <th>Acciones</th>
        </tr>
    </thead>
    <tbody>

        <?php
                    
                        $query = "SELECT * FROM usuarios;";
                        $result = mysqli_query($conn,$query);

                        while($row = mysqli_fetch_array($result)){ ?>
        <tr>
            <td><?php echo $row['nombre']; ?> </td>
            <td><?php echo $row['correo']; ?> </td>
            <td><?php echo $row['cv']; ?> </td>
            <td><?php echo $row['fecha_creacion'];?></td>
            <td>

                <a href="edit_user.php?id=<?php echo $row['id']; ?> " class="btn btn-warning btn-block"><i
                        class="far fa-edit"></i></a>
                <a onclick="borrar(<?php echo $row['id']; ?>)" " class="btn btn-danger btn-block"><i class="far fa-trash-alt"></i></a>

            </td>
        </tr>

        <?php   }?>
    </tbody>

</table>