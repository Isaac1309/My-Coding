#include <stdio.h>
#include <conio.h>
int main(){
    int n1, n2;
    printf("Digite el primer numero:\t");
    scanf("%d", &n1);
    printf("Digite el segundo numero:\t");
    scanf("%d", &n2);
    if(n1 > n2) {
		printf("\n\t El primer numero es mayor\n");
	} else if(n1 < n2) {printf("\n\t El segundo numero es mayor\n");
	} else {printf("\n\tSon iguales\n");}
getch();
return 0;}
