<?php
  $array = array("O","Q","R","S");

  $letter="";
  for ($i = 1; $i < count($array); $i++) {
    if (ord($array[$i]) != ord($array[$i - 1]) + 1) {
      $letter=chr(ord($array[$i - 1]) + 1);
    }
  }

  var_dump($letter);
  return $letter;
?>