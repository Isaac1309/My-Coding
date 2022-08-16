<?php
$dbstr = "(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP) (HOST = 192.168.56.1) (PORT = 8083))
(CONNECT_DATA = 
(SERVER = DEDICATED)
(SERVICE_NAME = XE)

))";
//(INSTANCE_NAME = csc)**/
global $conn;
$conn = oci_connect('system','123456',$dbstr);
if(!$conn){
    $e = oci_error();

    //trigger_error(htmlentities($e['message'],ENT_QUOTES),E_USER_ERROR);
    echo 'Algo salio mal en la conexion';
}
global $conn;

echo "Conexion a Oracle funciona correctamente";
error_reporting(2);
?> 