#include <stdio.h>
#define PLIB 100
#define PCUAD 15.5
#define PPLUM 2.35
void main () {
    int libros, cuadernos, plumas;
    float venta;
    printf("\tVenta de la PapeMex\n\n");
    printf("\n ¿Cuantos libros vendiste? \t");
    scanf("%d", &libros);
    printf("\n ¿Cuantos cuadernos vendiste? \t");
    scanf("%d", &cuadernos);
    printf("\n ¿Cuantos plumas vendiste? \t");
    scanf("%d", &plumas);
    venta=(libros*PLIB)+(cuadernos*PCUAD)+(plumas*PPLUM);
	printf("\nDinero recaudado de la venta de libros fue de: \t$ %d\n", libros*PLIB);
	printf("Dinero recaudado de la venta de cuadernos fue de: \t$ %.2f\n", cuadernos*PCUAD);
	printf("Dinero recaudado de la venta de plumas fue de: \t$ %.2f\n", plumas*PPLUM);
	printf("Dinero recaudado de la venta total del dia fue de: \t$%.2f\n", venta);
    getch();}
