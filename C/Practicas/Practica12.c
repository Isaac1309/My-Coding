#include<stdio.h>
void main(){
    int estacion;
    printf("Escribe el numero de la estacion: \n");
    scanf("%d", &estacion);
    switch(estacion){
        case 1: printf("la estacion %d es Primavera\n", estacion); break;
        case 2: printf("la estacion %d es Verano\n", estacion); break;
        case 3: printf("la estacion %d es Otoño\n", estacion); break;
        case 4: printf("la estacion %d es Invierno\n", estacion); break;
        default: printf("no hay un numero de la estacion %d en el año\n", estacion); break;}
    getch();}
