#include <stdio.h>
void main() {
  int elementos[11],i,j,auxiliar,minimo;
  printf("\t\tMetodo De Seleccion de 10 Elemento\n");
  printf("(Pone 0 en el Elemento 0)\n");
  getch();
  for(i=0; i<11; i++) {
    printf("Elemento [%i]\n", i);
    scanf("%i", &elementos[i]);}
  for(i=0;i<11;i++) {
    minimo=i;
    for(j=i+1;j<=11;j++) {
      if(elementos[j]<elementos[minimo]) {
        minimo=j;}}
    auxiliar=elementos[i];
    elementos[i]=elementos[minimo];
    elementos[minimo]=auxiliar;}
  for(i=0; i<11; i++) {
    printf("[%i]\n", elementos[i]);}
  return 0;
  getch();}
