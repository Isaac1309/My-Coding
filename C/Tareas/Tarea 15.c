#include <stdio.h>
int fibonacci(int n);
void main() {
	int numero, i;
	printf("Digita el numero de elementos de la serie de fibonacci que quieres que aparezca:\n");
	scanf("%i", &numero);
	for(i=1;i<=numero;i++) {printf("%i , ", fibonacci(i));}}
int fibonacci(int n) {
	if(n==0 || n==1) {return n;}
	else {return (fibonacci(n-1)+fibonacci(n-2));}
getch();}
