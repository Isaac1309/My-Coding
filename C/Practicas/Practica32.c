#include <stdio.h>
void Coincidencias(int n[], int x);
void Menores(int n[], int x);
void Mayores(int n[], int x);
void main() {
  int numero, i;
  int numeros[20];
  printf("Ingresa 20 numero para el arreglo: \n");
  for(i=0; i<20; i++) {
    scanf("%d", &numeros[i]);}
  printf("Ingresa tu numero a comparar: ");
  scanf("%d", &numero);
  Coincidencias(numeros, numero);
  Menores(numeros, numero);
  Mayores(numeros, numero);}
void Coincidencias(int n[], int x) {
  int i=0, coincidencia=0;
  for(i=0; i<20; i++) {
    if(n[i]==x) {
      coincidencia++;}}
  if(coincidencia<1) {
    printf("%d no se encontro coincidencia\n", x);
  } else if(coincidencia==1) {
    printf("%d se repite una vez\n", x);
  } else {
    printf("%d se repite %d veces\n", x, coincidencia);}}
void Menores(int n[], int x) {
  int i=0, coincidencia=0;
  for(i=0; i<20; i++) {
    if(n[i]<x) {
      coincidencia++;}}
  printf("Hay %d numeros menores a %d\n", coincidencia, x);}
void Mayores(int n[], int x) {
  int i=0, coincidencia=0;
  for(i=0; i<20; i++) {
    if(n[i]>x) {
      coincidencia++;}}
  printf("Hay %d numeros mayores a %d\n", coincidencia, x);
  getch();}
