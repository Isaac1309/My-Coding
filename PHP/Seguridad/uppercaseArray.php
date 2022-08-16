<?php
  $s="abcdef";
  $array=str_split($s);
  $par="";
  $impar="";
  $result = array();
  for($i=0; $i<count($array); $i++){
    if($i%2==0){
      $par=$par.strtoupper($array[$i]);
      $impar=$impar.($array[$i]);
    }else{
      $impar=$impar.strtoupper($array[$i]);
      $par=$par.($array[$i]);
    }
  }
  array_unshift($result, $par);
  array_push($result, $impar);
  var_dump($result);
  return $result;
?>