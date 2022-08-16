#include <stdio.h>
#include <stdlib.h>
int suma(int, int);
int resta(int, int);
int suma(int x, int y) {
	return x + y;}
int resta(int x, int y) {
	return x - y;}
void main() {
	int pA,pB;
	printf("Dame el valor de a:\t");
	scanf("%d", &pA);
	printf("Dame el valor de b:\t");
	scanf("%d", &pB);
	printf("La suma de a y b es: %d\n", suma(pA, pB));
	printf("La resta de a y b es: %d\n", resta(pA, pB));
}
