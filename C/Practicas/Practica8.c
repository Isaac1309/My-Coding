#include <stdio.h>
void main(){
   char c;
   printf ("Digite una tecla cualquiera:\n");
   scanf ("%c",&c);
   if (c>=48 && c<=57){
    printf("\nLa tecla es un numero");}
   else if (c>=65 && c <=90){
    printf ("\nLa tecla es una letra mayuscula");}
   else if (c>=97 && c <=122){
    printf("\nLa tecla es una letra minuscula");}
   else {
    printf("\nLa tecla es un caracter especial");}
    getch();
    return 0;}
