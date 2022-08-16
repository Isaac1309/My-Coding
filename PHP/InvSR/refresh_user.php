<table class="table table-bordered table-dark">
    <thead>
        <tr>
            <th>Nombre</th>
            <th>Tipo de Ayuda</th>
            <th>Descripción de la ayuda</th>
            <th>Fecha de Creacion</th>
        </tr>
    </thead>
    <tbody>
        <?php
            $query = "SELECT * FROM usuarios;";
            $result = mysqli_query($conn,$query);
            while($row = mysqli_fetch_array($result)){ ?>
        <tr>
            <td><?php echo $row['nombre']; ?> </td>
            <td><?php echo $row['tipo_ayuda']; ?> </td>
            <td><?php echo $row['descripcion']; ?> </td>
            <td><?php echo $row['fecha_creacion'];?></td>
        </tr>
        <?php } ?>
    </tbody>
</table>