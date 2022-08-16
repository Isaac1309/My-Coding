#include <stdio.h>
#include <stdlib.h>
#include<conio.h>
#include<string.h>
void maina(){
    char nombre[50];
    printf("No lo acabe\n");
    printf ("\t¿Cual es el archivo a leer?(sin .txt): ");
    scanf("%s", &nombre);
	FILE *archivo;
	strcat(nombre,".txt");
	char caracter;
	archivo=fopen(nombre,"r");
	if (archivo == NULL){
            printf("\nError de apertura del archivo. \n\n");
        }else{
            printf("\nEl contenido es: \n\n");
            while((caracter = fgetc(archivo)) != EOF){
            printf("%c",caracter);}}
        fclose(archivo);
        getch();
	return 0;}
void mainb(){
    printf("No lo hice\n");}
float resultado;
void celciusAFahrenheit(float grados) {
	resultado = ((grados * 1.8) + 32);
	printf("%.f Celcius = %.2f Fahrenheit\n", grados, resultado);}
void fahrenheitACelcius(float grados) {
	resultado = ((grados - 32) / 1.8);
	printf("%.f Fahrenheit = %.2f Celcius\n", grados, resultado);}
void mainc() {
	char tipoConversion;
	float grados;
	int opcion;
	printf("\t\t Convertidor de grados Centigrados - Fahrenheit\n");
	printf("\nPresiona \'A\' para convertir:  centigrados => Fahrenheit\n");
	printf("Presiona \'B\' para convertir:  Fahrenheit => Centigrados\n");
	printf("\v\vEligo 1:\t");
	scanf("%c", &tipoConversion);
	printf("Ingrese los grados:\t");
	scanf("%f", &grados);
	switch(tipoConversion) {
		case 'a':
		case 'A':
			celciusAFahrenheit(grados);
			break;
		case 'b':
		case 'B':
			fahrenheitACelcius(grados);
			break;
		default:
			printf("Opcion invalida\n");}
	printf("\v\v¿Desea realizar otra conversion?. Si(1), No(0): \t");
	scanf("%d", &opcion);
	while(getchar()!='\n');
	while(opcion < 0 || opcion > 1) {
		printf("\a¡Error!, ingrese una opcion valida: \t");
		scanf("%d", &opcion);}
	if(opcion != 0) {
		mainc();
	} else {
		exit;}}
void maind(){
    printf("Selecciona el numero de elementos:\n");
	int lista[100][100],filas,columnas,x,y,suma;
    suma =0;
    printf("Escoge el numero de filas: \t");
    scanf("%d",&filas);
    printf("\nEscoge el numero de columnas: \t");
    scanf("%d",&columnas);
	for(x=0;x<filas;x++){
		for(y=0;y<columnas;y++){
			printf("Dame el elemento [%d][%d]: ",x,y);
			scanf("%d",&lista[x][y]);}}
	printf("\n\n");
	for(x=0;x<filas;x++){
		printf("\n");
		for(y=0;y<columnas;y++){
			printf("\t%d",lista[x][y]);}}
	for(x=0; x<filas; x++ ){
		for(y=0; y<columnas; y++ ){
			if( y==x )
				suma = suma + lista[x][y];}}
        printf("\n\nLa suma de la diagonal es = %d", suma);
    getch();
    return 0;}
int maine(){
    int matriz[3][3];
    int a,b;
    for(a=0;a<3;a++){
        for(b=0;b<3; b++){
            printf("Inserte sus numeros en la matriz de 3*3:\t[%i] [%i] ",a+1,b+1);
                scanf("%i", &matriz[a][b]);}}
    printf("\t\tMatriz Original:\n");
    for(a=0;a<3;a++){
        for(b=0;b<3; b++){
            printf("[%i]",matriz[a][b]);}
        printf("\n");}
    printf("\n\t\tMatriz Transpuesta:\n");
    for(a=0;a<3;a++){
        for(b=0;b<3; b++){
            printf(" [%i] ",matriz[b][a]);}
        printf("\n");}
    getch();
    return 0;}
void mainf(){
    char palabra[80];
    int x,y,z;
    int opcion;
    printf("\nIngresa el texto a evaluar si es palindromo o no:\n");
    scanf(" %s",palabra);
    x=strlen(palabra);
    x=x-1;
    for(y=0,z=x;y<=x/2;y++,z--);
    if(palabra[y]==palabra[z]){printf("Es palindromo");}
    else{printf("No es palindromo");}
getch();}
void main() {
	char opcion;
	int repetir;
	cia:
	printf("\n\tElige alguna de las siguientes opciones a realizar:");
	printf("\n\nA) Ordenar lista de numeros contenida en archivos\n");
	printf("B) Lectura y manipulacion de archivos\n");
	printf("C) Conversion de grados centigrados a grados Fahrenheit\n");
	printf("D) Impresion de la diagonal de una matriz y suma de la diagonal\n");
	printf("E) Impresion de la transpuerta de una matriz\n");
	printf("F) Palabras o frases palindromas\n");
	printf("G) Salir del programa\n");
	printf("\nQue opcion quiere realizar:");
	scanf("%s", &opcion);
while(getchar() != '\n');
	switch(opcion) {
		case 'a':
		case 'A':
			printf("\nElegiste la opcion A\n\n");
			maina();
			printf("\n¿Deseas realizar otra conversion?. Regresar al menú.(1), Salir(0): \t");
	scanf("%d", &repetir);
	if (repetir==1){goto cia;}
	while(repetir < 0 || repetir > 1) {
		printf("\a¡Error!, ingresa una opcion valida: \t");
		scanf("%d", &repetir);}
	if(repetir != 0) {
		maina();
	} else {
		exit;}
			break;
		case 'b':
		case 'B':
			printf("\nElegiste la opcion B\n\n");
			printf("\n¿Deseas realizar otra conversion?. Regresar al menú.(1), Salir(0): \t");
	scanf("%d", &repetir);
	if (repetir==1){goto cia;}
	while(repetir < 0 || repetir > 1) {
		printf("\a¡Error!, ingresa una opcion valida: \t");
		scanf("%d", &repetir);}
	if(repetir != 0) {
		mainb();
	} else {
		exit;}
			break;
        case 'c':
		case 'C':
			printf("\nElegiste la opcion C\n\n");
        mainc();
        printf("\n¿Deseas realizar otra conversion?. Regresar al menú.(1), Salir(0): \t");
	scanf("%d", &repetir);
	if (repetir==1){goto cia;}
	while(repetir < 0 || repetir > 1) {
		printf("\a¡Error!, ingresa una opcion valida: \t");
		scanf("%d", &repetir);}
	if(repetir != 0) {
		mainc();
	} else {
		exit;}
			break;
        case 'd':
		case 'D':
			printf("\nElegiste la opcion D\n\n");
			printf("Selecciona el numero de elementos\n");
        maind();
        printf("\n¿Deseas realizar otra conversion?. Regresar al menú.(1), Salir(0): \t");
	scanf("%d", &repetir);
	if (repetir==1){goto cia;}
	while(repetir < 0 || repetir > 1) {
		printf("\a¡Error!, ingresa una opcion valida: \t");
		scanf("%d", &repetir);}
	if(repetir != 0) {
		maind();
	} else {
		exit;}
			break;
        case 'e':
		case 'E':
			printf("\nElegiste la opcion E\n\n");
        maine();
        printf("\n¿Deseas realizar otra conversion?. Regresar al menú.(1), Salir(0): \t");
	scanf("%d", &repetir);
	if (repetir==1){goto cia;}
	while(repetir < 0 || repetir > 1) {
		printf("\a¡Error!, ingresa una opcion valida: \t");
		scanf("%d", &repetir);}
	if(repetir != 0) {
		maine();
	} else {
		exit;}
			break;
        case 'f':
		case 'F':
			printf("\nElegiste la opcion F\n\n");
			printf("\nEL PRESENTE EJERCICIO ESTA IMPLEMENTADO DE MANERA RECURSIVA\n\n");
        mainf();
                 printf("\n¿Deseas realizar otra conversion?. Regresar al menú.(1), Salir(0): \t");
	scanf("%d", &repetir);
	if (repetir==1){goto cia;}
	while(repetir < 0 || repetir > 1) {
		printf("\a¡Error!, ingresa una opcion valida: \t");
		scanf("%d", &repetir);}
	if(repetir != 0) {
		mainf();
	} else {
		exit;}
            break;
            break;
		case 'g':
		case 'G':
            printf("\nHas elegido salir del programa, grasias!\n\n");
			exit;
			break;}
    getch();}
