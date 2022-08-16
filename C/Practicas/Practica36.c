#include <stdio.h>
int main() {
  int vec[6]={13,9,12,6,2000,18},i,j,bandera,aux;
  printf("\t\tMetodo Burbuja Mejorada\n");
  getch();
  printf("\n\tArreglo Original:\n\n");
  for(i=0;i<6;i++) {
    printf("%i\t", vec[i]);}
  for(i=1;i<6;i++) {
    bandera=0;
    for(j=6-1;j>=i;j--) {
      if(vec[j-1]>vec[j]) {
        aux=vec[j-1];
        vec[j-1]=vec[j];
        vec[j]=aux;
        bandera=1;}}
    if(bandera==0)
      break;}
  getch();
  printf("\n\n\tArreglo Ordenado:\n\n");
  for(i=0;i<6;i++) {
    printf("%d\t", vec[i]);}
  return 0;
  getch();}
