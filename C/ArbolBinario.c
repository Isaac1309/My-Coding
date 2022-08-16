#include<stdio.h>
#include<stdlib.h>

struct nodo{
    struct nodo *padre;
    struct nodo *izquierdo;
    struct nodo *derecho;
    int valor;
};

struct nodo *crear_nodo(struct nodo *padre,int valor);
void agregar_valor(struct nodo *arbol,int valor);

int main(){
    struct nodo *arbol;
    arbol = crear_nodo(NULL, 40);
    agregar_valor(arbol, 10);
    agregar_valor(arbol, 50);
    agregar_valor(arbol, 20);
    agregar_valor(arbol, 45);
    agregar_valor(arbol, 12);
    agregar_valor(arbol, 55);
    agregar_valor(arbol, 48);
    agregar_valor(arbol, 22);
    agregar_valor(arbol, 53);
    agregar_valor(arbol, 54);
    agregar_valor(arbol, 21);
    agregar_valor(arbol, 29);
    agregar_valor(arbol, 0);
    agregar_valor(arbol, -1);
    agregar_valor(arbol, -29);

struct nodo *crear_nodo(struct nodo *padre,int valor){
    struct nodo *n = calloc(sizeof(struct nodo), 1);
    n->padre = padre;
    n->valor = valor;
    return n;
}

void agregar_valor(struct nodo *arbol,int valor){
    struct nodo *temp,*pivote;
    int derecho = 0;
    if(arbol){
        temp=arbol;
        while(temp != NULL){
            pivote = temp;
            if(valor > temp->valor){//derecho
                temp= temp->derecho;
                derecho = 1;
            }else{//izquierdo
                temp= temp->izquierdo;
                derecho = 0;
            }
        }
        temp = crear_nodo(pivote, valor);
        if(derecho){
            printf("Insertado %i del lado derecho de %i \n", valor, pivote->valor);
            pivote->derecho = temp;
        }else{
            printf("Insertado %i del lado izquierdo de %i \n", valor, pivote->valor);
            pivote->izquierdo = temp;

        }
    }else{
        printf("Error no esta inicializando el arbol");
    }
}
