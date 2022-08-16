#include <stdio.h>
#include <stdlib.h>
void main() {
	int n, m = 0, i = 0;
	printf("Ingrese un numero mayor a 5: \t");
	scanf("%d", &n);
	for(i = 1; i <= n; i++) {
		if(i % 5 == 0) {
			m += 1;}}
	printf("Dentro del rango del 1 al %d hay %d multiplos de 5\n", n, m);
getch();}
