#include<stdio.h>
#include<conio.h>
void main(){
int l[10],i;
for (i=0;i<=9;i++){
    printf("Dame el elemento %d:\t", i+1);
    scanf("%d", &l[i]);}
printf("\n Lista: \n");
for (i=0;i<=9;i++)
    printf("%d \n",l[i]);
 getch();
 return 0;}
