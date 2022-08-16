#include <stdlib.h>
#include <stdio.h>
int main(){
    char cadena[1000];
    printf("Ingrese la cadena \n");
    gets(cadena);
    printf("La cadena fue: %s\n",cadena);
    for (int x=0;x<1000;x++){
      switch(cadena[x]){
      case 'e':
          cadena[x]='a';
        break;
        case 'i':
          cadena[x]='a';
        break;
        case 'o':
          cadena[x]='a';
        break;
        case 'u':
          cadena[x]='a';
        break;}}
    printf("La cadena fue: %s\n",cadena);
return 0;}
