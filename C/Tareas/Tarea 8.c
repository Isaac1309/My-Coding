#include <stdio.h>
#include <stdlib.h>
void main() {
	int min = 0, max = 0, pares = 0, i = 0;
	printf("¿Donde inicio a evaluar?:\t");
	scanf("%d", &min);
	printf("¿Donde termino de evaluar?:\t");
	scanf("%d", &max);
	for(i=min; i<=max; i++) {
		if(i%2==0) {pares += i;}}
	printf("La suma de pares es %d\n", pares);
	getch();}
