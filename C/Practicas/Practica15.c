#include <stdio.h>
void main(){
int n = 1, acumulador, numero;
	printf("Ingresa un numero positivo: \t");
	scanf("%d", &numero);
	while(n <= numero) {
		acumulador += n;
		n++;}
	numero = acumulador;
	printf("La suma es: %d\n", numero);
getch();}
