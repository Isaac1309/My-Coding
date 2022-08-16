#include <iostream>
#include <string>
#include <stdlib.h>
using namespace std;
char libro;
char revista;
char website;
int uni();
int uni(){
    class libro{
    private:
        void capturaLibro();
        void imprimeLibro();
        string au;
        string tit;
        string imp;
        int añp, mep, dip, pag;
        string sub;
        string loc;
    public:
    count << "Autor de la obra: ";cin>>au;
    count << "\nTitulo: ";cin>>tit;
    count << "\nNombre de la imprenta: ";cin>>imp;
    count << "\nAño de publicacion: ";cin>>añp;
    count << "\nMes de publicacion: ";cin>>mep;
    count << "\nDia de publicacion: ";cin>>dip;
    count << "\nSubtitulo: ";cin>>sub;
    count << "\nPagina: ";cin>>pag;
    count << "\nLocalizacion de la imprenta: ";cin>>loc;
};

class revista{
    private:
    void capturaRevista();
    void imprimeRevista();
    string aut;
    string titu;
    string nomr;
    int añop, mesp, diap, volum, pagi;
    public:
    count << "Autor de la obra: ";cin>>aut;
    count << "\nTitulo: ";cin>>titu;
    count << "\nNombre de la revista: ";cin>>nomr;
    count << "\nAño de publicacion: ";cin>>añop;
    count << "\nMes de publicacion: ";cin>>mesp;
    count << "\nDia de publicacion: ";cin>>diap;
    count << "\nVolumen: ";cin>>volum;
    count << "\nPagina: ";cin>>pagi;

    };

int website(){
    private:
    void capturaWeb();
    void imprimeWeb();
    string autor;
    string titulo;
    string nomstw;
    int ap, mp, dp, ac, mc, dc;
    string url;
    public:
    count << "Autor de la obra: ";cin>>autor;
    count << "\nTitulo: ";cin>>titulo;
    count << "\nNombre del sitio web: ";cin>>nomstw;
    count << "\nAño de publicacion: ";cin>>ap;
    count << "\nMes de publicacion: ";cin>>mp;
    count << "\nDia de publicacion: ";cin>>dp;
    count << "\nAño de consulta: ";cin>>ac;
    count << "\nMes de consulta: ";cin>>mc;
    count << "\nDia de consulta: ";cin>>dc;
    count << "\nDireccion URL: ";cin>>url;
    };}

void libro::imprimeLibro(){
    count << "Autor de la obra: ";<<au<<endl;
    count << "Titulo: ";<<tit<<endl;
    count << "Nombre de la imprenta: ";<<imp<<endl;
    count << "Año de publicacion: ";<<añp<<endl;
    count << "Mes de publicacion: ";<<mep<<endl;
    count << "Dia de publicacion: ";<<dip<<endl;
    count << "Subtitulo: ";<<sub<<endl;
    count << "Pagina: ";<<pag<<endl;
    count << "Localizacion de la imprenta: ";<<loc<<endl;
    }
void revista::imprimeRevista(){
    count << "Autor de la obra: ";<<aut<<endl;
    count << "Titulo: ";<<titu<<endl;
    count << "Nombre de la revista: ";<<nomr<<endl;
    count << "Año de publicacion: ";<<añop<<endl;
    count << "Mes de publicacion: ";<<mesp<<endl;
    count << "Dia de publicacion: ";<<diap<<endl;
    count << "Volumen: ";<<volum<<endl;
    count << "Pagina: ";<<pagi<<endl;}
    void website::imprimeWeb(){
    count << "Autor de la obra: ";<<autor<<endl;
    count << "Titulo: ";<<titulo<<endl;
    count << "Nombre del sitio web: ";<<nomstw<<endl;
    count << "Año de publicacion: ";<<ap<<endl;
    count << "Mes de publicacion: ";<<mp<<endl;
    count << "Dia de publicacion: ";<<dp<<endl;
    count << "Año de consulta: ";<<ac<<endl;
    count << "Mes de consulta: ";<<mc<<endl;
    count << "Dia de consulta: ";<<dc<<endl;
    count << "Direccion URL: ";<<url<<endl;
    }
int main(){
cout << "Este en un programa de referencias" <<endl;
cout << "¿Que tipo de fuente quieres citar?" << endl;
cout << "1. Libro." << endl;
cout << "2. Revista." << endl;
cout << "3. Sitio Web." << endl;
cout << "4. Salir." << endl;
option = readinteger();
switch (option){
    case 1:
        void capturaLibro();
        void imprimeLibro();
    case 2:
        void capturaRevista();
        void imprimeRevista();
    case 3:
        void capturaWeb();
        void imprimeWeb();
    case 4:
        exit(EXIT_SUCCESS);
        }}
