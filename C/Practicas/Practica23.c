#include <stdio.h>
#include <stdlib.h>
void main() {
	int e[5], i = 0, m = 0;
	for(i=0; i<=4; i++) {
		printf("Numero %d:\t", i+1);
		scanf("%d", &e[i]);}
	m = e[0];
	for(i=0; i<=4; i++) {if(m < e[i]) {m = e[i];}}
	printf("El mayor es: %d\n", m);
	getch();}
