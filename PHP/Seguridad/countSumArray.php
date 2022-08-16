<?php
  $input=array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15);

  $a=array();
  $count=0;
  $sum=0;
  if(count($input)>0){
    for($i=0;$i<count($input);$i++){
      if($input[$i]>0)$count++;
      if($input[$i]<0)$sum +=$input[$i];
    }
    array_push($a, $count);
    array_push($a, $sum);
  }
  var_dump($a);
  return $a;
?>