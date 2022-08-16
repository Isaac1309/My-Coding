#include <stdio.h>
#include <stdlib.h>
void main() {
	int n, multiplos = 0, i = 0;
	printf("Numeros multiples de 5 en un rango");
	printf("\nIngresa un numero: \t");
	scanf("%d", &n);
	for(i = 1; i <= n; i++) {
		if(i % 5 == 0) {
			multiplos += 1;}}
	printf("Dentro del rango del 1 al %d hay %d multiplos de 5\n", n, multiplos);
	system("sleep 2");

}
