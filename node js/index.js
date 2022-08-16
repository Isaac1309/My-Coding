const express = require('express');//se establece en la variable express el modulo express
const app = express();//se establece en la variable app el metodo express
const path = require('path');//se establece en la variable path el modulo path
const puerto = 1206;//se establece en la variable puerto el numero 1206

app.use(express.static(path.join(__dirname, "usuario")));//se establece el inicio en la carpeta usuario
app.use(express.json());//permite el uso de json

app.use('/proyecto/mathjs', require('./api/mathjs'));//se establece que /proyecto/mathjs es igual a la ubicacion del archivo mathjs.js

app.listen(puerto, ()=>{//se mantiene el servidor escuchando en el puerto indicado por la variable puerto
    console.log('Inicio de servicio en el puerto', puerto)//se imprime en la consola el puerto con el que se inicio
})