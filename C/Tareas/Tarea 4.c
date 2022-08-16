#include <stdio.h>
void main() {
	int cal1, cal2, cal3;
	float promedio;
	printf("Digite las calificaciones del alumno: \t");
	scanf("%d %d %d", &cal1, &cal2, &cal3);
	promedio = (cal1 + cal2 + cal3) / 3;
	if(promedio > 95)
		promedio = 100;
		printf("\n El promedio del alumno es: %.2f", promedio);
getch();}
