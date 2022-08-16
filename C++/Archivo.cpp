#include<iostream>
#include<stdlib.h>
#include<fstream>
#include<string.h>
#include<conio.h>
using namespace std;
void leer();

int main(){
    leer();
    system("pause");
    return 0;
}

void leer(){
    ifstream  archivo;
    string nombreArchivo, texto;
    cout<<"Inserta el nombre del archivo a leer en .txt(poner la direccion y el nombre del archivo): ";
    getline(cin,nombreArchivo);
    archivo.open("nombreArchivo.c_str()",ios::in); //Abrir en lectura
    if(archivo.fail()){
        cout<<"\nNo se pudo abrir el archivo";
        exit(1);
    }
    while(!archivo.eof()){
        getline(archivo,texto);
        cout<<texto<<endl;
    }
    archivo.close();//cierre del archivo
}
