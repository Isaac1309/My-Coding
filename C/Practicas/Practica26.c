#include <stdio.h>
#include <stdlib.h>
void ic(char c[], int i);
void main() {char c[50];int i = 0;printf("\tPalabra u oracion al reves\n\n");
	printf("Ingresa una palabra o una oracion:\t");
	fgets(c, 50, stdin);
	ic(c, i);
	printf("\n");}
void ic(char c[], int i) {
    if(c[i] == '\n')
        {printf("%c", c[i]);} else {ic(c, i+1);printf("%c", c[i]);}
getch();}
