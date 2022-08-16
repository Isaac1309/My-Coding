<?php
  $str="hello world!";

  $a=array();
  $a=explode(" ", $str);
  $strReturn="";
  for($i=count($a)-1;$i>=0;$i--){
    if($strReturn=="")$strReturn=$a[$i];
    else $strReturn=$strReturn." ".$a[$i];
  }
  
  var_dump($strReturn);
  return $strReturn;
?>