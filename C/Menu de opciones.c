#include <stdio.h>
#include <stdlib.h>
#include<conio.h>

void rot13(char*);

void maina(){
int main(){
        char cadena[1000];
        printf("Ingrese la cadena \n");
        gets(cadena);
        printf(cadena);
        rot13(cadena);
        printf(cadena);
        rot13(cadena);
	return 0;
}

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
        }

    }

}

int mainb(){
    char cadena[1000];
    printf("Ingrese la cadena \n");
    gets(cadena);
    printf("La cadena fue: %s\n",cadena);
    for(int x=0;x<1000;x++)
    {
      switch(cadena[x])
      {
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
        break;
      }
    }
    printf("La cadena fue: %s\n",cadena);
    return 0;
}

void main() {
	char opcion;
	int repetir;
	printf("Elige alguna de las siguientes opciones a realizar:");
	printf("\n\nA) Hacer una oracion con ROT 13\n");
	printf("B) Cambiar todas las vocales por a´s\n");
    scanf("%c", &opcion);
    while(getchar() != '\n');
	do{
		system("cls");
		switch(opcion) {
			case 'a':
			case 'A':
				printf("\nElegiste la opcion A\n\n");
        	}
	}

}
