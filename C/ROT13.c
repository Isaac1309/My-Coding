#include <stdio.h>
void rot13(char*);
int main(){
    char cadena[1000];
    printf("Ingrese la cadena: \n");
    gets(cadena);
    printf(cadena);
    printf("\n");
    rot13(cadena);
    printf(cadena);
    printf("\n");
    rot13(cadena);
    printf(cadena);
return 0;}
void rot13(char*cadena){
        int c;
        int i = 0;
        while (cadena[i] != '\0'){
                c = cadena[i];
                if (c >= 'A' && c < 'N') {
                        cadena[i] = c + 13;
                } else if (c >= 'N' && c <= 'Z') {
                        cadena[i] = c - 13;
                } else if (c >= 'a' && c < 'n') {
                        cadena[i] = c + 13;
                } else if (c >= 'n' && c <= 'z') {
                        cadena[i] = c - 13;}
                i++;
}}
