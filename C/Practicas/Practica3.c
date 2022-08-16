#include <stdio.h>
#include <ctype.h>
void main(){
    char palabra[80];
    int cont, aux;
    printf("Introduce la palabra que quieres convertir a mayusculas:\n");
    for(cont=0;(palabra[cont]=getchar())!='\n';++cont);
    aux=cont;
    for(cont=0; cont<aux; ++cont){
        putchar(toupper(palabra[cont]));}
    putchar('\n');
getch();}
