/** @author isaac */
public class Test {
    public static void main(String []args){
        Estacionamiento parking = new Estacionamiento();
        Vehiculo v1 = new Vehiculo(parking,"Audi", "AEE-46-91");
        Vehiculo v2 = new Vehiculo(parking,"BMW", "DHJ-39-07");
        Vehiculo v3 = new Vehiculo(parking,"Chrysler", "FHD-21-09");
        Vehiculo v4 = new Vehiculo(parking,"Dodge", "GBD-72-99");
        Vehiculo v5 = new Vehiculo(parking,"Honda", "ALA-91-43");
        Vehiculo v6 = new Vehiculo(parking,"Mazda", "DSE-76-20");
        Vehiculo v7 = new Vehiculo(parking,"Mercedes-Benz", "AMG-12-06");
        Vehiculo v8 = new Vehiculo(parking,"Mitsubishi", "HBZ-73-59");
        Vehiculo v9 = new Vehiculo(parking,"Nissan", "CZG-73-20");
        Vehiculo v10 = new Vehiculo(parking,"Toyota", "FSW-23-77");
        try {
            v1.start();
            v2.start();
            v3.start();
            v4.start();
            v5.start();
            v6.start();
            v7.start();
            v8.start();
            v9.start();
            v10.start();
            Thread.sleep(4000);
            parking.abrirEstacionamiento();
            Thread.sleep(15000);
            parking.cerrarEstacionamiento();
        } catch (Exception e) {}
    }
}
