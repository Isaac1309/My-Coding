public class Operaciones {
    Sumar suma= new Sumar();
    Restar restar = new Restar();
    Multiplicar multi = new Multiplicar();
    Dividir dividir = new Dividir();
    Residuo residuo = new Residuo();
    
    public int classSuma(int a1, int b1) {
        int resp;
        resp = suma.sumar(a1, b1);
        return resp;
    }
    public int classResta(int a1, int b1) {
        int resp;
        resp = restar.resta(a1, b1);
        return resp;
    }
    public int classMultiplica(int a1, int b1) {
        int resp;
        resp = multi.multiplicacion(a1, b1);
        return resp;
    }
    public int classDivision(int a1, int b1) {
        int resp;
        resp = dividir.division(a1, b1);
        return resp;
    }
    public int classResiduo(int a1, int b1) {
        int resp;
        resp = residuo.residuo(a1, b1);
        return resp;
    }
}
