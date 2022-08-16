#include <stdio.h>
void main() {
	int enteros[5],i = 0,nm = 0;
	for(i=0; i<=4; i++) {
		printf("Ingresa el numero #%d\t", i+1);
		scanf("%d", &enteros[i]);
		if(enteros[i] >= nm) {
			nm = enteros[i];}}
	for(i=0; i<=4; i++) {
		if(enteros[i] != nm) {
			printf("Enteros [%d] = %d\n", i, enteros[i]);
		} else {
			printf("Enteros [%d] = %d <- Mayor\n", i, enteros[i]);}}
    getch();}
