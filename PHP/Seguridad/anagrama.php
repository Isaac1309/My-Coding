<?php
  $word="racer";
  $words=array('carer', 'arcre', 'carre', 'racrs', 'racers', 'arceer', 'raccer', 'carrer', 'cerarr');

  $a=array();
  for($i=0;$i<count($words);$i++){
    if (count_chars($word, 1) == count_chars($words[$i], 1)){
      array_push($a, $words[$i]);
    }
  }
  var_dump($a);
  return $a;
?>