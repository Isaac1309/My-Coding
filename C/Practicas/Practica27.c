#include <stdio.h>
#include <stdlib.h>
void cr(int n, int i);
void main() {
	int n, i=1;
	printf("Cuenta regresiva\n");
	printf("¿Cuando debe comenzar la cuenta regresiva?:\t");
	scanf("%i", &n);
	cr(n, i);
	printf("\n");}
void cr(int n, int i) {
	if(i == n) {
		printf("%i\t", i);
	} else {
		cr(n, i+1);
		printf("%i\t", i);}
getch();}
