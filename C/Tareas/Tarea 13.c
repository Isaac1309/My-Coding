#include <stdio.h>
#include <stdlib.h>
void main() {
	int numeroA=0,
			numeroB=0,
			i=3;
	char opcion;
	printf("\tCALCULADORA ARITMETICA\n\n");
	printf("a) Sumar\n");
	printf("b) Restar\n");
	printf("c) Multiplicar\n");
	printf("d) Dividir\n");
	printf("e) Salir\n\n");
	printf("Tu eleccion es:\t");
	scanf("%c", &opcion);
	if(opcion == 'e') {
		exit(0);}
	printf("Dame el primer valor:\t");
	scanf("%d", &numeroA);
	printf("Dame el segundo valor:\t");
	scanf("%d", &numeroB);
	switch(opcion) {
		case 'a':
		case 'A':
			printf("%d + %d = %d\n", numeroA, numeroB, numeroA + numeroB);
			break;
		case 'b':
		case 'B':
			printf("%d - %d = %d\n", numeroA, numeroB, numeroA - numeroB);
			break;
		case 'c':
		case 'C':
			printf("%d x %d = %d\n", numeroA, numeroB, numeroA * numeroB);
			break;
		case 'd':
		case 'D':
			printf("%d / %d = %d\n", numeroA, numeroB, numeroA / numeroB);
			break;
		default:
			printf("Opcion invalida");}
	while(getchar()!='\n');
	main();
	getch();}
