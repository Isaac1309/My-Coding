<?php
    include("db.php");
    include("includes/header.php");
    include("includes/navigation.php");
?>
<script>
    $(document).ready(function(e){
        $('#formUsr').submit(function(ev){
            ev.preventDefault();
            var datos = $(this).serialize();
            $.ajax({
                type:"POST",
                url: "save_user.php",
                data: datos,
                success: function(result){
                    if(result != 0){
                        $("#tableContainer").html(result);
                    }else{
                        alert("Falló guardado");
                    }
                }
            });
        });
    });
</script>
<div class="container-fluid p-4">
    <div class="row">
        <div class="col-md-4 mt-4">
        <?php include('mensajes.php'); ?>
            <div class="card card-body">
                <form id="formUsr" action="" method="POST">
                    <div class="form-group">
                        <input type="text" name="nombre" class="form-control" placeholder="Nombre">
                    </div>
                    <div class="form-group">
                        <input type="text" name="tipo_ayuda" class="form-control" placeholder="Tipo de Ayuda">
                    </div>
                    <div class="form-group">
                        <textarea type="text" rows="10" name="descripcion" class="form-control" placeholder="Descripción de la ayuda"></textarea>
                    </div>
                    <input  type="submit" value="Guardar Usuario" name="guardar_usr" class="btn btn-success btn-block">
                </form>
            </div>
        </div>
        <div id="tableContainer" class="col-md-8 mt-4 table-responsive">
            <?php include('refresh_user.php'); ?>
        </div>
    </div>
</div>
<?php include("includes/footer.php"); ?>