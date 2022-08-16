#include <stdio.h>
void main() {
	int enteros[4][3] = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}},
			fila = 0,
			columna = 0,
			sumaCol1 = 0,
			sumaCol2 = 0,
			sumaCol3 = 0,
			band1 = 0,
			band2 = 0,
			band3 = 0;
	for(fila=0; fila<4; fila++) {
		for(columna=0; columna<3; columna++) {
			printf("%d\t", enteros[fila][columna]);}}
    getch();}
