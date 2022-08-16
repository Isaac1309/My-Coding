#include <stdio.h>
#include <stdlib.h>
void llv(int x[], int tam);
void iv(int x[], int tam);
void sv(int x[], int y[], int z[], int tam);
void main() {
	int a[20], b[20], c[20];
	int t;
	printf("Total de elementos:\n");
	scanf("%d", &t);
	printf("Dame los elementos del vector a:\n");
	llv(a, t);
	printf("Dame los elementos del vector b:\n");
	llv(b, t);
	sv(a, b, c, t);
	printf("Vector |a|: ");
	iv(a, t);
	printf("Vector |b|: ");
	iv(b, t);
	printf("\n");
	printf("La suma es: ");
	iv(c, t);
getch();}
void llv(int x[], int tam) {
	int i = 0;
	for(i=0; i<tam; i++) {scanf("%d", &x[i]);}}
void sv(int x[], int y[], int z[], int tam) {
	int i = 0;
	for(i=0; i<tam; i++) {z[i]=x[i]+y[i];}}
void iv(int x[], int tam) {
	int i = 0;
	for(i=0; i<tam; i++) {
		printf("%d ", x[i]);}
	printf("\n");}
