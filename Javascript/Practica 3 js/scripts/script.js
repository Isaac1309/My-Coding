function getHistory(){
    //obtener valor del historial
    return document.getElementById("history-value").innerText;
}

function printHistory(num){
    document.getElementById("history-value").innerText = num;
}

function getOutput(){
    return document.getElementById("output-value").innerText;
}

function printOutput(num){
    if (num==""){
        //si se recibe cadena vacía por el botón de borrar
        document.getElementById("output-value").innerText = "";
    }else{
        document.getElementById("output-value").innerText = getFormattedNumber(num);
    }
}

function getFormattedNumber(num){
    if (num == "-"){
        return "";
    }
    var n = Number(num);
    var value = n.toLocaleString("en");//convertir número a formato local (comas)
    return value;
}

function limpiar(){
    printHistory("");
    printOutput("");
}

//regex
function reverseNumberFormat(num){
    return Number(num.replace(/,/g,""));
}

function retroceder(){
    var output = reverseNumberFormat(getOutput()).toString();
    if (output){
        //si output tiene valor
        output = output.substr(0, output.length-1);
        printOutput(output);
    }
}

function number(numero){
    var output = reverseNumberFormat(getOutput());
    if (output != NaN){ // Not a number
        //si output es un número
        output = output + numero;
        printOutput(output);
    }
}

function operador(operador){
    var output = getOutput(); // obtener datos de output
    var history = getHistory(); // obtener datos de history
    if (output=="" && history != ""){
        if (isNaN(history[history.length-1])){//revisar si el ultimo valor de history es un numero
            history = history.substr(0, history.length-1); //extraer string sin caracter
        }
    }
    if (output!= ""){
        output = reverseNumberFormat(output);
    }
    history = history + output;
    if (operador == "="){
        var result = eval(history);
        printOutput(result);
        printHistory("");
    }
    else{
        history = history+operador;  //concatenar operador con string history
        printHistory(history);
        printOutput("");
    }


}

