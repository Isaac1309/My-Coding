<?php
  $startPriceOld = 8000;
  $startPriceNew = 12000;
  $savingPerMonth = 500;
  $percentLossByMonth = 1;

  $result = array();
  $total=0;
  $month=0;
  $change=0;
  while($total+$startPriceOld<$startPriceNew){
      if($month%2==0){
        $startPriceOld -= $startPriceOld*($percentLossByMonth/100);
        $startPriceNew -= $startPriceNew*($percentLossByMonth/100);
        $total+=$savingPerMonth;
        $percentLossByMonth += 0.5;
        $change =(int) round($total+$startPriceOld-$startPriceNew);
        $month++;
        echo nl2br("end month $month: percentLoss $percentLossByMonth available $change\n");
      }else{
        $startPriceOld -= $startPriceOld*($percentLossByMonth/100);
        $startPriceNew -= $startPriceNew*($percentLossByMonth/100);
        $total+=$savingPerMonth;
        $change =(int) round($total+$startPriceOld-$startPriceNew);
        $month++;
        echo nl2br("end month $month: percentLoss $percentLossByMonth available $change\n");
      }
  }
  if($month==0)$change =(int) round($total+$startPriceOld-$startPriceNew);
  array_push($result, $month);
  array_push($result, $change);
  var_dump($result);
  return $result;
?>