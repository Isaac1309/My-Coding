#include <stdio.h>
#include <conio.h>
void main(){
    int cal1, cal2, cal3;
    float promedio;
    printf("Digite las tres calificaciones del alumno:\t");
    scanf("%d %d %d", &cal1, &cal2, &cal3);
    promedio=(cal1+cal2+cal3)/3.;
    if (promedio>95)
        promedio=100;
        printf("\n El promedio del alumno es de: %.2f", promedio);
    getch();
    return 0;}
