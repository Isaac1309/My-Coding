#include<stdio.h>
main(){
int gas, lit, pesos, des, bomba;
char nom[20];
float total, total1, litros;
printf("Gasolinera Alegres y de Sabiduria de Mexico GAS-MEX \n");
do {
printf("1-.Bomba 1\n2-.Bomba 2\n3-.Bomba 3\n4.-Salir\nNumero de bomba: ");
scanf("%d",&bomba); fflush(stdin);
switch (bomba){
case 1:printf("Se selecciono Bomba 1 \n");break;
case 2:printf("Se selecciono Bomba 2 \n");break;
case 3:printf("Se selecciono Bomba 3 \n");break;
case 4:exit(0);
}}while (bomba!=1 && bomba!=2 && bomba!=3);
do {
printf("1-.Magna\n2-.Premium\n3-.Diesel\nElija la opcion del tipo de gasolina: ");
scanf("%d",&gas);
fflush(stdin);
switch (gas){
case 1:printf("Se selecciono Magna \n"); break;
case 2:printf("Se selecciono Premium \n"); break;
case 3:printf("Se selecciono Diesel \n"); break;
}}while (gas!=1 && gas!=2 && gas!=3);
do{
    printf("1-.Litros\n2-.Precio\nElija la opcion del modo a despachar: ");
    scanf("%d",&des); fflush(stdin);
    switch (des){
        case 1:printf("Se selecciono litros "); printf("Introduzca la cantidad de litros: ");
            scanf("%d",&lit); fflush(stdin);
            if(gas==1) total1=19.97*lit;
            else if (gas==2) total1= 21.5*lit;
            else if (gas==3) total1= 20.10*lit;
            litros=lit;
            break;
        case 2:printf("Se selecciono precio "); printf("Introduzca la cantidad en pesos: " );
            scanf("%d",&pesos); fflush(stdin);
            if(gas==1)litros=pesos/19.97;
            else if(gas==2) litros=pesos/21.5; //supuse precio para la premiun
            else if (gas==3)litros=pesos/20.10; //supuse precio para disiel
            total = pesos;
            break;
    }
}while (des != 1 && des != 2 && des !=  3);
printf("Nombre completo cliente: ");
gets(nom);
system ("cls");
printf("Gasolinera Alegres y de Sabiduria de Mexico GAS-MEX \n");
if (bomba==1)
printf("Despachador: Durante Degli Alighieri\n\n");
if (bomba==2)
printf("Despachador: Karl Heinrich Marx\n\n");
else
printf("Despachador: Nicolas de Bernardo de Maquiavelo \n\n");
printf("Cliente: %20s\n\n", nom);
if (gas==1)
printf("Tipo de gasolina: Magna\n\n");
else
printf("Tipo de gasolina: Premium\n\n");
printf("Cantidad de litros %4.2f:\n\n", litros);
if (des==1){
printf("Precio por litro: %6.2f\n", 19.97);
printf("Total a pagar: %6.2f",total1);}
else{
printf("Precio por litro: %6.2f\n", 21.5);
printf("Total a pagar: %6.2f\n\n",total);}
printf("\n\nGracias por su preferencia.");
getchar();
}
