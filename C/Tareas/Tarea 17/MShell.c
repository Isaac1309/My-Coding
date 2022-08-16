#include <stdio.h>
int main(){
  int vec[6]={13,9,12,6,2000,18},ints=6,i,bandera,aux;
  printf("\t\tMetodo Shell\n");
  getch();
  printf("\n\tArreglo Original:\n\n");
  for(i=0;i<6;i++) {
    printf("%i\t", vec[i]);}
  while(ints>1){
    ints=ints/2;
    bandera=1;
    while(bandera==1){
      bandera=0;
      i=0;
      while((i+ints)<=6){
        if(vec[i]>vec[i+ints]){
          aux=vec[i];
          vec[i]=vec[i+ints];
          vec[i+ints]=aux;
          bandera=1;}i++;}}}
  getch();
  printf("\n\n\tArreglo Ordenado:\n\n");
  for(i=0;i<6;i++) {
    printf("%d\t", vec[i]);}
  return 0;
  getch();}
