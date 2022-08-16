/** @author isaac */
public class Examen {
    public static void main(String[] args) {
        Basura basura = new Basura();
        Intendente intendente = new Intendente("Don Francisco", basura);
        Alumno alumno1 = new Alumno("pedro", basura);
        Alumno alumno2 = new Alumno("juan", basura);
        Alumno alumno3 = new Alumno("maria", basura);
        Alumno alumno4 = new Alumno("jose", basura);
        Alumno alumno5 = new Alumno("carlos", basura);
        intendente.start();
        alumno1.start();
        alumno2.start();
        alumno3.start();
        alumno4.start();
        alumno5.start();
    }
}
