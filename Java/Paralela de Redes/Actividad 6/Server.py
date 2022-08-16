import socket

miSocket=socket.socket()
miSocket.bind(('localhost',1026))
miSocket.listen(5)

while True:
	conexion, addr = miSocket.accept()
	print ("Nueva conexion establecida")
	print (addr)

	peticion = conexion.recv(1024)
	peticion= peticion.decode("utf-8")
	print (peticion)
	if peticion=="#":
		print ("Accion cancelada")
	else:
		a = conexion.recv(1024)
		a= int(a.decode('utf-8'))
		print (a)
		b = conexion.recv(1024)
		b= int(b.decode("utf-8"))
		print (b)
		if peticion=='+':
			resp=a+b
		elif peticion=='-':
			resp=a-b
		elif peticion=='*':
			resp=a*b
		elif peticion=='/':
			resp=a/b
		elif peticion=='%':
			resp=a%b
		else:
			resp = -1000;
			print("Operacion invalida")
		print (resp)
		sresp = str(resp)
		conexion.send(sresp.encode('utf-8'))
	conexion.close()