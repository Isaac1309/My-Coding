<?php
  $data="iiisdoso";
  $array=str_split($data);
  $par="";
  $impar="";
  $result = array();
  $valor=0;
  for($i=0; $i<count($array); $i++){
    if($array[$i]=="i"){
      $valor=$valor+1;
    }elseif($array[$i]=="d"){
      $valor=$valor-1;
    }elseif($array[$i]=="s"){
      $valor=$valor*$valor;
    }elseif($array[$i]=="o"){
      array_push($result, $valor);
    }
  }
  var_dump($result);
  return $result;
?>