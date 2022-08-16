#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 128
void encriptar(char frase[MAX], int numero);
void desencriptar(char frase[MAX], int numero);
void desencriptar(char frase[MAX], int numero){
    int i=0;
    while(frase[i]!='\0'){frase[i]=frase[i]-numero; i++;}
printf("\nLa frase desencriptada es:\n%s\n", frase);}
void encriptar(char frase[MAX], int numero){
    int i=0;
    char letra;
    while(frase[i]!='\0'){frase[i]=frase[i]+numero; i++;}
printf("\nLa frase encriptada es:\n%s\n", frase);}
int main(){
    int x;
    char cadena[MAX];
    printf("\tEncriptado/Desencriptado del Metodo Cesar\n");
    printf("Introduce una cadena:\t");
    scanf("%128[^\n]", cadena);
    while(getchar()!='\n');
    printf("\nIntroduce un numero:\t");
    scanf("%d", &x);
    while(getchar()!='\n');
    encriptar(cadena, x);
    getchar();
    desencriptar(cadena, x);
    getchar();
getch();}
