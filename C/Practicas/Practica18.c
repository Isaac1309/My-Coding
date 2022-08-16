#include <stdio.h>
void main(){
    int m;
    printf("Elige una opcion entre la A, B, C o Salir:\nA=1\nB=2\nC=3\nSalir=4\n");
    scanf("%d", m);
    switch(m){
        case 1: printf("El menu %d es comida mexicana\n", m); break;
        case 2: printf("El menu %d es comida italiana\n", m); break;
        case 3: printf("El menu %d es bebida\n", m); break;
        case 4: printf("%d Gracias por su preferencia\n", m); break;
        default: printf("No existe el numero %d en el menu\n", m); break;}
    getch();}
