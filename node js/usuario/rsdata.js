const Operacion = () => {//se inicia el evento Operacion
  let jsonR = { Funcion: '' }//se crea el json jsonR con el apartado de Funcion
  const xX = /x/ig; //se crea una constante que es igual a x y a X
  const operaAnidada = document.getElementById('opeAni').value;//se obtiene la operacion anidada del usuario

  jsonR.Funcion = operaAnidada.replace(xX, '*');//se reemplaza lo que es igual a la variable xX por el signo *
  document.getElementById('jrequest').textContent = JSON.stringify(jsonR);//se imprime la JsonRequest en jrequest
  fetch(`http://localhost:1206/proyecto/mathjs`,{//realiza una peticion a la api ubicacion de proyecto/mathjs (el archivo mathjs.js)
    method: 'POST', //se selecciona el metodo post
    headers: { 'Content-Type': 'application/json' },//indica que el contenido es un json
    body: JSON.stringify(jsonR) //envia como body el json
  })
  .then(response => response.json())//esta promesa espera a que haya una respuesta en un formato json
  .then(jsonR => {//esta promesa recibe la variable jsonR para poder usarla
      document.getElementById('jresponse').textContent = JSON.stringify(jsonR, null, 2);//se imprime la JsonResponse en jresponse
      document.getElementById('resul').textContent = JSON.stringify(jsonR.Resultado);//se imprime el resultado en resul
    })
    .catch(error => console.log(`Error: ${error}`));//Si falla se imprime en la consola el error
}

document.getElementById('envOp').addEventListener('click', Operacion);//se crea el evento Operacion al dar clic en el boton de enviar