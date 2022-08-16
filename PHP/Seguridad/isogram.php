<?php
  $string="DermatoglyphicsDd";

  $bool=true;
  $str=strtolower($string);
  foreach (count_chars($str, 1) as $i => $val) {
    if($val>1) $bool=false;
  }
  
  var_dump($bool);
  return $bool;
?>