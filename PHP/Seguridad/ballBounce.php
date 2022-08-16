<?php
  $h=3.0;
  $bounce=0.66;
  $window=1.5;

  $result=1;
  if($h>0){
    if($bounce>0&$bounce<1){
      if($window<$h){
        while($window<($h*$bounce)){
          $h=$h*$bounce;
          if($h>$window)$result++;
          $result++;
        }
      }else$result=-1;
    }else$result=-1;
  }else$result=-1;

  var_dump($result);
  return $result;
?>