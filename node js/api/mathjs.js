const Router = require('express');//se establece en la variable Router el modulo express
const router = new Router();//se establece en la variable router el metodo Router
const {evaluate} = require('mathjs');//se establece en la variable {evaluate} el modulo mathjs

router.post('/', (request, response) => {//se usa el metodo post para solucionar y responder a la peticion 
  const {body} = request//se establece en la variable body todo el requst de los datos enviados por rsdata.js
  let jRes = { Resultado: '' }//se crea el json jRes con el apartado de Resultado
  jRes.Resultado = evaluate(body.Funcion);//se inserta en jRes en el apartado de Resultado el resultado de la funcion hecha por la funcion evaluate()
  response.send(jRes);//se le responde con el json jRes al rsdata.js
})

module.exports = router;//se exporta el modulo router