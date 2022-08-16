<?php
  $a = array(1,2,3);
  $b = array(1,2);
  if(count($a)>0&count($b)>0){
    for($f=0;$f<count($b);$f++){
      for($i=0;$i<=count($a);$i++){
        if($a[$i]==$b[$f]){
          unset($a[$i]);
        }
      }
    }
    $a=array_values($a);
  }
  var_dump($a);
  return $a;
?>