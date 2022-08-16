//Examen practico de Estructura de Datos
//Alvarez Gonzalez Carlos Isaac
//Tiempos 1.-10.475 seg.   2.-11.195 seg. 3.-11.052 seg. 4.- seg. 5.-10.121 seg. 6.-12.46 seg. 7.-11.018 seg.
//El libro que se uso fue Harry Potter y la priedra filosofa (en ingles).
#include<iostream>
#include<stdlib.h>
#include<fstream>
#include<string>
#include<conio.h>
#include<algorithm>
#include<bits/stdc++.h>
#include<vector>
#include<ctime>
using namespace std;
void trab();

int main() {
    clock_t a;
    a=clock();
	trab();
	a=clock()-a;
	cout<<"Duro "<<float(a)/CLOCKS_PER_SEC<<" segundos en ejecucion del programa.";
	system("pause");
	return 0;
}

void trab() {
    int a=0, rep=0, s=0;
	ifstream  arch;
	vector <string> vec;
	string nombre, tex;
	cout << "Inserta el nombre del archivo a leer y contar en .txt: ";
	getline(cin, nombre);
	arch.open(nombre.c_str()); //Abre el archivo
	if (arch.fail()) {
		cout<<"\nNo se pudo abrir el archivo";
		cout<<"\nGracias";
		exit(1);
	}
	while (arch>>tex) {
        vec.push_back(tex);
        }
    arch.close();//Cierra el archivo
    sort(vec.begin(), vec.end());
	for (a=0;a<vec.size(); a++){
		if(vec.at(a).compare(vec.back())!=0){
			cout<<vec.at(a)<<"\t";
		rep=0;
		s=a;
		do{
			rep++;
			if(vec.at(s).compare(vec.at(s+1))==0){
				rep++;
				s++;
			}
		}while(vec.at(s).compare(vec.at(s+1))==0);
		cout<<rep<<"\n";
		if(vec.at(a).compare(vec.at(a+1))==0)
			a=s;
		}else if(vec.at(a).compare(vec.at(a-1))!=0){
			cout<<vec.at(a)<<"\t";
			cout<<"1\n";
		}
	}
}
