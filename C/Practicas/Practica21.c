#include<stdio.h>
void a();
void b();
void a(){
    printf("Estoy en la funcion A\n");
    b();}
void b(){
    printf("Estoy en la funcion B\n");}
void main(){
    printf("Estoy en main\n");
    a();
    printf("Regrese a la funcion main\n");
    getch();}
