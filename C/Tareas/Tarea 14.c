#include <stdio.h>
void main(){
	int enteros[5], i=0, j=0, temp;
	for(i=0; i<=4; i++) {
		printf("Numero %d:\t", i + 1);
		scanf("%d", &enteros[i]);}
	for(i=0; i<=4; i++) {
		printf("%d\n", enteros[i]);}
	for(i=1; i<5; i++){
		temp = enteros[i];
		j = i - 1;
		while ( (enteros[j] > temp) && (j >= 0) ) {
			enteros[j+1] = enteros[j];
			j--;}
		enteros[j+1] = temp;}
	for(i=0; i<=4; i++) {
		printf("%d\n", enteros[i]);}
getch();}
