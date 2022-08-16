<?php
    $str= "ehT kciuq nworb xof spmuj revo eht yzal .god";
    $partes = explode(" ", $str);
    $fraseC="";
    for($i=0; $i<count($partes); $i++){
      $palabra = strrev($partes[$i]);
      $fraseC = $fraseC." ".$palabra;
    }
    echo $fraseC;
    return $fraseC;
?>