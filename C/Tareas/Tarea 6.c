#include <stdio.h>
void main() {
	int mes, consulta;
	printf("\tIMPRIMIR LOS MESES DE UNA ANUALIDAD\n\n");
	printf("Ingresa el numero correspondiente al mes: \t");
	scanf("%d", &mes);
	while(mes<=0 || mes>12)
	switch(mes){
		case 1:printf("Numero:\t%d\nMes:\tEnero\n", mes);break;
		case 2:printf("Numero:\t%d\nMes:\tFebrero\n", mes);break;
		case 3:printf("Numero:\t%d\nMes:\tMarzo\n", mes);break;
		case 4:printf("Numero:\t%d\nMes:\tAbril\n", mes);break;
		case 5:printf("Numero:\t%d\nMes:\tMayo\n", mes);break;
		case 6:printf("Numero:\t%d\nMes:\tJunio\n", mes);break;
		case 7:printf("Numero:\t%d\nMes:\tJulio\n", mes);break;
		case 8:printf("Numero:\t%d\nMes:\tAgosto\n", mes);break;
		case 9:printf("Numero:\t%d\nMes:\tSeptiembre\n", mes);break;
		case 10:printf("Numero:\t%d\nMes:\tOctubre\n", mes);break;
		case 11:printf("Numero:\t%d\nMes:\tNoviembre\n", mes);break;
		case 12:printf("Numero:\t%d\nMes:\tDiciembre\n", mes);break;
		default:printf("Opcion invalida\n");break;}
	printf("¿Deseas consultar otro mes?. Si(1), No(0): \t");
	scanf("%d", &consulta);
	while(consulta<0 || consulta>1){
		printf("\a¡Error!, ingresa una mes valida: \t");
		scanf("%d", &consulta);}
	if(consulta != 0) {
		main();
	}else{
		exit;}
		getch();}
