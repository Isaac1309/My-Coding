#include <stdio.h>
#include <stdlib.h>
float fa(int);
float fa(int n){
	float f;
	if(n==0) {f=1;}
	else {f=n*fa(n-1);}
	return f;}
void main(){
    printf("\tFactorial de un numero\n\n");
	float fact;
	int n;
	printf("Dame algun numero:\t");
	scanf("%d", &n);
	fact=fa(n);
	printf("El numero factorial es: %.2f\n", fact);
	getch();}
