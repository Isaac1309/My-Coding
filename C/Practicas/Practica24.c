#include <stdio.h>
int f(int);
int f(int n) {
	int i = 1,
			f = 1;
	for(i=1; i<=n; i++) {if(i==n){printf("%d", i);}else{printf("%d x ", i);}f *= i;}
	printf(" = %d\n", f);
	return f;}
void main() {
	int fact = 0,
			resultado = 0;
	printf("Factorial con proceso de:\t");
	scanf("%d", &fact);
	resultado = f(fact);
	printf("El resultado es: %d\n", resultado);}
