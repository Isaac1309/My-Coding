#include <stdio.h>
#include <stdlib.h>
void llm(int x[][20], int tam);
void im(int x[][20], int tam);
void sm(int x[][20], int y[][20], int z[][20], int tam);
void main() {
	int a[20][20], b[20][20], c[20][20];
	int t;
	printf("Total de elementos(se multiplicara por si mismo):\t");
	scanf("%d", &t);
	printf("Dame los elementos de la primera matriz (matriz a):\n");
	llm(a, t);
	printf("Dame los elementos de la segunda matriz (matriz b):\n");
	llm(b, t);
	printf("Primera matriz (Matriz a): \n");
	im(a, t);
	printf("Segunda matriz (Matriz b): \n");
	im(b, t);
	sm(a, b, c, t);
	printf("La suma es de: \n");
	im(c, t);
}
void llm(int x[][20], int tam) {
	int i=0, j=0;
	for(i=0; i<tam; i++) {
		for(j=0; j<tam; j++) {scanf("%d", &x[i][j]);}}}
void im(int x[][20], int tam) {
	int i=0, j=0;
	for(i=0; i<tam; i++) {
		for(j=0; j<tam; j++) {printf("%d\t", x[i][j]);}
		printf("\n");}}
void sm(int x[][20], int y[][20], int z[][20], int tam) {
	int i=0, j=0;
	for(i=0; i<tam; i++) {for(j=0; j<tam; j++){
			z[i][j]=x[i][j]+y[i][j];}}}
