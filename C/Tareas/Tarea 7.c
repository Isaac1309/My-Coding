#include <stdio.h>
float resultado;
void celciusAFahrenheit(float grados) {
	resultado = ((grados * 1.8) + 32);
	printf("%.f Celcius = %.2f Fahrenheit\n", grados, resultado);}
void fahrenheitACelcius(float grados) {
	resultado = ((grados - 32) / 1.8);
	printf("%.f Fahrenheit = %.2f Celcius\n", grados, resultado);}
void main() {
	char tipoConversion;
	float grados;
	int opcion;
	printf("\t\tCONVERCION DE GRADOS CELCIUS A FAHRENHEIT \n");
	printf("Seleccion de conversion de grados \n");
	printf("\vPresione \'A\' para:  Celcius => Fahrenheit\n");
	printf("Presione \'B\' para:  Fahrenheit => Celcius\n");
	printf("\v\vEliga:\t");
	scanf("%c", &tipoConversion);
	printf("Ingresa los grados:\t");
	scanf("%f", &grados);
	switch(tipoConversion) {
		case 'a':
		case 'A':
			celciusAFahrenheit(grados);
			break;
		case 'b':
		case 'B':
			fahrenheitACelcius(grados);
			break;}
		exit;
		getch();}
