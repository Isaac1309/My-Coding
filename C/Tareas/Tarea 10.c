#include <stdio.h>
#include <stdlib.h>
void main(){
	int enteros[5] = {10, 15, 20, 25, 30},i = 0, acumulador = 0;
	for(i=0; i <= 4; i++) {
		acumulador += enteros[i];}
	printf("La suma de los enteros es: %d\n", acumulador);
	getch();}
