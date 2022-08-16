package regresion.lineal;
/**
 * @author isaac
 * Yo creo que es un bueno pero le faltan mejoras debido a que no es muy seguro de que entre mas alto sea una persona mas pesada es.
 * Lo logre el codigo gracias al apoyo en dudas con un compañero de la clase.
 */
public class RegresionLineal {
    public static void main(String[] args) {
        double media = 0, sum = 0, sumf = 0, desvest = 0, numeroActual = 0, xy = 0, sumycud = 0, sumxcud = 0, sumx = 0, sumy = 0;
        double[][] matriz = {{65, 70, 89, 63, 55, 105, 85, 74, 81, 88},
        {1.68, 1.75, 1.76, 1.77, 1.73, 1.76, 1.7, 1.8, 1.74, 1.82}};
        double mayor = matriz[0][0], menor = matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            sumf = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                sumf += matriz[i][j];
                if (i == 1) {
                    sumy += matriz[i][j];
                    sumycud += matriz[i][j] * matriz[i][j];
                    xy += (matriz[i][j] * matriz[i-1][j]);
                }
                if (i == 0) {
                    sumx += matriz[i][j];
                    sumxcud += matriz[i][j] * matriz[i][j];
                }
                numeroActual = matriz[i][j];
                if (numeroActual > mayor) {
                    mayor = numeroActual;
                }
                if (numeroActual < menor) {
                    menor = numeroActual;
                }
            }
            media = sumf / 10;
            sum += Math.pow(matriz[i].length - media, 2);
            desvest = Math.sqrt(sum / matriz[i].length);
            System.out.printf("El Rango de " + (i + 1) + " es:  " + (mayor - menor) + "\n");
            System.out.println("La Media de " + (i + 1) + " es:  " + media);
            System.out.println("La Desviación estándar de " + (i + 1) + " es:  " + desvest + "\n");
            media = 0;
        }
            double puntdconv = (10*xy-sumx*sumy)/(10*sumxcud-sumx*sumx);
            double pdrec = (sumy-puntdconv*sumx)/10;
            System.out.println("Valor del punto de convergencia: "+puntdconv);
            System.out.println("Valor de la pendiente de la recta: "+pdrec);
    }
}
