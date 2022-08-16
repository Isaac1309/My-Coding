<?php
  $n=7;
  $result = decbin($n);
  $count = substr_count($result, "1");
  echo $count;
  return $count;
?>