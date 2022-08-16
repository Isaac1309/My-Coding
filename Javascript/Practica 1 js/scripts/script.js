'use strict'/* Uso de modo estricto*/

var variable=5+5;
console.log(variable);

/* imprimir en consola y en documento*/
console.log("Hola mundo");
document.write("<h1>Hola mundo desde javascript</h1>");
console.error("Tu al nacer");
/*Tipos de datos*/
var hello="Hello word";
hello= hello+" desde Javascript"
console.log(hello);

var num1=100;
var num2=10;

console.log("La suma es "+(num1+num2));
console.log("La resta es "+(num1-num2));
console.log("La multiplicacion es "+(num1*num2));
console.log("La division es "+(num1/num2));
console.log("El modulo (residuo) es "+(num1%num2));

//Boolean
var booleano = true;
if(10>6 && booleano==true){
    console.log(true);
}else{
    console.error("error en booleano");
}

//switch
var tipotarjeta = "Credit Card";
switch(tipotarjeta){
    case 'Debit Card':
        console.log("Tarjeta de debito");
        break;
    case 'Credit Card':
        console.log("Tarjeta de credito");
        break;
    default:
        console.log("No existe esa opcion");
}

//Arrays
var nombres = ['joe','ryan','martha'];
console.log(nombres);
nombres[1]='cesar';
console.log(nombres);

var nombres2 = ['joe2','ryan2','martha2','Andrea','Alfredo'];
nombres=nombres.concat(nombres2);
console.log(nombres);
nombres2.splice(3);//cortar a partir de posiscion
console.log(nombres2);
nombres2.push('ricardo');
console.log(nombres2);
nombres2.splice(2,1);//cortar a partir de posiscion 2 
console.log(nombres2);
/*Se copia el apuntador no el arreglo
var nombrecopia=nombres;
console.log(nombrecopia);
nombrecopia[0]='jose';
console.log(nombres);
console.log(nombrecopia);*/

//ciclos
for(let i=0; i<nombres.length; i++){
    console.log("Elementos"+i+""+nombres[i])
}
console.log("--------------------");

nombres.forEach(element => {
    console.log(element);
});
console.log("--------------------");

var contador=0;
while(contador<nombres.length){
    console.log(nombres[contador]);
    contador++;
}

//objetos
var objetousu = {
    "username":"ryan",
    "score":70,
    "hours":100,
}
console.log(objetousu);
objetousu.profesional=true;
console.log(objetousu);
//crear objeto con clase padre object
var objetousu2=new Object();
objetousu2.username="cesar";
objetousu2.score=100;
objetousu2.hours=50;
objetousu2.profesional=true;
console.log(objetousu2);

class Usuario{
    constructor(username,score,hours,profesional){
        this.username=username;
        this.score=score;
        this.hours=hours;
        this.profesional=profesional;
    }
    //metodos
    getName(){
        return this.username;
    }
    setName(nombre){
        this.username=nombre;
    }
}
var objetousu3 = new Usuario("alfredo",100,30,false);
console.log(objetousu3);
objetousu3.setName('Fernando');
console.log(objetousu3.getName());

var a=5;
var b=10;
if(a==5){
    let a =4;//alcance dentro de if
    var b=1;//alcance global
    console.log(a);
    console.log(b);
}
console.log(a);
console.log(b);

//connstates
const PI=3.1416;
console.log(PI);
//PI=4;

document.write(PI+"<br>");
document.write(objetousu3+"<br>");
document.write(objetousu3.username);

document.getElementById('username').value = objetousu3.username;

document.getElementById("botonDes").innerText="Desactivar";
document.getElementById("botonDes").style.backgroundColor="green";
document.getElementById("botonDes").style.color="white";

function desactivarBtn(){
    let opc = prompt("Desactivar? 1=Si, 0=No");
    if(opc == "1"){
        document.getElementById("botonDes").disabled=true;
        document.getElementById("act").innerText="Boton Inactivo";
        document.getElementById("botonAct").hidden=false;
        //Estilo
        document.getElementById("botonAct").style.backgroundColor="blue";
        document.getElementById("botonAct").style.color="white";
        document.getElementById("botonDes").style.backgroundColor="red";
    }
}
function activarBtn(){
    let opc = prompt("Desactivar? 1=Si, 0=No");
    if(opc == "1"){
        document.getElementById("botonDes").disabled=false;
        document.getElementById("act").innerText="Activo";
        document.getElementById("botonAct").hidden=true;

        document.getElementById("botonDes").style.backgroundColor="green";
    }
}

document.getElementById("Mih1").innerText="Sin nombre";

function escribirDatosClick(elementoH1){
    let nombre = prompt("Cual es tu nombre?");
    elementoH1.innerText= "Hola "+nombre;
}
escribirDatos();
function escribirDatos(){
    prompt("Terminar de cargar pagina");
}

window.onload = function(){
    this.console.log("Se ha terminado de cargar la pagina");
}