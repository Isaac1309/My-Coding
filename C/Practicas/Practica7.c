#include <stdio.h>
void main(){
   int n;
   printf ("Ingresa un numero:\t");
   scanf ("%d",&n);
   if (n>0){
    printf("\n El numero es positivo");}
   else if (n<0){
    printf ("\n El numero es negativo");}
   else{
    printf("\n El numero es neutro");}
    getch();
    return 0;}
