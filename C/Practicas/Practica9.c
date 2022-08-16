#include<stdio.h>
void main(){
    int dia;
    printf("Escriba el numero del dia: \n");
    scanf("%d", &dia);
    switch(dia){
        case 1: printf("el dia %d es Lunes\n", dia); break;
        case 2: printf("el dia %d es Martes\n", dia); break;
        case 3: printf("el dia %d es Miercoles\n", dia); break;
        case 4: printf("el dia %d es Jueves\n", dia); break;
        case 5: printf("el dia %d es Viernes\n", dia); break;
        case 6: printf("el dia %d es Sabado\n", dia); break;
        case 7: printf("el dia %d es Domingo\n", dia); break;
        default: printf("No hay un numero dia %d en la semana\n", dia); break;}
    getch();
    return 0;}
