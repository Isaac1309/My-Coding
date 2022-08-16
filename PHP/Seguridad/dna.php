<?php
  $dna='ATTGC';

  $result="";
  $a=array();
  $a=str_split($dna);
  for($i=0;$i<count($a);$i++){
    if($a[$i]=="T")$a[$i]="A";
    else{
      if($a[$i]=="A")$a[$i]="T";
      else{
        if($a[$i]=="G")$a[$i]="C";
        else{
          if($a[$i]=="C")$a[$i]="G";
        }
      }
    }
  }
  for($i=0;$i<count($a);$i++){
    $result=$result.$a[$i];
  }

  var_dump($a);
  var_dump($result);
  return $result;
?>