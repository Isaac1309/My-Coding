<?php

    include("db.php");

?>


<?php
    include("includes/header.php");
    include("includes/navigation.php");
?>

<script>

    $(document).ready(function(e){
        $('#formUsr').submit(function(ev){
            ev.preventDefault();//PREVENIR EL COMPORTAMIENTO DEL FORM
            var datos = $(this).serialize();//serializar los datos a enviar
            //console.log(this);
            //console.log(datos);
        
            $.ajax({
                type:"POST",
                url: "save_user.php",
                data: datos,
                success: function(result){
                    //console.log(result);
                    if(result != 0){
                        $("#tableContainer").html(result);
                    }else{
                        alert("Falló guardado");
                    }
                }

            });

        });
    });

    function borrar(id){
        //console.log(id);
        datos = "id= "+ id;
        $.ajax({
            type: "GET",
            url: "delete_user.php",
            data:datos,
            success: function(result){
                $("#tableContainer").html(result);
            }
        })
    }

</script>

<div class="container-fluid p-4">

    <div class="row">
        <div class="col-md-4 mt-4">

        <?php

            include('mensajes.php');

        ?>

            <div class="card card-body">

                <form id="formUsr" action="" method="POST">

                    <div class="form-group">
                        <input type="text" name="nombre" class="form-control" placeholder="Nombre">
                    </div>
                    <div class="form-group">
                        <input type="text" name="correo" class="form-control" placeholder="Correo">
                    </div>
                    <div class="form-group">
                        <textarea type="text" rows="10" name="cv" class="form-control"
                            placeholder="Curriculum"></textarea>
                    </div>
                    <input  type="submit" value="Guardar Usuario" name="guardar_usr" class="btn btn-success btn-block">


                </form>
            </div>



        </div>
        <div id="tableContainer" class="col-md-8 mt-4 table-responsive">
            <?php
            
                include('refresh_user.php');

            ?>
        </div>
    </div>

</div>

<?php
    include("includes/footer.php");
?>