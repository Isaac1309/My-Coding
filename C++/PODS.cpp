#include <iostream>
#include <string>
using namespace std;
char APA_Libro;
char APA_Revista;
char APA_Website;
int readinteger();
int readinteger(){
class APA_Libro{
    public:
        void capturaLibro();
        void imprimeRefLibro();
    private:
        string autor;
        int year;
        string title;
        string subtitle;
        string location;
        string publisher;};

class APA_Revista{
    public:
    void capturaRevista();
    void imprimeRefRevista();
    private:
    string autor;
    int year;
    string title;
    string magazine_name;
    int volum;
    int pages;};

class APA_Website{
    public:
    void capturaWebsite(APA_Website& arg);
    void imprimeRefWebsite(APA_Website& arg);
    private:
    string autor;
    int year;
    string title;
    string date_of_document_recovery;
    string assotiation_that_publishes_the_article;
    string url;};
    }
void APA_Libro::imprimeRefLibro(){
    cout << endl << "Referencia:" << endl;
    cout << autor << ", ";
    cout << "(" << year << ")" << endl;
    cout << title << endl;
    cout << subtitle << endl;
    cout << location << endl;
    cout << publisher << endl;}
void APA_Revista::imprimeRefRevista(){
    cout << endl << "Referencia:" << endl;
    cout << autor << ", ";
    cout << "(" << year << ")" << endl;
    cout << title << endl;
    cout << magazine name << endl;
    cout << volumen << endl;
    cout << "(" << volum << ")" << endl;
    cout << "(" << pages << ")" << endl;}
void APA_Website::imprimeRefWebsite(){
    cout << endl << "Referencia:" << endl;
    cout << autor << ", ";
    cout << "(" << year << ")" << endl;
    cout << title << endl;
    cout << "(" << date_of_document_recovery << ")" << endl;
    cout << "(" << year << ")" << endl;
    cout << assotiation_that_publishes_the_article << endl;
    cout << "(" << volum << ")" << endl;
    cout << "(" << pages << ")" << endl;}
int main(){
    APA_Libro refL:
cout << "Este en un programa de referencias" <<endl;
cout << "¿Que tipo de fuente quieres citar?" << endl;
cout << "1. Libro." << endl;
cout << "2. Revista." << endl;
cout << "3. Web." << endl;
cout << "4. Salir." << endl;
option = readinteger();
switch (option){
    case 1:
        refL.capturaLibro();
        refL.imprimeRefLibro();
    /*case 2:
        refR.capturaRevista();
        refRimprimeRefRevista();
    case 3:
        refW.capturaWebsite();
        refWimprimerefWebsite();*/}}
