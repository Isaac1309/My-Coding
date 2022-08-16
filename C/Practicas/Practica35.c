#include <stdio.h>
void main(){
  int elementos[10],i,j,auxiliar,minimo;
  for(i=0; i<10; i++) {
    printf("Elemento [%i]\n", i);
    scanf("%i", &elementos[i]);}
  for(i=0;i<10;i++) {
    minimo=i;
    for(j=i+1;j<=10;j++) {
      if(elementos[j]<elementos[minimo]) {
        minimo=j;}}
    auxiliar=elementos[i];
    elementos[i]=elementos[minimo];
    elementos[minimo]=auxiliar;}
  for(i=0; i<10; i++) {
    printf("[%i]\n", elementos[i]);}
getch();}
