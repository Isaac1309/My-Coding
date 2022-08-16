public class Mitsubishi extends Car{
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        super.startEngine();
        return "Mitsubishi -> startEngine()";
    }
    @Override
    public String accelerate() {
        super.accelerate();
        return "Mitsubishi -> accelerate()";
    }
    @Override
    public String brake() {
        super.brake();
        return "Mitsubishi -> brake()";
    }
}
