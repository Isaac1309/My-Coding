#include <stdio.h>
int main(){
  int vec[6]={13,9,12,6,2000,18},i,pos,aux;
  printf("\t\tMetodo Insercion Directa\n");
  getch();
  printf("\n\tArreglo Original:\n\n");
  for(i=0;i<6;i++) {
    printf("%i\t", vec[i]);}
  for(i=0;i<6;i++){
    pos=i;
    aux=vec[i];
    while((pos>0)&&(aux<vec[pos-1])){
      vec[pos]=vec[pos-1];
      pos--;}
    vec[pos]=aux;}
  getch();
  printf("\n\n\tArreglo Ordenado:\n\n");
  for(i=0;i<6;i++) {
    printf("%d\t", vec[i]);}
  return 0;
  getch();}
