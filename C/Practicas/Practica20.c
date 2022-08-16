#include<stdio.h>
#include<conio.h>
int main(){
    printf("Selecciona el numero de elementos:\n");
	int lista[3][3],x,y;
	for(x=0;x<3;x++){
		for(y=0;y<3;y++){
			printf("Dame el elemento [%d][%d]: ",x,y);
			scanf("%d",&lista[x][y]);}}
	printf("\n\n");
	for(x=0;x<3;x++){
		printf("\n");
		for(y=0;y<3;y++){
			printf("\t%d",lista[x][y]);}}
	printf("\n--------------------------------------------------\n");
	for(x=0;x<3;x++){
		printf("\n");
		for(y=0;y<3;y++){
			lista[x][y]*=10;
			printf("\t%d",lista[x][y]);}}
getch();}
