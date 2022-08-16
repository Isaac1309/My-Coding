#include <stdio.h>
#include <stdlib.h>

void Transferencia(int *puntero1,int *puntero2);

int main (){
    int arreglo1[10]= {9,8,7,6,5,4,3,2,1,0};
    int arreglo2[10];
    int *arre1=NULL, *arre2=NULL;
    arre1=(int*)malloc(10*sizeof(int));
    arre2=(int*)malloc(10*sizeof(int));
    arre1=&arreglo1[0];
    arre2=&arreglo2[0];
    for(int i=0; i<10; i++){
        printf("Posicion %d en el arreglo 1: %d\n", i, arreglo1[i]);
    }
        printf("------------------------------\n");
    for(int i=0; i<10; i++){
        printf("Posicion %d en el arreglo 2: %d\n", i, arreglo2[i]);
    }
    printf("\n------------------------------\n\n");
    if(arre1==NULL&&arre2==NULL){
        printf("No se asigna memoria\n");
    }else{
        printf("Se asigna memoria\n");
        Transferencia(arre1,arre2);
    }
    printf("\n------------------------------\n\n");
    for(int i=0; i<10; i++){
        printf("Posicion %d en el arreglo 1: %d\n", i, arreglo1[i]);
    }
    printf("------------------------------\n");
    for(int i=0; i<10; i++){
        printf("Posicion %d en el arreglo 2: %d\n", i, arreglo2[i]);
    }
    free(arre1);
    free(arre2);
    return 0;
}

void Transferencia(int *puntero1,int *puntero2){
    for(int i=0; i<10; i++){
        puntero2[i]=puntero1[i];
        puntero1[i]=0;
    }
}
