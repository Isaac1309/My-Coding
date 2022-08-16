<?php
  $seconds = 60;

  $a=sprintf("%02d%s%02d%s%02d", floor($seconds/3600), ":", ($seconds/60)%60, ":", $seconds%60);

  var_dump($a);
  return $a;
?>