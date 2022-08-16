#include <stdio.h>
#include <conio.h>
int main(){
    float cal;
    printf("Digite la calificacion del alumno sobre 100:\t");
    scanf("%f", &cal);
    if (cal>=60){
        printf("\n\t Aprobado.");
}else{printf("\n\t Reprobado.");}
getch();
return 0;}
