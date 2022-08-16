<?php
  $str="abracadabra";

  $vowelsCount = 0;
  $a = str_split($str);
  for($i=0;$i<count($a);$i++){
    if($a[$i]=="a"|$a[$i]=="e"|$a[$i]=="i"|$a[$i]=="o"|$a[$i]=="u")$vowelsCount++;
  }
  
  var_dump($vowelsCount);
  return $vowelsCount;
?>