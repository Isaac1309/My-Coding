#include<conio.h>
#include<stdio.h>
#include<string.h>
char comparar(char pala[20]){
	int num,i,j=0;
	num=strlen (pala)-1;
	for(i=num;i>=0;i--){
		pala[i]=toupper(pala[i]);
		printf("%c",pala[i]);}
	printf("\n\n");
	for(i=num;i>=0;i--){
		if(pala[i]==pala[j]){
			j++;
		} else{
			goto fin;}}
	fin:
	num=strlen(pala);
	if(j==num){
		printf("Si es un palindromo");
	} else{
		 printf("No es un palindromo");}}
void main(){
	printf("\t\tPalindromos\n");
	int a;
	char pal[20];
	printf("Ingresa una palabra:\n");
	gets(pal);
	comparar(pal);
getch();}
