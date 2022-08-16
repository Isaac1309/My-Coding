/*
Autor:Alvarez Gonzalez Carlos Isaac
Codigo: 215420162
Aplicación:Arbol Binario
*/
#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#include<iostream>

using namespace std;

struct Nodo{
    int dato;
    Nodo *izq;
    Nodo *der;
    Nodo *padre;
};

void menu();
Nodo *crearNodo(int,Nodo *);
void insertarNodo(Nodo *&,int,Nodo *);
void mostrarArbol(Nodo *,int);
void preOrden(Nodo *);
void inOrden(Nodo *);
void posOrden(Nodo *);
void eliminar(Nodo *, int);
void eliminarNodo(Nodo *);
Nodo *minimo(Nodo *);
void reemplazar(Nodo *, Nodo *);
void destruirNodo(Nodo *);

Nodo *arbol=NULL;

int main(){
    menu();
    return 0;
}

void menu(){
    int dato, opcion, contador=0;
    do{
        cout<<"\tMenu\n";
        cout<<"1. Insertar elementos en al arbol\n";
        cout<<"2. Mostrar el arbol\n";
        cout<<"3. Recorrido del arbol\n";
        cout<<"4. Recorrido del arbol\n";
        cout<<"5. Salir\n";
        cout<<"Opcion:\t";
        cin>> opcion;
        switch(opcion){
            case 1: cout<<"Digite un numero: ";
            cin>>dato;
            insertarNodo(arbol,dato,NULL);
            cout<<"\n";
            system("pause");
            break;
            case 2: cout<<"\nMostrando arbol completo (estara acostado):\n\n";
            mostrarArbol(arbol,contador);
            cout<<"\n";
            system("pause");
            break;
            case 3:cout<<"\nRecorrido en PreOrden:\n";
            preOrden(arbol);
            cout<<"\nRecorrido en Orden:\n";
            inOrden(arbol);
            cout<<"\nRecorrido en posOrden:\n";
            posOrden(arbol);
            cout<<"\n\n";
            system("pause");
            break;
            case 4: cout<<"\nDigite el numero a eliminar: ";
            cin>>dato;
            eliminar(arbol,dato);
            cout<<"\n";
            system("pause");
            break;
        }
        system("cls");
    }while(opcion!=5);
}

Nodo *crearNodo(int n,Nodo *padre){
    Nodo *nuevo_nodo=new Nodo();
    nuevo_nodo->dato=n;
    nuevo_nodo->der=NULL;
    nuevo_nodo->izq=NULL;
    nuevo_nodo->padre=padre;
    return nuevo_nodo;
}

void insertarNodo(Nodo *&arbol, int n, Nodo *padre){
    if(arbol==NULL){
        Nodo *nuevo_nodo=crearNodo(n, padre);
        arbol=nuevo_nodo;
    }else{
        int valorRaiz=arbol->dato;
        if(n<valorRaiz){
            insertarNodo(arbol->izq, n, arbol);
        }else{
            insertarNodo(arbol->der, n, arbol);
        }
    }
}

void mostrarArbol(Nodo *arbol, int cont){
    if(arbol==NULL){
        return;
    }else{
        mostrarArbol(arbol->der,cont+1);
        for(int i=0;i<cont;i++){
            cout<<"   ";
        }
        cout<<arbol->dato<<endl;
        mostrarArbol(arbol->izq,cont+1);
    }
}

void preOrden(Nodo *arbol){
    if(arbol==NULL){
        return;
    }else{
        cout<<arbol->dato<<" - ";
        preOrden(arbol->izq);
        preOrden(arbol->der);
    }
}

void inOrden(Nodo *arbol){
    if(arbol==NULL){
        return;
    }else{
        inOrden(arbol->izq);
        cout<<arbol->dato<<" - ";
        inOrden(arbol->der);
    }
}

void posOrden(Nodo *arbol){
    if(arbol==NULL){
        return;
    }else{
        posOrden(arbol->izq);
        posOrden(arbol->der);
        cout<<arbol->dato<<" - ";
    }
}

void eliminar(Nodo *arbol, int n){
    if(arbol==NULL){
        return;
    }else if(n< arbol->dato){
        eliminar(arbol->izq,n);
    }else if(n> arbol->dato){
        eliminar(arbol->der,n);
    }else{
        eliminarNodo(arbol);
    }
}
Nodo *minimo(Nodo *arbol){
    if(arbol==NULL){
        return NULL;
    }
    if(arbol->izq){
        return minimo(arbol->izq);
    }else{
        return arbol;
    }
}

void reemplazar(Nodo *arbol, Nodo * nuevoNodo){
    if(arbol->padre){
        if(arbol->dato==arbol->padre->izq->dato){
            arbol->padre->izq=nuevoNodo;
        }else if(arbol->dato==arbol->padre->der->dato){
            arbol->padre->der=nuevoNodo;
            }
    }
    if(nuevoNodo){
        nuevoNodo->padre=arbol->padre;
    }
}

void destruirNodo(Nodo *nodo){
    nodo->izq=NULL;
    nodo->der=NULL;
    delete nodo;
}

void eliminarNodo(Nodo *nodoEliminar){
    if(nodoEliminar->izq && nodoEliminar->der){
        Nodo *menor=minimo(nodoEliminar->der);
        nodoEliminar->dato=menor->dato;
        eliminarNodo(menor);
    }else if(nodoEliminar->izq){
        reemplazar(nodoEliminar, nodoEliminar->izq);
        destruirNodo(nodoEliminar);
    }else if(nodoEliminar->der){
        reemplazar(nodoEliminar, nodoEliminar->der);
        destruirNodo(nodoEliminar);
    }else{
        reemplazar(nodoEliminar,NULL);
        destruirNodo(nodoEliminar);
    }
}
