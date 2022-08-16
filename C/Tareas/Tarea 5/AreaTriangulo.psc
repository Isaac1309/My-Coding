Proceso areaCuadradoRectangulo
	Escribir "1) Calcular area de un cuadrado"
	Escribir "2) Calcular area de un rectangulo"
	Leer opcionCalculo
	Si opcionCalculo == 1 Entonces
		acciones_por_verdadero
	Sino
		acciones_por_falso
	Fin Si
	Escribir "Ingresa la medida de la base" 
	Leer base
	area<-(base*altura)
	Escribir "El area de tu cuadrado es: " area
FinProceso
