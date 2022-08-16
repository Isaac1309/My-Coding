#include <stdio.h>
void main() {
	char opcion;
	int repetir;
	printf("Menu");
	printf("\n\nOpcion A\n");
	printf("Opcion B\n");
	printf("\v\v Otras opciones\n");
	printf("Salir (s)\n");
	printf("Menu (m)\n");
	scanf("%c", &opcion);
	while(getchar() != '\n');
	switch(opcion) {
		case 'a':
		case 'A':
			printf("\nOpcion A comida Mexicana\n\n");
			break;
		case 'b':
		case 'B':
			printf("\nOpcion B comida Italiana\n\n");
			break;
		case 's':
		case 'S':
            printf("\nGracias por su preferencia\n\n");
			exit;
			break;
		case 'm':
		case 'M':
            printf("\nGracias por repetir\n\n");
			main();}
			getch();}
