'use strict'/* Uso de modo estricto*/

var table = document.getElementById("dinamicTable");

function Crear(){
    table.border="1";
    table.style.margin="auto";
    table.style.marginTop="30px";

    //Crear Encabezados De Columnas
    var NombreColumnas = ["Nombre","Apellido","Telefono","Eliminar"];
    var row=table.insertRow(0);

    for(let i=0; i<NombreColumnas.length;i++){
        let celdaEncabezado=document.createElement("th");
        celdaEncabezado.innerText=NombreColumnas[i];
        row.appendChild(celdaEncabezado);
    }
    //Activar Campos y botones
    document.getElementById("Nombre").disabled=false;
    document.getElementById("Apellido").disabled=false;
    document.getElementById("Telefono").disabled=false;
    document.getElementById("agregar").disabled=false;
    document.getElementById("limpiar").disabled=false;

    document.getElementById("crearTabla").disabled=true;
}

function Limpiar(){
    document.getElementById("Nombre").value="";
    document.getElementById("Apellido").value="";
    document.getElementById("Telefono").value="";
}

class Usuario{
    constructor(nombre, apellido, telefono){
        this.nombre=nombre;
        this.apellido=apellido;
        this.telefono=telefono;
    }
}

function AgregarUsr(){
    let nombre = document.getElementById("Nombre").value;
    let apellido = document.getElementById("Apellido").value;
    let telefono = document.getElementById("Telefono").value;
    
    let usr = new Usuario(nombre, apellido, telefono);
    dibujarEnTabla(usr);
}

function dibujarEnTabla(usr){
    var row = table.insertRow(-1); //Insertar en la ultima posicion
    row.id = Math.random(); //Dar un id al azar
    let values = Object.values(usr); //Descompone atributos en el arreglo
    console.log(values);

    for (let i=0; i <values.length;i++){
        var celda = row.insertCell(-1); //Crea una celda e inserta en la ultima fila
        celda.innerHTML = values[i]; 
    }
    //Insertar el boton eliminar en la última posición
    var celdaE = row.insertCell(-1);
    celdaE.innerHTML = ("<button onClick='borrar("+row.id+")'>Eliminar</button>");
}

function borrar(id){
    console.log("borrando "+id);
    let row = document.getElementById(id);
    row.parentNode.removeChild(row);
}