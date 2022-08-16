#include<stdio.h>

main(){
    float radio, area;
    printf("Valor del radio: ");
    scanf("%f", &radio);
    area=(radio*radio)*3.1416;
    printf("Area de un circulo es:= %f. ", area);
    float lado, Area;
    printf("Valor del lado: ");
    scanf("%f", &lado);
    Area=lado*lado;
    printf("Area de un cuadrado es:= %f", Area);
    getch();}
