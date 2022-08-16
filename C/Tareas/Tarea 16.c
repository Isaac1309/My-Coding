#include <stdio.h>
#include <string.h>
int main() {
   char c[80], pase[]="amjg120600";
   printf("Dame tu clave en numeros: ");
   fgets(c, 80, stdin);
   strtok(c, "\n");
   if(strcmp(pase, c)==0)
     printf("La clave es correcta. \t Bienvenido\n");
     else printf("La clave es incorrecta\n");
   getch();
   return 0;}
