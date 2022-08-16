#include <stdio.h>
int main() {
  int vec[6]={13,9,12,6,2000,18},i,j,aux;
  printf("\t\tMetodo Burbuja\n\n");
  getch();
  printf("\tArreglo Original\n\n");
  for(i=0;i<6;i++){printf("%i\t", vec[i]);}
  for(i=0;i<6;i++){
    for(j=0;j<6;j++){if(vec[j]>vec[j+1]){
        aux=vec[j+1];
        vec[j+1]=vec[j];vec[j]=aux;}}}
        getch();
  printf("\n\n\tArreglo Ordenado \n\n");
  for(i=0;i<6;i++) {printf("%d+\t", vec[i]);}
  return 0;
  getch();
}
