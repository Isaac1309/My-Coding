<?php
  $n=1021;

  $in=0;
  $a = str_split($n);
  rsort($a);
  for($i=0;$i<count($a);$i++){
    if($in==0) $in=$a[$i];
    else $in=$in.$a[$i];
  }
  
  var_dump(intval($in));
  return intval($in);
?>