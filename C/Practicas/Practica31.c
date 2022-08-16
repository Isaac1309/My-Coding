#include <stdio.h>
#include <string.h>
int main() {
   char d[80], paso[]="clave";
   printf("Dame tu clave: ");
   fgets(d, 80, stdin);
   strtok(d, "\n");
   if(strcmp(paso, d)==0)
     printf("La clave es correcta. \tBienvenido.");
     else printf("La clave es incorrecta");
   getch();
   return 0;}
