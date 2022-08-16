#include<iostream>
#include<stdlib.h>
#include<fstream>
#include<string>
#include<conio.h>
#include<algorithm>
#include<vector>
#include<ctime>
using namespace std;
void leer();

int main() {
    clock_t t;
    t=clock();
	leer();
	t=clock()-t;
	cout<<"Duraste "<<float(t)/CLOCKS_PER_SEC<<" segundos en ejecucion del programa.";
	system("pause");
	return 0;
}

void leer() {
    int i=0, c=0, o=0, x=0;
	ifstream  archivo;
	vector <string> v1, v2;
	string nombreArchivo, texto;
	cout << "Inserta el nombre del archivo a leer en .txt(poner la direccion y el nombre del archivo): ";
	getline(cin, nombreArchivo);
	archivo.open(nombreArchivo.c_str()); //Abrir
	if (archivo.fail()) {
		cout<<"\nNo se pudo abrir el archivo";
		exit(1);
	}
	while (archivo>>texto) {
        v1.push_back(texto);
        }
    archivo.close();//cierre del archivo
	for (i;i<v1.size(); i++){
		cout<<v1[i]<<endl;
	}
	for (c;c<v1.size(); c++){
	    int cont=0;
        for (o;o<v1.size(); o++){
            if(v1[o]<v2[o+1]){
                    break;
            }else{
                cont++;
            }
            v2.insert(v2.begin()+cont,v1[c]);
        }
	}
	for (x;x<v2.size(); x++){
        int mycount = std::count(v2.begin(),v2.end(),v2[x]);
        cout<<mycount<<endl;
	}
}
